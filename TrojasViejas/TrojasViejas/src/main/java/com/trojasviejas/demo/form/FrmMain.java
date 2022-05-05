package com.trojasviejas.demo.form;

import com.trojasviejas.component.main.event.IEventMenuSelected;
import com.trojasviejas.swing.scroll.ScrollBar;
import java.awt.*;
import javax.swing.JComponent;

public class FrmMain extends javax.swing.JFrame {
    
    private FrmHome home;
    private FrmProviders providers;
    private FrmItems items;
    private FrmInvoices invoices;
    private FrmInventory inventory;
    private FrmUsers users;

    public FrmMain() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        
        pnlMenu.initWinButton(this, pnlContainer);
        
        home = new FrmHome();
        providers = new FrmProviders();
        items = new FrmItems();
        invoices = new FrmInvoices();
        inventory = new FrmInventory();
        users = new FrmUsers();
        
        pnlMenu.initMoving(this);
        pnlMenu.addEventMenuSelected(new IEventMenuSelected(){
            @Override
            public void selected(int index) {
                if(index == 0){
                    setForm(home);
                } else if(index == 1){
                    setForm(providers);
                } else if(index == 2){
                    setForm(items);
                } else if(index == 3){
                    setForm(invoices);
                } else if(index == 4){
                    setForm(inventory);
                } else if(index == 5){
                    setForm(inventory);
                } else if(index == 9){
                    setForm(users);
                } else if(index == 10){
                    setForm(users);
                }
            }
        });
        
        setForm(new FrmHome());
    }
    
    private void setForm(JComponent component){
        pnlMain.removeAll();
        pnlMain.add(component);
        pnlMain.repaint();
        pnlMain.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new com.trojasviejas.swing.panels.PanelBorder();
        pnlMenu = new com.trojasviejas.component.main.PanelMenu();
        panelHeader1 = new com.trojasviejas.component.main.PanelHeader();
        pnlMain = new javax.swing.JPanel();
        scrollBar1 = new com.trojasviejas.swing.scroll.ScrollBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlContainer.setBackground(new java.awt.Color(232, 241, 242));
        pnlContainer.setForeground(new java.awt.Color(255, 255, 255));

        pnlMain.setBackground(new java.awt.Color(232, 241, 242));
        pnlMain.setOpaque(false);
        pnlMain.setLayout(new java.awt.BorderLayout());
        pnlMain.add(scrollBar1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addComponent(panelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 708, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.component.main.PanelHeader panelHeader1;
    private com.trojasviejas.swing.panels.PanelBorder pnlContainer;
    private javax.swing.JPanel pnlMain;
    private com.trojasviejas.component.main.PanelMenu pnlMenu;
    private com.trojasviejas.swing.scroll.ScrollBar scrollBar1;
    // End of variables declaration//GEN-END:variables
}
