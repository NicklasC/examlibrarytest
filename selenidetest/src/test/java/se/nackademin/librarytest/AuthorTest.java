package se.nackademin.librarytest;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import se.nackademin.librarytest.helpers.AuthorHelper;
import se.nackademin.librarytest.helpers.UserHelper;
import se.nackademin.librarytest.model.Author;
import se.nackademin.librarytest.pages.AddAuthorPage;
import se.nackademin.librarytest.pages.ViewAuthorPage;
import static se.nackademin.librarytest.helpers.StringHelper.randomString;
import se.nackademin.librarytest.pages.BrowseAuthorsPage;
import se.nackademin.librarytest.pages.MenuPage;

/**
 *
 * @author nicklas
 */

public class AuthorTest extends TestBase {


        static ViewAuthorPage viewAuthorPage = page(ViewAuthorPage.class);
        static MenuPage menuPage = page(MenuPage.class);
        static AddAuthorPage addAuthorPage=page(AddAuthorPage.class);
        static BrowseAuthorsPage browseAuthorsPage=page(BrowseAuthorsPage.class);

    
    @Test
    public void createAuthor(){
        UserHelper.loginAsAdmin();
        
        Author newAuthor = AuthorHelper.addNewAuthor(null, null, null, null);
        
        AuthorHelper.searchAndDisplayAuthor(newAuthor.getFirstName(),newAuthor.getLastName(), newAuthor.getCountry());
        sleep(3000);
        assertEquals("displayed author name is correct",newAuthor.getFirstName()+" "+newAuthor.getLastName(),viewAuthorPage.getAuthorName());
        assertEquals("Author country displays correct",newAuthor.getCountry(),viewAuthorPage.getCountry());
        assertEquals("Author biography displays correct", newAuthor.getBiography(),viewAuthorPage.getBiography());
    }
    /**
 * Task 1: Create new author
 * @author nicklas
 */

    @Test
    public void createNewAuthorAndUpdate(){
       
        // Generate new author data
        String firstName = randomString();
        String lastName = randomString();
        String country = randomString();
        String biography = randomString();
        
        // Login
        UserHelper.loginAsAdmin();
        
        // Creating new author
        AuthorHelper.addNewAuthor(firstName, lastName, country, biography);
        
        // Now verifying that the author got added correctly...
        AuthorHelper.searchAndDisplayAuthor(firstName, lastName, country);
        sleep(3000);
        assertEquals("Author title should be '"+firstName +" "+lastName,firstName +" "+lastName,viewAuthorPage.getAuthorName());
        assertEquals("Country should be "+country,country,viewAuthorPage.getCountry());
        assertEquals("Biography should be "+biography,biography,viewAuthorPage.getBiography());
        
        // Now editing the author
        viewAuthorPage.clickEditAuthorButton();
        
        addAuthorPage.setFirstName(firstName+"x");
        addAuthorPage.setLastName(lastName+"y");
        addAuthorPage.setCountry(country+"z");
        addAuthorPage.setBiography(biography+"zz");
        addAuthorPage.clickSaveChangesButton();
        
        AuthorHelper.searchAndDisplayAuthor(firstName+"x", lastName+"y", country);
        
        assertEquals("Author name after update should be correct ",firstName+"x" +" "+lastName+"y",viewAuthorPage.getAuthorName());
        assertEquals("Country after update should be correct",country+"z",viewAuthorPage.getCountry());
        assertEquals("Biography after update should be correct",biography+"zz",viewAuthorPage.getBiography());
    }    
    
    @Test
    public void createAuthor_firstNameIsObligatory(){
    
        UserHelper.loginAsAdmin();

        AuthorHelper.addNewAuthor("", randomString(),randomString(), randomString());
        $(".v-label-undef-w").waitUntil(Condition.visible, 9000);
        assertEquals("first name is obligatory, error message should display","Invalid data, please try again.",$(".v-label-undef-w").getText());
    }
    @Test
    public void createAuthor_lastNameIsObligatory(){
    
        UserHelper.loginAsAdmin();

        AuthorHelper.addNewAuthor(randomString(),"",randomString(), randomString());
        $(".v-label-undef-w").waitUntil(Condition.visible, 9000);
        assertEquals("last name is obligatory, error message should display","Invalid data, please try again.",$(".v-label-undef-w").getText());
    }
    @Test
    public void createAuthor_countryIsObligatory(){
    
        UserHelper.loginAsAdmin();

        AuthorHelper.addNewAuthor(randomString(),randomString(),"", randomString());
        $(".v-label-undef-w").waitUntil(Condition.visible, 9000);
        assertEquals("country is obligatory, error message should display","Invalid data, please try again.",$(".v-label-undef-w").getText());
    }
    @Test
    public void createAuthor_biographyIsObligatory(){
    
        UserHelper.loginAsAdmin();

        AuthorHelper.addNewAuthor(randomString(),randomString(),randomString(), "");
        $(".v-label-undef-w").waitUntil(Condition.visible, 9000);
        assertEquals("biography is obligatory, error message should display","Invalid data, please try again.",$(".v-label-undef-w").getText());
    }
    @Test
    public void createAndDeleteAuthor(){
        
        // Creating a new author
        UserHelper.loginAsAdmin();
        Author author = AuthorHelper.addNewAuthor(null, null, null, null);
        
        // Deleting it
        AuthorHelper.searchAndDisplayAuthor(author.getFirstName(), author.getLastName(), null);
        viewAuthorPage.clickDeleteAuthorButton();
        browseAuthorsPage.clickConfirmOkButton();
        
        // Verifying it is removed
        menuPage.navigateToBrowseAuthors();
        browseAuthorsPage.setName(author.getFirstName()+" "+author.getLastName());
        browseAuthorsPage.clickSearchAuthorsButton();
        
        assertEquals("Author should not display in search as it is deleted",false,browseAuthorsPage.firstResultExists());
    }
}
