package com.trojasviejas.models.entity;

import com.trojasviejas.models.utility.ActionType;
import java.util.Date;

public class ActivityModel {
    private int id;
    private ActionType typeAction;
    private int currentStock;
    private String amount;
    private String description;
    private Date date;
    private int idInventory;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(int idInventory) {
        this.idInventory = idInventory;
    }

    
}
