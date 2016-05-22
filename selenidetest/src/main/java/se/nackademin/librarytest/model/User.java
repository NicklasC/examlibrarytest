package se.nackademin.librarytest.model;

import se.nackademin.librarytest.helpers.StringHelper;

/**
 *
 * @author nicklas
 */
public class User {
    private final String userName;
    private final String password;
    
    public User(){
        this.userName=StringHelper.randomString();
        this.password=StringHelper.randomString();
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
}
