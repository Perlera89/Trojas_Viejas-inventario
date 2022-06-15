package com.trojasviejas.models.viewmodel;

import com.trojasviejas.component.main.event.IInvoicesEventAction;
import com.trojasviejas.models.utility.InvoiceActionModel;
import com.trojasviejas.models.utility.ProviderType;
import java.util.Date;

public class InvoicesVM {
    private int id;
    private String totalAmount;
    private String buyDate;
    private byte[] picture;
    private String name;

    private int amountItems;
    private int stock;
    

    public InvoicesVM() {
    }

    public InvoicesVM(int id, String totalAmount, String buyDate, byte[] picture, String name, int amountItems, int stock) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.buyDate = buyDate;
        this.picture = picture;
        this.name = name;
        this.amountItems = amountItems;
        this.stock = stock;
    }
    
    public Object[] toRowTable(IInvoicesEventAction event) {
        return new Object[]{id, name, totalAmount, amountItems, stock, buyDate, picture, new InvoiceActionModel(this, event)};
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
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
    
    public int getAmountItems() {
        return amountItems;
    }

    public void setAmountItems(int amountItems) {
        this.amountItems = amountItems;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
