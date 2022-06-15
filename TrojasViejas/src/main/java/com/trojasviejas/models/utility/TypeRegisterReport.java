/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trojasviejas.models.utility;


import com.trojasviejas.models.utility.Months;

/**
 *
 * @author wilian
 */
public class TypeRegisterReport {
  
    private Months month;
    private int entries;
    private int amountEntries;
    private int outputs;
    private int amountOutPuts;

    public TypeRegisterReport() {
    }
    
    public TypeRegisterReport(Months month, int entries, int amountEntries, int outputs, int amountOutPuts) {
        this.month = month;
        this.entries = entries;
        this.amountEntries = amountEntries;
        this.outputs = outputs;
        this.amountOutPuts = amountOutPuts;
    }
    
    public Months getMonth() {
        return month;
    }

    public void setMonth(Months month) {
        this.month = month;
    }

    public int getEntries() {
        return entries;
    }

    public void setEntries(int entries) {
        this.entries = entries;
    }

    public int getAmountEntries() {
        return amountEntries;
    }

    public void setAmountEntries(int amountEntries) {
        this.amountEntries = amountEntries;
    }

    public int getOutputs() {
        return outputs;
    }

    public void setOutputs(int outputs) {
        this.outputs = outputs;
    }

    public int getAmountOutPuts() {
        return amountOutPuts;
    }

    public void setAmountOutPuts(int amountOutPuts) {
        this.amountOutPuts = amountOutPuts;
    }

  
    
}
