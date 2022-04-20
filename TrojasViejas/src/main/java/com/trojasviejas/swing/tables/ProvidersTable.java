package com.trojasviejas.swing.tables;

import com.trojasviejas.models.utility.ProviderActionModel;
import com.trojasviejas.models.utility.ProviderType;
import com.trojasviejas.swing.TypeCellStatus;
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class ProvidersTable extends JTable {

    public ProvidersTable() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                if (i1 == 4) {
                    header.setHorizontalAlignment(JLabel.LEFT);
                }
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
//                if (i1 != 4) {
//                    Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
//                    com.setBackground(Color.WHITE);
//                    setBorder(noFocusBorder);
//                    if (selected) {
//                        com.setForeground(new Color(15, 89, 140));
//                    } else {
//                        com.setForeground(new Color(102, 102, 102));
//                    }
//                    return com;
//
//                } else {
//                    if (o instanceof ProviderActionModel) {
//                        ProviderActionModel data = (ProviderActionModel) o;
//                        ProviderAction cell = new ProviderAction(data);
//                        if (selected) {
//                            cell.setForeground(new Color(15, 89, 140));
//                        } else {
//                            cell.setForeground(new Color(102, 102, 102));
//                        }
//
//                        return cell;
//                    } else {
//                        ProviderType type = (ProviderType) o;
//                        TypeCellStatus cell = new TypeCellStatus(type);
//                        return cell;
//                    }
//                }
                if (o instanceof ProviderType) {
                    ProviderType type = (ProviderType) o;
                    TypeCellStatus cell = new TypeCellStatus(type);
                    
                    if (selected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    
                    return cell;

                } else if (o instanceof ProviderActionModel) {
                    ProviderActionModel data = (ProviderActionModel) o;
                    ProviderAction cell = new ProviderAction(data);
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
        if (col == 5) {
            return new ProviderCellAction();
        } else {
            return super.getCellEditor(row, col);
        }
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
}
