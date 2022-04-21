package com.trojasviejas.models.utility;

public class TestModel {

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
    
    public TestModel(){
        
    }

    public TestModel(int userId, String userName, String password, String verifyPassword) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }
    
    public TestModel(int userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }
    
    private int userId;
    private String userName;
    private String password;
    private String verifyPassword;
}
