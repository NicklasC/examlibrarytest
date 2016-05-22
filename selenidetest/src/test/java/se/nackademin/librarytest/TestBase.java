package se.nackademin.librarytest;

import static com.codeborne.selenide.Selenide.open;
import org.junit.After;
import org.junit.Before;

/**
 *
 * @author nicklas
 */
public class TestBase {
    @Before
    public void setup(){
        open("http://localhost:8080/librarytest");
    }
    @After
    public void teardown(){
    
    }
}
