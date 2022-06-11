package com.trojasviejas.demo.form;

import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.component.login.MessageSuccessDialog;
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
import com.trojasviejas.swing.tables.invoice.InvoiceAction;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.awt.Graphics;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class FrmInvoices extends javax.swing.JPanel {

    public FrmInvoices() {
        setOpaque(false);
        initComponents();
        initCard();
        initTableData();
        scroll.setBorder(BorderFactory.createEmptyBorder());
    }

    private void initCard() {
        pnlCardInvoices.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/seller.png")), "Facturas", amoutPurshases + ""));
        pnlCardItems.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/donor.png")), "Total Arcticulos", amount_items + ""));
        pnlCardTotal.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/donor.png")), "Total", "$" + sumTotals));

    }
    //mensajes personalizados
    MessageErrorDialog errorDialogResult = new MessageErrorDialog(new FrmLogin());
    MessageSuccessDialog successDialogResult = new MessageSuccessDialog(new FrmLogin());
    
    public static Date getDateFormat(String date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateWithFormat = null;

        try {
            Date parsed = dateFormat.parse(date);
            dateWithFormat = new Date(parsed.getTime());
        } catch (Exception e) {
            System.out.println("Error occurred" + e.getMessage());
        }
        return dateWithFormat;
    }

    FrmInvoices form = this;
    private IInvoicesEventAction f_eventAction;

    public void initTableData() {
        //Agregar registro

        IInvoicesEventAction eventAction = new IInvoicesEventAction() {
            int IndexRow;

            @Override
            public void delete(InvoicesVM entity) {
                if (tblInvoices.getSelectedRowCount() > 0) {
                    MessageErrorDialog dialogResult = new MessageErrorDialog(new FrmLogin());
                    dialogResult.showMessage("ADVERTENCIA", 
                            "Ésta es una acción grave: cada factura tiene configurado un borrado en cascada,"
                           + " por consecuencia, se borrarán todos los detalles de la factura, todos los registros"
                           + " de los artículos en el inventario y todas la entradas/salidas relacionadas. Esta acción no es"
                           + " reversible. ¿Realmente desea eliminar esta factura?");

                    if (dialogResult.getMessageType() == MessageErrorDialog.MessageType.OK) {

                        InvoicesDao invD = new InvoicesDao();
                        IndexRow = tblInvoices.getSelectedRow();
                        invD.DeleteInvoice(Integer.parseInt(tblInvoices.getValueAt(IndexRow, 0).toString()));
                        clearRowsInTable();
                        initTableData();
                    } else {
                        repaint();
                    }
                } else {
                    errorDialogResult.showMessage("Advertencia","Para eliminar un registro debe seleccionar uno previamente");
                }
            }

            //ver detalles de facturas
            @Override
            public void view(InvoicesVM entity) {
                int indexRow;
                if (tblInvoices.getSelectedRowCount() > 0) {
                    //obtenemos el id de la fila seleccionada
                    indexRow = tblInvoices.getSelectedRow();

                    FrmDetails detailsForm = new FrmDetails(entity.getId());
                    //detailsForm.idInvoice = (int)tblInvoices.getValueAt(indexRow, 0);
                    detailsForm.lblProvider.setText(tblInvoices.getValueAt(indexRow, 1).toString());
                    detailsForm.lblPrice.setText(tblInvoices.getValueAt(indexRow, 2).toString());
                    detailsForm.lblBuyDate.setText(tblInvoices.getValueAt(indexRow, 5).toString());
                    System.out.println((int)tblInvoices.getValueAt(indexRow, 0));
                    
                    detailsForm.formInvoices = form;
                    detailsForm.setVisible(true);
                } else {
                    errorDialogResult.showMessage("ERROR", "Seleccione previamente una factura para ver sus detalles.");
                }

            }
            //
            @Override
            public void image(InvoicesVM entity) {
                int indexRow;
                if (tblInvoices.getSelectedRowCount() > 0) {
                        //obtenemos el id de la fila seleccionada
                        indexRow = tblInvoices.getSelectedRow();
                        
                    //comprobando que la factura tenga foto (no hay: donante, hay: comercial)
                    if (tblInvoices.getValueAt(indexRow, 6) != null) {
                        byte[] img = (byte[]) tblInvoices.getValueAt(indexRow, 6);
                        //conviertiendo los bytes en imagen, y la imagen en IconImagen
                        ImageIcon image = new ImageIcon(byteToImage(img));
                        FrmImage frmImage = new FrmImage();
                        //ImageIcon mIcono = new ImageIcon(img.getScaledInstance(frm.getWidth(), lblImagen.getHeight(), 0));

                        frmImage.lblPurchaseImage.setIcon(image);
                        frmImage.setVisible(true);                       
                    }else{
                        errorDialogResult.showMessage("ERROR", "Las facturas con un proveedor tipo DONANTE no tienen foto.");                       
                    }
                    
                } else {
                    errorDialogResult.showMessage("ERROR", "Seleccione previamente una factura para ver su foto.");
                }                
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

    private Image byteToImage(byte[] image){
        Image img=new ImageIcon(image).getImage();
        return img;
    }
    //Método para limpiar la tabla
    private void clearRowsInTable() {
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
            errorDialogResult.showMessage("Error","Formato de busqueda no valido" + ex.toString());
        }
    }

    int amoutPurshases = 0;
    int amount_items = 0;
    double sumTotals = 0;

    public void showInvoices(String tipo_filtro, IInvoicesEventAction eventAction) {
        //Reseteando los contadores     
        amoutPurshases = 0;
        amount_items = 0;
        sumTotals = 0;

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
                    amoutPurshases++;
                    amount_items += i.getAmountItems();
                    sumTotals += i.getTotalAmount();
                }
                //paintInvoicesWithZeroStock();
                initCard();
            }
        }
    }
    //Actualizando los contadores

    private void add_rows_to_table(InvoicesVM invM, IInvoicesEventAction eventAction) {

        tblInvoices.addRow(new InvoicesVM(
                invM.getId(),
                invM.getTotalAmount(),
                invM.getBuyDate(),
                invM.getPicture(),
                invM.getName(),
                invM.getAmountItems(),
                invM.getStock()
        ).toRowTable(eventAction));
       
    }
    private void paintInvoicesWithZeroStock(){
        //int index = tblInvoices.getRowCount() - 1;
        for (int i = 0; i < tblInvoices.getRowCount(); i++) {
            if ((int)tblInvoices.getValueAt(i, 4) == 0) {
                //codigo para pintar aqui

            }
        }
        
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
        setPreferredSize(new java.awt.Dimension(916, 664));

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
                "Id", "Proveedor", "Total", "Artículos", "Existencias", "Fecha de compra", "Picture", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(tblInvoices);
        if (tblInvoices.getColumnModel().getColumnCount() > 0) {
            tblInvoices.getColumnModel().getColumn(6).setMinWidth(0);
            tblInvoices.getColumnModel().getColumn(6).setPreferredWidth(0);
            tblInvoices.getColumnModel().getColumn(6).setMaxWidth(0);
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
                    .addComponent(scroll)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProviders)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addContainerGap(14, Short.MAX_VALUE))
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
