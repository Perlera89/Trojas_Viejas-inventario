package com.trojasviejas.demo.form;

import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.component.login.PanelMessage;
import com.trojasviejas.component.main.FrmPassword;
import com.trojasviejas.component.main.event.IItemEventAction;
import com.trojasviejas.data.dao.ItemDao;
import static com.trojasviejas.demo.form.FrmMain.getStringSearch;
import com.trojasviejas.demo.form.window.*;
import com.trojasviejas.models.utility.*;
import com.trojasviejas.swing.scroll.ScrollBar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.trojasviejas.models.entity.ItemModel;
import com.trojasviejas.models.entity.UserModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

public class FrmItems extends javax.swing.JPanel {

    MessageErrorDialog errorMessage = new MessageErrorDialog(new JFrame());
    private FrmPassword password;
    FrmItems form = this;
    private IItemEventAction f_eventAction;

    public FrmItems() {
        setOpaque(false);
        initComponents();
        initCard();
        initTableData();
        scroll.setBorder(BorderFactory.createEmptyBorder());
    }

    private void initCard() {
        pnlCardCountItems.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/item.png")), "ARTÍCULOS",""+contador_item));
        pnlCardCountCategory1.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/tools.png")), "HERRAMIENTAS",""+contador_tools));
        pnlCardCountCategory2.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/accessories.png")), "ACCESORIOS",""+contador_accesories));

        pnlCardCountItems.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showItems("ALL", f_eventAction);
            }

        });

        pnlCardCountCategory1.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showItems(String.valueOf(CategoryType.HERRAMIENTAS), f_eventAction);

            }

        });
        pnlCardCountCategory2.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showItems(String.valueOf(CategoryType.ACCESORIOS), f_eventAction);
            }

        });
    }

    public void initTableData() {
        //Agregar registro
        IItemEventAction eventAction = new IItemEventAction() {
            @Override
            public void update(ItemModel entity) {
                if (tblItems.getSelectedRowCount() > 0) {
                    int index = tblItems.getSelectedRow(); //saber que fila se ha seleccionado

                    //Pasar datos al formulario de Windows
                    WindowItem formulario = new WindowItem();
                    formulario.frmItem = form;

                    //Se ejecuta solo si hay una fila selecionada una fila
                    formulario.idRegistro = (int) tblItems.getValueAt(index, 0);
                    formulario.txtName.setText(tblItems.getValueAt(index, 1).toString());
                    formulario.txtAmount.setText(tblItems.getValueAt(index, 2).toString());
                    formulario.txtDescription.setText(tblItems.getValueAt(index, 3).toString());
                    formulario.cbbCategory.setSelectedItem(tblItems.getValueAt(index, 4).toString());
                    formulario.cbbItemType.setSelectedItem(tblItems.getValueAt(index, 5).toString());

                    WindowHome.main(WindowType.ITEM, formulario, true);
                    repaint();
                } else {

                    errorMessage.showMessage("ADVERTENCIA", "Para actualizar debe seleccionar un registro.");

                }

            }

            @Override
            public void delete(ItemModel entity) {
                if (tblItems.getSelectedRowCount() > 0) {

                    errorMessage.showMessage("Eliminar " + entity.getName(), "¿Estas seguro de eliminar el articulo " + entity.getName() + "?");

                    if (errorMessage.getMessageType() == MessageErrorDialog.MessageType.OK) {
                                    itemDao.changeStateInItem((int)tblItems.getValueAt(tblItems.getSelectedRow(), 0), 0);
                                    reloadChoosedFilter();
                    } 
                } else {

                    errorMessage.showMessage("ADVERTENCIA", "Para eliminar debe seleccionar un registro.");
                }
            }
        };

        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.white);

        //Cargando datos a la tabla
        f_eventAction = eventAction;
        showItems("ALL", f_eventAction);

        //Agregndo los contadores
        initCard();

    }

    DefaultTableModel modelo = null;
    int filas[] = null;
    int index;
    //Método para limpiar la tabla
    private void clearRowsInTable() {
        try {
            modelo = (DefaultTableModel) tblItems.getModel();

            tblItems.selectAll();

            filas = tblItems.getSelectedRows();
            index = filas.length - 1;
            for (int i = 0; i < filas.length; i++) {
                modelo.removeRow(index);
                index--;
            }
        } catch (Exception e) {
            errorMessage.showMessage("Error", "Error al limpiar la tabla.");
        }
    }

    //METODO BUSAR
    ArrayList<ItemModel> listFound = null;

    public void filterByStringSearch(String search_string) {

        //habilitados
        switch (cbbState.getSelectedIndex()) {
            case 0 -> {
                listFound = itemDao.findItem(search_string,1);
                showItems("ALL", f_eventAction);
                filter = "HABILITADOS";
                //desabilitados
            }
            case 1 -> {
                listFound = itemDao.findItem(search_string, 0);
                showItems("ALL",f_eventAction);
                filter = "DESABILITADOS";
            }
            default -> {
                    listFound = itemDao.findItem(search_string,1);
                    showItems("ALL", f_eventAction);
                    filter = "HABILITADOS";
            }
        }
    }

    private int contador_item = 0;
    private int contador_tools = 0;
    private int contador_accesories = 0;
    
    ItemDao itemDao = new ItemDao();
    ArrayList<ItemModel> items = null;
    public void showItems(String tipo_filtro, IItemEventAction eventAction) {
        //Reseteando los contadores     
        contador_item = 0;
        contador_tools = 0;
        contador_accesories = 0;

        //Limpiando la tabla
        clearRowsInTable();
        items = itemDao.ListItems(1);
        
        if (listFound != null) {
            items = listFound;
        }

        if (!items.isEmpty()) {
            //Mostrar todos los datos
            switch (tipo_filtro) {
                case "ALL" -> {
                    for (var item : items) {
                        if (item.getCategory().equals(CategoryType.HERRAMIENTAS)) {
                            contador_tools++;
                        }
                        if (item.getCategory().equals(CategoryType.ACCESORIOS)) {
                            contador_accesories++;
                        }

                        //Agregando la fila a la tabla y los botones de acciones
                        add_rows_to_table(item, eventAction);
                        contador_item++;
                    }
                }

                //Filtrar filas por categoría de "HERRAMIENTAS"
                case "HERRAMIENTAS" -> {
                    for (var item : items) {
                        if (item.getCategory().equals(CategoryType.HERRAMIENTAS)) {
                            contador_tools++;

                            //Agregando la fila a la tabla y los botones
                            add_rows_to_table(item, eventAction);
                            contador_item++;
                        }
                    }
                }
                //filtrar las filas por la categoria de "ACCESORIOS"
                case "ACCESORIOS" -> {
                    for (var item : items) {
                        if (item.getCategory().equals(CategoryType.ACCESORIOS)) {
                            contador_accesories++;

                            //Agregando la fila a la tabla y los botones de acciones
                            add_rows_to_table(item, eventAction);
                            contador_item++;
                        }
                    }
                }
                default -> {
                }
            }

            initCard();
        } else {
            initCard();
        }

    }

    private void add_rows_to_table(ItemModel item, IItemEventAction eventAction) {
        //Agregando fila a la tabla
        tblItems.addRow(new ItemModel(
                item.getIdItem(),
                item.getName(),
                item.getMinimunAmount(),
                item.getDescription(),
                item.getCategory(),
                item.getType()
        ).toRowTable(eventAction));
    }

    public void reloadChoosedFilter() {
        if (listFound != null) {
            filterByStringSearch(getStringSearch()); //Obtiene el texto de la busqueda realizada
        } else if(cbbState.getSelectedIndex()==0){
            listFound = itemDao.ListItems(1);
            showItems(filter, f_eventAction);
        }else if(cbbState.getSelectedIndex()==1){
            listFound = itemDao.ListItems(0);
            showItems(filter, f_eventAction);
        }else{
            listFound = itemDao.ListItems(1);
            showItems(filter, f_eventAction);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JLayeredPane();
        pnlCardCountItems = new com.trojasviejas.component.main.PanelCard();
        pnlCardCountCategory1 = new com.trojasviejas.component.main.PanelCard();
        pnlCardCountCategory2 = new com.trojasviejas.component.main.PanelCard();
        pnlTable = new com.trojasviejas.swing.panels.PanelBorder();
        lblProviders = new javax.swing.JLabel();
        btnNew = new com.trojasviejas.swing.Buttons.ActionButton();
        scroll = new javax.swing.JScrollPane();
        tblItems = new com.trojasviejas.swing.tables.item.ItemsTable();
        btnRefresh = new com.trojasviejas.swing.Buttons.ActionButton();
        cbbState = new com.trojasviejas.swing.ComboBox();
        btnUpdateState = new com.trojasviejas.swing.Buttons.ActionButton();

        setBackground(new java.awt.Color(232, 241, 242));
        setPreferredSize(new java.awt.Dimension(1000, 664));

        pnlContainer.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        pnlCardCountItems.setToolTipText("Quita los filtros aplicados");
        pnlCardCountItems.setColor1(new java.awt.Color(0, 40, 85));
        pnlCardCountItems.setColor2(new java.awt.Color(2, 62, 125));
        pnlContainer.add(pnlCardCountItems);

        pnlCardCountCategory1.setToolTipText("Filtra y cuenta los articulos que pertenezcan a la categoría de herramientas");
        pnlCardCountCategory1.setColor1(new java.awt.Color(255, 123, 0));
        pnlCardCountCategory1.setColor2(new java.awt.Color(255, 136, 0));
        pnlContainer.add(pnlCardCountCategory1);

        pnlCardCountCategory2.setToolTipText("Filtra y cuenta los articulos que pertenezcan a la categoría de accesorios");
        pnlContainer.add(pnlCardCountCategory2);

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        lblProviders.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblProviders.setForeground(new java.awt.Color(127, 127, 127));
        lblProviders.setText("Articulos");

        btnNew.setBackground(new java.awt.Color(0, 184, 82));
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnNew.setText("Nuevo");
        btnNew.setToolTipText("Nuevo registro de artículo");
        btnNew.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        scroll.setBorder(null);

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Cantidad minima", "Descripcion", "Categoria", "Tipo", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(tblItems);
        if (tblItems.getColumnModel().getColumnCount() > 0) {
            tblItems.getColumnModel().getColumn(0).setMinWidth(0);
            tblItems.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblItems.getColumnModel().getColumn(0).setMaxWidth(0);
            tblItems.getColumnModel().getColumn(3).setMinWidth(0);
            tblItems.getColumnModel().getColumn(3).setPreferredWidth(0);
            tblItems.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRefresh.setToolTipText("Resetea los filtros aplicados y/o los datos de la busqueda realizada");
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRefreshMousePressed(evt);
            }
        });

        cbbState.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Habilitados", "Desabilitados" }));
        cbbState.setSelectedIndex(-1);
        cbbState.setToolTipText("Filtro que muestra los articulos habilitados y desabilitados");
        cbbState.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        cbbState.setLabeText("Elija estado del artículo");
        cbbState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbStateActionPerformed(evt);
            }
        });

        btnUpdateState.setBackground(new java.awt.Color(0, 102, 102));
        btnUpdateState.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateState.setText("Actualizar estado");
        btnUpdateState.setToolTipText("Actualizar estado del artículo");
        btnUpdateState.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnUpdateState.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnUpdateState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProviders)
                            .addGroup(pnlTableLayout.createSequentialGroup()
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUpdateState, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(cbbState, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addGap(19, 19, 19)
                        .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdateState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbbState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        WindowItem item = new WindowItem();
        item.frmItem = form;
        WindowHome.main(WindowType.ITEM, item, false);

    }//GEN-LAST:event_btnNewActionPerformed

    private void btnRefreshMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMousePressed
        listFound = null;
        showItems("ALL", f_eventAction);
    }//GEN-LAST:event_btnRefreshMousePressed

    String filter = "ALL";
    private void cbbStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbStateActionPerformed
        //habilitados
        if (cbbState.getSelectedIndex() == 0) {
            //colocando el array de las listas de busqueda como nula
            //para que solo se carguen los que estan desabilitados
            listFound = itemDao.ListItems(1);

            //recargando todos los datos
            showItems("ALL", f_eventAction);

            filter = "HABILITADOS";
            btnUpdateState.setVisible(false);
            //desabilitados
        } else if (cbbState.getSelectedIndex() == 1) {

            //colocando en la lista de filtrado los datos de los items desabilitados
            listFound = itemDao.ListItems(0);
            showItems("ALL",f_eventAction);

            filter = "DESABILITADOS";
            btnUpdateState.setVisible(true);
        }
    }//GEN-LAST:event_cbbStateActionPerformed

    private void btnUpdateStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStateActionPerformed
            if (tblItems.getSelectedRowCount() > 0) {
             itemDao.changeStateInItem((int)tblItems.getValueAt(tblItems.getSelectedRow(), 0),1);
             listFound = itemDao.ListItems(0);
                showItems("ALL", f_eventAction);
        }else{
                errorMessage.showMessage("ERROR","Para actualizar el estado debe elegir el artículo previamente.");
            }
    }//GEN-LAST:event_btnUpdateStateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.Buttons.ActionButton btnNew;
    private com.trojasviejas.swing.Buttons.ActionButton btnRefresh;
    private com.trojasviejas.swing.Buttons.ActionButton btnUpdateState;
    private com.trojasviejas.swing.ComboBox cbbState;
    private javax.swing.JLabel lblProviders;
    private com.trojasviejas.component.main.PanelCard pnlCardCountCategory1;
    private com.trojasviejas.component.main.PanelCard pnlCardCountCategory2;
    private com.trojasviejas.component.main.PanelCard pnlCardCountItems;
    private javax.swing.JLayeredPane pnlContainer;
    private com.trojasviejas.swing.panels.PanelBorder pnlTable;
    private javax.swing.JScrollPane scroll;
    private com.trojasviejas.swing.tables.item.ItemsTable tblItems;
    // End of variables declaration//GEN-END:variables
}
