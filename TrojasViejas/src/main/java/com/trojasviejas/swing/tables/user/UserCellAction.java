package com.trojasviejas.swing.tables.user;

import com.trojasviejas.swing.tables.item.*;
import com.trojasviejas.models.utility.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class UserCellAction extends DefaultCellEditor{
    private UserActionModel data;

    public UserCellAction() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (UserActionModel) o;
        UserAction cell = new UserAction(data);
        cell.setBackground(new Color(239, 244, 255));
        return cell;
    }

    @Override
    public Object getCellEditorValue() {
        return data;
    }
}