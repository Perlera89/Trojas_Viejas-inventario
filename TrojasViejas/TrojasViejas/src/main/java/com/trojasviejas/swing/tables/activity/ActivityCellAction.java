package com.trojasviejas.swing.tables.activity;

import com.trojasviejas.models.utility.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class ActivityCellAction extends DefaultCellEditor{
    private ActivityActionModel data;

    public ActivityCellAction() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (ActivityActionModel) o;
        ActivityAction cell = new ActivityAction(data);
        cell.setBackground(new Color(239, 244, 255));
        return cell;
    }

    @Override
    public Object getCellEditorValue() {
        return data;
    }
}