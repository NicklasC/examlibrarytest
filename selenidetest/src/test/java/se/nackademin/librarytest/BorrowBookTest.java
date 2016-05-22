package se.nackademin.librarytest;

import se.nackademin.librarytest.helpers.BookHelper;
import se.nackademin.librarytest.helpers.UserHelper;
import se.nackademin.librarytest.pages.BookPage;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Task 3: Borrow book test
 * @author nicklas
 */
public class BorrowBookTest extends TestBase{
    @Test
    public void borrowBookTest(){
        
        // Creating a new user and logging in
        UserHelper.createAndLoginNewUser();
    
        BookPage bookPage=page(BookPage.class);
        BookHelper.fetchBook("Rendezvous with Rama");
        // Getting current copies available
        Integer copiesAvailable=Integer.parseInt(bookPage.getCopiesAvailable());
        
        // Now borrowing book
        bookPage.clickBorrowBookButton();
        bookPage.clickConfirmOKbutton();
        
        // Verifying that one less copy is available
        assertEquals("Copies available should be reduced by one",copiesAvailable-1,Integer.parseInt(bookPage.getCopiesAvailable()));
        BookHelper.returnBook();
    }
}
