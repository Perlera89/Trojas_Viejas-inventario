package com.trojasviejas.swing.tables.item;

import com.trojasviejas.models.utility.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class ItemCellAction extends DefaultCellEditor{
    private ItemActionModel data;

    public ItemCellAction() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (ItemActionModel) o;
        ItemAction cell = new ItemAction(data);
        cell.setBackground(new Color(239, 244, 255));
        return cell;
    }

    @Override
    public Object getCellEditorValue() {
        return data;
    }
}