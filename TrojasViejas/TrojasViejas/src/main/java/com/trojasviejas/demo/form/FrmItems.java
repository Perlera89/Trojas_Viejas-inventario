package com.trojasviejas.demo.form;

import com.trojasviejas.component.login.MessageDialog;
import com.trojasviejas.component.main.event.IItemEventAction;
import com.trojasviejas.data.dao.ItemDao;

import com.trojasviejas.demo.form.window.*;
import com.trojasviejas.models.utility.*;
import com.trojasviejas.swing.scroll.ScrollBar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.trojasviejas.models.entity.ItemModel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

public class FrmItems extends javax.swing.JPanel {

    public FrmItems() {
        setOpaque(false);
        init();
    }
    
    public void init(){
        initComponents();
        initCard(0);
        initTableData();
    }

    private void initCard(int contadorItem) {
        pnlCardCountItems.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/stock.png")), "Total Artículos", String.valueOf(contadorItem)));
        pnlCardCountCategory1.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/tools.png")), "Total Herramientas", "21"));
        pnlCardCountCategory2.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/accessories.png")), "Total Accesorios", "18"));
        
        pnlCardCountCategory1.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Filtrando contador herramientas");
            }
            
        });
        
        pnlCardCountCategory2.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Filtrando contador herramientas");
            }
            
        });
    }

    FrmItems form = this;

    public void initTableData() {
        //Agregar registro
        IItemEventAction eventAction = new IItemEventAction() {
            @Override
            public void update(ItemModel entity) {

                ArrayList<Object> selectedtRow = new ArrayList<>();
                selectedtRow.addAll(Arrays.asList(entity.toRowTable(this)));

                //Pasar datos al formulario de Windows
                WindowItem formulario = new WindowItem();
                formulario.frmItem = form;

                formulario.idRegistro = (int) selectedtRow.get(0);
                formulario.txtName.setText(selectedtRow.get(1).toString());
                formulario.txtAmount.setText(selectedtRow.get(2).toString());
                formulario.txtDescription.setText(selectedtRow.get(3).toString());
                formulario.cbbCategory.setSelectedItem(selectedtRow.get(4).toString());
                formulario.cbbItemType.setSelectedItem(selectedtRow.get(5).toString());

                WindowHome.main(WindowType.ITEM, formulario, true);

                repaint();
            }

            @Override
            public void delete(ItemModel entity) {
                MessageDialog dialogResult = new MessageDialog(new FrmLogin());
                dialogResult.showMessage("Eliminar " + entity.getName(), "¿Estas seguro de eliminar el articulo " + entity.getName() + "?");

                if (dialogResult.getMessageType() == MessageDialog.MessageType.OK) {
                    ItemDao item = new ItemDao();
                    ArrayList<Object> selectedtRow = new ArrayList<>();
                    selectedtRow.addAll(Arrays.asList(entity.toRowTable(this)));
                    item.DeleteItem(Integer.parseInt(selectedtRow.get(0).toString()));
                    initTableData();
                } else {
                    repaint();
                }
            }
        };

        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.white);

        //LIMPIAR TABLA
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblItems.getModel();
            int filas = tblItems.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }

        ItemDao items = new ItemDao();
        int contadorItem = 0;

        for (var item : items.ListItems()) {
            tblItems.addRow(new ItemModel(
                    item.getIdItem(),
                    item.getName(),
                    item.getMinimunAmount(),
                    item.getDescription(),
                    item.getCategory(),
                    item.getType()
            ).toRowTable(eventAction));
            contadorItem++;
        }
        for (var i : items.ListItems()) {
            System.out.println(i.getCategory().toString() + i.getType().toString());
        }

        initCard(contadorItem);

        //Ocultar Columnas
        tblItems.getColumnModel().getColumn(0).setMaxWidth(0);
        tblItems.getColumnModel().getColumn(0).setMinWidth(0);
        tblItems.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblItems.getColumnModel().getColumn(0).setResizable(false);

        tblItems.getColumnModel().getColumn(3).setMaxWidth(0);
        tblItems.getColumnModel().getColumn(3).setMinWidth(0);
        tblItems.getColumnModel().getColumn(3).setPreferredWidth(0);
        tblItems.getColumnModel().getColumn(3).setResizable(false);

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

        setBackground(new java.awt.Color(232, 241, 242));

        pnlContainer.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        pnlCardCountItems.setColor1(new java.awt.Color(0, 40, 85));
        pnlCardCountItems.setColor2(new java.awt.Color(2, 62, 125));
        pnlContainer.add(pnlCardCountItems);

        pnlCardCountCategory1.setColor1(new java.awt.Color(255, 123, 0));
        pnlCardCountCategory1.setColor2(new java.awt.Color(255, 136, 0));
        pnlContainer.add(pnlCardCountCategory1);
        pnlContainer.add(pnlCardCountCategory2);

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        lblProviders.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblProviders.setForeground(new java.awt.Color(127, 127, 127));
        lblProviders.setText("Articulos");

        btnNew.setBackground(new java.awt.Color(0, 184, 82));
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnNew.setText("Nuevo");
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

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRefreshMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addComponent(lblProviders)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblProviders)
                .addGap(20, 20, 20)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        WindowItem item = new WindowItem();
        WindowHome.main(WindowType.ITEM, item, false);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnRefreshMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMousePressed
        initTableData();
    }//GEN-LAST:event_btnRefreshMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.Buttons.ActionButton btnNew;
    private com.trojasviejas.swing.Buttons.ActionButton btnRefresh;
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
