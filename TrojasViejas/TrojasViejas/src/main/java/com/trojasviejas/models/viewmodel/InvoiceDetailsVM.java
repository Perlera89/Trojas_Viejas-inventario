/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trojasviejas.models.viewmodel;

/**
 *
 * @author wilian
 */
public class InvoiceDetailsVM {
    
    private int id;
    private int amount;
    private String itemName;
    private double pricerPerUnit;
    private double subtotal;
    private int invoiceFk;
    
    public InvoiceDetailsVM() {
    }

    public InvoiceDetailsVM(int id, int amount, String itemName, double pricerPerUnit, double subtotal, int invoiceFk) {
        this.id = id;
        this.amount = amount;
        this.itemName = itemName;
        this.pricerPerUnit = pricerPerUnit;
        this.subtotal = subtotal;
        this.invoiceFk = invoiceFk;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPricerPerUnit() {
        return pricerPerUnit;
    }

    public void setPricerPerUnit(double pricerPerUnit) {
        this.pricerPerUnit = pricerPerUnit;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getInvoiceFk() {
        return invoiceFk;
    }

    public void setInvoiceFk(int invoiceFk) {
        this.invoiceFk = invoiceFk;
    }
    
}
