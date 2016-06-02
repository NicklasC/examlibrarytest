package se.nackademin.rest.test;

import java.util.UUID;

/**
 *
 * @author nicklas
 */
public class StringOperations {
    public static String getRandomString(){
        return UUID.randomUUID().toString().substring(0, 12);
    }
    
}
