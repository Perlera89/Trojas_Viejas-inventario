package com.trojasviejas.models.entity;

import com.trojasviejas.models.utility.ProviderActionModel;
import com.trojasviejas.models.utility.ProviderType;
import java.text.DecimalFormat;
import javax.swing.Icon;
import com.trojasviejas.component.main.event.IProviderEventAction;

public class ProviderModel {
    private int id;
    private String name;
    private String numberPhone;
    private String email;
    private String address;
    private ProviderType type;

    public ProviderModel(int id, String name, String numberPhone, String email, String address, ProviderType type) {
        this. id = id;
        this.name = name;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.type = type;
    }

    public ProviderModel() {
    }
    
    public Object[] toRowTable(IProviderEventAction event) {
        return new Object[]{id, name, numberPhone, email, address, type, new ProviderActionModel(this, event)};
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
