/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trojasviejas.models.entity;

import java.util.Date;

/**
 *
 * @author cb272
 */
public class InvoicesModel {
    private int id;
    private Double totalAmount;
    private String buyDate;
    private byte[] picture;
    private int fkProv;

    public InvoicesModel() {
    }

    public InvoicesModel(int id, Double totalAmount, String buyDate, byte[] picture, int fkProv) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.buyDate = buyDate;
        this.picture = picture;
        this.fkProv = fkProv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getFkProv() {
        return fkProv;
    }

    public void setFkProv(int fkProv) {
        this.fkProv = fkProv;
    }
    
    
}
