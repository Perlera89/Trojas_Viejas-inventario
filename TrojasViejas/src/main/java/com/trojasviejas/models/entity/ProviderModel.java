package com.trojasviejas.models.entity;

import com.trojasviejas.component.main.event.IEventAction;
import com.trojasviejas.models.utility.ProviderActionModel;
import com.trojasviejas.models.utility.ProviderType;
import java.text.DecimalFormat;
import javax.swing.Icon;

public class ProviderModel {
    private String name;
    private String numberPhone;
    private String email;
    private String address;
    private ProviderType type;

    public ProviderModel(String name, String numberPhone, String email, String address, ProviderType type) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.type = type;
    }

    public ProviderModel() {
    }
    
    public Object[] toRowTable(IEventAction event) {
        return new Object[]{name, numberPhone, email, address, type, new ProviderActionModel(this, event)};
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
