package com.trojasviejas.component.main.event;

import com.trojasviejas.models.entity.*;

public interface IUserEventAction {
    public void delete(UserModel entity);
    public void update(UserModel entity);
}
