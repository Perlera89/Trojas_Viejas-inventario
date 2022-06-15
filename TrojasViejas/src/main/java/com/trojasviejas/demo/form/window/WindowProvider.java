package com.trojasviejas.demo.form.window;

import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.data.dao.ProviderDao;
import com.trojasviejas.demo.form.FrmProviders;
import com.trojasviejas.models.entity.ProviderModel;
import com.trojasviejas.models.utility.ProviderType;
import java.awt.Window;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class WindowProvider extends javax.swing.JPanel {

    //almacena el objeto actual del formulario principal
    public FrmProviders frmProvider;
    //almacena el objeto del frame principal para los crud
    public WindowHome home;
    //id del proveedor
    public int id;

    //mensaje personalizado
    MessageErrorDialog errorMessage = new MessageErrorDialog(new JFrame());
    
    public WindowProvider() {
        setOpaque(false);
        initComponents();
        CargarComboBox();
        txtName.requestFocus();
    }

    public void CargarComboBox() {

        for (var i : ProviderType.values()) {
            cbbType.addItem(i.toString());
        }

    }

    public void clean() {
        txtName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        cbbType.setSelectedItem(ProviderType.values()[0].toString());
        txtName.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new com.trojasviejas.swing.fields.LinearTextField();
        cbbType = new com.trojasviejas.swing.ComboBox();
        txtEmail = new com.trojasviejas.swing.fields.LinearTextField();
        txtPhone = new com.trojasviejas.swing.fields.LinearTextField();
        txtAddress = new com.trojasviejas.swing.fields.LinearTextField();
        btnAdd = new com.trojasviejas.swing.buttons.Button();
        btnCancel = new com.trojasviejas.swing.buttons.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        txtName.setToolTipText("Nombre del proveedor");
        txtName.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtName.setLabelText("Nombre");
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        cbbType.setForeground(new java.awt.Color(100, 100, 100));
        cbbType.setToolTipText("Tipo de proveedor");
        cbbType.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbbType.setLabeText("Tipo");
        cbbType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbbTypeKeyReleased(evt);
            }
        });

        txtEmail.setToolTipText("Correo electrónico del proveedor");
        txtEmail.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtEmail.setLabelText("Correo");
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        txtPhone.setToolTipText("Número de teléfono del proveedor");
        txtPhone.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtPhone.setLabelText("Telefono");
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneKeyReleased(evt);
            }
        });

        txtAddress.setToolTipText("Dirección del negocio del proveedor ");
        txtAddress.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtAddress.setLabelText("Direccion");
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddressKeyReleased(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 184, 82));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 5, 0));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbType, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(cbbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        //verificando que el nombre y la direccion no esta vacia
        if ((!txtName.getText().isEmpty() && !txtName.getText().isBlank())
                && (!txtAddress.getText().isEmpty() && !txtAddress.getText().isBlank())) {
            //verificando que se haya seleccionado un tipo
            if (cbbType.getSelectedIndex() != -1 && cbbType.getSelectedItem() != null) {
                if (id > 0) {
                    ProviderModel provM = new ProviderModel();
                    ProviderDao provD = new ProviderDao();

                    //dando valores por defecto sin no hay numero y email
                    if (txtPhone.getText().isEmpty() && txtPhone.getText().isBlank()){
                        provM.setNumberPhone("Sin número");                       
                    }
                    if (txtEmail.getText().isEmpty() && txtEmail.getText().isBlank()){
                        provM.setEmail("Sin dirección");                       
                    }
                    provM.setId(id);
                    provM.setName(txtName.getText());
                    provM.setAddress(txtAddress.getText());
                    provM.setType(ProviderType.values()[cbbType.getSelectedIndex()]);
                    provD.UpdateProvider(provM);
                    
                    //recargando datos en el formulario principal
                    frmProvider.initTableData();
 
                    home.dispose();

                } else {
                    ProviderModel provM = new ProviderModel();
                    ProviderDao provD = new ProviderDao();

                    if (txtPhone.getText().isEmpty() && txtPhone.getText().isBlank()){
                        provM.setNumberPhone("Sin número");                       
                    }
                    if (txtEmail.getText().isEmpty() && txtEmail.getText().isBlank()){
                        provM.setEmail("Sin dirección");                       
                    }
                    provM.setName(txtName.getText());
                    provM.setAddress(txtAddress.getText());
                    provM.setType(ProviderType.values()[cbbType.getSelectedIndex()]);

                    provD.AddProvider(provM);
                    
                    //recargando datos en el formulario principal
                    frmProvider.initTableData();
                    //limpiando para agregar más
                    clean();
                }              
            }else{
                errorMessage.showMessage("ERROR", "Es obligatorio definir un tipo de proveedor.");
            }

        }else{
            errorMessage.showMessage("ERROR", "Campos obligatorios nulos o vacíos.");
        }
        cerrarVentana();

    }//GEN-LAST:event_btnAddActionPerformed
    public void cerrarVentana(){
        Window w = SwingUtilities.getWindowAncestor(this);
        w.setVisible(false);
    }
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        cerrarVentana();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPhone.requestFocus();
        }
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyReleased
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtEmail.requestFocus();
        }
    }//GEN-LAST:event_txtPhoneKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtAddress.requestFocus();
        }
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbbType.requestFocus();
            cbbType.showPopup();
        }
    }//GEN-LAST:event_txtAddressKeyReleased

    private void cbbTypeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbTypeKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.doClick();
        }
    }//GEN-LAST:event_cbbTypeKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.buttons.Button btnAdd;
    private com.trojasviejas.swing.buttons.Button btnCancel;
    public com.trojasviejas.swing.ComboBox cbbType;
    public com.trojasviejas.swing.fields.LinearTextField txtAddress;
    public com.trojasviejas.swing.fields.LinearTextField txtEmail;
    public com.trojasviejas.swing.fields.LinearTextField txtName;
    public com.trojasviejas.swing.fields.LinearTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
