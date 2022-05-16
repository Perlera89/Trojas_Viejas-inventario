package com.trojasviejas.models.viewmodel;

import com.trojasviejas.models.utility.*;
import java.util.Date;

public class ActivityVM {
    
    private int id;
    private ActionType typeAction;
    private String item;
    private int currentStock;
    private String amount;
    private int newStock;
    private String description;
    private double pricePerUnit;
    private CategoryType category;
    private ItemType type;
    private String buyDate;
    private String registerDate;
    
    public ActivityVM(){
        
    }

    public ActivityVM(int id, ActionType typeAction, String item, int currentStock, String amount, int newStock, String description, double pricePerUnit, CategoryType category, ItemType type, String buyDate, String registerDate) {
        this.id = id;
        this.typeAction = typeAction;
        this.item = item;
        this.currentStock = currentStock;
        this.amount = amount;
        this.newStock = newStock;
        this.description = description;
        this.pricePerUnit = pricePerUnit;
        this.category = category;
        this.type = type;
        this.buyDate = buyDate;
        this.registerDate = registerDate;
    }
    
    public Object[] toRowTable() {
        return new Object[]{id, typeAction, item, currentStock, amount, newStock, description, pricePerUnit, category, type, buyDate, registerDate};
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ActionType getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(ActionType typeAction) {
        this.typeAction = typeAction;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getNewStock() {
        return newStock;
    }

    public void setNewStock(int newStock) {
        this.newStock = newStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getDate() {
        return registerDate;
    }

    public void setDate(String date) {
        this.registerDate = date;
    }
}
