package se.nackademin.rest.test;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

/**
 *
 * @author nicklas
 */
public class UserOperations {
    private static final String BASE_URL="http://localhost:8080/librarytest-rest/users";   
    
    
    public static String getLastUserDisplayName(){
        Response getResponse = given().accept(ContentType.JSON).get(BASE_URL);
        return getResponse.jsonPath().getString("users.user[-1].displayName");
    }
    public static String getLastUserId(){
        Response getResponse = given().accept(ContentType.JSON).get(BASE_URL);
        return getResponse.jsonPath().getString("users.user[-1].id");
    }
    
    public static void createStaticUser(){
        String postBody;
        postBody="{\n" +
            "  \"user\": {\n" +
            "    \"id\": 999999999,\n" +
            "    \"displayName\": \"Nicklas\",\n" +
            "    \"email\": \"nca@example.com\",\n" +
            "    \"firstName\": \"Nicklas\",\n" +
            "    \"lastName\": \"Moraeus\",\n" +
            "    \"password\": \"secretpassword\",\n" +
            "    \"phone\": \"+46000333444\", \n" +
            "    \"role\":\"LOANER\"\n" +
            "  }\n" +
            "}";
            SendHelper.PostBody(postBody, BASE_URL);        
    
    }
    
    
}
