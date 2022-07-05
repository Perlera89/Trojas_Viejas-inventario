package com.trojasviejas.demo.form;

import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.component.main.FrmPassword;
import com.trojasviejas.component.main.event.IItemEventAction;
import com.trojasviejas.data.connectiondb.Conexion;
import javax.swing.*;
import java.awt.*;
import com.trojasviejas.report.invoiceP;
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

public class FrmReport extends javax.swing.JPanel {

    MessageErrorDialog dialogResult = new MessageErrorDialog(new FrmLogin());
    private FrmPassword password;
    FrmReport form = this;
    private IItemEventAction f_eventAction;

    public FrmReport() {
        setOpaque(false);
        initComponents(); 
        initCards();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTable = new com.trojasviejas.swing.panels.PanelBorder();
        reportsCard1 = new com.trojasviejas.component.main.ReportsCard();
        reportsCard2 = new com.trojasviejas.component.main.ReportsCard();
        reportsCard3 = new com.trojasviejas.component.main.ReportsCard();
        reportsCard4 = new com.trojasviejas.component.main.ReportsCard();

        setBackground(new java.awt.Color(232, 241, 242));

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportsCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportsCard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportsCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportsCard4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportsCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportsCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportsCard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportsCard4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );

        reportsCard1.currentReportWindow = currentReport;
        reportsCard1.indexReport = 1;
        reportsCard2.currentReportWindow = currentReport;
        reportsCard2.indexReport = 2;
        reportsCard3.currentReportWindow = currentReport;
        reportsCard3.indexReport = 3;
        reportsCard4.currentReportWindow = currentReport;
        reportsCard4.indexReport = 4;

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initCards(){
        reportsCard1.setData("REPORTE DE INVENTARIO", new ImageIcon(getClass().getResource("/img/r_inventory.png")), false, false);
        reportsCard2.setData("REPORTE DE ARTÍCULOS", new ImageIcon(getClass().getResource("/img/r_item.png")), false, false);
        reportsCard3.setData("REPORTE DE FACTURAS", new ImageIcon(getClass().getResource("/img/r_invoice.png")), false, true);
        reportsCard4.setData("REPORTE DE ENTRADAS y SALIDAS", new ImageIcon(getClass().getResource("/img/r_register.png")), true, true);
    }
    public FrmReport currentReport = this;  
    
    public void generateReport(int index, String month, int year){
        switch (index) {
            case 1 -> generateInventoryReport();
            case 2 -> generateItemReport();
            case 3 -> generateInvoiceReport(year);
            case 4 -> generateRegistersReport(month,year);
            default -> {}
        }
    }
    
    private void generateItemReport(){
        Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

       Map parametro = new HashMap();
       parametro.put("logo", "/img/isotipo.png");
        
        //String archive = "C:/Users/cb272/Documents/GitHub/Trojas_Viejas-inventario/TrojasViejas/src/main/java/com/trojasviejas/report/itemsReport.jasper";
        String archive = "src/main/java/com/trojasviejas/report/itemsReport.jasper";
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
    }
    
    private void generateInventoryReport(){
         Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

       Map parametro = new HashMap();
       parametro.put("logo", "/img/isotipo.png");
        
        String archive = "src/main/java/com/trojasviejas/report/inventoriesReport.jasper";
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
    }
    
    private void generateInvoiceReport(int year){
        Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

        Map parametro = new HashMap();
        parametro.put("parameter1", ""+year);
       parametro.put("logo", "/img/isotipo.png");
        
       // String archive = "C:/Users/cb272/Documents/GitHub/Trojas_Viejas-inventario/TrojasViejas/src/main/java/com/trojasviejas/report/invoiceReport.jasper";
        String archive = "src/main/java/com/trojasviejas/report/invoiceReport.jasper";
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
        reportsCard3.txtYear.setText("");
    }
    
    private void generateRegistersReport(String month, int year){              
        Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

        Map parametro = new HashMap();
        parametro.put("p_month", month);
        parametro.put("p_year", year);
        parametro.put("logo", "/img/isotipo.png");

        String archive = "src/main/java/com/trojasviejas/report/ActivityRegisters.jasper";
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
        reportsCard4.txtMonth.setText("");
        reportsCard4.txtYear.setText("");
    }
        public void generateRegistersReportByInvoice(int idInvoice, int items, int usedItems, int stock ){              
        Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

        Map parametro = new HashMap();
        parametro.put("p_id_invoice", idInvoice);
        parametro.put("items", items);
        parametro.put("usedItems", usedItems);
        parametro.put("stock", stock);
       parametro.put("logo", "/img/isotipo.png");

        String archive = "src/main/java/com/trojasviejas/report/RegistersByInvoiceId.jasper";
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
    }
    public void cerrarVentana(){
        Window w = SwingUtilities.getWindowAncestor(this);
        w.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.panels.PanelBorder pnlTable;
    private com.trojasviejas.component.main.ReportsCard reportsCard1;
    private com.trojasviejas.component.main.ReportsCard reportsCard2;
    private com.trojasviejas.component.main.ReportsCard reportsCard3;
    private com.trojasviejas.component.main.ReportsCard reportsCard4;
    // End of variables declaration//GEN-END:variables
}
