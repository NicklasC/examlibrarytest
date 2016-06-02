package se.nackademin.librarytest.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ViewBookPage extends PageBase{
    
    @FindBy(css="#gwt-uid-3")
    private SelenideElement titleField;
    
    @FindBy(css="#gwt-uid-5")
    private SelenideElement authorField;
    
    @FindBy(css="#gwt-uid-7")
    private SelenideElement descriptionField;
    
    @FindBy(css="#gwt-uid-9")
    private SelenideElement isbnField;

    @FindBy(css="#gwt-uid-11")
    private SelenideElement datePublishedField;
    
    @FindBy(css="#gwt-uid-13")
    private SelenideElement numberOfCopiesAvailableField;
    
    @FindBy(css="#gwt-uid-15")
    private SelenideElement totalNumberOfCopiesAvailableField;


    @FindBy(css="#borrow-book-button")
    private SelenideElement borrowBookButton;

    @FindBy(css="#edit-book-button")
    private SelenideElement editBookButton;
    
    @FindBy(css="#delete-book-button")
    private SelenideElement deleteBookButton;

    @FindBy(css="#confirmdialog-ok-button")
    private SelenideElement confirmOkButton;
    
    @FindBy(css="#return-book-button")
    SelenideElement returnBookButton;




    public String getTitle(){
        titleField.waitUntil(Condition.visible, 9000);
        return titleField.getText();
    }

    public String getAuthor(){
        return authorField.getText();
    }

    public String getDescription(){
        return descriptionField.getText();
    }

    public String getIsbn(){
        return isbnField.getText();
    }

    public String getDatePublished(){
        return datePublishedField.getText();
    }

    public String getNumberOfCopiesAvailable(){
        return numberOfCopiesAvailableField.getText();
    }

    public String getTotalNumberOfCopiesAvailable(){
        return totalNumberOfCopiesAvailableField.getText();
    }


    // Buttons
    public void clickBorrowBookButton(){
        clickButton("borrow book button",borrowBookButton);
    }
    
    public void clickEditBookButton(){
        clickButton("edit book button",editBookButton);
    }

    public void clickDeleteBookButton(){
        clickButton("delete book button",deleteBookButton);
    }
    
    public void clickConfirmOkButton(){
        clickButton("confirm ok button",confirmOkButton);
    }
    
    public void clickReturnBookButton(){
        clickButton("return book button",returnBookButton);
    }
}
