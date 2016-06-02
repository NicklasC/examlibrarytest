package se.nackademin.rest.test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;


/**
 *
 * @author nicklas
 */
public class AuthorOperations {
    private static final String BASE_URL="http://localhost:8080/librarytest-rest/";    
    
    public static String getLastAuthorId(){
        Response getResponse = given().accept(ContentType.JSON).get(BASE_URL+"authors");
        return getResponse.jsonPath().getString("authors.author[-1].id");
    }
    public static String getLastAuthorFirstName(){
        Response getResponse = given().accept(ContentType.JSON).get(BASE_URL+"authors");
        return getResponse.jsonPath().getString("authors.author[-1].firstName");
    }

    public  static void createStaticAuthors(){
        String postBody="{\n" +
        "  \"author\": {\n" +
        "    \"id\": \"999999999\",\n" +
        "    \"bio\": \"Author bio...\",\n" +
        "    \"country\": \"Great Britain\",\n" +
        "    \"firstName\": \"Nicklas\",\n" +
        "    \"lastName\": \"Carlsson\"\n" +
        "  }\n" +
        "}";
       
        SendHelper.PostBody(postBody, BASE_URL+"authors");
        
        postBody="{\n" +
        "  \"author\": {\n" +
        "    \"id\": \"88888888\",\n" +
        "    \"bio\": \"Author bio...\",\n" +
        "    \"country\": \"Great Britain\",\n" +
        "    \"firstName\": \"Sven\",\n" +
        "    \"lastName\": \"Svensson\"\n" +
        "  }\n" +
        "}";
        SendHelper.PostBody(postBody, BASE_URL+"authors");
    }
    public static void createRandomAuthor(){
        String postBody="{\n" +
        "  \"author\": {\n" +
        "    \"bio\": \"Author bio...\",\n" +
        "    \"country\": \"Great Britain\",\n" +
        "    \"firstName\": \""+StringOperations.getRandomString()+"\",\n" +
        "    \"lastName\": \""+StringOperations.getRandomString()+"\"\n" +
        "  }\n" +
        "}";
        SendHelper.PutBody(postBody, BASE_URL+"authors");
    }

}
