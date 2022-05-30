package com.trojasviejas.demo.form;

import com.trojasviejas.swing.scroll.ScrollBar;
import java.awt.*;
import javax.swing.*;

public class FrmDetails extends javax.swing.JFrame {

    public FrmDetails() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        initTableData();
    }
    
    public void initTableData(){
        scrollTable.setVerticalScrollBar(new ScrollBar());
        scrollTable.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scrollTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scrollTable.getViewport().setBackground(Color.white);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new com.trojasviejas.swing.panels.PanelBorder();
        pnlHeader = new com.trojasviejas.swing.panels.PanelBorder();
        btnClose = new com.trojasviejas.swing.Buttons.ActionButton();
        jLabel1 = new javax.swing.JLabel();
        lblEncabezado = new javax.swing.JLabel();
        pnlData = new com.trojasviejas.swing.panels.PanelShadow();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblProvider = new javax.swing.JLabel();
        lblBuyDate = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        cbbItems = new com.trojasviejas.swing.ComboBox();
        btnSearch = new com.trojasviejas.swing.buttons.Button();
        txtItem = new com.trojasviejas.swing.fields.MyTextField();
        txtCU = new com.trojasviejas.swing.fields.MyTextField();
        txtAmount = new com.trojasviejas.swing.fields.MyTextField();
        btnAdd = new com.trojasviejas.swing.buttons.Button();
        pnlTable1 = new com.trojasviejas.swing.panels.PanelBorder();
        btnRefresh1 = new com.trojasviejas.swing.Buttons.ActionButton();
        scrollTable = new javax.swing.JScrollPane();
        detailTable = new com.trojasviejas.swing.tables.detail.DetailTable();
        jLabel4 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnAdd1 = new com.trojasviejas.swing.buttons.Button();
        panelBorder3 = new com.trojasviejas.swing.panels.PanelBorder();
        btnAdd2 = new com.trojasviejas.swing.buttons.Button();
        btnAdd3 = new com.trojasviejas.swing.buttons.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        pnlContainer.setBackground(new java.awt.Color(255, 255, 255));

        pnlHeader.setBackground(new java.awt.Color(27, 152, 224));

        btnClose.setBackground(new java.awt.Color(27, 152, 224));
        btnClose.setForeground(new java.awt.Color(200, 0, 20));
        btnClose.setText("X");
        btnClose.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/isotipoSmall.png"))); // NOI18N

        lblEncabezado.setBackground(new java.awt.Color(255, 255, 255));
        lblEncabezado.setFont(new java.awt.Font("Norwester", 0, 24)); // NOI18N
        lblEncabezado.setForeground(new java.awt.Color(255, 255, 255));
        lblEncabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEncabezado.setText("Detalles de factura");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 152, 224));
        jLabel2.setText("Detalles de compra");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(100, 100, 100));
        jLabel3.setText("Proveedor:");

        lblProvider.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblProvider.setForeground(new java.awt.Color(100, 100, 100));
        lblProvider.setText("...");

        lblBuyDate.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblBuyDate.setForeground(new java.awt.Color(100, 100, 100));
        lblBuyDate.setText("...");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(100, 100, 100));
        jLabel8.setText("Fecha de compra");

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(100, 100, 100));
        jLabel9.setText("Valor de compra");

        lblPrice.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(100, 100, 100));
        lblPrice.setText("...");

        javax.swing.GroupLayout pnlDataLayout = new javax.swing.GroupLayout(pnlData);
        pnlData.setLayout(pnlDataLayout);
        pnlDataLayout.setHorizontalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProvider)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(lblPrice))
                        .addGap(234, 234, 234)
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBuyDate)
                            .addComponent(jLabel8))
                        .addGap(30, 30, 30))))
        );
        pnlDataLayout.setVerticalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(20, 20, 20)
                        .addComponent(lblProvider))
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(20, 20, 20)
                        .addComponent(lblPrice))
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(20, 20, 20)
                        .addComponent(lblBuyDate)))
                .addGap(34, 34, 34))
        );

        cbbItems.setLabeText("Articulo");

        btnSearch.setBackground(new java.awt.Color(0, 100, 148));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_small.png"))); // NOI18N
        btnSearch.setText("Buscar");

        txtItem.setColorFont(new java.awt.Color(27, 152, 224));
        txtItem.setHint("Articulo:");

        txtCU.setColorFont(new java.awt.Color(27, 152, 224));
        txtCU.setHint("C/U:");

        txtAmount.setColorFont(new java.awt.Color(27, 152, 224));
        txtAmount.setHint("Cantidad:");

        btnAdd.setBackground(new java.awt.Color(255, 5, 0));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.png"))); // NOI18N
        btnAdd.setText("Cancelar");

        pnlTable1.setBackground(new java.awt.Color(255, 255, 255));

        btnRefresh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRefresh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRefresh1MousePressed(evt);
            }
        });

        detailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cantidad", "Articulo", "C/U", "Subtotal", "Factura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTable.setViewportView(detailTable);

        javax.swing.GroupLayout pnlTable1Layout = new javax.swing.GroupLayout(pnlTable1);
        pnlTable1.setLayout(pnlTable1Layout);
        pnlTable1Layout.setHorizontalGroup(
            pnlTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTable1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(pnlTable1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        pnlTable1Layout.setVerticalGroup(
            pnlTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTable1Layout.createSequentialGroup()
                .addComponent(btnRefresh1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jLabel4.setFont(new java.awt.Font("Anton", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 152, 224));
        jLabel4.setText("Total:");

        lblTotal.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(27, 152, 224));
        lblTotal.setText("...");

        btnAdd1.setBackground(new java.awt.Color(0, 184, 82));
        btnAdd1.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnAdd1.setText("Agregar");

        panelBorder3.setBackground(new java.awt.Color(232, 241, 242));

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        btnAdd2.setBackground(new java.awt.Color(0, 100, 148));
        btnAdd2.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_small.png"))); // NOI18N
        btnAdd2.setText("Eliminar");

        btnAdd3.setBackground(new java.awt.Color(0, 184, 82));
        btnAdd3.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        btnAdd3.setText("Actualizar");

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlContainerLayout.createSequentialGroup()
                                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(txtCU, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(20, 20, 20)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(pnlData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbItems, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(pnlTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lblTotal))
                    .addComponent(btnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnRefresh1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefresh1MousePressed

    }//GEN-LAST:event_btnRefresh1MousePressed

    public static void main() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.buttons.Button btnAdd;
    private com.trojasviejas.swing.buttons.Button btnAdd1;
    private com.trojasviejas.swing.buttons.Button btnAdd2;
    private com.trojasviejas.swing.buttons.Button btnAdd3;
    private com.trojasviejas.swing.Buttons.ActionButton btnClose;
    private com.trojasviejas.swing.Buttons.ActionButton btnNew;
    private com.trojasviejas.swing.Buttons.ActionButton btnRefresh;
    private com.trojasviejas.swing.Buttons.ActionButton btnRefresh1;
    private com.trojasviejas.swing.buttons.Button btnSearch;
    private com.trojasviejas.swing.ComboBox cbbItems;
    private com.trojasviejas.swing.tables.detail.DetailTable detailTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblBuyDate;
    public javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProvider;
    private javax.swing.JLabel lblProviders;
    private javax.swing.JLabel lblTotal;
    private com.trojasviejas.swing.panels.PanelBorder panelBorder2;
    private com.trojasviejas.swing.panels.PanelBorder panelBorder3;
    private com.trojasviejas.swing.panels.PanelBorder pnlContainer;
    private com.trojasviejas.swing.panels.PanelShadow pnlData;
    private com.trojasviejas.swing.panels.PanelBorder pnlHeader;
    private com.trojasviejas.swing.panels.PanelBorder pnlTable;
    private com.trojasviejas.swing.panels.PanelBorder pnlTable1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane scrollTable;
    private com.trojasviejas.swing.tables.item.ItemsTable tblItems;
    private com.trojasviejas.swing.fields.MyTextField txtAmount;
    private com.trojasviejas.swing.fields.MyTextField txtCU;
    private com.trojasviejas.swing.fields.MyTextField txtItem;
    // End of variables declaration//GEN-END:variables
}
