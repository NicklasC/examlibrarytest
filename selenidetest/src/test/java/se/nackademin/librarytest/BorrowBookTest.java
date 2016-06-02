package se.nackademin.librarytest;

import se.nackademin.librarytest.helpers.BookHelper;
import se.nackademin.librarytest.helpers.UserHelper;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import se.nackademin.librarytest.pages.ViewBookPage;
import static com.codeborne.selenide.Selenide.page;

/**
 * Task 3: Borrow book test
 * @author nicklas
 */
public class BorrowBookTest extends TestBase{
    @Test
    public void borrowBookTest(){
        
        // Creating a new user and logging in
        UserHelper.createAndLoginNewUser();
    
        ViewBookPage viewBookPage=page(ViewBookPage.class);
        BookHelper.fetchBook("Rendezvous with Rama");
        
        // Getting current copies available
        Integer copiesAvailable=Integer.parseInt(viewBookPage.getNumberOfCopiesAvailable());
        
        // Now borrowing book
        viewBookPage.clickBorrowBookButton();
        viewBookPage.clickConfirmOkButton();
        
        // Verifying that one less copy is available
        assertEquals("Copies available should be reduced by one",copiesAvailable-1,Integer.parseInt(viewBookPage.getNumberOfCopiesAvailable()));
        BookHelper.returnBook();
    }
}
