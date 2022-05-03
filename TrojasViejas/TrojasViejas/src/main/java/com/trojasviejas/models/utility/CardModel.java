package com.trojasviejas.models.utility;

import javax.swing.*;

public class CardModel {
    Icon icon;
    String title;
    String values;
    
    public CardModel(){
        
    }
    
    public CardModel(Icon icon, String title, String values){
        this.icon = icon;
        this.title = title;
        this.values = values;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
