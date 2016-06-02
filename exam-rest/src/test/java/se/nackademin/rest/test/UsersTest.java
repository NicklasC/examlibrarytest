package se.nackademin.rest.test;

import com.jayway.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicklas
 */
public class UsersTest {
    
    Response response;
    String postBody;
    private static final String BASE_URL="http://localhost:8080/librarytest-rest/users";
    
    public UsersTest() {
    }
    
    
    @Test
    public void users_POST201_createUser(){
        
        String displayName=StringOperations.getRandomString();
    
        postBody="{\n" +
        "  \"user\": {\n" +
        "    \"displayName\": \""+displayName+"\",\n" +
        "    \"email\": \"lennart@example.com\",\n" +
        "    \"firstName\": \""+StringOperations.getRandomString()+"\",\n" +
        "    \"lastName\": \"Moraeus\",\n" +
        "    \"password\": \"secretpassword\",\n" +
        "    \"phone\": \"+46000333444\", \n" +
        "    \"role\":\"LOANER\"\n" +
        "  }\n" +
        "}";
        response=SendHelper.PostBody(postBody, BASE_URL);
        assertEquals("User should be created",201,response.getStatusCode());
        
        //response=SendHelper.getBody(BASE_URL+"/"+UserOperations.getLastUserId());
        assertEquals("Verifying book is created",displayName,UserOperations.getLastUserDisplayName());
    }
    @Test
    public void users_POST400_createUserWithExistingDisplayName(){
        
        postBody="{\n" +
        "  \"user\": {\n" +
        "    \"displayName\": \""+UserOperations.getLastUserDisplayName()+"\",\n" +
        "    \"email\": \"lennart@example.com\",\n" +
        "    \"firstName\": \""+StringOperations.getRandomString()+"\",\n" +
        "    \"lastName\": \"Moraeus\",\n" +
        "    \"password\": \"secretpassword\",\n" +
        "    \"phone\": \"+46000333444\", \n" +
        "    \"role\":\"LOANER\"\n" +
        "  }\n" +
        "}";
        response=SendHelper.PostBody(postBody, BASE_URL);
        assertEquals("User should not be created, displayname already exists",400,response.getStatusCode());
        
        //response=SendHelper.getBody(BASE_URL+"/"+UserOperations.getLastUserId());
        //assertEquals("Verifying book is created",displayName,UserOperations.getLastUserDisplayName());
    }
    @Test
    public void users_GET200_fetchExistingUser(){
        UserOperations.createStaticUser();
        response=SendHelper.getBody(BASE_URL+"/"+999999999);
        
        assertEquals("User should have been fetched",200,response.getStatusCode());
    }
    @Test
    public void users_GET404_fetchNonExistingUser(){
        UserOperations.createStaticUser();
        response=SendHelper.getBody(BASE_URL+"/"+996629999);
        
        assertEquals("It should not be possible to fetch non-existant user",404,response.getStatusCode());
    }    
    
    @Test
    public void users_DELETE204_deleteUser(){
        users_POST201_createUser();
        String id= UserOperations.getLastUserId();
        response=SendHelper.deleteBody(BASE_URL+"/"+id);
        
        assertEquals("User should be deleted",204,response.getStatusCode());
        
        // Verifying user is removed
        response=SendHelper.getBody(BASE_URL+"/"+id);
        assertEquals("User should not exist",404,response.getStatusCode());
    }
    
    @Test
    public void users_DELETE404_deleteUser(){
        response=SendHelper.deleteBody(BASE_URL+"/3453ss16d");
        assertEquals("User cannot be deleted as it doesnt exist",404,response.getStatusCode());
    }
}
