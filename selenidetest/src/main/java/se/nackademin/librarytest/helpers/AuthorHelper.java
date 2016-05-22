
package se.nackademin.librarytest.helpers;
import static com.codeborne.selenide.Selenide.page;
import se.nackademin.librarytest.pages.AddAuthorPage;
import se.nackademin.librarytest.pages.BrowseAuthorsPage;
import se.nackademin.librarytest.pages.MenuPage;

/**
 *
 * @author nicklas
 */
public class AuthorHelper {
    public static void addNewAuthor(String firstName,String lastName,String country, String biography){
        MenuPage menuPage = page(MenuPage.class);
        AddAuthorPage addAuthorPage = page (AddAuthorPage.class);
      
        menuPage.navigateToAddAuthor();
    
        addAuthorPage.setFirstName(firstName);
        addAuthorPage.setLastName(lastName);
        addAuthorPage.setCountry(country);
        addAuthorPage.setBiography(biography);
        addAuthorPage.clickAddAuthorButton();

    }
    public static void searchAndDisplayAuthor(String firstName,String lastName,String country){
        MenuPage menuPage = page(MenuPage.class);
            
        menuPage.navigateToBrowseAuthors();
        BrowseAuthorsPage browseAuthorsPage = page(BrowseAuthorsPage.class);
        
        browseAuthorsPage.setName(firstName+" "+lastName);
        browseAuthorsPage.setCountry(country);
        browseAuthorsPage.clickSearchAuthorsButton();
        browseAuthorsPage.clickFirstSearchResult();
    }
}
