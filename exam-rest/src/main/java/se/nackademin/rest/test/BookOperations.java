package se.nackademin.rest.test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;


/**
 *
 * @author nicklas
 */
public class BookOperations {
    private static final String BASE_URL="http://localhost:8080/librarytest/rest/";
    AuthorOperations authorOperations = new AuthorOperations();
    public void BookOperations(){
    
    }
    
    public String getLastBookTitle(){
        Response getResponse = given().accept(ContentType.JSON).get(BASE_URL+"books");
        return getResponse.jsonPath().getString("books.book[-1].title");
    }
    public String getLastBookDescription(){
        Response getResponse = given().accept(ContentType.JSON).get(BASE_URL+"books");
        return getResponse.jsonPath().getString("books.book[-1].description");
    }

    public String getLastBookId(){
        Response getResponse = given().accept(ContentType.JSON).get(BASE_URL+"books");
        return getResponse.jsonPath().getString("books.book[-1].id");
    }
    public String getLastBookIsbn(){
        Response getResponse = given().accept(ContentType.JSON).get(BASE_URL+"books");
        return getResponse.jsonPath().getString("books.book[-1].isbn");
    }
    
}
