package se.nackademin.librarytest.pages;
import static com.codeborne.selenide.Selenide.sleep;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author nicklas
 */
public class BookPage extends PageBase{
    @FindBy(css="#gwt-uid-3")
    SelenideElement titleField;
    
    @FindBy(css="#gwt-uid-5")
    SelenideElement authorField;
    
    @FindBy(css="#gwt-uid-7")
    SelenideElement descriptionField;

    @FindBy(css="#gwt-uid-11")
    SelenideElement datePublishedField;
    
    @FindBy(css="#edit-book-button")
    SelenideElement editBookButton;
    
    @FindBy(css="#gwt-uid-7")
    SelenideElement datePublishedFieldEdit;
    
    @FindBy(css="#save-book-button")
    SelenideElement saveBookButton;
    
    @FindBy(css="#borrow-book-button")
    SelenideElement borrowBookButton;
    
    @FindBy(css="#gwt-uid-13")
    SelenideElement copiesAvailable;
    
    @FindBy(css="#confirmdialog-ok-button")
    SelenideElement confirmOKButton;
    
    
    public String getTitle(){
        return titleField.getText();
    }
    public String getAuthor(){
        return authorField.getText();
    }
    public String getDescription(){
        return descriptionField.getText();
    }
    
    public String getDatePublished(){
        return datePublishedField.getText();
    }

    public String getCopiesAvailable(){
        sleep(1000);
        return copiesAvailable.getText();
    }

    
    public void clickEditBookButton(){
        clickButton("edit book button",editBookButton);
    }
    public void setDatePublished(String date){
        setTextFieldValue("date published",date,datePublishedFieldEdit);
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
}
