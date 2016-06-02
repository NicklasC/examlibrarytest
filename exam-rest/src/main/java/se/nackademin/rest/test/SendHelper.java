package se.nackademin.rest.test;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

/**
 *
 * @author nicklas
 */
public class SendHelper {
    
    public static Response PostBody(String postBody, String targetUrl){
        return given().contentType(ContentType.JSON).body(postBody).post(targetUrl);
    }
    public static Response PutBody(String putBody, String targetUrl){
        return given().contentType(ContentType.JSON).body(putBody).put(targetUrl);
    }
    public static Response getBody(String url){
        return given().contentType(ContentType.JSON).get(url);
    }
    public static Response deleteBody(String url){
        return given().contentType(ContentType.JSON).delete(url);
    }
    
    
    
}
