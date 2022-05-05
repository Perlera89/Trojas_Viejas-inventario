package com.trojasviejas.models.viewmodel;

import com.trojasviejas.models.utility.*;
import java.util.Date;


public class InventoryVM {
    private int id;
    private int amount;
    private String item;
    private int stock;
    private double pricePerUnit;
    private int minimunAmount;
    private CategoryType category;
    private ItemType type;
    private Date buyDate;
    
    public InventoryVM(){
        
    }

    public InventoryVM(int amount, String item, int stock, int minimunAmount, double pricePerUnit, CategoryType category, ItemType type, Date buyDate) {
        this.amount = amount;
        this.item = item;
        this.stock = stock;
        this.pricePerUnit = pricePerUnit;
        this.minimunAmount = minimunAmount;
        this.category = category;
        this.type = type;
        this.buyDate = buyDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getMinimunAmount() {
        return minimunAmount;
    }

    public void setMinimunAmount(int minimunAmount) {
        this.minimunAmount = minimunAmount;
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

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
}
