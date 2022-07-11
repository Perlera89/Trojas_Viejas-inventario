package com.trojasviejas.demo.form;

import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.demo.form.window.*;
import com.trojasviejas.models.utility.*;
import com.trojasviejas.swing.scroll.ScrollBar;
import javax.swing.*;
import java.awt.*;
import com.trojasviejas.data.dao.InventoryDao;
import static com.trojasviejas.demo.form.FrmMain.getStringSearch;
import com.trojasviejas.models.viewmodel.InventoryVM;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FrmInventory extends javax.swing.JPanel {

    public FrmInventory() {
        setOpaque(false);
        initComponents();
        initCard();
        initTableData();
        scroll.setBorder(BorderFactory.createEmptyBorder());
    }
    MessageErrorDialog message = new MessageErrorDialog(new JFrame());

    private void initCard() {
        pnlCard1.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/item.png")), "ARTÍCULOS", ""+countItem));
        pnlCard2.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/stock.png")), "EXISTENCIAS", ""+countStock));
        pnlCard3.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/limit.png")), "BAJO EL LÍMITE", ""+countItemOnLimit));
        pnlCard4.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/tools.png")), "ACCESORIOS", ""+ countAccesories));
        pnlCard5.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/accessories.png")), "HERRAMIENTAS", ""+countTools));

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


                //EJECUTA FILTRO DE LAS FILAS QUE PERTECEN A ACCESORIOS
        pnlCard4.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showInventory("ACCESORIES");
            }

        });

        //EJECUTA FILTRO DE FILAS POR LAS QUE PERTENECEN A HERRAMIENTAS
        pnlCard5.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showInventory("TOOLS");
            }

        });

    }

    private void initTableData() {

        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.white);

        //mostrando el inevntario, filtrado por existencias > 0
        showInventory("ALL");

    }
    
    //formato para fechas
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    //Array De busqueda
    ArrayList<InventoryVM> listFound = null;

    public void filterByStringSearch(String _search) {
        //resetendo el array de busqueda
        listFound = null;
        
        if (cbbStock.getSelectedIndex() >= 0) {

            //guardando la busqueda en una array para ser usada en los filtros de cajas
            //y filtrando los items con stock
            if (cbbStock.getSelectedItem().equals("Agotados")) {
                listFound = itemsWithStock(inventoryDao.findBy(_search), 0);
            }else{
                listFound = itemsWithStock(inventoryDao.findBy(_search), 1);
            }
        } else {
            listFound = itemsWithStock(inventoryDao.findBy(_search), 1);
        }
        showInventory("ALL");

        filter = "BROWSER";
    }

    //contadores
    private int countItem = 0;
    private int countStock = 0;
    private int countItemOnLimit = 0;
    private int countTools = 0;
    private int countAccesories = 0;

    InventoryDao inventoryDao = null;
    ArrayList<InventoryVM> inventories = null;
    public void showInventory(String tipo_filtro) {
        //RESETEANDO LOS CONTADORES      
        countItem = 0;
        countStock = 0;
        countItemOnLimit = 0;
        countTools = 0;
        countAccesories = 0;

        //LIMPIANDO LA TABLA
        clearRowsInTable();

        inventoryDao = new InventoryDao();
        inventories = itemsWithStock(inventoryDao.list(), 1);

        if (listFound != null) {
            inventories = listFound;
        }
        
        modelo = (DefaultTableModel) tblInventory.getModel();
        
        if (!inventories.isEmpty()) {
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
                    modelo.addRow(add_rows_to_model(i));
                    //Sumando las existencias
                    countStock += i.getStock();
                    countItem++;
                }
                    tblInventory.setModel(modelo);
                    break;
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
                        modelo.addRow(add_rows_to_model(i));
                        countItem++;
                    }

                }
                    tblInventory.setModel(modelo);
                    break;
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
                        modelo.addRow(add_rows_to_model(i));
                        countItem++;
                    }
                }
                    tblInventory.setModel(modelo);
                    break;
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
                        modelo.addRow(add_rows_to_model(i));
                        countItem++;
                    }
                }
                    tblInventory.setModel(modelo);
                    break;
            }
            default -> {
                    break;
            }
        }
                //ACTUALIZANDO LOS CONTADORES
                updateCardsValues();
        }else{
                //ACTUALIZANDO LOS CONTADORES
                updateCardsValues();          
        }
        
    }

    private Object[] add_rows_to_model(InventoryVM inventory) {
        //AGREGANDO FILA A  lA TABLA
        return new Object[]{
            inventory.getId(),
            inventory.getAmount(),
            inventory.getItem(),
            inventory.getStock(),
            inventory.getMinimunAmount(),
            "$" + inventory.getPricePerUnit(),
            inventory.getCategory(),
            inventory.getType(),
            formato.format(inventory.getBuyDate())
        };
    }
    
    private void updateCardsValues() {
        pnlCard1.updateValue(""+countItem);
        pnlCard2.updateValue(""+countStock);
        pnlCard3.updateValue(""+countItemOnLimit);
        pnlCard4.updateValue(""+ countAccesories);
        pnlCard5.updateValue(""+countTools);
    }

    private ArrayList<InventoryVM> itemsWithStock(ArrayList<InventoryVM> inventories, int type) {

        ArrayList<InventoryVM> inventary = new ArrayList<>();

        if (type == 0) {
            for (var i : inventories) {
                //filtrando por las filas que tienen exitencias 0
                if (i.getStock() == 0) {
                    inventary.add(i);
                }
            }
        } else {
            for (var i : inventories) {
                //filtrando por las filas que tienen exitencias > 0
                if (i.getStock() > 0) {
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
        btnRefresh = new com.trojasviejas.swing.Buttons.ActionButton();

        setBackground(new java.awt.Color(232, 241, 242));

        pnlContainer.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        pnlCard1.setToolTipText("Quita los filtros aplicados");
        pnlCard1.setColor1(new java.awt.Color(0, 40, 85));
        pnlCard1.setColor2(new java.awt.Color(2, 62, 125));
        pnlContainer.add(pnlCard1);

        pnlCard2.setToolTipText("Cantidad total de artículos en el Invertario");
        pnlCard2.setColor1(new java.awt.Color(77, 0, 165));
        pnlCard2.setColor2(new java.awt.Color(83, 0, 204));
        pnlContainer.add(pnlCard2);

        pnlCard3.setToolTipText("Filtra y cuenta cantidad de artículos con existencias ≤ al límite establecido");
        pnlCard3.setColor1(new java.awt.Color(108, 5, 0));
        pnlCard3.setColor2(new java.awt.Color(162, 0, 0));
        pnlContainer.add(pnlCard3);

        pnlCard4.setToolTipText("Filtra y cuenta los articulos que pertenezcan a la categoría de accesorios");
        pnlCard4.setColor1(new java.awt.Color(0, 58, 1));
        pnlCard4.setColor2(new java.awt.Color(0, 71, 2));
        pnlContainer.add(pnlCard4);

        pnlCard5.setToolTipText("Filtra y cuenta los articulos que pertenezcan a la categoría de herramientas");
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
        btnRegister.setToolTipText("Actualizar registro de entrada o salida");
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
        cbbStock.setToolTipText("Filtro que muestra los articulos con existencias o sin existencias");
        cbbStock.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        cbbStock.setLabeText("Elija existencia");
        cbbStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbStockActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRefresh.setToolTipText("Resetea los filtros aplicados y/o los datos de la busqueda realizada");
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
                                .addComponent(lblProviders)
                                .addGap(0, 671, Short.MAX_VALUE))
                            .addGroup(pnlTableLayout.createSequentialGroup()
                                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbStock, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addComponent(lblProviders)
                        .addGap(11, 11, 11)
                        .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        WindowInventory newRegister = new WindowInventory();

        if (tblInventory.getSelectedRowCount() > 0) {
            transferDataToForm(newRegister);
            newRegister.inventoryForm = thisForm;
            WindowInventory.main(newRegister);
        } else {
            message.showMessage("Error", "Para registrar una salida debe seleccionar un artículo previamente");
        }
    }//GEN-LAST:event_btnRegisterActionPerformed
    private void transferDataToForm(WindowInventory newRegister) {

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

    private String filter = "EXISTENCIAS";

    public void reloadChoosedFilter() {
        switch (filter) {
            case "BROWSER" -> {
                filterByStringSearch(getStringSearch());
                showInventory("ALL");
            }
            case "AGOTADOS" -> {
                listFound = itemsWithStock(new InventoryDao().list(), 0);
                showInventory("ALL");
            }
            case "EXISTENCIAS" -> {
                listFound = itemsWithStock(new InventoryDao().list(), 1);
                showInventory("ALL");
            }
            default -> {
                showInventory("ALL");
            }
        }
    }
    DefaultTableModel modelo = null;
    int filas[] = null;
    int index ;
    private void clearRowsInTable() {
        try {
            modelo = (DefaultTableModel) tblInventory.getModel();

            tblInventory.selectAll();

            filas = tblInventory.getSelectedRows();
            index = filas.length - 1;
            for (int i = 0; i < filas.length; i++) {
                modelo.removeRow(index);
                index--;
            }
        } catch (Exception e) {

            message.showMessage("Error", "Error al limpiar la tabla.");
        }
    }

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

        listFound = null;
        cbbStock.setSelectedIndex(-1);
        showInventory("ALL");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void cbbStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbStockActionPerformed
        //existencias 
        if (cbbStock.getSelectedIndex() == 0) {
            //colocando el array de las listas de busqueda como nula
            //para que solo se carguen los que tiene existencias
            listFound = itemsWithStock(new InventoryDao().list(), 1);

            //recargando todos los datos
            showInventory("ALL");

            filter = "EXISTENCIAS";
            //agotados   
        } else if (cbbStock.getSelectedIndex() == 1) {

            //colocando en la lista de filtrado los datos de los items agotados
            listFound = itemsWithStock(new InventoryDao().list(), 0);
            showInventory("ALL");

            filter = "AGOTADOS";
        }
    }//GEN-LAST:event_cbbStockActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.Buttons.ActionButton btnRefresh;
    private com.trojasviejas.swing.Buttons.ActionButton btnRegister;
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
