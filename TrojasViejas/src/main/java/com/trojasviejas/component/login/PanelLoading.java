package com.trojasviejas.component.login;

import java.awt.*;
import java.awt.event.MouseAdapter;

public class PanelLoading extends javax.swing.JPanel {

    public PanelLoading() {
        initComponents();
        setOpaque(false);
        setFocusCycleRoot(true);
        setVisible(false);
        setFocusable(true);
        addMouseListener(new MouseAdapter(){
            
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLoading = new javax.swing.JLabel();

        lblLoading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoading.setIcon(new javax.swing.ImageIcon("/Users/perlera/Documents/GitHub/Trojas_Viejas-inventario/TrojasViejas/src/main/src/loading.gif")); // NOI18N
        lblLoading.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLoading, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLoading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paintComponents(Graphics grphcs){
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setColor(new Color(255, 255, 255));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setComposite(AlphaComposite.SrcOver);
        super.paintComponent(grphcs);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblLoading;
    // End of variables declaration//GEN-END:variables
}