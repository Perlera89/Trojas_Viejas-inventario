package com.trojasviejas.demo.form;

import com.trojasviejas.demo.form.window.*;
import com.trojasviejas.models.entity.ProviderModel;
import com.trojasviejas.models.utility.*;
import com.trojasviejas.swing.scroll.ScrollBar;
import javax.swing.*;
import java.awt.*;
import com.trojasviejas.component.main.event.IProviderEventAction;
import com.trojasviejas.models.viewmodel.InventoryVM;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrmInventory extends javax.swing.JPanel {

    public FrmInventory() {
        setOpaque(false);
        initComponents();
        initCard();
        initTableData();
    }
    
    private void initCard(){
        pnlCard1.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/seller.png")), "Total Vendedores", "21"));
        pnlCard2.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/donor.png")), "Total Donadores", "$8"));
    }
    
    private void initTableData(){
        //Agregar registro
        IProviderEventAction eventAction = new IProviderEventAction() {
            @Override
            public void update(ProviderModel entity) {
                System.out.println("Editar a " + entity.getName());
            }

            @Override
            public void delete(ProviderModel entity) {
                System.out.println("Eliminar a " + entity.getName());
            }
        };
        
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.white);
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate fecha = LocalDate.now();
        
        tblInventory.addRow(new Object[]{10, "Tubo", 10, 5, 4, CategoryType.ACCESORIOS, ItemType.PVC, fecha});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JLayeredPane();
        pnlCard1 = new com.trojasviejas.component.main.PanelCard();
        pnlCard2 = new com.trojasviejas.component.main.PanelCard();
        pnlCard3 = new com.trojasviejas.component.main.PanelCard();
        pnlCard4 = new com.trojasviejas.component.main.PanelCard();
        pnlCard5 = new com.trojasviejas.component.main.PanelCard();
        pnlTable = new com.trojasviejas.swing.panels.PanelBorder();
        lblProviders = new javax.swing.JLabel();
        btnNew = new com.trojasviejas.swing.Buttons.ActionButton();
        scroll = new javax.swing.JScrollPane();
        tblInventory = new com.trojasviejas.swing.tables.inventory.InventoryTable();
        cbbStock = new com.trojasviejas.swing.ComboBox();

        setBackground(new java.awt.Color(232, 241, 242));

        pnlContainer.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        pnlCard1.setColor1(new java.awt.Color(0, 40, 85));
        pnlCard1.setColor2(new java.awt.Color(2, 62, 125));
        pnlContainer.add(pnlCard1);

        pnlCard2.setColor1(new java.awt.Color(77, 0, 165));
        pnlCard2.setColor2(new java.awt.Color(83, 0, 204));
        pnlContainer.add(pnlCard2);

        pnlCard3.setColor1(new java.awt.Color(108, 5, 0));
        pnlCard3.setColor2(new java.awt.Color(162, 0, 0));
        pnlContainer.add(pnlCard3);

        pnlCard4.setColor1(new java.awt.Color(0, 58, 1));
        pnlCard4.setColor2(new java.awt.Color(0, 71, 2));
        pnlContainer.add(pnlCard4);

        pnlCard5.setColor1(new java.awt.Color(255, 123, 0));
        pnlCard5.setColor2(new java.awt.Color(255, 136, 0));
        pnlContainer.add(pnlCard5);

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        lblProviders.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblProviders.setForeground(new java.awt.Color(127, 127, 127));
        lblProviders.setText("Inventario");

        btnNew.setBackground(new java.awt.Color(0, 184, 82));
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnNew.setText("Nuevo");
        btnNew.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        scroll.setBorder(null);

        tblInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Comprado", "Articulo", "Existencias", "Cantidad minima", "C/U", "Categoria", "Tipo", "Fecha de compra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(tblInventory);

        cbbStock.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Existencias", "Agotados" }));
        cbbStock.setSelectedIndex(-1);
        cbbStock.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        cbbStock.setLabeText("Elija existencia");

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTableLayout.createSequentialGroup()
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProviders)
                            .addGroup(pnlTableLayout.createSequentialGroup()
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbStock, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(scroll)))
                .addGap(20, 20, 20))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblProviders)
                .addGap(11, 11, 11)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        
    }//GEN-LAST:event_btnNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.Buttons.ActionButton btnNew;
    private com.trojasviejas.swing.ComboBox cbbStock;
    private javax.swing.JLabel lblProviders;
    private com.trojasviejas.component.main.PanelCard pnlCard1;
    private com.trojasviejas.component.main.PanelCard pnlCard2;
    private com.trojasviejas.component.main.PanelCard pnlCard3;
    private com.trojasviejas.component.main.PanelCard pnlCard4;
    private com.trojasviejas.component.main.PanelCard pnlCard5;
    private javax.swing.JLayeredPane pnlContainer;
    private com.trojasviejas.swing.panels.PanelBorder pnlTable;
    private javax.swing.JScrollPane scroll;
    private com.trojasviejas.swing.tables.inventory.InventoryTable tblInventory;
    // End of variables declaration//GEN-END:variables
}
