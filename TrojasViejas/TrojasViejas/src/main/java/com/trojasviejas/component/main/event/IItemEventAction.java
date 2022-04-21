package com.trojasviejas.component.main.event;

import com.trojasviejas.models.entity.ItemModel;

public interface IItemEventAction {
    public void delete(ItemModel entity);
    public void update(ItemModel entity);
}
