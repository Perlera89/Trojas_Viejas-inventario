package com.trojasviejas.swing.tables.invoice;

import com.trojasviejas.swing.tables.item.*;
import com.trojasviejas.models.utility.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class InvoiceCellAction extends DefaultCellEditor{
    private InvoiceActionModel data;

    public InvoiceCellAction() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (InvoiceActionModel) o;
        InvoiceAction cell = new InvoiceAction(data);
        cell.setBackground(new Color(239, 244, 255));
        return cell;
    }

    @Override
    public Object getCellEditorValue() {
        return data;
    }
}