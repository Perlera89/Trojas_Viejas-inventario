package com.trojasviejas.demo.form.window;

import com.trojasviejas.data.dao.InvoicesDao;
import com.trojasviejas.demo.form.FrmInvoices;
import com.trojasviejas.demo.form.FrmInvoices;
import com.trojasviejas.demo.form.window.WindowHome;
import com.trojasviejas.models.entity.InvoicesModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class WindowInvoice extends javax.swing.JPanel {

    public FrmInvoices frmInvoice;
    public WindowHome home;
    public int id;

    public WindowInvoice() {
        setOpaque(false);
        initComponents();
        cbbProvider.requestFocus();
        CargarComboBox();
    }

    private byte[] getImagenByte(String Ruta) {
        File imagen = new File(Ruta);
        try {
            byte[] icono = new byte[(int) imagen.length()];
            InputStream input = new FileInputStream(imagen);
            input.read(icono);
            return icono;
        } catch (Exception ex) {
            return null;
        }
    }

    public void CargarComboBox() {
        ArrayList<String> provM = new ArrayList<String>();
        InvoicesDao invDao = new InvoicesDao();
        provM = invDao.SelectNameProv();

        for (var i : provM) {
            cbbProvider.addItem(i.toString());
        }
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
        lblImagen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        cbbProvider.setForeground(new java.awt.Color(100, 100, 100));
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
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(cbbProvider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbbProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
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

    String ruta = "";
    byte[] rutaByte;
    private void lblImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblImageActionPerformed
        String ruta = "";
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        fileChooser.setFileFilter(filtrado);

        int respuesta = fileChooser.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            ruta = fileChooser.getSelectedFile().getPath();
            rutaByte = getImagenByte(ruta);
//            lblImage.setFont(new Font("Roboto", 0, 12));
//            lblImage.setText(ruta);
            Image img = new ImageIcon(ruta).getImage();
            ImageIcon mIcono = new ImageIcon(img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), 0));
            lblImagen.setIcon(mIcono);

        }
//        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            ruta = fileChooser.getSelectedFile().getAbsolutePath();
//            rutaByte = getImagenByte(ruta);
//            Image img = new ImageIcon(ruta).getImage();
//            ImageIcon mIcono = new ImageIcon(img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), 0));
//            lblImage.setIcon(mIcono);
//        }
    }//GEN-LAST:event_lblImageActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        InvoicesModel inv = new InvoicesModel();
        InvoicesDao invDao = new InvoicesDao();

        if (id > 0) {
            LocalDate dateObj = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = dateObj.format(formatter);

            inv.setId(id);
            inv.setBuyDate(date);
            inv.setTotalAmount(Double.parseDouble(txtTotal.getText()));
            inv.setPicture(rutaByte);
            inv.setFkProv(cbbProvider.getSelectedIndex());
            invDao.UpdateInvoice(inv);
            
            frmInvoice.initTableData();
        } else {
            LocalDate dateObj = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = dateObj.format(formatter);

            inv.setBuyDate(date);
            inv.setTotalAmount(Double.parseDouble(txtTotal.getText()));
            inv.setPicture(rutaByte);
            inv.setFkProv(cbbProvider.getSelectedIndex());
            invDao.AddInvoice(inv);
            frmInvoice.initTableData();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        home.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.buttons.Button btnAdd;
    private com.trojasviejas.swing.buttons.Button btnCancel;
    public com.trojasviejas.swing.ComboBox cbbProvider;
    public com.trojasviejas.swing.buttons.ButtonOutline lblImage;
    public javax.swing.JLabel lblImagen;
    public com.toedter.calendar.JDateChooser txtDate;
    public com.trojasviejas.swing.fields.LinearTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
