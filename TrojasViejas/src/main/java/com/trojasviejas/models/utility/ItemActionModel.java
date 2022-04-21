package com.trojasviejas.models.utility;

import com.trojasviejas.models.entity.*;
import com.trojasviejas.component.main.event.*;

public class ItemActionModel {

    public ItemModel getItem() {
        return item;
    }

    public void setItem(ItemModel item) {
        this.item = item;
    }

    public IItemEventAction getEvent() {
        return event;
    }

    public void setEvent(IItemEventAction event) {
        this.event = event;
    }

    public ItemActionModel(ItemModel item, IItemEventAction event) {
        this.item = item;
        this.event = event;
    }

    public ItemActionModel() {
    }

    private ItemModel item;
    private IItemEventAction event;
}
