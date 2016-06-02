package se.nackademin.librarytest.helpers;

import se.nackademin.librarytest.pages.AddUserPage;
import se.nackademin.librarytest.pages.MenuPage;
import se.nackademin.librarytest.pages.MyProfilePage;
import se.nackademin.librarytest.pages.SignInPage;
import static com.codeborne.selenide.Selenide.page;
import se.nackademin.librarytest.model.User;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

/**
 *
 * @author nicklas
 */
public class UserHelper {
    
    static MenuPage menuPage = page(MenuPage.class);
    
    public static User createNewLoanerUser(String userName, String passWord){
        
        // Create profile
        menuPage.navigateToAddUser();
        
        AddUserPage addUserPage = page(AddUserPage.class);
        addUserPage.setUserName(userName);
        addUserPage.setPassword(passWord);
        addUserPage.clickAddUserButton();
        
        User user = new User();
        user.setUserName(userName);
        user.setPassword(passWord);
        return user;

    }
    public static User createNewLibraryUser(String userName, String passWord){

        // Create profile
        UserHelper.loginAsAdmin();
        menuPage.navigateToAddUser();
        
        AddUserPage addUserPage = page(AddUserPage.class);
        addUserPage.setUserName(userName);
        addUserPage.setPassword(passWord);
        addUserPage.clickAddLibrarianRadioButton();
        addUserPage.clickAddUserButton();
        
        User user = new User();
        user.setUserName(userName);
        user.setPassword(passWord);
        user.setIsLibrarian(true);
        return user;
    }
    
    
    
    
    public static void loginAsUser(String userName, String passWord){
        
        menuPage.navigateToSignIn();
        SignInPage signInPage = page(SignInPage.class);
        signInPage.setUserName(userName);
        signInPage.setPassword(passWord);
        signInPage.clickLogInButton();
        sleep(1000);
    }
    
    public static void updateUserEmailAdress(String newEmailAdress){
        // Navigate to My Profile
        menuPage.navigateToMyProfile();
        
        // Change email adress
        MyProfilePage myProfilePage = page(MyProfilePage.class);
        myProfilePage.clickEditUserButton();
        myProfilePage.setEmailAdress(newEmailAdress);
        myProfilePage.clickSaveUserButton();
    }
    public static User createAndLoginNewUser(){
        User user = new User();

        UserHelper.createNewLoanerUser(user.getUserName(), user.getPassword());
        UserHelper.loginAsUser(user.getUserName(), user.getPassword());
        return user;
    }
    
    public static void loginAsAdmin(){
        UserHelper.loginAsUser("admin", "1234567890");
    }
}
