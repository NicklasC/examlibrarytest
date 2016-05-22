package se.nackademin.librarytest.helpers;
import java.util.UUID;

/**
 *
 * @author nicklas
 */
public class StringHelper {
    
    public static String randomString(){
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
