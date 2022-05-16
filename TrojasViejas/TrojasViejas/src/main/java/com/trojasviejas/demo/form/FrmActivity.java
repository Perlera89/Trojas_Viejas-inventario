package com.trojasviejas.demo.form;

import com.trojasviejas.component.main.event.IActivityEventAction;
import com.trojasviejas.demo.form.window.*;
import com.trojasviejas.models.entity.ProviderModel;
import com.trojasviejas.models.utility.*;
import com.trojasviejas.swing.scroll.ScrollBar;
import javax.swing.*;
import java.awt.*;
import com.trojasviejas.component.main.event.IProviderEventAction;
import com.trojasviejas.data.dao.InventoryDao;
import com.trojasviejas.models.viewmodel.ActivityVM;
import com.trojasviejas.models.viewmodel.InventoryVM;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class FrmActivity extends javax.swing.JPanel {

    public FrmActivity() {
        setOpaque(false);
        initComponents();
        initCard();
        initTableData();
    }

    private void initCard() {
        pnlCard1.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/register.png")), "REGISTROS", "15"));
        pnlCard2.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/income.png")), "ENTRADAS", "25"));
        pnlCard3.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/output.png")), "SALIDAS", "12"));
    }

    private void initTableData() {
        //Agregar registro
        IActivityEventAction eventAction = (ActivityVM entity) -> {
            System.out.println("Editar a " + entity.getItem());
        };

        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.white);
        Date buyDate = new Date();
        Date registerDate = new Date();

        tblActivity.addRow(new ActivityVM(1, ActionType.ENTRADA, "Botella", 10, "$10", 8, "Sin descripcion", 3.5, CategoryType.ACCESORIOS, ItemType.PVC, new SimpleDateFormat("dd-MM-yyyy").format(buyDate), new SimpleDateFormat("dd-MM-yyyy").format(registerDate)).toRowTable(eventAction));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTable = new com.trojasviejas.swing.panels.PanelBorder();
        lblActivity = new javax.swing.JLabel();
        btnRegister = new com.trojasviejas.swing.Buttons.ActionButton();
        btnRefresh = new com.trojasviejas.swing.Buttons.ActionButton();
        scroll = new javax.swing.JScrollPane();
        tblActivity = new com.trojasviejas.swing.tables.activity.ActivityTable();
        pnlContainer = new javax.swing.JLayeredPane();
        pnlCard1 = new com.trojasviejas.component.main.PanelCard();
        pnlCard2 = new com.trojasviejas.component.main.PanelCard();
        pnlCard3 = new com.trojasviejas.component.main.PanelCard();

        setBackground(new java.awt.Color(232, 241, 242));

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        lblActivity.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblActivity.setForeground(new java.awt.Color(127, 127, 127));
        lblActivity.setText("Actividad");

        btnRegister.setBackground(new java.awt.Color(0, 184, 82));
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnRegister.setText("Registro");
        btnRegister.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnRegister.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        scroll.setBorder(null);

        tblActivity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Accion", "Articulo", "Existencias", "Retiro", "En inventario", "Descripción", "C/U", "Categoria", "Tipo", "Fecha de compra", "Fecha de registro", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(tblActivity);

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scroll)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblActivity)
                            .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addComponent(lblActivity)
                        .addGap(20, 20, 20)
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlContainer.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        pnlCard1.setColor1(new java.awt.Color(0, 40, 85));
        pnlCard1.setColor2(new java.awt.Color(2, 62, 125));
        pnlContainer.add(pnlCard1);

        pnlCard2.setColor1(new java.awt.Color(0, 58, 1));
        pnlCard2.setColor2(new java.awt.Color(0, 71, 2));
        pnlContainer.add(pnlCard2);

        pnlCard3.setColor1(new java.awt.Color(108, 5, 0));
        pnlCard3.setColor2(new java.awt.Color(162, 0, 0));
        pnlContainer.add(pnlCard3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                    .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    FrmActivity thisForm = this;
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed

        WindowActivity.main();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.Buttons.ActionButton btnRefresh;
    private com.trojasviejas.swing.Buttons.ActionButton btnRegister;
    private javax.swing.JLabel lblActivity;
    private com.trojasviejas.component.main.PanelCard pnlCard1;
    private com.trojasviejas.component.main.PanelCard pnlCard2;
    private com.trojasviejas.component.main.PanelCard pnlCard3;
    private javax.swing.JLayeredPane pnlContainer;
    private com.trojasviejas.swing.panels.PanelBorder pnlTable;
    private javax.swing.JScrollPane scroll;
    private com.trojasviejas.swing.tables.activity.ActivityTable tblActivity;
    // End of variables declaration//GEN-END:variables
}
