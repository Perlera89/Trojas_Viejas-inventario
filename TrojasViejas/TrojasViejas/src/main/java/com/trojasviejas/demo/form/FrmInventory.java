package com.trojasviejas.demo.form;

import com.trojasviejas.demo.form.window.*;
import com.trojasviejas.models.entity.ProviderModel;
import com.trojasviejas.models.utility.*;
import com.trojasviejas.swing.scroll.ScrollBar;
import javax.swing.*;
import java.awt.*;
import com.trojasviejas.component.main.event.IProviderEventAction;
import com.trojasviejas.data.dao.InventoryDao;
import com.trojasviejas.models.viewmodel.InventoryVM;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FrmInventory extends javax.swing.JPanel {

    public FrmInventory() {
        setOpaque(false);
        initComponents();
        initCard();
        initTableData();
    }
    
    private void initCard(){
        pnlCard1.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/seller.png")), "ARTÍCULOS", String.valueOf(countItem)));
        pnlCard2.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/donor.png")), "EXISTENCIAS", String.valueOf(countStock)));
        pnlCard3.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/donor.png")), "BAJO EL LÍMITE", String.valueOf(countItemOnLimit)));
        pnlCard4.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/donor.png")), "HERRAMIENTAS", String.valueOf(countTools)));
        pnlCard5.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/donor.png")), "ACCESORIOS", String.valueOf(countAccesories)));

        
        //MUESTRA TODOS LOS REGISTROS NUEVAMENTE
        pnlCard1.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showInventory("ALL");
            }
            
        });
        
        //EJECUTA FILTRO DE ITEMS <= LIMITE ESTABLECIDO
        pnlCard3.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showInventory("ITEMS_ON_LIMIT");
            }
            
        }); 
        
        //EJECUTA FILTRO DE FILAS POR LAS QUE PERTENECEN A HERRAMIENTAS
        pnlCard4.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showInventory("TOOLS");
            }
            
        });
           
        //EJECUTA FILTRO DE LAS FILAS QUE PERTECEN A ACCESORIOS
        pnlCard5.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showInventory("ACCESORIES");
            }
            
        });
        
    }
    
    private void initTableData(){
        //Agregar registro
        IProviderEventAction eventAction = new IProviderEventAction() {
            @Override
            public void update(ProviderModel entity) {
                System.out.println("Editar a " + entity.getName());
            }

            @Override
            public void delete(ProviderModel entity) {
                System.out.println("Eliminar a " + entity.getName());
            }
        };
        
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.white);
        
        //mostrando el inevntario, filtrado por existencias > 0
        showInventory("ALL");

    }
        
    private void clearRowsInTable(){
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblInventory.getModel();
            int filas = tblInventory.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
    //formato para fechas
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    //Array De busqueda
    ArrayList<InventoryVM> listFound=null;
    
    public void listByFinder(String _search){
        //resetendo el array de busqueda
        listFound = null;
        if (!_search.isBlank() || !_search.isEmpty()){

            InventoryDao inventories = new InventoryDao();
            if (cbbStock.getSelectedIndex() >= 0) {
                
                //guardando la busqueda en una array para ser usada en los filtros de cajas
                //y filtrando los items con stock
                if (cbbStock.getSelectedItem().equals("Agotados")) {
                    listFound = itemsWithStock(inventories.findBy(_search), 0);
                } else {
                    listFound = itemsWithStock(inventories.findBy(_search), 1);
                }
            }else{
                listFound = itemsWithStock(inventories.findBy(_search), 1);       
            }

            showInventory("ALL");
        }

    }
    
    //contadores
    private int countItem = 0;
    private int countStock = 0;
    private int countItemOnLimit = 0;
    private int countTools = 0;
    private int countAccesories = 0;
    
    public void showInventory(String tipo_filtro){
        //RESETEANDO LOS CONTADORES      
        countItem = 0;
        countStock = 0;
        countItemOnLimit = 0;
        countTools = 0;
        countAccesories = 0;
        
        //LIMPIANDO LA TABLA
        clearRowsInTable();
        
       InventoryDao inventory = new InventoryDao();
        ArrayList<InventoryVM> inventories = itemsWithStock(inventory.list(),1);  
        
        if (listFound != null) {
            inventories = listFound;
        }
        //MOSTRAR TODOS LOS DATOS
        switch (tipo_filtro) {
            case "ALL" -> {
                for (var i : inventories) {
                    if (i.getCategory().equals(CategoryType.HERRAMIENTAS)) {
                        countTools++;
                    }
                    if (i.getCategory().equals(CategoryType.ACCESORIOS)) {
                        countAccesories++;
                    }
                    if (i.getStock() <= i.getMinimunAmount()) {
                        countItemOnLimit++;
                    }
                    //AGREGANDO LA FILA A LA TABLA Y LOS BOTONES DE ACCIONES
                    add_rows_to_table(i);
                    //Sumando las existencias
                    countStock += i.getStock();
                    countItem++;
                }
                //ACTUALIZANDO LOS CONTADORES
                initCard();
            }
            //FILTRAR LAAS FILAS POR ITEMS BAJO EL MINIMO
            case "ITEMS_ON_LIMIT" -> {
                for (var i : inventories) {

                    if (i.getStock() <= i.getMinimunAmount()) {
                        if (i.getCategory().equals(CategoryType.HERRAMIENTAS)) {
                            countTools++;
                        }
                        if (i.getCategory().equals(CategoryType.ACCESORIOS)) {
                            countAccesories++;
                        }
                        countItemOnLimit++;
                        //Sumando las existencias
                        countStock += i.getStock();

                        //AGREGANDO LA FILA A LA TABLA Y LOS BOTONES DE ACCIONES
                        add_rows_to_table(i);
                        countItem++;
                    }

                    
                }
                //ACTUALIZANDO LOS CONTADORES
                initCard();
            }
            //FILTRAR LAAS FILAS POR LA CATEGORIA DE HERRAMIENTAS
            case "TOOLS" -> {
                for (var i : inventories) {
                    if (i.getCategory().equals(CategoryType.HERRAMIENTAS)) {
                        
                        if (i.getStock() <= i.getMinimunAmount()) {
                            countItemOnLimit++;
                        }
                        //Sumando las existencias
                        countStock += i.getStock();
                        countTools++;
                        //AGREGANDO LA FILA A LA TABLA Y LOS BOTONES DE ACCIONES
                        add_rows_to_table(i);
                        countItem++;
                    }
                }
                //ACTUALIZANDO LOS CONTADORES
                initCard();
            }
            //FILTRAR LAS FILAS POR LA CATEGORIA DE ACCESORIOS
            case "ACCESORIES" -> {
                for (var i : inventories) {
                    if (i.getCategory().equals(CategoryType.ACCESORIOS)) {

                        if (i.getStock() <= i.getMinimunAmount()) {
                            countItemOnLimit++;
                        }
                        //Sumando las existencias
                        countStock += i.getStock();
                        
                        countAccesories++;
                        //AGREGANDO LA FILA A LA TABLA Y LOS BOTONES DE ACCIONES
                        add_rows_to_table(i);
                        countItem++;
                    }
                }
                //ACTUALIZANDO LOS CONTADORES
                initCard();

            }
            default -> {
            }
        } 
    }
    
    private void add_rows_to_table(InventoryVM inventory){
        //AGREGANDO FILA A  lA TABLA
        tblInventory.addRow(new Object[]{
                inventory.getId(),
                inventory.getAmount(),
                inventory.getItem(),
                inventory.getStock(),
                inventory.getMinimunAmount(),
                "$"+inventory.getPricePerUnit(),
                inventory.getCategory(),
                inventory.getType(),
                formato.format(inventory.getBuyDate())
        });
    }
    
    private ArrayList<InventoryVM> itemsWithStock(ArrayList<InventoryVM> inventories, int type ){

        ArrayList<InventoryVM> inventary = new ArrayList<>();
        ArrayList<InventoryVM> _inventary = new ArrayList<>();

        for (var i : inventories) {

            //filtrando por las filas que tienen exitencias 0
            if (i.getStock() > 0) {
                inventary.add(i);
            }else{
                _inventary.add(i);
            }

        }

        //retornando los datos en items agotados filtrados por el string de busqueda
        if (type==0) {
           return _inventary;
        }
        return inventary;
    }
    
    private ArrayList<InventoryVM> filterBy(String typeFilter){
        
        InventoryDao inventories = new InventoryDao();
        
        ArrayList<InventoryVM> inventary = new ArrayList<>();
        
        if (typeFilter.equals("AGOTADOS")) {
            for (var i : inventories.list()) {

                //filtrando por las filas que tienen exitencias 0
                if (i.getStock() == 0) {
                    inventary.add(i);
                }
            }


        }
        return inventary;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JLayeredPane();
        pnlCard1 = new com.trojasviejas.component.main.PanelCard();
        pnlCard2 = new com.trojasviejas.component.main.PanelCard();
        pnlCard3 = new com.trojasviejas.component.main.PanelCard();
        pnlCard4 = new com.trojasviejas.component.main.PanelCard();
        pnlCard5 = new com.trojasviejas.component.main.PanelCard();
        pnlTable = new com.trojasviejas.swing.panels.PanelBorder();
        lblProviders = new javax.swing.JLabel();
        btnRegister = new com.trojasviejas.swing.Buttons.ActionButton();
        scroll = new javax.swing.JScrollPane();
        tblInventory = new com.trojasviejas.swing.tables.inventory.InventoryTable();
        cbbStock = new com.trojasviejas.swing.ComboBox();
        cbbItems = new com.trojasviejas.swing.ComboBox();
        btnRefresh = new com.trojasviejas.swing.Buttons.ActionButton();

        setBackground(new java.awt.Color(232, 241, 242));

        pnlContainer.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        pnlCard1.setColor1(new java.awt.Color(0, 40, 85));
        pnlCard1.setColor2(new java.awt.Color(2, 62, 125));
        pnlContainer.add(pnlCard1);

        pnlCard2.setColor1(new java.awt.Color(77, 0, 165));
        pnlCard2.setColor2(new java.awt.Color(83, 0, 204));
        pnlContainer.add(pnlCard2);

        pnlCard3.setColor1(new java.awt.Color(108, 5, 0));
        pnlCard3.setColor2(new java.awt.Color(162, 0, 0));
        pnlContainer.add(pnlCard3);

        pnlCard4.setColor1(new java.awt.Color(0, 58, 1));
        pnlCard4.setColor2(new java.awt.Color(0, 71, 2));
        pnlContainer.add(pnlCard4);

        pnlCard5.setColor1(new java.awt.Color(255, 123, 0));
        pnlCard5.setColor2(new java.awt.Color(255, 136, 0));
        pnlContainer.add(pnlCard5);

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        lblProviders.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblProviders.setForeground(new java.awt.Color(127, 127, 127));
        lblProviders.setText("Inventario");

        btnRegister.setBackground(new java.awt.Color(0, 184, 82));
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnRegister.setText("Registro");
        btnRegister.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnRegister.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        scroll.setBorder(null);

        tblInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Comprado", "Articulo", "Existencias", "Cantidad minima", "C/U", "Categoria", "Tipo", "Fecha de compra"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(tblInventory);
        if (tblInventory.getColumnModel().getColumnCount() > 0) {
            tblInventory.getColumnModel().getColumn(0).setMinWidth(0);
            tblInventory.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblInventory.getColumnModel().getColumn(0).setMaxWidth(0);
            tblInventory.getColumnModel().getColumn(4).setMinWidth(0);
            tblInventory.getColumnModel().getColumn(4).setPreferredWidth(0);
            tblInventory.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        cbbStock.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Existencias", "Agotados" }));
        cbbStock.setSelectedIndex(-1);
        cbbStock.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        cbbStock.setLabeText("Elija existencia");
        cbbStock.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbStockItemStateChanged(evt);
            }
        });

        cbbItems.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Existencias", "Agotados" }));
        cbbItems.setSelectedIndex(-1);
        cbbItems.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        cbbItems.setLabeText("Elija articulo");

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scroll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTableLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cbbItems, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbStock, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblProviders)
                            .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addComponent(lblProviders)
                        .addGap(11, 11, 11)
                        .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents
    FrmInventory thisForm = this;
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        WindowActivityRegisters newRegister = new WindowActivityRegisters();
        
        if (tblInventory.getSelectedRowCount() > 0) {
            transferDataToForm(newRegister);
            newRegister.inventoryForm = thisForm;
            WindowActivityRegisters.main(newRegister);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Para registrar una salida debe seleccionar un artículo previamente. \n",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnRegisterActionPerformed
   private void transferDataToForm(WindowActivityRegisters newRegister){

        int indexRegister = tblInventory.getSelectedRow();

        //agregando los datos a las cajas 
        newRegister.idItem = Integer.parseInt(tblInventory.getValueAt(indexRegister, 0).toString());
       
        newRegister.lblAmountBought.setText(tblInventory.getValueAt(indexRegister, 1).toString());
        newRegister.lblItem.setText(tblInventory.getValueAt(indexRegister, 2).toString());
        newRegister.lblStock.setText(tblInventory.getValueAt(indexRegister, 3).toString());
        newRegister.lblCategory.setText(tblInventory.getValueAt(indexRegister, 6).toString());
        newRegister.lblType.setText(tblInventory.getValueAt(indexRegister, 7).toString());
        newRegister.lblBuyDate.setText(tblInventory.getValueAt(indexRegister, 8).toString());

    }
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        
        listFound = null;
        cbbStock.setSelectedIndex(-1);
        showInventory("ALL");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void cbbStockItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbStockItemStateChanged
               if(cbbStock.getSelectedIndex()==0){
            //colocando el array de las listas de busqueda como nula
            //para que solo se carguen los que tiene existencias
            listFound = null;
            
            //recargando todos los datos
            showInventory("ALL");
            
        }else if(cbbStock.getSelectedIndex()==1){
            
            //colocando en la lista de filtrado los datos de los items agotados
             listFound = filterBy("AGOTADOS");
             showInventory("ALL");
            
            
        }
    }//GEN-LAST:event_cbbStockItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.Buttons.ActionButton btnRefresh;
    private com.trojasviejas.swing.Buttons.ActionButton btnRegister;
    private com.trojasviejas.swing.ComboBox cbbItems;
    private com.trojasviejas.swing.ComboBox cbbStock;
    private javax.swing.JLabel lblProviders;
    private com.trojasviejas.component.main.PanelCard pnlCard1;
    private com.trojasviejas.component.main.PanelCard pnlCard2;
    private com.trojasviejas.component.main.PanelCard pnlCard3;
    private com.trojasviejas.component.main.PanelCard pnlCard4;
    private com.trojasviejas.component.main.PanelCard pnlCard5;
    private javax.swing.JLayeredPane pnlContainer;
    private com.trojasviejas.swing.panels.PanelBorder pnlTable;
    private javax.swing.JScrollPane scroll;
    private com.trojasviejas.swing.tables.inventory.InventoryTable tblInventory;
    // End of variables declaration//GEN-END:variables
}
