package se.nackademin.rest.test;

import com.jayway.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicklas
 */
public class AuthorsTest {
    
    private static final String BASE_URL="http://localhost:8080/librarytest-rest/authors";
    
    

    Response postResponse;
    public AuthorsTest() {
    }
    
    @Test    
    public void authors_POST201_createAuthorAndVerifyCreation(){

        String firstName = StringOperations.getRandomString();
        String lastName = StringOperations.getRandomString();
        String postBody="{\n" +
        "  \"author\": {\n" +
        "    \"bio\": \"Author bio...\",\n" +
        "    \"country\": \"Great Britain\",\n" +
        "    \"firstName\": \""+firstName+"\",\n" +
        "    \"lastName\": \""+lastName+"\"\n" +
        "  }\n" +
        "}";

        postResponse=SendHelper.PostBody(postBody, BASE_URL);
        assertEquals("Author created",201,postResponse.getStatusCode());

        // Checking that author was created
        assertEquals("Author should exist",firstName,AuthorOperations.getLastAuthorFirstName());
    }  
    
    @Test
    public void authors_POST400_createAuthorWithNoFirstNameNotPossible(){
        AuthorOperations.createStaticAuthors();
        
        String postBody="{\n" +
        "  \"author\": {\n" +
        "    \"bio\": \"Author bio...\",\n" +
        "    \"country\": \"Great Britain\",\n" +
        "    \"lastName\": \"Carlsson\"\n" +
        "  }\n" +
        "}";

        postResponse = SendHelper.PostBody(postBody, BASE_URL);
        assertEquals("Author with no first name not possible",400,postResponse.getStatusCode());
    }  
    
    @Test
    public void authors_PUT200_updateAuthor(){
        AuthorOperations.createRandomAuthor();
        
        String id=AuthorOperations.getLastAuthorId();
        String firstName = StringOperations.getRandomString();
        String putBody="{\n" +
        "  \"author\": {\n" +
        "    \"id\": \""+id+"\",\n" +
        "    \"bio\": \"Author bio...\",\n" +
        "    \"country\": \"Great Britain\",\n" +
        "    \"firstName\": \""+firstName+"\",\n" +
        "    \"lastName\": \"Testsson\"\n" +
        "  }\n" +
        "}";
        
        postResponse = SendHelper.PutBody(putBody, BASE_URL);
        assertEquals("Author should be updated, exp status 200",200,postResponse.getStatusCode());
        
         //Verifying update
        assertEquals("Author name should be updated",firstName,AuthorOperations.getLastAuthorFirstName());
    }
    
    @Test
    public void authors_PUT400_updateWithNoName(){
        AuthorOperations.createRandomAuthor();
        
        String id=AuthorOperations.getLastAuthorId();
        String firstName=AuthorOperations.getLastAuthorFirstName();
        
        String putBody="{\n" +
        "  \"author\": {\n" +
        "    \"id\": \""+id+"\",\n" +
        "    \"bio\": \"Author bio...\",\n" +
        "    \"country\": \"Great Britain\",\n" +
        "    \"lastName\": \"Testsson\"\n" +
        "  }\n" +
        "}";
        postResponse = SendHelper.PutBody(putBody, BASE_URL);
        assertEquals("No update should have been done",400,postResponse.getStatusCode());
        assertEquals("Old name should remain",firstName,AuthorOperations.getLastAuthorFirstName());
    }
    
    @Test
    public void authors_PUT404_tryUpdateAuthorThatDoesNotExist(){
        AuthorOperations.createRandomAuthor();
        String putBody="{\n" +
        "  \"author\": {\n" +
        "    \"id\": \"345msdvsdkkj2354\",\n" +
        "    \"bio\": \"Author bio...\",\n" +
        "    \"country\": \"Great Britain\",\n" +
        "    \"firstName\": \"Testnamn\",\n" +
        "    \"lastName\": \"Testsson\"\n" +
        "  }\n" +
        "}";
        
        postResponse = SendHelper.PutBody(putBody, BASE_URL);
        
        assertEquals("Cannot update author that does not exist",404,postResponse.getStatusCode());
    }
    
    @Test
    public void authors_GET200_fetchExistingAuthor(){
        // Making sure static authors exists...
        AuthorOperations.createStaticAuthors();
        postResponse = SendHelper.getBody(BASE_URL+"/"+999999999);
        
        assertEquals("Author should exist",200,postResponse.getStatusCode());

    }
   @Test
   public void authors_GET404_fetchAuthorThatDoesNotExist(){
        AuthorOperations.createStaticAuthors();
        postResponse = SendHelper.getBody(BASE_URL+"/"+999921739);
        
        assertEquals("Author should not exist",404,postResponse.getStatusCode());

    }
   @Test
   public void authors_DELETE204_deleteExistingAuthor(){
        // Creating a random author
        AuthorOperations.createRandomAuthor();
        String id=AuthorOperations.getLastAuthorId();
        
        postResponse = SendHelper.deleteBody(BASE_URL+"/"+id);
        
        assertEquals("Author should be deleted",204,postResponse.getStatusCode());
        
        // Now verifying author is deleted
        postResponse = SendHelper.getBody(BASE_URL+"/"+id);
        assertEquals("Author should not exist",404,postResponse.getStatusCode());
    }
   
   
   @Test
   public void authors_DELETE404_deleteNonExistantAuthor(){
        postResponse = SendHelper.deleteBody(BASE_URL+"/sdfgs¤%&¤%sdfgs");
        assertEquals("Author cannot be deleted as it does not exist",404,postResponse.getStatusCode());
   }

}    



