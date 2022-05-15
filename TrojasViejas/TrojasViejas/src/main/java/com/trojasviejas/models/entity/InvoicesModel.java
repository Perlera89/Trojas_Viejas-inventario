package com.trojasviejas.models.entity;

import com.trojasviejas.component.main.event.IInvoicesEventAction;
import com.trojasviejas.component.main.event.IItemEventAction;
import com.trojasviejas.models.utility.InvoiceActionModel;
import com.trojasviejas.models.utility.ItemActionModel;
import java.util.Date;

public class InvoicesModel {
    private int id;
    private Double totalAmount;
    private String buyDate;
    private byte[] picture;
    private int fkProv;

    public InvoicesModel() {
    }

    public InvoicesModel(int id, Double totalAmount, String buyDate, int fkProv) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.buyDate = buyDate;
        //this.picture = picture;
        this.fkProv = fkProv;
    }
    
    public Object[] toRowTable(IInvoicesEventAction event) {
        return new Object[]{id, totalAmount, buyDate, fkProv, new InvoiceActionModel(this, event)};
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
