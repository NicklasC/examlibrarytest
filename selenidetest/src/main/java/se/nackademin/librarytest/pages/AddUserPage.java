package se.nackademin.librarytest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends MenuPage {
    
    @FindBy(css="#gwt-uid-3")
    SelenideElement userNameField;
    
    @FindBy(css="#gwt-uid-5")
    SelenideElement passwordField;
    
    @FindBy(css="#add-user-button")
    SelenideElement addUserButton;
    
    @FindBy(css="v-label v-widget v-label-undef-w")
    SelenideElement errorMessage;
    
    @FindBy(css="span.v-radiobutton:nth-child(1)")
    SelenideElement librarianRadioButton;
    
    public void setUserName(String username){
        setTextFieldValue("user name field",username,userNameField);
    }
    
    public void setPassword(String password){
        setTextFieldValue("password field",password,passwordField);
    }
    public void clickAddUserButton(){
        clickButton("add user button", addUserButton);
    }
    public void clickAddLibrarianRadioButton(){
        clickButton("add user radio button",librarianRadioButton);
    }
    public boolean errorMessageDisplays(){
        return errorMessage.isDisplayed();
    }
}
