package com.trojasviejas.demo.form;

import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.component.login.PanelMessage;
import com.trojasviejas.component.main.FrmPassword;
import com.trojasviejas.component.main.event.IItemEventAction;
import com.trojasviejas.data.connectiondb.Conexion;
import com.trojasviejas.data.dao.ItemDao;
import static com.trojasviejas.demo.form.FrmMain.getStringSearch;
import com.trojasviejas.demo.form.window.*;
import com.trojasviejas.models.utility.*;
import com.trojasviejas.swing.scroll.ScrollBar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.trojasviejas.models.entity.ItemModel;
import com.trojasviejas.models.entity.UserModel;
import com.trojasviejas.report.invoiceP;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class FrmReport extends javax.swing.JPanel {

    MessageErrorDialog dialogResult = new MessageErrorDialog(new FrmLogin());
    private FrmPassword password;
    FrmReport form = this;
    private IItemEventAction f_eventAction;

    public FrmReport() {
        setOpaque(false);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JLayeredPane();
        pnlTable = new com.trojasviejas.swing.panels.PanelBorder();
        btnRItems = new com.trojasviejas.swing.buttons.Button();
        btnRInventory = new com.trojasviejas.swing.buttons.Button();
        btnRInvoice = new com.trojasviejas.swing.buttons.Button();
        txtDate = new com.trojasviejas.swing.fields.LinearTextField();

        setBackground(new java.awt.Color(232, 241, 242));

        pnlContainer.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        btnRItems.setBackground(new java.awt.Color(27, 152, 224));
        btnRItems.setForeground(new java.awt.Color(255, 255, 255));
        btnRItems.setText("Reporte de Articulos");
        btnRItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRItemsActionPerformed(evt);
            }
        });

        btnRInventory.setBackground(new java.awt.Color(27, 152, 224));
        btnRInventory.setForeground(new java.awt.Color(255, 255, 255));
        btnRInventory.setText("Reporte de Inventario");
        btnRInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRInventoryActionPerformed(evt);
            }
        });

        btnRInvoice.setBackground(new java.awt.Color(27, 152, 224));
        btnRInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnRInvoice.setText("Facturas");
        btnRInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRInvoiceActionPerformed(evt);
            }
        });

        txtDate.setLabelText("Año");

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTableLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRItems, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnRItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnRInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(437, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRItemsActionPerformed
        Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

//        Map parametro = new HashMap();
//        parametro.put("parameter1", txtDate.getText());
        
        String archive = "C:/Users/cb272/Documents/GitHub/Trojas_Viejas-inventario/TrojasViejas/src/main/java/com/trojasviejas/report/itemsReport.jasper";
        try {
            connection = Conexion.getConnection();
            jr = (JasperReport) JRLoader.loadObjectFromFile(archive);
            print = JasperFillManager.fillReport(jr, null, connection);
        } catch (SQLException ex) {
            Logger.getLogger(invoiceP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(invoiceP.class.getName()).log(Level.SEVERE, null, ex);
        }

        JasperViewer jv = new JasperViewer(print, false);
        jv.setVisible(true);
    }//GEN-LAST:event_btnRItemsActionPerformed

    private void btnRInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRInventoryActionPerformed
        Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

//        Map parametro = new HashMap();
//        parametro.put("parameter1", txtDate.getText());
        
        String archive = "C:/Users/cb272/Documents/GitHub/Trojas_Viejas-inventario/TrojasViejas/src/main/java/com/trojasviejas/report/inventoriesReport.jasper";
        try {
            connection = Conexion.getConnection();
            jr = (JasperReport) JRLoader.loadObjectFromFile(archive);
            print = JasperFillManager.fillReport(jr, null, connection);
        } catch (SQLException ex) {
            Logger.getLogger(invoiceP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(invoiceP.class.getName()).log(Level.SEVERE, null, ex);
        }

        JasperViewer jv = new JasperViewer(print, false);
        jv.setVisible(true);
    }//GEN-LAST:event_btnRInventoryActionPerformed

    private void btnRInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRInvoiceActionPerformed
        Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

        Map parametro = new HashMap();
        parametro.put("parameter1", txtDate.getText());
        
        String archive = "C:/Users/cb272/Documents/GitHub/Trojas_Viejas-inventario/TrojasViejas/src/main/java/com/trojasviejas/report/invoiceReport.jasper";
        try {
            connection = Conexion.getConnection();
            jr = (JasperReport) JRLoader.loadObjectFromFile(archive);
            print = JasperFillManager.fillReport(jr, parametro, connection);
        } catch (SQLException ex) {
            Logger.getLogger(invoiceP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(invoiceP.class.getName()).log(Level.SEVERE, null, ex);
        }

        JasperViewer jv = new JasperViewer(print, false);
        jv.setVisible(true);
        txtDate.setText("");
    }//GEN-LAST:event_btnRInvoiceActionPerformed

    public void cerrarVentana(){
        Window w = SwingUtilities.getWindowAncestor(this);
        w.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.buttons.Button btnRInventory;
    private com.trojasviejas.swing.buttons.Button btnRInvoice;
    private com.trojasviejas.swing.buttons.Button btnRItems;
    private javax.swing.JLayeredPane pnlContainer;
    private com.trojasviejas.swing.panels.PanelBorder pnlTable;
    private com.trojasviejas.swing.fields.LinearTextField txtDate;
    // End of variables declaration//GEN-END:variables
}
