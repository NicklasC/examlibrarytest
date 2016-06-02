package se.nackademin.librarytest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends PageBase{
    @FindBy(css="#side-menu-link-add-user")
    private SelenideElement addUser;
    @FindBy(css="#side-menu-link-sign-in")
    private SelenideElement signIn;
    
    @FindBy(css="#side-menu-link-sign-out")
    private SelenideElement signOut;
    
    
    @FindBy(css="#side-menu-link-my-profile")
    private SelenideElement myProfile;
    
    @FindBy(css="#side-menu-link-browse-books")
    private SelenideElement browseBook;
    
    @FindBy(css="#side-menu-link-add-author")
    private SelenideElement addAuthor;
    
    @FindBy(css="#side-menu-link-browse-authors")
    private SelenideElement browseAuthors;
    
    @FindBy(css="#side-menu-link-add-book")
    private SelenideElement addBooks;
    
    public void navigateToBrowseBooks(){
        clickButton("browse books", browseBook);
    }
       
    public void navigateToAddBooks(){
        clickButton("add books",addBooks);
    }
    public boolean addBooksLinkExists(){
        return addBooks.isDisplayed();
    }
    
    public void navigateToAddUser(){
        clickButton("add user", addUser);
    }
    public void navigateToSignIn(){
        clickButton("sign in", signIn);
    }
    public void navigateToSignOut(){
        clickButton("sign out", signOut);
    }
    public void navigateToMyProfile(){
        clickButton("my profile",myProfile);
    }
    public void navigateToAddAuthor(){
        clickButton("add author",addAuthor);
    }
    public boolean addAuthorLinkExists(){
        return addAuthor.isDisplayed();
    }
    
    public void navigateToBrowseAuthors(){
        clickButton("browse authors",browseAuthors);
    }
}
