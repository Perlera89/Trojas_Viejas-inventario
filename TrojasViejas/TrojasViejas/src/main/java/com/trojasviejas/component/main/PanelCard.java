package com.trojasviejas.component.main;

import com.trojasviejas.models.utility.CardModel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class PanelCard extends javax.swing.JPanel {
    
    private Color color1;
    private Color color2;

    public PanelCard() {
        initComponents();
        setOpaque(false);
        color1 = Color.decode("#005f73");
        color2 = Color.decode("#0a9396");
        
        color1 = Color.decode("#582f0e");
        color2 = Color.decode("#7f4f24");
        
        color1 = Color.decode("#1b4332");
        color2 = Color.decode("#2d6a4f");
    }
    
    public void setFilter(MouseListener action){
        btnFilter.setBackground(new Color(0,0,0,0));
        btnFilter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnFilter.setIcon(new ImageIcon(getClass().getResource("/icons/filter.png")));
        btnFilter.addMouseListener(action);
    }
    
    public void setData(CardModel data) {
        lblIcon.setIcon(data.getIcon());
        lblTitle.setText(data.getTitle());
        lblValues.setText(data.getValues());
    }
    
    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIcon = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblValues = new javax.swing.JLabel();
        btnFilter = new javax.swing.JLabel();

        lblTitle.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Titulo");

        lblValues.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblValues.setForeground(new java.awt.Color(255, 255, 255));
        lblValues.setText("Valores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
                        .addComponent(btnFilter))
                    .addComponent(lblValues)
                    .addComponent(lblTitle))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblValues)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnFilter;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblValues;
    // End of variables declaration//GEN-END:variables
}
