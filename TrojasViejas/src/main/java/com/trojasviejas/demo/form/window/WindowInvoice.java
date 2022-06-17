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
import java.awt.event.KeyEvent;
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

    public WindowInvoice() {
        setOpaque(false);
        initComponents();       
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
    ProviderDao invDao = null;
    ArrayList<ProviderModel> invA = null;
    public void CargarComboBox(String name) {
        
        invDao = new ProviderDao();    
        invA = invDao.ListProviders(name);
        ids = new int[invA.size()];
        
        if (!invA.isEmpty()) {
            cbbProvider.removeAllItems();

          int index = 0;
          for (var i : invA) {
              cbbProvider.addItem(i.getName()+", "+i.getType());
              ids[index] = i.getId();
              index++;
          }
          cbbProvider.setSelectedIndex(0);  
          cbbProvider.showPopup();
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTotal = new com.trojasviejas.swing.fields.LinearTextField();
        btnAdd = new com.trojasviejas.swing.buttons.Button();
        btnCancel = new com.trojasviejas.swing.buttons.Button();
        lblRuta = new com.trojasviejas.swing.buttons.ButtonOutline();
        txtDate = new com.toedter.calendar.JDateChooser();
        lblImagen = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        cbbProvider = new com.trojasviejas.swing.ComboBox();
        txtProvider = new com.trojasviejas.swing.fields.LinearTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        txtTotal.setToolTipText("Valor total de la factura, valor > 0");
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
        lblRuta.setToolTipText("Imagen de la factura");
        lblRuta.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblRuta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRuta.setMaximumSize(new java.awt.Dimension(330, 34));
        lblRuta.setPreferredSize(new java.awt.Dimension(330, 34));
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
        txtDate.setToolTipText("Fecha de la factura | fecha de recepción de donación");
        txtDate.setDateFormatString("dd/MM/yyyy");
        txtDate.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        lblImagen.setToolTipText("Imagen en vertical");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cbbProvider.setForeground(new java.awt.Color(100, 100, 100));
        cbbProvider.setToolTipText("Nombre del proveedor a elegir");
        cbbProvider.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbbProvider.setLabeText("Elige el proveedor");
        cbbProvider.setLineColor(new java.awt.Color(255, 255, 255));
        cbbProvider.setVerifyInputWhenFocusTarget(false);
        cbbProvider.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbProviderItemStateChanged(evt);
            }
        });
        cbbProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbProviderActionPerformed(evt);
            }
        });

        txtProvider.setToolTipText("Nombre del proveedor a buscar");
        txtProvider.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtProvider.setLabelText("Proveedor");
        txtProvider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProviderKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProvider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cbbProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))
                        .addGap(25, 25, 25)
                        .addComponent(cbbProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
               if (cbbProvider.getSelectedItem() != null && cbbProvider.getSelectedIndex() >= 0) {
            //verificando si es un proveedor de tipo donador
            if (getProviderType(cbbProvider.getSelectedItem().toString()).equals(" DONANTE")) {
                //factura especial para donaciones
                saveDonorTypeInvoice();
            }else{
                //factura comercial
                saveComercialTypeInvoce();
            }
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

//    public void cerrarVentana(){
//        Window w = SwingUtilities.getWindowAncestor(this);
//        w.setVisible(false);
//    }
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        home.dispose();
        
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        findProvider();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbbProviderItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbProviderItemStateChanged
        //verificando que se haya seleccionado un proveedor del combo
        if (cbbProvider.getSelectedItem() != null && cbbProvider.getSelectedIndex() >= 0) {
            //verificando si es un proveedor de tipo donador
            if (getProviderType(cbbProvider.getSelectedItem().toString()).equals(" DONANTE")) {
                txtTotal.setEnabled(false);
                txtTotal.setText("0.00");
                lblRuta.setEnabled(false);
                lblRuta.setText(" Foto de factura no requerida");
            }else{
                txtTotal.setEnabled(true);
                lblRuta.setEnabled(true);
                lblRuta.setText("  Agrega una imagen");
            }
        }
    }//GEN-LAST:event_cbbProviderItemStateChanged

    private void cbbProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbProviderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbProviderActionPerformed

    private void txtProviderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProviderKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProviderKeyTyped

    //busca un proveedor
    private void findProvider(){
            if (!txtProvider.getText().isBlank() && !txtProvider.getText().isEmpty()) {
                CargarComboBox(txtProvider.getText());
            } else {
                txtProvider.setText("");
                txtProvider.requestFocus();
                errorMessage.showMessage("ERROR", "Nombre del proveedor nulo o vacío. Ingrese un nombre para realizar la busqueda.");
            }
        
    }
    //retorna el tipo de proveedor concantenado al final del nombre del proveedor
    private String getProviderType(String provider){
        String _provider[] = provider.split(",");
        return _provider[1];
    }
    
    private void saveComercialTypeInvoce(){
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

                    //verificando que el total sea mayor a cero
                    if (Double.parseDouble(txtTotal.getText()) > 0) {
                        detailsForm.lblPrice.setText("$"+txtTotal.getText());
                        detailsForm.rutaByte = rutaByte;
                        detailsForm.idProvider = ids[cbbProvider.getSelectedIndex()];
                        detailsForm.lblProvider.setText(cbbProvider.getSelectedItem().toString());
                        detailsForm.formInvoices = frmInvoice;
                        detailsForm.setVisible(true);
                        home.dispose();
                    }else{
                        errorMessage.showMessage("ERROR", "El total de la factura no puede ser cero. Ingrese una cantidad válida.");
                    }

                } catch (Exception e) {
                    errorMessage.showMessage("ERROR", "Valor no válido. Verifique el total ingresado."+e.toString());
                }          
            }else{
                errorMessage.showMessage("ERROR", "Campos de fecha, imagen y total nulos o vacíos.");
            }         
        }else{
            errorMessage.showMessage("ERROR", "Campo del proveedor nulo o vacío. Elija un proveedor.");
        }
    }
    
    private void saveDonorTypeInvoice(){
         //verificando que se haya eligido un proveedor
        if (cbbProvider.getSelectedItem() != null
             && cbbProvider.getSelectedIndex()!=-1) {
            //verificando que lel campo de la fecha no esten vacio
            if (txtDate.getDate() != null && lblRuta.getText().equals(" Foto de factura no requerida")) {
                        FrmDetails detailsForm = new FrmDetails(0);
                        detailsForm.dateInvoice = txtDate.getDate();
                        detailsForm.lblBuyDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(txtDate.getDate()));
                        detailsForm.lblPrice.setText("$"+txtTotal.getText());
                        detailsForm.rutaByte = rutaByte;
                        detailsForm.idProvider = ids[cbbProvider.getSelectedIndex()];
                        detailsForm.lblProvider.setText(cbbProvider.getSelectedItem().toString());
                        detailsForm.formInvoices = frmInvoice;
                        detailsForm.txtCU.setText("0.00");
                        detailsForm.txtCU.setEditable(false);
                        detailsForm.setVisible(true);
                        home.dispose();        
            }else{
                errorMessage.showMessage("ERROR", "Campos de fecha nulo o vacío.");
            }         
        }else{
            errorMessage.showMessage("ERROR", "Campo del proveedor nulo o vacío. Elija un proveedor.");
        }      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.buttons.Button btnAdd;
    private javax.swing.JButton btnBuscar;
    private com.trojasviejas.swing.buttons.Button btnCancel;
    public com.trojasviejas.swing.ComboBox cbbProvider;
    private javax.swing.JLabel lblImagen;
    public com.trojasviejas.swing.buttons.ButtonOutline lblRuta;
    public com.toedter.calendar.JDateChooser txtDate;
    public com.trojasviejas.swing.fields.LinearTextField txtProvider;
    public com.trojasviejas.swing.fields.LinearTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
