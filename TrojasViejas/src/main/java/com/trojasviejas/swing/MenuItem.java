package com.trojasviejas.swing;

import com.trojasviejas.models.utility.MenuModel;
import java.awt.*;
import javax.swing.SwingConstants;

public class MenuItem extends javax.swing.JPanel {

    private boolean isSelected;
    private boolean isOver;
    public MenuItem(MenuModel data) {
        initComponents();
        setOpaque(false);
        if(data.getType() == MenuModel.MenuType.MENU){
            lblIcon.setIcon(data.toIcon());
            lblName.setText(data.getName());
            lblName.setFont(new Font("Roboto", 0, 14));
            lblName.setAlignmentX(SwingConstants.LEFT);
        } else if(data.getType() == MenuModel.MenuType.TITLE){
            lblIcon.setText(data.getName());
            lblIcon.setFont(new Font("Norwester", 0, 20));
            lblIcon.setForeground(Color.white);
            lblName.setVisible(false);
        } else{
            lblName.setText(" ");
        }
    }
    
    public void setSelected(boolean isSelected){
        this.isSelected = isSelected;
        repaint();
    }
    
    public void setOver(boolean isOver){
        this.isOver = isOver;
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIcon = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblName.setText("Menu Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        if(isSelected || isOver){
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if(isSelected){
                g2.setColor(new Color(255, 255, 255, 80));
            } else{
                g2.setColor(new Color(255, 255, 255, 20));
            }
            g2.fillRoundRect(10, 0, getWidth() - 20, getHeight(), 5, 5);
        }
        super.paintComponent(g);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblName;
    // End of variables declaration//GEN-END:variables
}
