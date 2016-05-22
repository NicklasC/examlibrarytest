package se.nackademin.librarytest.helpers;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import se.nackademin.librarytest.model.Book;
import se.nackademin.librarytest.pages.BookPage;
import se.nackademin.librarytest.pages.BrowseBooksPage;
import se.nackademin.librarytest.pages.MenuPage;
import se.nackademin.librarytest.pages.MyProfilePage;

public class BookHelper {
    static MenuPage menuPage = page(MenuPage.class);
    static BookPage bookPage = page(BookPage.class);
    static BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
    static MyProfilePage myProfilePage = page(MyProfilePage.class);

    public static void addNewBook(Book book){
       
   
    }
    public static Book fetchBook(String searchQuery){
        menuPage.navigateToBrowseBooks();
        browseBooksPage.setTitleField(searchQuery);
        browseBooksPage.clickSearchBooksButton();
        browseBooksPage.clickFirstResultTitle();
        
        Book book = new Book();
        book.getTitle();
        book.setTitle(bookPage.getTitle());
        book.setAuthor(bookPage.getAuthor());
        book.setDescription(bookPage.getDescription());
        return book;
    }
    
    public static void returnBook(){
        menuPage.navigateToMyProfile();
        myProfilePage.clickFirstBookInProfile();
        myProfilePage.clickReturnBookButton();
        bookPage.clickConfirmOKbutton();
    }
}
