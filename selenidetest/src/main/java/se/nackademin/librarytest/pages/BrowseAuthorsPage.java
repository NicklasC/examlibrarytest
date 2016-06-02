package se.nackademin.librarytest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author nicklas
 */
public class BrowseAuthorsPage extends PageBase{
    
    @FindBy(css="#gwt-uid-3")
    private SelenideElement nameField;
    
    @FindBy(css="#gwt-uid-5")
    private SelenideElement countryField;
    
    @FindBy(css="#search-authors-button")
    private SelenideElement searchAuthorsButton;
    
    // First search hit gets this description
    @FindBy(css="td.v-grid-cell:nth-child(1) > a:nth-child(1)")
    private SelenideElement firstSearchResult;

    @FindBy(css="#confirmdialog-ok-button")
    SelenideElement confirmOkButton;
    
    
    public void setName(String name){
        setTextFieldValue("name",name,nameField);
    }
    public void setCountry(String country){
        setTextFieldValue("country",country,countryField);
    }
    public void clickSearchAuthorsButton(){
        clickButton("Search Authors button",searchAuthorsButton);
    }
    public void clickFirstSearchResult(){
        clickButton("first search result...",firstSearchResult);
    }
    public boolean firstResultExists(){
        return firstSearchResult.isDisplayed();
    }
    public void clickConfirmOkButton(){
        clickButton("confirm OK",confirmOkButton);
    }
    
    
    
}
