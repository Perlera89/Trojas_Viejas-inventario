package com.trojasviejas.models.viewmodel;

import com.trojasviejas.component.main.event.IInvoicesEventAction;
import com.trojasviejas.models.utility.InvoiceActionModel;
import com.trojasviejas.models.utility.ProviderType;
import java.util.Date;

public class InvoicesVM {
    private int id;
    private Double totalAmount;
    private String buyDate;
    private byte[] picture;
    private String name;
    

    public InvoicesVM() {
    }

    public InvoicesVM(int id, Double totalAmount, String buyDate, byte[] picture, String name) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.buyDate = buyDate;
        this.picture = picture;
        this.name = name;
    }
    
    public Object[] toRowTable(IInvoicesEventAction event) {
        return new Object[]{id, name, totalAmount, buyDate, picture, new InvoiceActionModel(this, event)};
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
