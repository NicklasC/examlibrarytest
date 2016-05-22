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
    
    public String getAuthorName(){
        return authorName.getText();
    }
    
    public String getCountry(){
        return country.getText();
    }
    public String getBiography(){
        return biography.getText();
    }
}
