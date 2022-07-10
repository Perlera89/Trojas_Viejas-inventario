package com.trojasviejas.demo.form;

import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.data.dao.ReportDao;
import com.trojasviejas.models.utility.ReportCardModel;
import javax.swing.*;
import java.awt.*;

public class FrmReport extends javax.swing.JPanel {

    MessageErrorDialog dialogResult = new MessageErrorDialog(new FrmLogin());
    FrmReport form = this;

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
        reportsCard1.setData(new ReportCardModel("REPORTE DE INVENTARIO", new ImageIcon(getClass().getResource("/img/r_inventory.png")), false, false));
        reportsCard2.setData(new ReportCardModel("REPORTE DE ARTÍCULOS", new ImageIcon(getClass().getResource("/img/r_item.png")), false, false));
        reportsCard3.setData(new ReportCardModel("REPORTE DE FACTURAS", new ImageIcon(getClass().getResource("/img/r_invoice.png")), false, true));
        reportsCard4.setData(new ReportCardModel("REPORTE DE ENTRADAS y SALIDAS", new ImageIcon(getClass().getResource("/img/r_register.png")), true, true));
    }
    public FrmReport currentReport = this;  
    ReportDao reportDao = new ReportDao();
    
    public void generateReport(int index, String month, int year){
        switch (index) {
            case 1 -> reportDao.generateInventoryReport();
            case 2 -> reportDao.generateItemReport();
            case 3 -> reportDao.generateInvoiceReport(year, this.reportsCard3);
            case 4 -> reportDao.generateRegistersReport(month,year, this.reportsCard4);
            default -> {}
        }
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
