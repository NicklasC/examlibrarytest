package se.nackademin.librarytest.model;

import se.nackademin.librarytest.helpers.StringHelper;

/**
 *
 * @author nicklas
 */
public class User {
    private String userName;
    private String password;
    private boolean isLibrarian;
    
    public User(){
        this.userName=StringHelper.randomString();
        this.password=StringHelper.randomString();
        this.isLibrarian=false;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public boolean isLibrarian(){
        return this.isLibrarian;
    }
    public void setIsLibrarian(boolean isLibrarian){
        this.isLibrarian=isLibrarian;
    }
}
