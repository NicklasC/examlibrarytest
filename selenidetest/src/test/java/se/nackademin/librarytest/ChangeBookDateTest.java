package se.nackademin.librarytest;

import org.junit.Test;
import se.nackademin.librarytest.helpers.UserHelper;
import se.nackademin.librarytest.helpers.BookHelper;
import se.nackademin.librarytest.pages.BookPage;
import static org.junit.Assert.assertEquals;
import static com.codeborne.selenide.Selenide.page;

/**
 *
 * @author nicklas
 */
public class ChangeBookDateTest extends TestBase{
    @Test
    public void changeBookDate(){
    
        UserHelper.loginAsUser("admin","1234567890");
        BookHelper.fetchBook("Rendezvous with Rama");
        
        BookPage bookPage = page(BookPage.class);
        
        String currentDate=bookPage.getDatePublished();
        String newDate;
        if (currentDate.equals("1990-05-01")){
            newDate="1990-05-02";
        }else{
            newDate="1990-05-01";        
        }
        
        bookPage.clickEditBookButton();
        bookPage.setDatePublished(newDate);
        bookPage.clickSaveBookButton();
        
        // Verifying the changes have taken place
        
        BookHelper.fetchBook("Rendezvous with Rama");
        assertEquals("Book date should have been updated",newDate,bookPage.getDatePublished());
    }
}
