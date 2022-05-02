package com.trojasviejas.demo.form;

import com.trojasviejas.swing.scroll.ScrollBar;
import javax.swing.*;
import java.awt.*;

public class FrmHome extends javax.swing.JPanel {

    public FrmHome() {
        initComponents();
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.white);
//        pnlCard1.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/stock.png")), "Total stock", "200", "Incremento un 10%"));
//        pnlCard2.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/dollar.png")), "Total costo", "$1200", "Incremento un 45%"));
//        pnlCard3.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/stock.png")), "Total stock", "200", "Incremento un 10%"));
//        
//        //Agregar registro
//        scroll.setVerticalScrollBar(new ScrollBar());
//        scroll.getVerticalScrollBar().setBackground(Color.white);
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.white);
//        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
//        scroll.getViewport().setBackground(Color.white);
//        
//        tblProviders.addRow(new Object[]{"Manuel Perlera", "7097-0435", "manuenitoo@gmail.com", "Barrio el carmen", ProviderType.VENDEDOR});
//        tblProviders.addRow(new Object[]{"Manuel Perlera", "7097-0435", "manuenitoo@gmail.com", "Barrio el carmen", ProviderType.DONADOR});
//        tblProviders.addRow(new Object[]{"Manuel Perlera", "7097-0435", "manuenitoo@gmail.com", "Barrio el carmen", ProviderType.VENDEDOR});
//        tblProviders.addRow(new Object[]{"Manuel Perlera", "7097-0435", "manuenitoo@gmail.com", "Barrio el carmen", ProviderType.DONADOR});
//        tblProviders.addRow(new Object[]{"Manuel Perlera", "7097-0435", "manuenitoo@gmail.com", "Barrio el carmen", ProviderType.VENDEDOR});
//        tblProviders.addRow(new Object[]{"Manuel Perlera", "7097-0435", "manuenitoo@gmail.com", "Barrio el carmen", ProviderType.DONADOR});
//        tblProviders.addRow(new Object[]{"Manuel Perlera", "7097-0435", "manuenitoo@gmail.com", "Barrio el carmen", ProviderType.VENDEDOR});
//        tblProviders.addRow(new Object[]{"Manuel Perlera", "7097-0435", "manuenitoo@gmail.com", "Barrio el carmen", ProviderType.DONADOR});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        pnlBg = new javax.swing.JPanel();
        panelShadow1 = new com.trojasviejas.swing.panels.PanelShadow();

        setBackground(new java.awt.Color(232, 241, 242));

        scroll.setBorder(null);

        pnlBg.setBackground(new java.awt.Color(232, 241, 242));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlBgLayout = new javax.swing.GroupLayout(pnlBg);
        pnlBg.setLayout(pnlBgLayout);
        pnlBgLayout.setHorizontalGroup(
            pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(619, Short.MAX_VALUE))
        );
        pnlBgLayout.setVerticalGroup(
            pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1375, Short.MAX_VALUE))
        );

        scroll.setViewportView(pnlBg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 915, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel4;
    private com.trojasviejas.swing.panels.PanelShadow panelShadow1;
    private javax.swing.JPanel pnlBg;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
