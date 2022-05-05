package com.trojasviejas.demo.form.window;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class WindowInvoice extends javax.swing.JPanel {

    public WindowInvoice() {
        setOpaque(false);
        initComponents();
        cbbProvider.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbbProvider = new com.trojasviejas.swing.ComboBox();
        txtTotal = new com.trojasviejas.swing.fields.LinearTextField();
        btnAdd = new com.trojasviejas.swing.buttons.Button();
        btnCancel = new com.trojasviejas.swing.buttons.Button();
        lblImage = new com.trojasviejas.swing.buttons.ButtonOutline();
        txtDate = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));

        cbbProvider.setForeground(new java.awt.Color(100, 100, 100));
        cbbProvider.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo", "Vendedores", "Donadores" }));
        cbbProvider.setSelectedIndex(-1);
        cbbProvider.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbbProvider.setLabeText("Proveedor");

        txtTotal.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTotal.setLabelText("Total");
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalKeyTyped(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 184, 82));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Agregar");

        btnCancel.setBackground(new java.awt.Color(255, 5, 0));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");

        lblImage.setForeground(new java.awt.Color(150, 150, 150));
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/image.png"))); // NOI18N
        lblImage.setText("  Agrega una imagen");
        lblImage.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblImageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblImageMouseExited(evt);
            }
        });
        lblImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblImageActionPerformed(evt);
            }
        });

        txtDate.setBackground(new java.awt.Color(255, 255, 255));
        txtDate.setForeground(new java.awt.Color(100, 100, 100));
        txtDate.setDateFormatString("dd/MM/yyyy");
        txtDate.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbProvider, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                        .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(55, 55, 55)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cbbProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(110, 110, 110)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < ',' || car > '.'))
        evt.consume();
    }//GEN-LAST:event_txtTotalKeyTyped

    private void lblImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseEntered
        lblImage.setForeground(new Color(100, 100, 100));
    }//GEN-LAST:event_lblImageMouseEntered

    private void lblImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseExited
        lblImage.setForeground(new Color(150, 150, 150));
    }//GEN-LAST:event_lblImageMouseExited

    private void lblImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblImageActionPerformed
        String ruta = "";
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        fileChooser.setFileFilter(filtrado);

        int respuesta = fileChooser.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            ruta = fileChooser.getSelectedFile().getPath();
            lblImage.setFont(new Font("Roboto", 0, 12));
            lblImage.setText(ruta);
            //Image imagen = new ImageIcon(ruta).getImage();
            //ImageIcon icono = new ImageIcon(imagen.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
            //lblImage.setIcon(icono);
        }
    }//GEN-LAST:event_lblImageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.buttons.Button btnAdd;
    private com.trojasviejas.swing.buttons.Button btnCancel;
    private com.trojasviejas.swing.ComboBox cbbProvider;
    private com.trojasviejas.swing.buttons.ButtonOutline lblImage;
    private com.toedter.calendar.JDateChooser txtDate;
    private com.trojasviejas.swing.fields.LinearTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
