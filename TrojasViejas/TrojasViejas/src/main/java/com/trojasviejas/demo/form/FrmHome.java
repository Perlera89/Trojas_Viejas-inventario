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
        gaugeChart1.setValueWithAnimation(75);
        gaugeChart2.setValueWithAnimation(90);
        gaugeChart3.setValueWithAnimation(45);
        init();
    }
    
    private void init(){
        barChart.addLegend("Entradas", new Color(12, 84, 175), new Color(0, 108, 247));
        barChart.addLegend("Gastos", new Color(54, 4, 143), new Color(104, 49, 200));
        barChart.addLegend("Ganancia", new Color(5, 125, 0), new Color(95, 209, 69));
        barChart.addLegend("Costo", new Color(186, 37, 37), new Color(241, 100, 120));
        barChart.addData(new ChartModel("Enero", new double[]{500, 200, 80, 89}));
        barChart.addData(new ChartModel("Febrero", new double[]{600, 750, 90, 150}));
        barChart.addData(new ChartModel("Marzo", new double[]{200, 350, 460, 900}));
        barChart.addData(new ChartModel("Abril", new double[]{480, 150, 750, 700}));
        barChart.addData(new ChartModel("Mayo", new double[]{350, 540, 300, 150}));
        barChart.addData(new ChartModel("Junio", new double[]{190, 280, 81, 200}));
        barChart.start();
        
        lineChart.addLegend("Entradas", new Color(12, 84, 175), new Color(0, 108, 247));
        lineChart.addLegend("Gastos", new Color(54, 4, 143), new Color(104, 49, 200));
        lineChart.addLegend("Ganancia", new Color(5, 125, 0), new Color(95, 209, 69));
        lineChart.addLegend("Costo", new Color(186, 37, 37), new Color(241, 100, 120));
        lineChart.addData(new ChartModel("Enero", new double[]{500, 200, 80, 89}));
        lineChart.addData(new ChartModel("Febrero", new double[]{600, 750, 90, 150}));
        lineChart.addData(new ChartModel("Marzo", new double[]{200, 350, 460, 900}));
        lineChart.addData(new ChartModel("Abril", new double[]{480, 150, 750, 700}));
        lineChart.addData(new ChartModel("Mayo", new double[]{350, 540, 300, 150}));
        lineChart.addData(new ChartModel("Junio", new double[]{190, 280, 81, 200}));
        lineChart.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        pnlBg = new javax.swing.JPanel();
        pnlCard = new com.trojasviejas.swing.panels.PanelShadow();
        gaugeChart1 = new com.trojasviejas.swing.chart.GaugeChart();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnlCard1 = new com.trojasviejas.swing.panels.PanelShadow();
        gaugeChart2 = new com.trojasviejas.swing.chart.GaugeChart();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pnlCard11 = new com.trojasviejas.swing.panels.PanelShadow();
        gaugeChart3 = new com.trojasviejas.swing.chart.GaugeChart();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblLineChart = new javax.swing.JLabel();
        panelShadow1 = new com.trojasviejas.swing.panels.PanelShadow();
        lineChart = new com.trojasviejas.swing.chart.LineChart();
        lblData2 = new javax.swing.JLabel();
        panelShadow2 = new com.trojasviejas.swing.panels.PanelShadow();
        barChart = new com.trojasviejas.swing.chart.Chart();

        setBackground(new java.awt.Color(232, 241, 242));

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlBg.setBackground(new java.awt.Color(232, 241, 242));
        pnlBg.setPreferredSize(new java.awt.Dimension(1100, 1200));

        pnlCard.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));

        gaugeChart1.setColor1(new java.awt.Color(255, 255, 255));
        gaugeChart1.setColor2(new java.awt.Color(27, 152, 224));
        gaugeChart1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        gaugeChart1.setValue(50);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(100, 100, 100));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total entrada");

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(150, 150, 150));
        jLabel2.setText("Diciembre");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 152, 224));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("$ 150.00");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(150, 150, 150));
        jLabel4.setText("Enero");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 152, 224));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("$ 200.00");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(150, 150, 150));
        jLabel6.setText("Febrero");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 152, 224));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("$ 100.00");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        javax.swing.GroupLayout pnlCardLayout = new javax.swing.GroupLayout(pnlCard);
        pnlCard.setLayout(pnlCardLayout);
        pnlCardLayout.setHorizontalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCardLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlCardLayout.createSequentialGroup()
                        .addComponent(gaugeChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                        .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlCardLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        pnlCardLayout.setVerticalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gaugeChart1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardLayout.createSequentialGroup()
                        .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26))))
        );

        pnlCard1.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));

        gaugeChart2.setColor1(new java.awt.Color(255, 255, 255));
        gaugeChart2.setColor2(new java.awt.Color(248, 78, 78));
        gaugeChart2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        gaugeChart2.setValue(89);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(100, 100, 100));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Total salida");

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(150, 150, 150));
        jLabel9.setText("Diciembre");
        jLabel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(248, 78, 78));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("$ 150.00");
        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(150, 150, 150));
        jLabel11.setText("Enero");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(248, 78, 78));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("$ 200.00");
        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(150, 150, 150));
        jLabel13.setText("Febrero");
        jLabel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(248, 78, 78));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("$ 100.00");
        jLabel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        javax.swing.GroupLayout pnlCard1Layout = new javax.swing.GroupLayout(pnlCard1);
        pnlCard1.setLayout(pnlCard1Layout);
        pnlCard1Layout.setHorizontalGroup(
            pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCard1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlCard1Layout.createSequentialGroup()
                        .addComponent(gaugeChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                        .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlCard1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard1Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        pnlCard1Layout.setVerticalGroup(
            pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gaugeChart2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard1Layout.createSequentialGroup()
                        .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(26, 26, 26))))
        );

        pnlCard11.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));

        gaugeChart3.setColor1(new java.awt.Color(255, 255, 255));
        gaugeChart3.setColor2(new java.awt.Color(27, 152, 224));
        gaugeChart3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        gaugeChart3.setValue(15);

        jLabel78.setBackground(new java.awt.Color(255, 255, 255));
        jLabel78.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(100, 100, 100));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("Total gasto");

        jLabel79.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(150, 150, 150));
        jLabel79.setText("Diciembre");
        jLabel79.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel80.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(27, 152, 224));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel80.setText("$ 150.00");
        jLabel80.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel81.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(150, 150, 150));
        jLabel81.setText("Enero");
        jLabel81.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel82.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(27, 152, 224));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel82.setText("$ 200.00");
        jLabel82.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel83.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(150, 150, 150));
        jLabel83.setText("Febrero");
        jLabel83.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel84.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(27, 152, 224));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel84.setText("$ 100.00");
        jLabel84.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        javax.swing.GroupLayout pnlCard11Layout = new javax.swing.GroupLayout(pnlCard11);
        pnlCard11.setLayout(pnlCard11Layout);
        pnlCard11Layout.setHorizontalGroup(
            pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCard11Layout.createSequentialGroup()
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlCard11Layout.createSequentialGroup()
                        .addComponent(gaugeChart3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel79, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                        .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlCard11Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard11Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard11Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        pnlCard11Layout.setVerticalGroup(
            pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel78)
                .addGap(18, 18, 18)
                .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gaugeChart3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard11Layout.createSequentialGroup()
                        .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel79)
                            .addComponent(jLabel80))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel81)
                            .addComponent(jLabel82))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel83)
                            .addComponent(jLabel84))
                        .addGap(26, 26, 26))))
        );

        lblData.setFont(new java.awt.Font("Norwester", 0, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(27, 152, 224));
        lblData.setText("Grafico de lineas");

        lblLineChart.setFont(new java.awt.Font("Norwester", 0, 18)); // NOI18N
        lblLineChart.setForeground(new java.awt.Color(27, 152, 224));
        lblLineChart.setText("Informe de datos");

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        lblData2.setFont(new java.awt.Font("Norwester", 0, 18)); // NOI18N
        lblData2.setForeground(new java.awt.Color(27, 152, 224));
        lblData2.setText("Grafico de lineas");

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(barChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(barChart, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout pnlBgLayout = new javax.swing.GroupLayout(pnlBg);
        pnlBg.setLayout(pnlBgLayout);
        pnlBgLayout.setHorizontalGroup(
            pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBgLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBgLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblData2)
                        .addGap(924, 944, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBgLayout.createSequentialGroup()
                        .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelShadow1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelShadow2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBgLayout.createSequentialGroup()
                                .addComponent(pnlCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(pnlCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(pnlCard11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))))
            .addGroup(pnlBgLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblData)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBgLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(lblLineChart)
                    .addContainerGap(923, Short.MAX_VALUE)))
        );
        pnlBgLayout.setVerticalGroup(
            pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBgLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCard11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblData)
                .addGap(30, 30, 30)
                .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblData2)
                .addGap(20, 20, 20)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBgLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(lblLineChart)
                    .addContainerGap(1148, Short.MAX_VALUE)))
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
            .addComponent(scroll)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.chart.Chart barChart;
    private com.trojasviejas.swing.chart.GaugeChart gaugeChart1;
    private com.trojasviejas.swing.chart.GaugeChart gaugeChart2;
    private com.trojasviejas.swing.chart.GaugeChart gaugeChart3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblData2;
    private javax.swing.JLabel lblLineChart;
    private com.trojasviejas.swing.chart.LineChart lineChart;
    private com.trojasviejas.swing.panels.PanelShadow panelShadow1;
    private com.trojasviejas.swing.panels.PanelShadow panelShadow2;
    private javax.swing.JPanel pnlBg;
    private com.trojasviejas.swing.panels.PanelShadow pnlCard;
    private com.trojasviejas.swing.panels.PanelShadow pnlCard1;
    private com.trojasviejas.swing.panels.PanelShadow pnlCard11;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
