package se.nackademin.librarytest.helpers;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import se.nackademin.librarytest.model.Book;
import se.nackademin.librarytest.model.UniqueBook;
import se.nackademin.librarytest.pages.EditBookPage;
import se.nackademin.librarytest.pages.BrowseBooksPage;
import se.nackademin.librarytest.pages.MenuPage;
import se.nackademin.librarytest.pages.MyProfilePage;

import se.nackademin.librarytest.pages.ViewBookPage;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;

public class BookHelper {
    static MenuPage menuPage = page(MenuPage.class);
    static EditBookPage editBookPage = page(EditBookPage.class);
    static ViewBookPage viewBookPage = page(ViewBookPage.class);
    static BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
    static MyProfilePage myProfilePage = page(MyProfilePage.class);

    public static void addNewBook(Book book){
       
   
    }
    public static Book fetchBook(String searchQuery){
        menuPage.navigateToBrowseBooks();
        
        browseBooksPage.setTitleField(searchQuery);
        browseBooksPage.clickSearchBooksButton();
        sleep(1000);
        browseBooksPage.clickFirstResultTitle();
        
        Book book = new Book();
        
        book.setTitle(viewBookPage.getTitle());
        book.setAuthor(viewBookPage.getAuthor());
        book.setDescription(viewBookPage.getDescription());
        book.setIsbn(viewBookPage.getIsbn());
        book.setDatePublished(viewBookPage.getDatePublished());
        book.setNbrAvailable(Integer.parseInt(viewBookPage.getNumberOfCopiesAvailable()));
        return book;
    }
    
    public static void returnBook(){
        menuPage.navigateToMyProfile();
        myProfilePage.clickFirstBookInProfile();
        sleep(1000);
        viewBookPage.clickReturnBookButton();
        viewBookPage.clickConfirmOkButton();
    }
    
    public static Book createBook(String useTitle,String useAuthor,String useDescription, String useIsbn,String useDatePublished, Integer useNbrAvailable){
        sleep(1000);
        UserHelper.loginAsAdmin();
        
        MenuPage menuPage = page(MenuPage.class);
        EditBookPage bookPage = page(EditBookPage.class);
        
        // Navigating to add book page
        menuPage.navigateToAddBooks();
        
        // Creating a unique book
        UniqueBook uniqueBook=new UniqueBook(useTitle,useAuthor,useDescription,useIsbn,useDatePublished,useNbrAvailable);
        bookPage.setTitle(uniqueBook.getTitle());
        bookPage.setAuthorSelect(uniqueBook.getAuthor());
        bookPage.setDatePublished(uniqueBook.getDatePublished());
        bookPage.setDescription(uniqueBook.getDescription());
        bookPage.setIsbn(uniqueBook.getIsbn());
        bookPage.setDatePublished(uniqueBook.getDatePublished());
        bookPage.setNumberInInventory(uniqueBook.getNbrAvailable().toString());
        bookPage.clickAddBookButton();
        return uniqueBook;
    
    
    }
    
    public static Book searchForBookAndReturnFirstHit(String title, String author, String isbn, String datePublished){
        MenuPage menuPage = page(MenuPage.class);
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        
        menuPage.navigateToBrowseBooks();
        browseBooksPage.setTitleField(title);
        browseBooksPage.setNameOfAuthorField(author);
        browseBooksPage.setIsbnField(isbn);
        browseBooksPage.setDatePublishedField(datePublished);
        browseBooksPage.clickSearchBooksButton();
        browseBooksPage.clickFirstResultTitle();
        
        Book book = new Book();
        
        book.setTitle(viewBookPage.getTitle());
        book.setAuthor(viewBookPage.getAuthor());
        book.setDescription(viewBookPage.getDescription());
        book.setIsbn(viewBookPage.getIsbn());
        book.setDatePublished(viewBookPage.getDatePublished());
        book.setNbrAvailable(Integer.parseInt(viewBookPage.getNumberOfCopiesAvailable()));
        return book;
    }
    
    public static void deleteBook(String title){
        open("http://localhost:8080/librarytest");
        BookHelper.fetchBook(title);
        viewBookPage.clickDeleteBookButton();
        viewBookPage.clickConfirmOkButton();
    }
}
