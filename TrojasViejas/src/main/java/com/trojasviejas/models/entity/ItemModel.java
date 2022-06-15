package com.trojasviejas.models.entity;

import com.trojasviejas.models.utility.*;
import com.trojasviejas.component.main.event.*;

public class ItemModel {
    private int idItem;
    private String name;
    private CategoryType category;
    private ItemType type;
    private int minimunAmount;
    private String description;
    
    public ItemModel(){
        
    }

    public ItemModel(int idItem, String name, int minimunAmount, String description, CategoryType category, ItemType type) {
        this.idItem = idItem;
        this.name = name;
        this.minimunAmount = minimunAmount;
        this.description = description;
        this.category = category;
        this.type = type;
    }
    
    
    public Object[] toRowTable(IItemEventAction event) {
        return new Object[]{idItem, name, minimunAmount, description, category, type, new ItemActionModel(this, event)};
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public int getMinimunAmount() {
        return minimunAmount;
    }

    public void setMinimunAmount(int minimunAmount) {
        this.minimunAmount = minimunAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
