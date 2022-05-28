/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trojasviejas.models.entity;

/**
 *
 * @author Willian
 */
public class InvoicesAverageReport {
    private int amoutPurchases;
    private int amountItems;
    private double value;
    
    public InvoicesAverageReport(int amoutPurchases, int amountItems, double value) {
        this.amoutPurchases = amoutPurchases;
        this.amountItems = amountItems;
        this.value = value;
    }

    public int getAmoutPurchases() {
        return amoutPurchases;
    }

    public void setAmoutPurchases(int amoutPurchases) {
        this.amoutPurchases = amoutPurchases;
    }

    public int getAmountItems() {
        return amountItems;
    }

    public void setAmountItems(int amountItems) {
        this.amountItems = amountItems;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
}
