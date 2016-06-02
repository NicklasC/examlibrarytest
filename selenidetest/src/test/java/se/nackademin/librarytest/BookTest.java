package se.nackademin.librarytest;

import org.junit.Test;
import se.nackademin.librarytest.helpers.BookHelper;
import se.nackademin.librarytest.model.Book;
import se.nackademin.librarytest.pages.EditBookPage;
import se.nackademin.librarytest.pages.ViewBookPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;
import se.nackademin.librarytest.helpers.UserHelper;
import se.nackademin.librarytest.pages.BrowseBooksPage;
import se.nackademin.librarytest.pages.MenuPage;

public class BookTest extends TestBase{
    static ViewBookPage viewBookPage=page(ViewBookPage.class);
    static EditBookPage editBookPage=page(EditBookPage.class);
    static MenuPage menuPage = page(MenuPage.class);
    static BrowseBooksPage browseBooksPage = page (BrowseBooksPage.class);
    
    @Test
    public void bookCreateAndVerifyItIsSavedCorrectly(){
        
        // Creating a book to work with
        Book createdBook = BookHelper.createBook(null, null, null, null, null, null);
        
        // fethching the book
        Book fetchedBook = BookHelper.fetchBook(createdBook.getTitle());
        
        // Verifying the information is the same as when it was created
        assertEquals("Book title was created correctly",createdBook.getTitle(),fetchedBook.getTitle());
        assertEquals("Description was created correctly",createdBook.getDescription(),fetchedBook.getDescription());
        assertEquals("ISBN was created correctly",createdBook.getIsbn(),fetchedBook.getIsbn());
        assertEquals("Date was created correctly",createdBook.getDatePublished(),fetchedBook.getDatePublished());
        assertEquals("Number available was created correctly",createdBook.getNbrAvailable(),fetchedBook.getNbrAvailable());
    }
    
    @Test
    public void updateAllBookFields(){
        
        Book createdBook = BookHelper.createBook(null, null, null, null, null, null);
        
        BookHelper.fetchBook(createdBook.getTitle());
        viewBookPage.clickEditBookButton();
        
        editBookPage.setTitle(createdBook.getTitle()+"x");
        editBookPage.setDescription("new description");
        editBookPage.setIsbn("new isbn");
        editBookPage.setDatePublished("1973-11-11");
        editBookPage.setNumberInInventory("99");
        editBookPage.clickSaveBookButton();
        
        Book fetchedBook=BookHelper.fetchBook(createdBook.getTitle()+"x");

        assertEquals("Title is updated",createdBook.getTitle()+"x",fetchedBook.getTitle());
        assertEquals("Description is updated","new description",fetchedBook.getDescription());
        assertEquals("Isbn is updated","new isbn",fetchedBook.getIsbn());
        assertEquals("Date published is update","1973-11-11",fetchedBook.getDatePublished());
        assertEquals("Number in inventory is updated","99",Integer.toString(fetchedBook.getNbrAvailable()));
    }
    @Test
    public void createBookWithNoTitleIsNotPossible(){
        BookHelper.createBook("", null, null, null, null, null);
        
        String text=$(".v-label-undef-w").getText();
        assertEquals("Invalid data error message should display","Invalid data, please try again.",text);
        
    }
    @Test
    public void changeBookDate(){
    
        UserHelper.loginAsAdmin();
        BookHelper.fetchBook("Rendezvous with Rama");
       
        String currentDate=viewBookPage.getDatePublished();
        String newDate;
        if (currentDate.equals("1990-05-01")){
            newDate="1990-05-02";
        }else{
            newDate="1990-05-01";        
        }
        
        viewBookPage.clickEditBookButton();
        editBookPage.setDatePublished(newDate);
        editBookPage.clickSaveBookButton();
        
        // Verifying the changes have taken place
        BookHelper.fetchBook("Rendezvous with Rama");
        assertEquals("Book date should have been updated",newDate,viewBookPage.getDatePublished());
    }
    
    @Test
    public void createAndDeleteBook(){
        Book book = BookHelper.createBook(null, null, null, null, null, null);
        BookHelper.fetchBook(book.getTitle());
        
        viewBookPage.clickDeleteBookButton();
        viewBookPage.clickConfirmOkButton();
        
        menuPage.navigateToBrowseBooks();
        browseBooksPage.setTitleField(book.getTitle());
        browseBooksPage.clickSearchBooksButton();
        
        assertEquals("Book should now be deleted",false,browseBooksPage.firstSearchResultExist());
    }
}
