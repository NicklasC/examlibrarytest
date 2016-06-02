package se.nackademin.librarytest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author nicklas
 */
public class AddAuthorPage extends PageBase{
    
    @FindBy(css="#gwt-uid-7")
    private SelenideElement firstNameField;
    
    @FindBy(css="#gwt-uid-9")
    private SelenideElement lastNameField;

    @FindBy(css="#gwt-uid-3")
    private SelenideElement countryField;

    @FindBy(css="#gwt-uid-5")
    private SelenideElement biographyField;
    
    @FindBy(css="#add-author-button")
    private SelenideElement addAuthorButton;
    
    @FindBy(css="#save-author-button")
    private SelenideElement saveChangesButton;
    
    public void setFirstName(String firstname){
        setTextFieldValue("username",firstname,firstNameField);
    }
    public void setLastName(String lastname){
        setTextFieldValue("username",lastname,lastNameField);
    }
    public void setCountry(String country){
        setTextFieldValue("username",country,countryField);
    }
    public void setBiography(String biography){
        setTextFieldValue("username",biography,biographyField);
    }
    public void clickAddAuthorButton(){
        clickButton("author button",addAuthorButton);
    }
    public void clickSaveChangesButton(){
        clickButton("save changes button",saveChangesButton);
    }
}
