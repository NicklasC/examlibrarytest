package se.nackademin.librarytest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author nicklas
 */
public class ViewAuthorPage extends PageBase{
    @FindBy(css="#gwt-uid-3")
    private SelenideElement authorName;
    
    @FindBy(css="#gwt-uid-5")
    private SelenideElement country;
    
    @FindBy(css="#gwt-uid-7")
    private SelenideElement biography;
    
    @FindBy(css="#edit-author-button")
    private SelenideElement editAuthorButton;
    
    
    //displays when logged in as administrator
    @FindBy(css="#delete-author-button")
    private SelenideElement deleteAuthorButton;
    
    @FindBy(css="#confirmdialog-ok-button")
    private SelenideElement confirmOkButton;
    
    public String getAuthorName(){
        return authorName.getText();
    }
    
    public String getCountry(){
        return country.getText();
    }
    public String getBiography(){
        return biography.getText();
    }
    
    public void clickEditAuthorButton(){
        clickButton("edit author button",editAuthorButton);
    }
    public void clickDeleteAuthorButton(){
        clickButton("delete author button",deleteAuthorButton);
    }
    public void clickConfirmOkButton(){
        clickButton("Confirm Ok button",confirmOkButton);
    }
}
