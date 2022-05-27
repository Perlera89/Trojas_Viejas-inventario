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
    
    private void initCard(){
        pnlCard1.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/seller.png")), "Facturas", contador_factura + ""));
        pnlCard2.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/donor.png")), "Total Donadores", "$8"));
    }
    
    public static Date getDateFormat(String date) {
//        SimpleDateFormat formatter = new SimpleDateFormat(formatPattern);
//        return formatter.parse(date);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaConvertida=null;

        try {
            Date parsed =  dateFormat.parse(date);
            fechaConvertida = new Date(parsed.getTime());
        } catch(Exception e) {
            System.out.println("Error occurred"+ e.getMessage());
        }
        return fechaConvertida;
    }
    
    FrmInvoices form = this;
    private IInvoicesEventAction f_eventAction;

    public void initTableData(){
        //Agregar registro
        
        IInvoicesEventAction eventAction = new IInvoicesEventAction(){
            int IndexRow;
            
            @Override
            public void update(InvoicesModel entity) {
                InvoicesDao invD = new InvoicesDao();
                String provName;
                
                
                if (tblInvoices.getSelectedRowCount() > 0) {
                    IndexRow = tblInvoices.getSelectedRow();

                    //Pasar datos al formulario de Windows
                    WindowInvoice formulario = new WindowInvoice();
                    formulario.frmInvoice = form;

                    formulario.id = (int) tblInvoices.getValueAt(IndexRow, 0);
                    formulario.txtTotal.setText(tblInvoices.getValueAt(IndexRow, 1).toString());
                    //Pasando fecha al JDateChooser
                    String fecha = (tblInvoices.getValueAt(IndexRow, 2)).toString();
                    Date fechaParse = getDateFormat(fecha);
                    formulario.txtDate.setDate(fechaParse);
////                    String fechaPleca = fecha.replaceAll("[-]", "/");
//                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//                    Date fechaDate = formato.parse("2022/01/02");
//                    formulario.txtDate.setDate(fechaDate);
                    
                    provName = invD.SelectNameProvWfk((int)tblInvoices.getValueAt(IndexRow, 3));
                    formulario.cbbProvider.setSelectedItem(provName);
                   
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
            public void delete(InvoicesModel entity) {
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
            public void view(InvoicesModel entity) {
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
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblInvoices.getModel();
            int filas = tblInvoices.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
    
    private int contador_factura = 0;
    //private int  = 0;
//    private int contador_accesories = 0;

    public void showInvoices(String tipo_filtro, IInvoicesEventAction eventAction) {
        //Reseteando los contadores     
        contador_factura = 0;
//        contador_tools = 0;
//        contador_accesories = 0;

        //Limpiando la tabla
        clearRowsInTable();

        InvoicesDao invD = new InvoicesDao();

        //Mostrar todos los datos
        switch (tipo_filtro) {
            case "ALL" -> {
                for (var i : invD.ListInvoices()) {
                    add_rows_to_table(i, eventAction);
                    contador_factura++;
//                    if (i.getCategory().equals(CategoryType.HERRAMIENTAS)) {
//                        contador_tools++;
//                    }
//                    if (item.getCategory().equals(CategoryType.ACCESORIOS)) {
//                        contador_accesories++;
//                    }

                    //Agregando la fila a la tabla y los botones de acciones
                    
                }

                //Actualizando los contadores
                //initCard(contador_item, contador_tools, contador_accesories);
            }
//
//            //Filtrar filas por categoría de "HERRAMIENTAS"
//            case "HERRAMIENTAS" -> {
//                for (var item : items.ListItems()) {
//                    if (item.getCategory().equals(CategoryType.HERRAMIENTAS)) {
//                        contador_tools++;
//
//                        //Agregando la fila a la tabla y los botones
//                        add_rows_to_table(item, eventAction);
//                        contador_item++;
//                    }
//                }
//
//                //Actualizando los contadores
//                initCard(contador_item, contador_tools, contador_accesories);
//            }
//            //filtrar las filas por la categoria de "ACCESORIOS"
//            case "ACCESORIOS" -> {
//                for (var item : items.ListItems()) {
//                    if (item.getCategory().equals(CategoryType.ACCESORIOS)) {
//                        contador_accesories++;
//
//                        //Agregando la fila a la tabla y los botones de acciones
//                        add_rows_to_table(item, eventAction);
//                        contador_item++;
//                    }
//                }
//                //Actualizando los contadores
//                initCard(contador_item, contador_tools, contador_accesories);
//
//            }
//            default -> {
//            }
        }
    }

    private void add_rows_to_table(InvoicesModel invM, IInvoicesEventAction eventAction) {
        //Agregando fila a la tabla
        //InvoicesDao invD = new InvoicesDao();
        //String provName = invD.SelectNameProvWfk(invM.getFkProv());
        
        tblInvoices.addRow(new InvoicesModel(
                invM.getId(),
                invM.getTotalAmount(),
                invM.getBuyDate(),
                //invM.getPicture(),
                //provName
                invM.getFkProv()
        ).toRowTable(eventAction));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JLayeredPane();
        pnlCard1 = new com.trojasviejas.component.main.PanelCard();
        pnlCard2 = new com.trojasviejas.component.main.PanelCard();
        pnlTable = new com.trojasviejas.swing.panels.PanelBorder();
        lblProviders = new javax.swing.JLabel();
        btnNew = new com.trojasviejas.swing.Buttons.ActionButton();
        scroll = new javax.swing.JScrollPane();
        tblInvoices = new com.trojasviejas.swing.tables.invoice.InvoicesTable();

        setBackground(new java.awt.Color(232, 241, 242));

        pnlContainer.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        pnlCard1.setColor1(new java.awt.Color(0, 40, 85));
        pnlCard1.setColor2(new java.awt.Color(2, 62, 125));
        pnlContainer.add(pnlCard1);

        pnlCard2.setColor1(new java.awt.Color(255, 123, 0));
        pnlCard2.setColor2(new java.awt.Color(255, 136, 0));
        pnlContainer.add(pnlCard2);

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
                "Id", "Total", "Fecha de compra", "Proveedor", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(tblInvoices);

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProviders))
                .addGap(20, 20, 20))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblProviders)
                .addGap(20, 20, 20)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        WindowHome.main(WindowType.INVOICE, invoice, false);
    }//GEN-LAST:event_btnNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.Buttons.ActionButton btnNew;
    private javax.swing.JLabel lblProviders;
    private com.trojasviejas.component.main.PanelCard pnlCard1;
    private com.trojasviejas.component.main.PanelCard pnlCard2;
    private javax.swing.JLayeredPane pnlContainer;
    private com.trojasviejas.swing.panels.PanelBorder pnlTable;
    private javax.swing.JScrollPane scroll;
    private com.trojasviejas.swing.tables.invoice.InvoicesTable tblInvoices;
    // End of variables declaration//GEN-END:variables
}
