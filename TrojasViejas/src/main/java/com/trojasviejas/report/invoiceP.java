/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.trojasviejas.report;

import com.trojasviejas.data.connectiondb.Conexion;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author cb272
 */
public class invoiceP extends javax.swing.JFrame {

    /**
     * Creates new form invoiceP
     */
    public invoiceP() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDate = new javax.swing.JTextField();
        btnConsulta = new javax.swing.JButton();
        btnItems = new javax.swing.JButton();
        btnInventory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnConsulta.setText("Factura");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        btnItems.setText("Reporte de articulos");
        btnItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemsActionPerformed(evt);
            }
        });

        btnInventory.setText("Reporte de inventario");
        btnInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnItems, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnItems)
                .addGap(18, 18, 18)
                .addComponent(btnInventory)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsulta))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//        File file = new File(application.getRealPath(""));
//        Map<String, Object> parameter = new HashMap<String, Object>();
//        byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPatg)
//    Connection connection = null;
//    JasperPrint print = null;
//    JasperReport jr = null;
//    String archive = "";
    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

        Map parametro = new HashMap();
        parametro.put("parameter1", txtDate.getText());
        
        String archive = "C:/Users/cb272/Desktop/TrojasViejas/src/main/java/com/trojasviejas/report/Prueba.jasper";
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

    }//GEN-LAST:event_btnConsultaActionPerformed

    private void btnInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryActionPerformed
        Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

//        Map parametro = new HashMap();
//        parametro.put("parameter1", txtDate.getText());
        
        String archive = "C:/Users/cb272/Desktop/TrojasViejas/src/main/java/com/trojasviejas/report/inventoriesReport.jasper";
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
    }//GEN-LAST:event_btnInventoryActionPerformed

    private void btnItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemsActionPerformed
        Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

//        Map parametro = new HashMap();
//        parametro.put("parameter1", txtDate.getText());
        
        String archive = "C:/Users/cb272/Desktop/TrojasViejas/src/main/java/com/trojasviejas/report/itemsReport.jasper";
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
    }//GEN-LAST:event_btnItemsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(invoiceP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(invoiceP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(invoiceP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(invoiceP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new invoiceP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnInventory;
    private javax.swing.JButton btnItems;
    private javax.swing.JTextField txtDate;
    // End of variables declaration//GEN-END:variables
}
