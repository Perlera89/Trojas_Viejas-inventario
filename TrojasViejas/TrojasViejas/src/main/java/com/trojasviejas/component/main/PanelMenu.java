package com.trojasviejas.component.main;

import com.trojasviejas.component.main.event.IEventMenuSelected;
import com.trojasviejas.models.utility.MenuModel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.*;
import javax.swing.*;

public class PanelMenu extends javax.swing.JPanel {
    
    private IEventMenuSelected event;
    
    public void addEventMenuSelected(IEventMenuSelected event){
        this.event = event;
        lstMenu.addEventMenuSelected(event);
    }

    public PanelMenu() {
        initComponents();
        setOpaque(false);
        lstMenu.setOpaque(false);
        init();
    }
    
    private void init(){
        //Agregando elementos del menu
//        DefaultListCellRenderer cellRenderer = (DefaultListCellRenderer)lstMenu.getCellRenderer();
//        cellRenderer.setHorizontalAlignment(SwingConstants .CENTER);
        lstMenu.addItem(new MenuModel("home", "Inicio", MenuModel.MenuType.MENU));
        lstMenu.addItem(new MenuModel("provider", "Proveedores", MenuModel.MenuType.MENU));
        lstMenu.addItem(new MenuModel("item", "Articulos", MenuModel.MenuType.MENU));
        lstMenu.addItem(new MenuModel("invoice", "Facturas", MenuModel.MenuType.MENU));
        lstMenu.addItem(new MenuModel("inventory", "Inventario", MenuModel.MenuType.MENU));
        lstMenu.addItem(new MenuModel("activity", "Actividad", MenuModel.MenuType.MENU));
        lstMenu.addItem(new MenuModel("reports", "Reportes", MenuModel.MenuType.MENU));
        lstMenu.addItem(new MenuModel("", "", MenuModel.MenuType.EMPTY));
        
        lstMenu.addItem(new MenuModel("", "Perfil", MenuModel.MenuType.TITLE));
        lstMenu.addItem(new MenuModel("", "", MenuModel.MenuType.EMPTY));
        lstMenu.addItem(new MenuModel("user", "Usuarios", MenuModel.MenuType.MENU));
        lstMenu.addItem(new MenuModel("setting", "Ajustes", MenuModel.MenuType.MENU));
        lstMenu.addItem(new MenuModel("", "", MenuModel.MenuType.EMPTY));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lstMenu = new com.trojasviejas.swing.ListMenu<>();

        pnlHeader.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Norwester", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/isotipoSmall.png"))); // NOI18N
        jLabel1.setText("Trojas Viejas");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lstMenu.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lstMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lstMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradient = new GradientPaint(0, 0, new Color(27, 152, 224), 0, getHeight(), new Color(19, 41, 61));
        g2.setPaint(gradient);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(g);
    }
    
    private int x;
    private int y;
    
    public void initMoving(JFrame window){
        pnlHeader.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
            
        });
        
        pnlHeader.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {
                window.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private com.trojasviejas.swing.ListMenu<String> lstMenu;
    private javax.swing.JPanel pnlHeader;
    // End of variables declaration//GEN-END:variables
}
