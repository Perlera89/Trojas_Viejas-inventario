package com.trojasviejas.demo;

import javax.swing.SwingConstants;
import javax.swing.table.*;
import com.trojasviejas.models.*;
import com.trojasviejas.swing.ScrollBar;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;

public class FrmHome extends javax.swing.JPanel {

    public FrmHome() {
        initComponents();
        pnlCard1.setData(new CardModel(new ImageIcon("/Users/perlera/Documents/GitHub/Trojas_Viejas-inventario/TrojasViejas/src/main/src/icons/stock.png"), "Total stock", "200", "Incremento un 10%"));
        pnlCard2.setData(new CardModel(new ImageIcon("/Users/perlera/Documents/GitHub/Trojas_Viejas-inventario/TrojasViejas/src/main/src/icons/dollar.png"), "Total costo", "$1200", "Incremento un 45%"));
        pnlCard3.setData(new CardModel(new ImageIcon("/Users/perlera/Documents/GitHub/Trojas_Viejas-inventario/TrojasViejas/src/main/src/icons/stock.png"), "Total stock", "200", "Incremento un 10%"));
        
        //Agregar registro
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.white);
        
        tblProviders.addRow(new Object[]{"Manuel Perlera", "7097-0435", "manuenitoo@gmail.com", "Barrio el carmen", ProviderType.VENDEDOR});
        tblProviders.addRow(new Object[]{"Manuel Perlera", "7097-0435", "manuenitoo@gmail.com", "Barrio el carmen", ProviderType.DONADOR});
        tblProviders.addRow(new Object[]{"Manuel Perlera", "7097-0435", "manuenitoo@gmail.com", "Barrio el carmen", ProviderType.VENDEDOR});
        tblProviders.addRow(new Object[]{"Manuel Perlera", "7097-0435", "manuenitoo@gmail.com", "Barrio el carmen", ProviderType.DONADOR});
        tblProviders.addRow(new Object[]{"Manuel Perlera", "7097-0435", "manuenitoo@gmail.com", "Barrio el carmen", ProviderType.VENDEDOR});
        tblProviders.addRow(new Object[]{"Manuel Perlera", "7097-0435", "manuenitoo@gmail.com", "Barrio el carmen", ProviderType.DONADOR});
        tblProviders.addRow(new Object[]{"Manuel Perlera", "7097-0435", "manuenitoo@gmail.com", "Barrio el carmen", ProviderType.VENDEDOR});
        tblProviders.addRow(new Object[]{"Manuel Perlera", "7097-0435", "manuenitoo@gmail.com", "Barrio el carmen", ProviderType.DONADOR});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JLayeredPane();
        pnlCard1 = new com.trojasviejas.component.main.PanelCard();
        pnlCard2 = new com.trojasviejas.component.main.PanelCard();
        pnlCard3 = new com.trojasviejas.component.main.PanelCard();
        pnlTable = new com.trojasviejas.swing.PanelBorder();
        lblProviders = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        tblProviders = new com.trojasviejas.swing.Table();

        setBackground(new java.awt.Color(232, 241, 242));

        pnlContainer.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        pnlCard1.setColor1(new java.awt.Color(0, 40, 85));
        pnlCard1.setColor2(new java.awt.Color(2, 62, 125));
        pnlContainer.add(pnlCard1);

        pnlCard2.setColor1(new java.awt.Color(255, 123, 0));
        pnlCard2.setColor2(new java.awt.Color(255, 136, 0));
        pnlContainer.add(pnlCard2);
        pnlContainer.add(pnlCard3);

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        lblProviders.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblProviders.setForeground(new java.awt.Color(127, 127, 127));
        lblProviders.setText("Proveedores");

        scroll.setBorder(null);

        tblProviders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Telefono", "Email", "Direccion", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProviders.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        scroll.setViewportView(tblProviders);

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addComponent(lblProviders)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblProviders)
                .addGap(13, 13, 13)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(pnlTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblProviders;
    private com.trojasviejas.component.main.PanelCard pnlCard1;
    private com.trojasviejas.component.main.PanelCard pnlCard2;
    private com.trojasviejas.component.main.PanelCard pnlCard3;
    private javax.swing.JLayeredPane pnlContainer;
    private com.trojasviejas.swing.PanelBorder pnlTable;
    private javax.swing.JScrollPane scroll;
    private com.trojasviejas.swing.Table tblProviders;
    // End of variables declaration//GEN-END:variables
}
