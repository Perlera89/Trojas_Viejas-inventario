package com.trojasviejas.models.entity;

import com.trojasviejas.component.main.event.*;
import com.trojasviejas.models.utility.*;

public class UserModel {
    private int userId;
    private String username;
    private String password;
    private String verifyPassword;
    private String verifyCode;

    public UserModel() {
    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserModel(String username, String password, String verifyPassword) {
        this.username = username;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }
    
    public UserModel(int userId, String username, String password, String verifyPassword) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public UserModel(int userId, String username, String password, String verifyPassword, String verifyCode) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.verifyPassword = verifyPassword;
        this.verifyCode = verifyCode;
    }
    
    public Object[] toRowTable(IUserEventAction event) {
        return new Object[]{userId,username, password, new UserActionModel(this, event)};
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    
    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
