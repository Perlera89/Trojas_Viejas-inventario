package com.trojasviejas.models.viewmodel;

import com.trojasviejas.models.utility.ProviderType;
import java.util.Date;

public class InvoicesVM {
    private int id;
    private Double totalAmount;
    private Date buyDate;
    private byte[] picture;
    private String name;
    private String numberPhone;
    private String email;
    private String address;
    private ProviderType type;

    public InvoicesVM() {
    }

    public InvoicesVM(int id, Double totalAmount, Date buyDate, byte[] picture, String name, String numberPhone, String email, String address, ProviderType type) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.buyDate = buyDate;
        this.picture = picture;
        this.name = name;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.type = type;
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

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ProviderType getType() {
        return type;
    }

    public void setType(ProviderType type) {
        this.type = type;
    }
}
