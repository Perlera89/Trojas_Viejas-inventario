package com.trojasviejas.swing.tables.detail;

import com.trojasviejas.swing.tables.inventory.*;
import com.trojasviejas.models.utility.CategoryType;
import com.trojasviejas.models.utility.ItemType;
import com.trojasviejas.swing.CategoryCellStatus;
import com.trojasviejas.swing.ItemCellStatus;
import com.trojasviejas.swing.tables.TableHeader;
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class DetailTable extends JTable {

    public DetailTable() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);     
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                if (i1 == 5) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });      
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {           
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                    setBorder(noFocusBorder);
                    com.setForeground(new Color(102, 102, 102));
                    if (selected) {
                        com.setBackground(new Color(239, 244, 255));
                    } else {
                        com.setBackground(Color.WHITE);
                    }
                    return com;
            }
        });
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
}
