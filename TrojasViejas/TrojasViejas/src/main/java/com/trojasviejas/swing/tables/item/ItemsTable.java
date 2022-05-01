package com.trojasviejas.swing.tables.item;

import com.trojasviejas.models.utility.CategoryType;
import com.trojasviejas.models.utility.ItemActionModel;
import com.trojasviejas.swing.CategoryCellStatus;
import com.trojasviejas.swing.tables.TableHeader;
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class ItemsTable extends JTable {

    public ItemsTable() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                if (i1 == 3) {
                    header.setHorizontalAlignment(JLabel.LEFT);
                }
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                if (o instanceof CategoryType) {
                    CategoryType type = (CategoryType) o;
                    CategoryCellStatus cell = new CategoryCellStatus(type);
                    
                    if (selected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    
                    return cell;

                } else if (o instanceof ItemActionModel) {
                    ItemActionModel data = (ItemActionModel) o;
                    ItemAction cell = new ItemAction(data);
                    if (selected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    
                    return cell;
                } else {
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
            }
        });
    }

    @Override
    public TableCellEditor getCellEditor(int row, int col) {
        if (col == 6) {
            return new ItemCellAction();
        } else {
            return super.getCellEditor(row, col);
        }
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
}
