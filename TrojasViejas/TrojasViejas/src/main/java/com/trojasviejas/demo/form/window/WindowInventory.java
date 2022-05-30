package com.trojasviejas.demo.form.window;

import com.trojasviejas.data.dao.ActivityDao;
import com.trojasviejas.demo.form.FrmInventory;
import com.trojasviejas.models.entity.ActivityModel;
import com.trojasviejas.models.utility.ActionType;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.BorderFactory;
import java.awt.Color;

public class WindowInventory extends javax.swing.JFrame {

    //public WindowItem items;

    public WindowInventory() {
        
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        initMoving(this);
        currentDate();
        setDataToCombobox();
    }

    private int x;
    private int y;

    public void initMoving(JFrame window) {
        pnlHeader.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }

        });

        pnlHeader.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                window.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtProveedor1 = new com.trojasviejas.swing.fields.LinearTextField();
        pnlHome = new com.trojasviejas.swing.panels.PanelRound();
        pnlHeader = new com.trojasviejas.swing.panels.PanelBorder();
        btnClose = new com.trojasviejas.swing.Buttons.ActionButton();
        jLabel1 = new javax.swing.JLabel();
        lblEncabezado = new javax.swing.JLabel();
        panelBorder2 = new com.trojasviejas.swing.panels.PanelBorder();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new com.trojasviejas.swing.buttons.Button();
        btnCancel = new com.trojasviejas.swing.buttons.Button();
        scroll = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        cbbActionType = new com.trojasviejas.swing.ComboBox();
        txtAmount = new com.trojasviejas.swing.fields.LinearTextField();
        txtDate = new com.toedter.calendar.JDateChooser();
        panelShadow1 = new com.trojasviejas.swing.panels.PanelShadow();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblItem = new javax.swing.JLabel();
        lblBuyDate = new javax.swing.JLabel();
        lblAmountBought = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();

        txtProveedor1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtProveedor1.setLabelText("Nombre");

        setLocationByPlatform(true);
        setUndecorated(true);

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
        lblEncabezado.setText("Agregar Entrada/Salida");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
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
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelBorder2.setBackground(new java.awt.Color(232, 241, 242));

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setBackground(new java.awt.Color(0, 184, 82));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btnAdd.setText("Guardar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 5, 0));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(150, 150, 150));
        txtDescription.setRows(5);
        txtDescription.setText("Sin descripcion");
        txtDescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtDescriptionMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDescriptionMousePressed(evt);
            }
        });
        scroll.setViewportView(txtDescription);

        cbbActionType.setForeground(new java.awt.Color(100, 100, 100));
        cbbActionType.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbbActionType.setLabeText("Tipo de accion");
        cbbActionType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbActionTypeActionPerformed(evt);
            }
        });

        txtAmount.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtAmount.setLabelText("Cantidad a retirar");
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAmountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAmountKeyTyped(evt);
            }
        });

        txtDate.setBackground(new java.awt.Color(255, 255, 255));
        txtDate.setForeground(new java.awt.Color(100, 100, 100));
        txtDate.setDateFormatString("dd/MM/yyyy");
        txtDate.setEnabled(false);
        txtDate.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 152, 224));
        jLabel2.setText("Detalles del articulo");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(100, 100, 100));
        jLabel3.setText("Articulo:");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(100, 100, 100));
        jLabel4.setText("Fecha de compra:");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(100, 100, 100));
        jLabel5.setText("Comprado:");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(100, 100, 100));
        jLabel6.setText("Existencias");

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(100, 100, 100));
        jLabel7.setText("Tipo:");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(100, 100, 100));
        jLabel8.setText("Categoria:");

        lblItem.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblItem.setText(". . .");

        lblBuyDate.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblBuyDate.setText(". . .");

        lblAmountBought.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblAmountBought.setText(". . .");

        lblCategory.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblCategory.setText(". . .");

        lblType.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblType.setText(". . .");

        lblStock.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblStock.setText(". . .");

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(10, 10, 10)
                                .addComponent(lblBuyDate))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(10, 10, 10)
                                .addComponent(lblItem))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(10, 10, 10)
                                .addComponent(lblAmountBought)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(10, 10, 10)
                                .addComponent(lblType))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(10, 10, 10)
                                .addComponent(lblStock))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(10, 10, 10)
                                .addComponent(lblCategory)))
                        .addGap(125, 125, 125))))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblCategory))
                        .addGap(20, 20, 20)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblType))
                        .addGap(20, 20, 20)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblStock)))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblItem))
                        .addGap(20, 20, 20)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblBuyDate))
                        .addGap(20, 20, 20)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblAmountBought))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scroll)
                            .addComponent(cbbActionType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cbbActionType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout pnlHomeLayout = new javax.swing.GroupLayout(pnlHome);
        pnlHome.setLayout(pnlHomeLayout);
        pnlHomeLayout.setHorizontalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBorder2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlHomeLayout.setVerticalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    //id del registro a actualizar
    public int idItem = 0;
    //objeto actual que muestra el inventario para acceder a su metodo de 
    //recarga de datos de la tabla al agregar y actualizar
    public FrmInventory inventoryForm;
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!txtAmount.getText().isEmpty() || !txtAmount.getText().isBlank()) {

            ActivityDao registerDao = new ActivityDao();
            ActivityModel register = new ActivityModel();

            //obteniendo los datos
            if (selection.equals(ActionType.ENTRADA)) {
                register.setAmount("+" + txtAmount.getText());
            } else {
                register.setAmount("-" + txtAmount.getText());
            }
            register.setIdInventory(idItem);
            register.setCurrentStock(Integer.parseInt(this.lblStock.getText()));
            register.setTypeAction(selection);
            register.setDescription(txtDescription.getText());
            register.setDate(txtDate.getDate());

            registerDao.save(register);

            inventoryForm.reloadChoosedFilter();

            this.dispose();

        }else{
            JOptionPane.showMessageDialog(
                    null, 
                    "Los retiros de valor nulo no son válidos.", 
                    "Valor no válido",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtDescriptionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescriptionMouseEntered
        txtDescription.setBorder(BorderFactory.createLineBorder(new Color(3,150,200), 0));
    }//GEN-LAST:event_txtDescriptionMouseEntered

    private void txtDescriptionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescriptionMousePressed
        if (txtDescription.getText().equals("Sin descripcion")) {
            txtDescription.setText("");
            txtDescription.setForeground(Color.black);
            txtDescription.setBorder(BorderFactory.createLineBorder(new Color(3,155,216), 0));
        }
    }//GEN-LAST:event_txtDescriptionMousePressed

    private void txtAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9'))
        evt.consume();
    }//GEN-LAST:event_txtAmountKeyTyped
   

    //almcacena el tipo de accion del registro para la validacion
    private ActionType selection;
    private void txtAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyReleased
        validatingSelectedIndex();   
    }//GEN-LAST:event_txtAmountKeyReleased

    private void cbbActionTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbActionTypeActionPerformed
         if (cbbActionType.getSelectedIndex()>=0) {
            selection = ActionType.values()[cbbActionType.getSelectedIndex()];
            txtAmount.setBackground(Color.WHITE);
            txtAmount.setText("");
        }
    }//GEN-LAST:event_cbbActionTypeActionPerformed
    private void validatingSelectedIndex() {
            //trae desde invemtario la cantidad de existencias
        int itemStock = Integer.parseInt(this.lblStock.getText());
        //trae desde invemtario la cantidad que ha sido comprada
        int itemBought = Integer.parseInt(this.lblAmountBought.getText());
        int amount = 0;
        try {
            //toma la cantlida de retiro ingresada
            amount = Integer.parseInt(txtAmount.getText());

            switch (selection) {
                case ENTRADA -> {
                    //la cantidad de entrada no debe ser mayor que la diferencia entre las existencias y la cantidad comprada
                    if (amount <= (itemBought - itemStock) && amount > 0) {
                        btnAdd.setEnabled(true);
                        txtAmount.setBackground(Color.WHITE);

                    } else {
                        txtAmount.setBackground(Color.getHSBColor(0, 184, 82));
                        btnAdd.setEnabled(false);
                    }
                }
                case SALIDA -> {
                    //la cantidad de retiro no debe ser mayor a las existencias actuales
                    if (amount > 0 && amount <= itemStock) {
                        btnAdd.setEnabled(true);
                        txtAmount.setBackground(Color.WHITE);

                    } else {
                        txtAmount.setBackground(Color.getHSBColor(0, 184, 82));
                        btnAdd.setEnabled(false);
                    }
                }
                default -> {
                }
            }

        } catch (NumberFormatException e) {
            txtAmount.setText("");
        }
    }

    private void setDataToCombobox() {
        for (var i : ActionType.values()) {
            cbbActionType.addItem(i);
        }
    }

    private void currentDate() {

        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();

        txtDate.setDate(dateObj);

    }

    public static void main(WindowInventory registerWindow) {
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
            java.util.logging.Logger.getLogger(WindowInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                registerWindow.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.buttons.Button btnAdd;
    private com.trojasviejas.swing.buttons.Button btnCancel;
    private com.trojasviejas.swing.Buttons.ActionButton btnClose;
    public com.trojasviejas.swing.ComboBox cbbActionType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblAmountBought;
    public javax.swing.JLabel lblBuyDate;
    public javax.swing.JLabel lblCategory;
    public javax.swing.JLabel lblEncabezado;
    public javax.swing.JLabel lblItem;
    public javax.swing.JLabel lblStock;
    public javax.swing.JLabel lblType;
    private com.trojasviejas.swing.panels.PanelBorder panelBorder2;
    private com.trojasviejas.swing.panels.PanelShadow panelShadow1;
    private com.trojasviejas.swing.panels.PanelBorder pnlHeader;
    private com.trojasviejas.swing.panels.PanelRound pnlHome;
    private javax.swing.JScrollPane scroll;
    public com.trojasviejas.swing.fields.LinearTextField txtAmount;
    private com.toedter.calendar.JDateChooser txtDate;
    public javax.swing.JTextArea txtDescription;
    private com.trojasviejas.swing.fields.LinearTextField txtProveedor1;
    // End of variables declaration//GEN-END:variables
}
