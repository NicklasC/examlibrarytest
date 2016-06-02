package se.nackademin.librarytest;

import org.junit.Test;
import se.nackademin.librarytest.helpers.StringHelper;
import se.nackademin.librarytest.helpers.UserHelper;
import se.nackademin.librarytest.pages.MenuPage;
import se.nackademin.librarytest.pages.MyProfilePage;
import static org.junit.Assert.assertEquals;
import static com.codeborne.selenide.Selenide.page;

/**
 * Task 2: Change E-mail address
 * @author nicklas
 */

public class ChangeEmailAdressTest extends TestBase{

    @Test
    public void changeEmailAdress(){    
        
        MyProfilePage myProfilePage = page(MyProfilePage.class);
        //Creating and logging in as new user
        UserHelper.createAndLoginNewUser();
        
        // Navigate to My Profile
        MenuPage menuPage = page(MenuPage.class);
        menuPage.navigateToMyProfile();
        
        // Change email adress
        String newEmailAdress=StringHelper.randomString()+"@test.com";
        UserHelper.updateUserEmailAdress(newEmailAdress);
        
        // Navigating to my profile again
        menuPage.navigateToMyProfile();
        
        // Verifying my email adress is updated
        assertEquals("Email adress should be updated",newEmailAdress,myProfilePage.getEmailAdress());
    }
}
