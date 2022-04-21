package com.trojasviejas.demo.form;

import com.trojasviejas.component.main.event.IItemEventAction;
import com.trojasviejas.demo.form.window.*;
import com.trojasviejas.models.utility.*;
import com.trojasviejas.swing.scroll.ScrollBar;
import javax.swing.*;
import java.awt.*;
import com.trojasviejas.models.entity.ItemModel;

public class FrmItems extends javax.swing.JPanel {

    public FrmItems() {
        setOpaque(false);
        initComponents();
        initCard();
        initTableData();
    }
    
    private void initCard(){
        pnlCard1.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/item.png")), "Total Articulos", "21", "Incremento un 10%"));
        pnlCard2.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/stock.png")), "Total Categorias", "$8", "Incremento un 45%"));
    }
    
    private void initTableData(){
        //Agregar registro
        IItemEventAction eventAction = new IItemEventAction() {
            @Override
            public void update(ItemModel entity) {
                System.out.println("Editar a " + entity.getName());
            }

            @Override
            public void delete(ItemModel entity) {
                System.out.println("Eliminar a " + entity.getName());
            }
        };
        
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.white);
        
        tblItems.addRow(new ItemModel("Tubo PVC", 20, "Sin descripcion", CategoryType.GALVANIZADO).toRowTable(eventAction));
        tblItems.addRow(new ItemModel("Arena", 25, "Sin descripcion", CategoryType.PVC).toRowTable(eventAction));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JLayeredPane();
        pnlCard1 = new com.trojasviejas.component.main.PanelCard();
        pnlCard2 = new com.trojasviejas.component.main.PanelCard();
        pnlTable = new com.trojasviejas.swing.panels.PanelBorder();
        lblProviders = new javax.swing.JLabel();
        btnNew = new com.trojasviejas.swing.Buttons.ActionButton();
        scroll = new javax.swing.JScrollPane();
        tblItems = new com.trojasviejas.swing.tables.item.ItemsTable();

        setBackground(new java.awt.Color(232, 241, 242));

        pnlContainer.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        pnlCard1.setColor1(new java.awt.Color(0, 40, 85));
        pnlCard1.setColor2(new java.awt.Color(2, 62, 125));
        pnlContainer.add(pnlCard1);

        pnlCard2.setColor1(new java.awt.Color(255, 123, 0));
        pnlCard2.setColor2(new java.awt.Color(255, 136, 0));
        pnlContainer.add(pnlCard2);

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        lblProviders.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblProviders.setForeground(new java.awt.Color(127, 127, 127));
        lblProviders.setText("Articulos");

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

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad minima", "Descripcion", "Categoria", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(tblItems);

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProviders)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblProviders)
                .addGap(27, 27, 27)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        WindowItems formulario = new WindowItems();
        formulario.setVisible(true);
    }//GEN-LAST:event_btnNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.Buttons.ActionButton btnNew;
    private javax.swing.JLabel lblProviders;
    private com.trojasviejas.component.main.PanelCard pnlCard1;
    private com.trojasviejas.component.main.PanelCard pnlCard2;
    private javax.swing.JLayeredPane pnlContainer;
    private com.trojasviejas.swing.panels.PanelBorder pnlTable;
    private javax.swing.JScrollPane scroll;
    private com.trojasviejas.swing.tables.item.ItemsTable tblItems;
    // End of variables declaration//GEN-END:variables
}
