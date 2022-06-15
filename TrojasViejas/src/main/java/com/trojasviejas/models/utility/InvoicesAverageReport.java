/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trojasviejas.models.utility;

/**
 *
 * @author Willian
 */
public class InvoicesAverageReport {
    private int amountPurchases;
    private int amountItems;
    private double value;
    
    public InvoicesAverageReport(){
        
    }
    public InvoicesAverageReport(int amountPurchases, int amountItems, double value) {
        this.amountPurchases = amountPurchases;
        this.amountItems = amountItems;
        this.value = value;
    }

    public int getAmountPurchases() {
        return amountPurchases;
    }

    public void setAmountPurchases(int amountPurchases) {
        this.amountPurchases = amountPurchases;
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
