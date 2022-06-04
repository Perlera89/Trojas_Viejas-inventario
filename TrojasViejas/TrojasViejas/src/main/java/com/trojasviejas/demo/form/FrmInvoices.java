package com.trojasviejas.demo.form;

import com.trojasviejas.component.login.MessageDialog;
import com.trojasviejas.component.main.event.IInvoicesEventAction;
import com.trojasviejas.demo.form.window.*;
import com.trojasviejas.models.entity.*;
import com.trojasviejas.models.utility.*;
import com.trojasviejas.swing.scroll.ScrollBar;
import javax.swing.*;
import java.awt.*;
import com.trojasviejas.component.main.event.IProviderEventAction;
import com.trojasviejas.data.dao.InvoicesDao;
import com.trojasviejas.data.dao.ProviderDao;
import com.trojasviejas.models.viewmodel.InvoicesVM;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class FrmInvoices extends javax.swing.JPanel {

    public FrmInvoices() {
        setOpaque(false);
        initComponents();
        initCard();
        initTableData();
    }

    private void initCard() {
        pnlCardInvoices.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/seller.png")), "Facturas", contador_factura + ""));
        pnlCardItems.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/donor.png")), "Total Arcticulos", "1"));
        pnlCardTotal.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/donor.png")), "Total", "$" + contador_total));

    }

    public static Date getDateFormat(String date) {
//        SimpleDateFormat formatter = new SimpleDateFormat(formatPattern);
//        return formatter.parse(date);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaConvertida = null;

        try {
            Date parsed = dateFormat.parse(date);
            fechaConvertida = new Date(parsed.getTime());
        } catch (Exception e) {
            System.out.println("Error occurred" + e.getMessage());
        }
        return fechaConvertida;
    }

    FrmInvoices form = this;
    private IInvoicesEventAction f_eventAction;

    public void initTableData() {
        //Agregar registro

        IInvoicesEventAction eventAction = new IInvoicesEventAction() {
            int IndexRow;

            @Override
            public void update(InvoicesVM entity) {
                InvoicesDao invD = new InvoicesDao();
                String provName;
                WindowInvoice formulario = new WindowInvoice();
                formulario.frmInvoice = form;

                if (tblInvoices.getSelectedRowCount() > 0) {
                    IndexRow = tblInvoices.getSelectedRow();

                    formulario.id = (int) tblInvoices.getValueAt(IndexRow, 0);
                    formulario.cbbProvider.setSelectedItem((tblInvoices.getValueAt(IndexRow, 1)).toString());
                    formulario.txtTotal.setText(tblInvoices.getValueAt(IndexRow, 2).toString());
                    //Pasando fecha al JDateChooser
                    //String fecha = (tblInvoices.getValueAt(IndexRow, 3)).toString();
                    formulario.txtDate.setDate(getDateFormat(tblInvoices.getValueAt(IndexRow, 3).toString()));

//                    formulario.txtDate.setDate(fechaParse);
                    //formulario.rutaByte[0] = entity.getPicture();
//                formulario.id = (int) selectedtRow.get(0);
//                formulario.txtName.setText(selectedtRow.get(1).toString());
//                formulario.txtPhone.setText(selectedtRow.get(2).toString());
//                formulario.txtEmail.setText(selectedtRow.get(3).toString());
//                formulario.txtAddress.setText(selectedtRow.get(3).toString());                
//                formulario.cbbType.setSelectedItem(selectedtRow.get(5).toString());
                    WindowHome.main(WindowType.INVOICE, formulario, false);
                    repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "Para actualizar un registro debe seleccionar uno previamente", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }

            }

            @Override
            public void delete(InvoicesVM entity) {
                if (tblInvoices.getSelectedRowCount() > 0) {
                    MessageDialog dialogResult = new MessageDialog(new FrmLogin());
                    dialogResult.showMessage(null, "¿Estas seguro de eliminar el proveedor?");

                    if (dialogResult.getMessageType() == MessageDialog.MessageType.OK) {

                        InvoicesDao invD = new InvoicesDao();
//                    ArrayList<Object> selectedtRow = new ArrayList<>();
//                    selectedtRow.addAll(Arrays.asList(entity.toRowTable(this)));

                        int IndexRow = tblInvoices.getSelectedRow();
                        invD.DeleteInvoice(Integer.parseInt(tblInvoices.getValueAt(IndexRow, 0).toString()));
                        clearRowsInTable();
                        initTableData();
                    } else {
                        repaint();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Para eliminar un registro debe seleccionar uno previamente", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            @Override
            public void view(InvoicesVM entity) {
                System.out.println("Ver a " + entity.getId());
            }
            
        };

        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.white);
        Date date = new Date();

        //tblInvoices.addRow(new InvoicesModel(1, 20.5, new SimpleDateFormat("dd-MM-yyyy").format(date), 1).toRowTable(eventAction));
        //Cargando datos a la tabla
        f_eventAction = eventAction;
        showInvoices("ALL", f_eventAction);

        //Agregndo los contadores
        initCard();

        //Ocultando columnas de la tabla tblInvoices
        tblInvoices.getColumnModel().getColumn(0).setMaxWidth(0);
        tblInvoices.getColumnModel().getColumn(0).setMinWidth(0);
        tblInvoices.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblInvoices.getColumnModel().getColumn(0).setResizable(false);
    }

    //Método para limpiar la tabla
    private void clearRowsInTable() {
//        try {
//            DefaultTableModel modelo = (DefaultTableModel) tblInvoices.getModel();
//            int filas = tblInvoices.getRowCount();
//            for (int i = 0; filas > i; i++) {
//                modelo.removeRow(0);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
//        }
        try {
            tblInvoices.selectAll();
            DefaultTableModel modelo = (DefaultTableModel) tblInvoices.getModel();
            int rowsSelected[] = tblInvoices.getSelectedRows();
            int indexRow = rowsSelected.length - 1;
            for (int i = 0; i < rowsSelected.length; i++) {
                modelo.removeRow(indexRow);
                indexRow--;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }

    }

    ArrayList<InvoicesVM> listFound = null;

    public void filterByStringSearch(String busqueda) {
        listFound = null;
        InvoicesDao invDao = new InvoicesDao();

        String[] Separador = busqueda.split("_");

        try {

            String month = Separador[0];
            int year = Integer.parseInt(Separador[1]);
            if (!month.isEmpty() && !month.isBlank()) {
                listFound = invDao.ListInvoices(month, year);
                showInvoices("ALL", f_eventAction);
            } else {
                listFound = invDao.ListInvoices("NULL", year);
                showInvoices("ALL", f_eventAction);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Formato de busqueda no valido" + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int contador_factura = 0;
    //private int  = 0;
    private double contador_total = 0;

    public void showInvoices(String tipo_filtro, IInvoicesEventAction eventAction) {
        //Reseteando los contadores     
        contador_factura = 0;
//        contador_tools = 0;
        contador_total = 0;

        //Limpiando la tabla
        clearRowsInTable();

        InvoicesDao invD = new InvoicesDao();
        ArrayList<InvoicesVM> invoices = invD.ListInvoices();

        if (listFound != null) {
            invoices = listFound;
        }

        //Mostrar todos los datos
        switch (tipo_filtro) {
            case "ALL" -> {
                for (var i : invoices) {
                    add_rows_to_table(i, eventAction);
                    contador_factura++;

                    contador_total += i.getTotalAmount();
                }
                initCard();
            }
        }
    }
    //Actualizando los contadores

    private void add_rows_to_table(InvoicesVM invM, IInvoicesEventAction eventAction) {

        //Date fech = new Date(formatter.format(invM.getBuyDate()));
        tblInvoices.addRow(new InvoicesVM(
                invM.getId(),
                invM.getTotalAmount(),
                invM.getBuyDate(),
                //invM.getPicture(),
                invM.getPicture(),
                invM.getName()
        //name
        ).toRowTable(eventAction));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JLayeredPane();
        pnlCardInvoices = new com.trojasviejas.component.main.PanelCard();
        pnlCardItems = new com.trojasviejas.component.main.PanelCard();
        pnlCardTotal = new com.trojasviejas.component.main.PanelCard();
        pnlTable = new com.trojasviejas.swing.panels.PanelBorder();
        lblProviders = new javax.swing.JLabel();
        btnNew = new com.trojasviejas.swing.Buttons.ActionButton();
        scroll = new javax.swing.JScrollPane();
        tblInvoices = new com.trojasviejas.swing.tables.invoice.InvoicesTable();
        btnRefresh = new com.trojasviejas.swing.Buttons.ActionButton();

        setBackground(new java.awt.Color(232, 241, 242));

        pnlContainer.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        pnlCardInvoices.setColor1(new java.awt.Color(0, 40, 85));
        pnlCardInvoices.setColor2(new java.awt.Color(2, 62, 125));
        pnlContainer.add(pnlCardInvoices);

        pnlCardItems.setColor1(new java.awt.Color(255, 123, 0));
        pnlCardItems.setColor2(new java.awt.Color(255, 136, 0));
        pnlContainer.add(pnlCardItems);

        pnlCardTotal.setColor1(new java.awt.Color(0, 40, 85));
        pnlCardTotal.setColor2(new java.awt.Color(2, 62, 125));
        pnlContainer.add(pnlCardTotal);

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        lblProviders.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblProviders.setForeground(new java.awt.Color(127, 127, 127));
        lblProviders.setText("Facturas");

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

        tblInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Proveedor", "Total", "Fecha de compra", "Picture", "Acciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Byte.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(tblInvoices);
        if (tblInvoices.getColumnModel().getColumnCount() > 0) {
            tblInvoices.getColumnModel().getColumn(4).setMinWidth(0);
            tblInvoices.getColumnModel().getColumn(4).setPreferredWidth(0);
            tblInvoices.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
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
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addComponent(lblProviders)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblProviders)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTableLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE))
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

        WindowInvoice invoice = new WindowInvoice();
        invoice.frmInvoice = form;

        WindowHome.main(WindowType.INVOICE, invoice, false);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnRefreshMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMousePressed
        initTableData();
    }//GEN-LAST:event_btnRefreshMousePressed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        listFound = null;
        showInvoices("ALL", f_eventAction);
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.Buttons.ActionButton btnNew;
    private com.trojasviejas.swing.Buttons.ActionButton btnRefresh;
    private javax.swing.JLabel lblProviders;
    private com.trojasviejas.component.main.PanelCard pnlCardInvoices;
    private com.trojasviejas.component.main.PanelCard pnlCardItems;
    private com.trojasviejas.component.main.PanelCard pnlCardTotal;
    private javax.swing.JLayeredPane pnlContainer;
    private com.trojasviejas.swing.panels.PanelBorder pnlTable;
    private javax.swing.JScrollPane scroll;
    private com.trojasviejas.swing.tables.invoice.InvoicesTable tblInvoices;
    // End of variables declaration//GEN-END:variables
}
