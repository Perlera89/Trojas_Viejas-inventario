package com.trojasviejas.demo.form;

import com.trojasviejas.swing.chart.ChartModel;
import com.trojasviejas.swing.scroll.ScrollBar;
import javax.swing.*;
import java.awt.*;

public class FrmHome extends javax.swing.JPanel {

    public FrmHome() {
        initComponents();
        setOpaque(false);
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.white);
        init();
    }
    
    private void init(){
//        barChart.addLegend("Entradas", new Color(12, 84, 175), new Color(0, 108, 247));
//        barChart.addLegend("Gastos", new Color(54, 4, 143), new Color(104, 49, 200));
//        barChart.addLegend("Ganancia", new Color(5, 125, 0), new Color(95, 209, 69));
//        barChart.addLegend("Costo", new Color(186, 37, 37), new Color(241, 100, 120));
//        barChart.addData(new ChartModel("Enero", new double[]{500, 200, 80, 89}));
//        barChart.addData(new ChartModel("Febrero", new double[]{600, 750, 90, 150}));
//        barChart.addData(new ChartModel("Marzo", new double[]{200, 350, 460, 900}));
//        barChart.addData(new ChartModel("Abril", new double[]{480, 150, 750, 700}));
//        barChart.addData(new ChartModel("Mayo", new double[]{350, 540, 300, 150}));
//        barChart.addData(new ChartModel("Junio", new double[]{190, 280, 81, 200}));
//        barChart.start();
//        
//        lineChart.addLegend("Entradas", new Color(12, 84, 175), new Color(0, 108, 247));
//        lineChart.addLegend("Gastos", new Color(54, 4, 143), new Color(104, 49, 200));
//        lineChart.addLegend("Ganancia", new Color(5, 125, 0), new Color(95, 209, 69));
//        lineChart.addLegend("Costo", new Color(186, 37, 37), new Color(241, 100, 120));
//        lineChart.addData(new ChartModel("Enero", new double[]{500, 200, 80, 89}));
//        lineChart.addData(new ChartModel("Febrero", new double[]{600, 750, 90, 150}));
//        lineChart.addData(new ChartModel("Marzo", new double[]{200, 350, 460, 900}));
//        lineChart.addData(new ChartModel("Abril", new double[]{480, 150, 750, 700}));
//        lineChart.addData(new ChartModel("Mayo", new double[]{350, 540, 300, 150}));
//        lineChart.addData(new ChartModel("Junio", new double[]{190, 280, 81, 200}));
//        lineChart.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        legendModel1 = new com.trojasviejas.swing.chart.LegendModel();
        scroll = new javax.swing.JScrollPane();
        pnlBg = new javax.swing.JPanel();

        setBackground(new java.awt.Color(232, 241, 242));

        scroll.setBorder(null);

        pnlBg.setBackground(new java.awt.Color(232, 241, 242));

        javax.swing.GroupLayout pnlBgLayout = new javax.swing.GroupLayout(pnlBg);
        pnlBg.setLayout(pnlBgLayout);
        pnlBgLayout.setHorizontalGroup(
            pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 905, Short.MAX_VALUE)
        );
        pnlBgLayout.setVerticalGroup(
            pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 837, Short.MAX_VALUE)
        );

        scroll.setViewportView(pnlBg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.chart.LegendModel legendModel1;
    private javax.swing.JPanel pnlBg;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
