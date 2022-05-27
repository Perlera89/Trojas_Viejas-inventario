package com.trojasviejas.demo.form;

import com.trojasviejas.data.dao.ProviderDao;
import com.trojasviejas.demo.form.FrmProviders;
import com.trojasviejas.demo.form.window.WindowHome;
import com.trojasviejas.models.entity.ProviderModel;
import com.trojasviejas.models.utility.ProviderType;

public class WindowProvider extends javax.swing.JPanel {

    public FrmProviders frmProviders;
    public WindowHome home;
    public int id = 0;
    
    public WindowProvider() {
        setOpaque(false);
        initComponents();
        txtName.requestFocus();
        CargarComboBox();
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

        txtName.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtName.setLabelText("Nombre");

        cbbType.setForeground(new java.awt.Color(100, 100, 100));
        cbbType.setSelectedIndex(-1);
        cbbType.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbbType.setLabeText("Tipo");

        txtEmail.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtEmail.setLabelText("Correo");

        txtPhone.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtPhone.setLabelText("Telefono");

        txtAddress.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtAddress.setLabelText("Direccion");

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

    public void CargarComboBox() {

        for (var i : ProviderType.values()) {
            cbbType.addItem(i.toString());
        }
    }

    //Método para limpiar cajas de texto
    public void clean() {
        txtName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        cbbType.setSelectedItem(ProviderType.values()[0].toString());
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        //Agregar o Actualizar
        if (id > 0) {
            ProviderModel prvM = new ProviderModel();
            ProviderDao prvD = new ProviderDao();

            prvM.setId(id);
            prvM.setName(txtName.getText());
            prvM.setNumberPhone(txtPhone.getText());
            prvM.setEmail(txtEmail.getText());
            prvM.setAddress(txtAddress.getText());
            prvM.setType(ProviderType.values()[cbbType.getSelectedIndex()]);

            prvD.UpdateProvider(prvM);
            frmProviders.initTableData();
            clean();

        } else {
            ProviderModel prvM = new ProviderModel();
            ProviderDao prvD = new ProviderDao();

            prvM.setName(txtName.getText());
            prvM.setNumberPhone(txtPhone.getText());
            prvM.setEmail(txtEmail.getText());
            prvM.setAddress(txtAddress.getText());
            prvM.setType(ProviderType.values()[cbbType.getSelectedIndex()]);

            prvD.AddProvider(prvM);
            frmProviders.initTableData();
            clean();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        home.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed


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
