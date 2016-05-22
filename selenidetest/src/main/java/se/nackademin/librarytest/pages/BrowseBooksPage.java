package se.nackademin.librarytest.pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author nicklas
 */
public class BrowseBooksPage {
    @FindBy(css="#gwt-uid-3")
    private SelenideElement titleField;
    
    @FindBy(css="#search-books-button")
    private SelenideElement  searchBooksButton;
    
    @FindBy(css="td.v-grid-cell:nth-child(1) > a:nth-child(1)")
    private SelenideElement firstResultTitle;
    
    public void clickFirstResultTitle(){
        firstResultTitle.click();
    }
    
    public void setTitleField(String title){
        titleField.clear();
        titleField.sendKeys(title);
    }
    public void clickSearchBooksButton(){
        searchBooksButton.click();
    }
}
