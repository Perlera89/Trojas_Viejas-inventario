package com.trojasviejas.demo.form;

import com.trojasviejas.component.main.PanelHeader;
import com.trojasviejas.component.main.event.IEventMenuSelected;
import com.trojasviejas.component.main.event.IFindFunctions;
import com.trojasviejas.models.viewmodel.LoginVM;
import com.trojasviejas.swing.scroll.ScrollBar;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class FrmMain extends javax.swing.JFrame implements IFindFunctions{
    
    public static FrmMain main;
   // private FrmHome home;
    //private FrmProviders providers;
    //private FrmItems items;
    //private FrmInvoices invoices;
   // private FrmInventory inventory;
    //private FrmActivity activity;
    //private FrmSetting setting;
    
    private JComponent currentForm;
    
    public static LoginVM login;
    public static int idLogin;

    public FrmMain() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        
        pnlMenu.initWinButton(this, pnlContainer);
        
        main = this;
        //home = new FrmHome();
       // providers = new FrmProviders();
       // items = new FrmItems();
       // invoices = new FrmInvoices();
        //inventory = new FrmInventory();
       // activity = new FrmActivity();
       // setting = new FrmSetting();
        
        pnlMenu.initMoving(this);
        pnlMenu.addEventMenuSelected(new IEventMenuSelected(){
            @Override
            public void selected(int index) {
                if(index == 0){
                    
                    //home.reloadData();
                    currentForm = new FrmHome();
                    setForm(currentForm);
                     panelHeader1.txtSearch.setToolTipText("Año por el cual desea filtrar las información");                   
                    //indice del dashboard
                    indexForm = 0;
                    
                } else if(index == 1){
                    currentForm = new FrmProviders();             
                    setForm(currentForm);
                    panelHeader1.txtSearch.setToolTipText("Nombre del proveedor | Tipo de proveedor");              
                    //indice del proveedores
                    indexForm = 1;
                    
                } else if(index == 2){
                    currentForm = new FrmItems(); 
                    setForm(currentForm);
                    panelHeader1.txtSearch.setToolTipText("Nombre del artículo | Categoría de artículo | Tipo de artículo");                    
                    //indice del items
                    indexForm = 2;                                      

                } else if(index == 3){
                    currentForm = new FrmInvoices(); 
                    setForm(currentForm);             
                    panelHeader1.txtSearch.setToolTipText("_año | mes_año");
                    //indice del facturas
                    indexForm = 3;
                    
                } else if(index == 4){
                    currentForm = new FrmInventory(); 
                    setForm(currentForm);
                    panelHeader1.txtSearch.setToolTipText("Nombre del artículo | Categoría de artículo | Tipo de artículo");
                    //indice del inventario
                    indexForm = 4;
                } else if(index == 5){
                    currentForm = new FrmActivity(); 
                    setForm(currentForm);
                    
                    //indice del registros de actividad
                    indexForm = 5;
                    panelHeader1.txtSearch.setToolTipText("_año | mes_año");
                } else if(index == 6){
                    
                    //indice del reportes
                    indexForm = 6;
                    currentForm = new FrmReport(); 
                    setForm(currentForm);
                }else if(index == 11){
                    currentForm = new FrmSetting(); 
                    setForm(currentForm);
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
    
    //variable para reconocer el objeto actual de menu en el buscador
    private final FrmMain formMain = this;
    

        //define el indice del boton presionado
    private int indexForm = 0;
    
    public void findIn(String stringSearch){
        switch (indexForm) {
            //redirige la busqueda al metodo de busqueda de la entidad en especifico
            case 0 -> findForDasboard(stringSearch);
            case 1 -> findForProviders(stringSearch);
            case 2 -> findForItems(stringSearch);
            case 3 -> findForInvoices(stringSearch);
            case 4 -> findForInventory(stringSearch);
            case 5 -> findForActivityRegisters(stringSearch);
            case 6 -> findForReports(stringSearch);
            default -> {}
        }
    }
    
        @Override
    public void findForDasboard(String stringSearch) {
        //llama al metodo en la entidad que ejecuta la busqueda
        //System.out.println("buscando en dashboard: "+ stringSearch);
        //home <- objeto de la entidad donde se buscara en metodo que ejecuta la busqueda
            FrmHome home = (FrmHome)currentForm;
            home.filterByStringSearch(stringSearch);
       // setForm(home);
    }

    @Override
    public void findForProviders(String stringSearch) {
        //llama al metodo en la entidad que ejecuta la busqueda
        //System.out.println("buscando en providers: "+ stringSearch);
        //providers <- objeto de la entidad donde se buscara en metodo que ejecuta la busqueda
        FrmProviders providers = (FrmProviders)currentForm;
        providers.filterByStringSearch(stringSearch);
    }

    @Override
    public void findForItems(String stringSearch) {
        //llama al metodo en la entidad que ejecuta la busqueda
        //items <- objeto de la entidad donde se buscara en metodo que ejecuta la busqueda
        FrmItems items = (FrmItems)currentForm;
        items.filterByStringSearch(stringSearch);
        
    }

    @Override
    public void findForInvoices(String stringSearch) {
        //llama al metodo en la entidad que ejecuta la busqueda
        //invoices <- objeto de la entidad donde se buscara en metodo que ejecuta la busqueda
        FrmInvoices invoices = (FrmInvoices)currentForm;
        invoices.filterByStringSearch(stringSearch);
    }

    @Override
    public void findForInventory(String stringSearch) { 
        //llama al metodo en la entidad que ejecuta la busqueda
        FrmInventory inventory = (FrmInventory)currentForm;
        inventory.filterByStringSearch(stringSearch);
        inventory.showInventory("ALL");
    }

     public static String getStringSearch(){
         //panelHeader1: objeto actual del menu general
         return panelHeader1.moveStringSearchToMenu();
     }

    @Override
    public void findForActivityRegisters(String stringSearch) {
         
        FrmActivity activity = (FrmActivity)currentForm;
        //llama al metodo en la entidad que ejecuta la busqueda
        activity.runSearch(stringSearch);
        //hara que se muestren los datos, y los contadores udaran la informacion de la busqueda para ;os filtros
        activity.showActivityRegistersFilterBy("ALL");
       
        
    }

    @Override
    public void findForReports(String stringSearch) {

        
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

        panelHeader1.frmMain = formMain;

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
    public static com.trojasviejas.component.main.PanelHeader panelHeader1;
    private com.trojasviejas.swing.panels.PanelBorder pnlContainer;
    private javax.swing.JPanel pnlMain;
    private com.trojasviejas.component.main.PanelMenu pnlMenu;
    private com.trojasviejas.swing.scroll.ScrollBar scrollBar1;
    // End of variables declaration//GEN-END:variables

}
