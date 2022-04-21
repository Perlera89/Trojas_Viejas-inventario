package com.trojasviejas.models.entity;

import com.trojasviejas.component.main.event.*;
import com.trojasviejas.models.utility.*;

public class UserModel {
    private String username;
    private String password;

    public UserModel() {
    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Object[] toRowTable(IUserEventAction event) {
        return new Object[]{username, password, new UserActionModel(this, event)};
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
}
