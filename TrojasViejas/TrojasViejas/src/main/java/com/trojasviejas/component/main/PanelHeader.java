package com.trojasviejas.component.main;

import com.trojasviejas.component.login.MessageDialog;
import com.trojasviejas.demo.form.FrmLogin;
import com.trojasviejas.demo.form.FrmMain;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class PanelHeader extends javax.swing.JPanel {


    //llamando al menu para luego pasarle los datos de las busqueda
    public PanelHeader(/*FrmMain main*/) {
        initComponents();
        setOpaque(false);
        //frmMain = main;
    }
    
    //string de busqueda
    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    
    public void setSearch(MouseListener action){
        btnSearch.addMouseListener(action);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255, 255, 255));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(0, 0, 25, getHeight());
        g2.fillRect(getWidth() - 25, getHeight() - 25, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSearch = new javax.swing.JLabel();
        txtSearch = new com.trojasviejas.swing.fields.SearchText();
        btnOption1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        btnOption1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOption1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/option.png"))); // NOI18N
        btnOption1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOption1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addGap(92, 92, 92)
                .addComponent(btnOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOption1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOption1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOption1MouseClicked

    }//GEN-LAST:event_btnOption1MouseClicked
    

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnSearchMouseEntered
    //se almacena el objeto actual del menu
    public FrmMain frmMain = null;
    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        setSearch(txtSearch.getText());
        frmMain.findIn(getSearch());
    }//GEN-LAST:event_btnSearchMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnOption1;
    private javax.swing.JLabel btnSearch;
    private com.trojasviejas.swing.fields.SearchText txtSearch;
    // End of variables declaration//GEN-END:variables
}
