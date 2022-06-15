package com.trojasviejas.models.utility;

import com.trojasviejas.models.entity.*;
import com.trojasviejas.component.main.event.*;

public class UserActionModel {

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public IUserEventAction getEvent() {
        return event;
    }

    public void setEvent(IUserEventAction event) {
        this.event = event;
    }

    public UserActionModel(UserModel user, IUserEventAction event) {
        this.user = user;
        this.event = event;
    }

    public UserActionModel() {
    }

    private UserModel user;
    private IUserEventAction event;
}
