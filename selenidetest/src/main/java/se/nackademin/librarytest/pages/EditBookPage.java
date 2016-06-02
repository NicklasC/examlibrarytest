package se.nackademin.librarytest.pages;
import static com.codeborne.selenide.Selenide.sleep;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author nicklas
 */
public class EditBookPage extends PageBase{
    @FindBy(css="#gwt-uid-3")
    SelenideElement titleField;
    
    @FindBy(css=".v-select-twincol-options")
    SelenideElement authorSelect;
    
    @FindBy(css=".v-select-twincol-buttons > div:nth-child(1)")
    SelenideElement moveToSelectedAuthorsButton;
    
    
    @FindBy(css="#gwt-uid-9")
    SelenideElement descriptionField;

    @FindBy(css="#gwt-uid-11")
    SelenideElement numberOfPagesField;
    
    @FindBy(css="#gwt-uid-13")
    SelenideElement isbnField;
    
    @FindBy(css="#gwt-uid-5")
    SelenideElement numberInInventoryField;
    
    @FindBy(css="#gwt-uid-7")
    SelenideElement datePublishedField;

    
    @FindBy(css="#save-book-button")
    SelenideElement saveBookButton;
    
    @FindBy(css="#borrow-book-button")
    SelenideElement borrowBookButton;
    
    @FindBy(css="#confirmdialog-ok-button")
    SelenideElement confirmOKButton;
    
    
    @FindBy(css="#add-book-button")
    private SelenideElement addBookButton;
    
    @FindBy(css=".v-label-undef-w")
    private SelenideElement invalidDataErrorMessage;


    public String getTitle(){
        return titleField.getText();
    }
    public void setTitle(String title){
        setTextFieldValue("title",title,titleField);
    }

    public void setAuthorSelect(String author){
        authorSelect.selectOption(author);
        moveToSelectedAuthorsButton.click();
    }
    
    public String getDescription(){
        return descriptionField.getText();
    }
    public void setDescription(String description){
        setTextFieldValue("book description",description,descriptionField);
    }
    
    
    public void setNumberOfPages(String pages){
        setTextFieldValue("number of pages",pages,numberOfPagesField);
    }

    
    public String getIsbn(){
        return isbnField.getText();
    }
    public void setIsbn(String isbn){
        setTextFieldValue("isbn",isbn,isbnField);
    }

    public void setNumberInInventory(String nbrAvailable){
        setTextFieldValue("Number in inventory",nbrAvailable,numberInInventoryField);
    }
    public String getNumberInInventory(){
        sleep(1000);
        return numberInInventoryField.getText();
    }
    

    public void setDatePublished(String date){
        setTextFieldValue("date published",date,datePublishedField);
    }


// Buttons    
    public void clickAddBookButton(){
        clickButton("add book button",addBookButton);
    }
    
    public void clickSaveBookButton(){
        clickButton("save book button",saveBookButton);
    }
    public void clickBorrowBookButton(){
        clickButton("borrow book button",borrowBookButton);
    }
    public void clickConfirmOKbutton(){
        clickButton("Confirm OK button",confirmOKButton);
    }
    
    public boolean invalidDataErrorMessageDisplays(){
        return invalidDataErrorMessage.isDisplayed();
    }
}
