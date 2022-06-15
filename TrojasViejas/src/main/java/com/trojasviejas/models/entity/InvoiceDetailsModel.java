/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trojasviejas.models.entity;

/**
 *
 * @author wilian
 */
public class InvoiceDetailsModel {

    private int id;
    private int amount;
    private double pricerPerUnit;
    private int itemFk;
    private int invoiceFk;
    
    
    public InvoiceDetailsModel(int id, int amount, double pricerPerUnit, int itemFk, int invoiceFk) {
        this.id = id;
        this.amount = amount;
        this.pricerPerUnit = pricerPerUnit;
        this.itemFk = itemFk;
        this.invoiceFk = invoiceFk;
    }
        public InvoiceDetailsModel(int amount, double pricerPerUnit, int itemFk, int invoiceFk) {
        this.amount = amount;
        this.pricerPerUnit = pricerPerUnit;
        this.itemFk = itemFk;
        this.invoiceFk = invoiceFk;
    }

    public InvoiceDetailsModel() {
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

    public double getPricerPerUnit() {
        return pricerPerUnit;
    }

    public void setPricerPerUnit(double pricerPerUnit) {
        this.pricerPerUnit = pricerPerUnit;
    }

    public int getItemFk() {
        return itemFk;
    }

    public void setItemFk(int itemFk) {
        this.itemFk = itemFk;
    }

    public int getInvoiceFk() {
        return invoiceFk;
    }

    public void setInvoiceFk(int invoiceFk) {
        this.invoiceFk = invoiceFk;
    }
    
}
