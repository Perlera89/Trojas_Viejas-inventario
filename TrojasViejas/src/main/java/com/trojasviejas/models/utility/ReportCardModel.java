/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trojasviejas.models.utility;

import javax.swing.Icon;

/**
 *
 * @author Willian
 */
public class ReportCardModel {

    private String title;
    private Icon icon;
    private boolean month;
    private boolean year;
    
    public ReportCardModel() {
    }

    public ReportCardModel(String title, Icon icon, boolean month, boolean year) {
        this.title = title;
        this.icon = icon;
        this.month = month;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public boolean isMonth() {
        return month;
    }

    public void setMonth(boolean month) {
        this.month = month;
    }

    public boolean isYear() {
        return year;
    }

    public void setYear(boolean year) {
        this.year = year;
    }
    
}
