
package se.nackademin.librarytest.helpers;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static se.nackademin.librarytest.helpers.StringHelper.randomString;
import se.nackademin.librarytest.model.Author;
import se.nackademin.librarytest.pages.AddAuthorPage;
import se.nackademin.librarytest.pages.BrowseAuthorsPage;
import se.nackademin.librarytest.pages.MenuPage;

/**
 *
 * @author nicklas
 */
public class AuthorHelper {
    public static Author addNewAuthor(String firstName,String lastName,String country, String biography){
        MenuPage menuPage = page(MenuPage.class);
        AddAuthorPage addAuthorPage = page (AddAuthorPage.class);

        menuPage.navigateToAddAuthor();
        
        if(firstName==null){
            firstName=randomString();
        }
        if(lastName==null){
            lastName=randomString();
        }
        if(country==null){
            country=randomString();
        }
        if(biography==null){
            biography=randomString();
        }

        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setCountry(country);
        author.setBiography(biography);
    
        addAuthorPage.setFirstName(firstName);
        addAuthorPage.setLastName(lastName);
        addAuthorPage.setCountry(country);
        addAuthorPage.setBiography(biography);
        addAuthorPage.clickAddAuthorButton();
        
        return author;
    }
    
    public static void searchAndDisplayAuthor(String firstName,String lastName,String country){
        sleep(3000);
        MenuPage menuPage = page(MenuPage.class);
        BrowseAuthorsPage browseAuthorsPage = page(BrowseAuthorsPage.class);    
        
        menuPage.navigateToBrowseAuthors();
        sleep(3000);
        browseAuthorsPage.setName(firstName+" "+lastName);
        browseAuthorsPage.setCountry(country);
        browseAuthorsPage.clickSearchAuthorsButton();
        browseAuthorsPage.clickFirstSearchResult();
    }
}
