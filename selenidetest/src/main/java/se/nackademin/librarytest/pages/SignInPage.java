package se.nackademin.librarytest.pages;

import com.codeborne.selenide.SelenideElement;
import java.util.logging.Logger;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageBase {
    
    private  static final Logger LOG = Logger.getLogger(MenuPage.class.getName());
    @FindBy(css="#input-username")
    SelenideElement userNameField;
    
    @FindBy(css="#input-password")
    SelenideElement passwordField;
    
    @FindBy(css="#login-button")
    SelenideElement logInButton;
    
    public void setUserName(String username){
        setTextFieldValue("username",username,userNameField);
    }
    
    public void setPassword(String password){
        setTextFieldValue("password",password,passwordField);
    }
    public void clickLogInButton(){
        logInButton.click();
    }
}
