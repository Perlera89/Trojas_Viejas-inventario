package com.trojasviejas.models.entity;

import com.trojasviejas.models.utility.*;
import com.trojasviejas.component.main.event.*;

public class ItemModel {
    private String name;
    private CategoryType category;
    private int minimunAmount;
    private String description;
    
    public ItemModel(){
        
    }

    public ItemModel(String name, int minimunAmount, String description, CategoryType category) {
        this.name = name;
        this.minimunAmount = minimunAmount;
        this.description = description;
        this.category = category;
    }
    
    public Object[] toRowTable(IItemEventAction event) {
        return new Object[]{name, minimunAmount, description, category, new ItemActionModel(this, event)};
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
}
