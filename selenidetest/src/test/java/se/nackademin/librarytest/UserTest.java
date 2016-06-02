package se.nackademin.librarytest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static se.nackademin.librarytest.helpers.StringHelper.randomString;
import se.nackademin.librarytest.helpers.UserHelper;
import se.nackademin.librarytest.model.User;
import se.nackademin.librarytest.pages.AddUserPage;
import se.nackademin.librarytest.pages.MenuPage;
import se.nackademin.librarytest.pages.MyProfilePage;

public class UserTest extends TestBase{
    static MenuPage menuPage = page(MenuPage.class);
    static AddUserPage addUserPage = page(AddUserPage.class);
    static MyProfilePage myProfilePage = page (MyProfilePage.class);
    
    
    @Test
    public void userLoanerCreateAndLoginAndVerifyRights(){
        User newUser = UserHelper.createNewLoanerUser(randomString(),randomString());
        UserHelper.loginAsUser(newUser.getUserName(), newUser.getPassword());

        String text=$(".v-margin-top > div:nth-child(5) > div:nth-child(1)").getText().substring(13);
        
        assertEquals("Loaner user should be logged in and username should display",newUser.getUserName()+".",text);
        
        //logging out
        menuPage.navigateToSignOut();
        text=$(".v-label").getText();
        assertEquals("Loaner user should be logged out message should display","Signed out user "+newUser.getUserName()+".",text);

        assertEquals("Add books menu option should not display",false,menuPage.addBooksLinkExists());
        assertEquals("Add Author menu option should not display",false,menuPage.addAuthorLinkExists());
    }
    
    @Test
    public void createUserWithOnlyUsernameShouldNotBePossible(){
        menuPage.navigateToAddUser();
        addUserPage.setUserName(randomString());
        addUserPage.clickAddUserButton();
        assertEquals("Create user with only username should not be possible",false,addUserPage.errorMessageDisplays());
    }
    @Test
    public void createUserWithOnlyPasswordShouldNotBePossible(){
        menuPage.navigateToAddUser();
        addUserPage.setPassword(randomString());
        addUserPage.clickAddUserButton();
        
        assertEquals("Create user with only password should not be possible",false,addUserPage.errorMessageDisplays());
    }
    @Test
    public void userLibrarianCreateAndLoginAndVerifyRights(){
        
        User newUser = UserHelper.createNewLibraryUser(randomString(),randomString());
        UserHelper.loginAsUser(newUser.getUserName(), newUser.getPassword());

        String text=$(".v-margin-top > div:nth-child(5) > div:nth-child(1)").getText().substring(13);
        assertEquals("Librarian user should be logged in and username should display",newUser.getUserName()+".",text);

        assertEquals("Add books menu option should display",true,menuPage.addBooksLinkExists());
        assertEquals("Add Author menu option should display",true,menuPage.addAuthorLinkExists());
        
        //logging out
        menuPage.navigateToSignOut();
        text=$(".v-label").getText();
        assertEquals("Librarian user should be logged out message should display","Signed out user "+newUser.getUserName()+".",text);
    }
    @Test
    public void createAndDeleteLibrarianUser(){
       User user = UserHelper.createNewLibraryUser(randomString(), randomString());
       UserHelper.loginAsUser(user.getUserName(), user.getPassword());
       menuPage.navigateToMyProfile();
       
       myProfilePage.clickDeleteUserButton();
       myProfilePage.clickConfirmOKButton();
       
       UserHelper.loginAsUser(user.getUserName(), user.getPassword());
       
       assertEquals("Error wrong password should display as the user doesnt exist","Error: Wrong password.",$("div.v-slot:nth-child(9) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)").getText());
    
    }
}