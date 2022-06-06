package com.trojasviejas.demo.form.window;

import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.component.login.MessageSuccessDialog;
import com.trojasviejas.data.dao.InvoicesDao;
import com.trojasviejas.data.dao.ProviderDao;
import com.trojasviejas.demo.form.FrmDetails;
import com.trojasviejas.demo.form.FrmInvoices;
import com.trojasviejas.demo.form.FrmLogin;
import com.trojasviejas.models.entity.InvoicesModel;
import com.trojasviejas.models.entity.ProviderModel;
import com.trojasviejas.models.utility.ProviderType;
import java.awt.Color;
//import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
//import net.miginfocom.layout.LinkHandler;

public class WindowInvoice extends javax.swing.JPanel {

    public FrmInvoices frmInvoice;
    public WindowHome home;
    public int id;

    public WindowInvoice() {
        setOpaque(false);
        initComponents();
        cbbProvider.requestFocus();
        
    }
    
    //mensajes personalizados
    MessageErrorDialog errorMessage = new MessageErrorDialog(new FrmLogin());
    MessageSuccessDialog successMessage = new MessageSuccessDialog(new FrmLogin());

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
    

    int[] ids = null;
    public void CargarComboBox(String name) {
        
        ProviderDao invDao = new ProviderDao();
        
        ArrayList<ProviderModel> invA = invDao.ListProviders(name);
        ids = new int[invA.size()];
        
        cbbProvider.removeAllItems();
        
        int index = 0;
        for (var i : invA) {
            cbbProvider.addItem(i.getName()+", "+i.getType());
            ids[index] = i.getId();
            index++;
        }
        cbbProvider.setSelectedIndex(-1);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbbProvider = new com.trojasviejas.swing.ComboBox();
        txtTotal = new com.trojasviejas.swing.fields.LinearTextField();
        btnAdd = new com.trojasviejas.swing.buttons.Button();
        btnCancel = new com.trojasviejas.swing.buttons.Button();
        lblRuta = new com.trojasviejas.swing.buttons.ButtonOutline();
        txtDate = new com.toedter.calendar.JDateChooser();
        lblImagen = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        cbbProvider.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cbbProvider.setEditable(true);
        cbbProvider.setForeground(new java.awt.Color(100, 100, 100));
        cbbProvider.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbbProvider.setLabeText("Proveedor");
        cbbProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbProviderActionPerformed(evt);
            }
        });

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

        lblRuta.setForeground(new java.awt.Color(150, 150, 150));
        lblRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/image.png"))); // NOI18N
        lblRuta.setText("  Agrega una imagen");
        lblRuta.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblRuta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRutaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRutaMouseExited(evt);
            }
        });
        lblRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblRutaActionPerformed(evt);
            }
        });

        txtDate.setBackground(new java.awt.Color(255, 255, 255));
        txtDate.setForeground(new java.awt.Color(100, 100, 100));
        txtDate.setDateFormatString("dd/MM/yyyy");
        txtDate.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRuta, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(cbbProvider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbbProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))
                        .addGap(20, 20, 20)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(lblRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < ',' || car > '.'))
            evt.consume();
    }//GEN-LAST:event_txtTotalKeyTyped

    private void lblRutaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRutaMouseEntered
        lblRuta.setForeground(new Color(100, 100, 100));
    }//GEN-LAST:event_lblRutaMouseEntered

    private void lblRutaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRutaMouseExited
        lblRuta.setForeground(new Color(150, 150, 150));
    }//GEN-LAST:event_lblRutaMouseExited

    public void Clean() {
        cbbProvider.setSelectedItem(ProviderType.values()[0].toString());
        txtTotal.setText("");
        txtDate.setDate(null);
        lblRuta.setText("");
        
    }
    
    String ruta = "";
    byte[] rutaByte;
    private void lblRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblRutaActionPerformed
        ruta = "";
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG", "PNG", "GIF", "jpg", "png", "gif");
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
            
            lblRuta.setText(ruta);

        }

    }//GEN-LAST:event_lblRutaActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        //verificando que se haya eligido un proveedor
        if (cbbProvider.getSelectedItem() != null
             && cbbProvider.getSelectedIndex()!=-1
                ) {
            //verificando que las campos de total, ruta de la imagen y la fecha no esten vacios
            if (!txtTotal.getText().isBlank() && !txtTotal.getText().isEmpty()
                && txtDate.getDate() != null && !lblRuta.getText().equals("  Agrega una imagen")) {
                try {
                        FrmDetails detailsForm = new FrmDetails(0);
                        detailsForm.dateInvoice = txtDate.getDate();
                        detailsForm.lblBuyDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(txtDate.getDate()));
                        detailsForm.lblPrice.setText(txtTotal.getText());
                        detailsForm.rutaByte = rutaByte;
                        detailsForm.idProvider = ids[cbbProvider.getSelectedIndex()];
                        detailsForm.lblProvider.setText(cbbProvider.getSelectedItem().toString());
                        detailsForm.formInvoices = frmInvoice;
                        detailsForm.setVisible(true);
                        cerrarVentana();
                } catch (Exception e) {
                    errorMessage.showMessage("ERROR", "Valor no válido. Verifique el total ingresado."+e.toString());
                }          
            }else{
                errorMessage.showMessage("ERROR", "Campos de fecha, imagen y total nulos o vacios.");
            }         
        }else{
            errorMessage.showMessage("ERROR", "Campo del proveedor nulo o vacío. Elija un proveedor.");
        }

        
    }//GEN-LAST:event_btnAddActionPerformed

    public void cerrarVentana(){
        Window w = SwingUtilities.getWindowAncestor(this);
        w.setVisible(false);
    }
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        cerrarVentana();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        CargarComboBox(cbbProvider.getSelectedItem().toString());
        System.out.println(cbbProvider.getSelectedIndex());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbbProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbProviderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbProviderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.buttons.Button btnAdd;
    private javax.swing.JButton btnBuscar;
    private com.trojasviejas.swing.buttons.Button btnCancel;
    public com.trojasviejas.swing.ComboBox cbbProvider;
    private javax.swing.JLabel lblImagen;
    public com.trojasviejas.swing.buttons.ButtonOutline lblRuta;
    public com.toedter.calendar.JDateChooser txtDate;
    public com.trojasviejas.swing.fields.LinearTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
