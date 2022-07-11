package com.trojasviejas.demo.form;

import com.trojasviejas.component.login.MessageSuccessDialog;
import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.demo.form.window.*;
import com.trojasviejas.models.entity.ProviderModel;
import com.trojasviejas.models.utility.*;
import com.trojasviejas.swing.scroll.ScrollBar;
import javax.swing.*;
import java.awt.*;
import com.trojasviejas.component.main.event.IProviderEventAction;
import com.trojasviejas.data.dao.ProviderDao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FrmProviders extends javax.swing.JPanel {

    public FrmProviders() {
        setOpaque(false);
        initComponents();
        initCard();
        initTableData();
        scroll.setBorder(BorderFactory.createEmptyBorder());
    }
    //mensajes personalizados
    MessageErrorDialog errotDialogResult = new MessageErrorDialog(new FrmLogin());
    MessageSuccessDialog successDialogResult = new MessageSuccessDialog(new FrmLogin());

    private void initCard() {
        pnlCardProvider.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/provider.png")), "PROVEEDORES", contador_provider + ""));
        pnlCardComercial.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/seller.png")), "COMERCIALES", contador_commercial + ""));
        pnlCardDonor.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/donor.png")), "DONADORES", contador_donor + ""));
        

        pnlCardComercial.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showProviders(String.valueOf(ProviderType.COMERCIAL), f_eventAction);
            }

        });

        pnlCardDonor.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showProviders(String.valueOf(ProviderType.DONANTE), f_eventAction);
            }

        });
        pnlCardProvider.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showProviders("ALL", f_eventAction);
            }

        });
    }

    FrmProviders form = this;
    private IProviderEventAction f_eventAction;

    public void initTableData() {
        //Agregar registro

        IProviderEventAction eventAction = new IProviderEventAction() {
            int IndexRow;

            @Override
            public void update(ProviderModel entity) {            
                    if (tblProviders.getSelectedRowCount() > 0) {
                    IndexRow = tblProviders.getSelectedRow();

                    //Pasar datos al formulario de Windows
                    WindowProvider formulario = new WindowProvider();
                    formulario.frmProvider = form;

                    formulario.id = (int)tblProviders.getValueAt(IndexRow, 0);
                    formulario.txtName.setText(tblProviders.getValueAt(IndexRow, 1).toString());
                    formulario.txtPhone.setText(tblProviders.getValueAt(IndexRow, 2).toString());
                    formulario.txtEmail.setText(tblProviders.getValueAt(IndexRow, 3).toString());
                    formulario.txtAddress.setText(tblProviders.getValueAt(IndexRow, 4).toString());
                    formulario.cbbType.setSelectedItem(tblProviders.getValueAt(IndexRow, 5).toString());

                    WindowHome.main(WindowType.PROVIDER, formulario, true);
                    repaint();
                } else {
                    errotDialogResult.showMessage("Advertencia", "Para actualizar un registro debe seleccionar uno previamente");
                }
            }

            @Override
            public void delete(ProviderModel entity) {
                if (tblProviders.getSelectedRowCount() > 0) {
                    // MessageErrorDialog dialogResult = new MessageErrorDialog(new FrmLogin());
                    errotDialogResult.showMessage("Eliminar " + entity.getName(), "¿Estas seguro de eliminar el proveedor " + entity.getName() + "?");

                    if (errotDialogResult.getMessageType() == MessageErrorDialog.MessageType.OK) {
                        IndexRow = tblProviders.getSelectedRow();
                        prvD.DeleteProvider((int)tblProviders.getValueAt(IndexRow, 0));
                        clearRowsInTable();
                        initTableData();
                    } else {
                        repaint();
                    }
                } else {
                    errotDialogResult.showMessage("ADVERTENCIA", "Para eliminar un registro debe seleccionar uno previamente");
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
        showProviders("ALL", f_eventAction);

        //Agregndo los contadores
        initCard();

        //Ocultando columnas de la tabla tblItems
        tblProviders.getColumnModel().getColumn(0).setMaxWidth(0);
        tblProviders.getColumnModel().getColumn(0).setMinWidth(0);
        tblProviders.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblProviders.getColumnModel().getColumn(0).setResizable(false);

    }

    ArrayList<ProviderModel> listFound = null;
    
    public void filterByStringSearch(String busqueda){
        
        listFound = prvD.ListProviders(busqueda);
        showProviders("ALL", f_eventAction);
    }
    
    int contador_commercial = 0;
    int contador_donor = 0;
    int contador_provider = 0;
        
    ProviderDao prvD = new ProviderDao();
    ArrayList<ProviderModel> providers = null;
    public void showProviders(String tipo_filtro, IProviderEventAction eventAction) {
        //Reseteando los contadores     
        contador_commercial = 0;
        contador_donor = 0;
        contador_provider = 0;

        //Limpiando la tabla
        clearRowsInTable();
         providers = prvD.ListProviders();
        
        if(listFound != null){
            providers = listFound;
        }
        
        modelo = (DefaultTableModel) tblProviders.getModel();

        if (!providers.isEmpty()) {
            //Mostrar todos los datos
            switch (tipo_filtro) {
                case "ALL" -> {
                    for (var i : providers) {
                        if (i.getType().equals(ProviderType.COMERCIAL)) {
                            contador_commercial++;
                        }
                        if (i.getType().equals(ProviderType.DONANTE)) {
                            contador_donor++;
                        }

                        //Agregando la fila a la tabla y los botones de acciones
                        modelo.addRow(add_rows_to_model(i, eventAction));
                        contador_provider++;
                    }
                        tblProviders.setModel(modelo);
                        break;
                }

                //filtrar las filas por la categoria de "COMERCIAL"
                case "COMERCIAL" -> {
                    for (var i : providers) {
                        if (i.getType().equals(ProviderType.COMERCIAL)) {
                            contador_commercial++;

                            //Agregando la fila a la tabla y los botones de acciones
                            modelo.addRow(add_rows_to_model(i, eventAction));
                            contador_provider++;
                        }
                    }
                        tblProviders.setModel(modelo);
                        break;
                }
                //Filtrar filas por tipo de "DONANTE"
                case "DONANTE" -> {
                    for (var i : providers) {
                        if (i.getType().equals(ProviderType.DONANTE)) {
                            contador_donor++;

                            //Agregando la fila a la tabla y los botones
                            modelo.addRow(add_rows_to_model(i, eventAction));
                            contador_provider++;
                        }
                    }
                        tblProviders.setModel(modelo);
                        break;
                }
                default -> {
                        break;
                }
                
            }
             updateCardsValues();
        }else{
             updateCardsValues();
        }

    }

    ProviderModel prv = null;
    private Object[] add_rows_to_model(ProviderModel prvM, IProviderEventAction eventAction) {
        //Agregando fila a la tabla
        prv = new ProviderModel(
                prvM.getId(),
                prvM.getName(),
                prvM.getNumberPhone(),
                prvM.getEmail(),
                prvM.getAddress(),
                prvM.getType());
        
                return prv.toRowTable(eventAction);
    }
    private void updateCardsValues() {
        pnlCardProvider.updateValue(""+contador_provider);
        pnlCardComercial.updateValue(""+ contador_commercial);
        pnlCardDonor.updateValue(""+contador_donor);
    }
    DefaultTableModel modelo = null;
    int rowsSelected[] = null;
    private void clearRowsInTable() {
            int indexRow;
        try {
            tblProviders.selectAll();
            modelo = (DefaultTableModel) tblProviders.getModel();
            rowsSelected = tblProviders.getSelectedRows();
            indexRow = rowsSelected.length - 1;
            for (int i = 0; i < rowsSelected.length; i++) {
                modelo.removeRow(indexRow);
                indexRow--;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JLayeredPane();
        pnlCardProvider = new com.trojasviejas.component.main.PanelCard();
        pnlCardComercial = new com.trojasviejas.component.main.PanelCard();
        pnlCardDonor = new com.trojasviejas.component.main.PanelCard();
        pnlTable = new com.trojasviejas.swing.panels.PanelBorder();
        lblProviders = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        tblProviders = new com.trojasviejas.swing.tables.ProvidersTable();
        btnNew = new com.trojasviejas.swing.Buttons.ActionButton();
        btnRefresh = new com.trojasviejas.swing.Buttons.ActionButton();

        setBackground(new java.awt.Color(232, 241, 242));

        pnlContainer.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        pnlCardProvider.setToolTipText("Quita los filtros aplicados");
        pnlCardProvider.setColor1(new java.awt.Color(0, 40, 85));
        pnlCardProvider.setColor2(new java.awt.Color(2, 62, 125));
        pnlContainer.add(pnlCardProvider);

        pnlCardComercial.setToolTipText("Filtra y cuenta los proveedores que pertenezcan a la categoría de comercial");
        pnlCardComercial.setColor1(new java.awt.Color(170, 0, 18));
        pnlCardComercial.setColor2(new java.awt.Color(191, 0, 0));
        pnlContainer.add(pnlCardComercial);

        pnlCardDonor.setToolTipText("Filtra y cuenta los proveedores que pertenezcan a la categoría de donadores");
        pnlCardDonor.setColor1(new java.awt.Color(0, 105, 104));
        pnlCardDonor.setColor2(new java.awt.Color(0, 120, 113));
        pnlContainer.add(pnlCardDonor);

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        lblProviders.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblProviders.setForeground(new java.awt.Color(127, 127, 127));
        lblProviders.setText("Proveedores");

        scroll.setBorder(null);

        tblProviders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Telefono", "Email", "Direccion", "Tipo", "Acciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProviders.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        scroll.setViewportView(tblProviders);

        btnNew.setBackground(new java.awt.Color(0, 184, 82));
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnNew.setText("Nuevo");
        btnNew.setToolTipText("Nuevo registro de proveedor");
        btnNew.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRefresh.setToolTipText("Resetea los filtros aplicados y/o los datos de la busqueda realizada");
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRefreshMousePressed(evt);
            }
        });
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProviders))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblProviders)
                        .addGap(20, 20, 20)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
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
        WindowProvider provider = new WindowProvider();
        provider.frmProvider = form;
        WindowHome.main(WindowType.PROVIDER, provider, false);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnRefreshMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMousePressed
        initTableData();
    }//GEN-LAST:event_btnRefreshMousePressed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        listFound = null;
        showProviders("ALL", f_eventAction);
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.Buttons.ActionButton btnNew;
    private com.trojasviejas.swing.Buttons.ActionButton btnRefresh;
    private javax.swing.JLabel lblProviders;
    private com.trojasviejas.component.main.PanelCard pnlCardComercial;
    private com.trojasviejas.component.main.PanelCard pnlCardDonor;
    private com.trojasviejas.component.main.PanelCard pnlCardProvider;
    private javax.swing.JLayeredPane pnlContainer;
    private com.trojasviejas.swing.panels.PanelBorder pnlTable;
    private javax.swing.JScrollPane scroll;
    private com.trojasviejas.swing.tables.ProvidersTable tblProviders;
    // End of variables declaration//GEN-END:variables
}
