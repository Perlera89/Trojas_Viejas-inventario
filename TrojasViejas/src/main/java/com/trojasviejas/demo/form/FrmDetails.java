package com.trojasviejas.demo.form;


import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.component.login.MessageSuccessDialog;
import com.trojasviejas.data.dao.InvoiceDetailsDao;
import com.trojasviejas.data.dao.InvoicesDao;
import com.trojasviejas.data.dao.ItemDao;
import com.trojasviejas.demo.form.window.WindowHome;
import com.trojasviejas.demo.form.window.WindowInvoice;
import com.trojasviejas.demo.form.window.WindowType;
import com.trojasviejas.models.entity.InvoiceDetailsModel;
import com.trojasviejas.models.entity.InvoicesModel;
import com.trojasviejas.models.entity.ItemModel;
import com.trojasviejas.swing.scroll.ScrollBar;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmDetails extends javax.swing.JFrame {

    public FrmDetails(int _idInvoice) {
        initComponents();
        setBackground(new Color(0,0,0,0));
        setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
        initTableData();
        setLocationRelativeTo(null);
        idInvoice = _idInvoice;
        addOrShowPurchase();
        scrollTable.setBorder(BorderFactory.createEmptyBorder());
        cbbItems.requestFocus();
    }

    //FACTURA==========================
    /*variable para almacenar el id de la factura mostrada,
      si es 0, se guardará una nueva factura con sus detalles
    */
    public int idInvoice;
    
    //id del proveedor que viene elegido desde la factura
    public int idProvider;
    
    //fecha de la factura
    public Date dateInvoice;
    
    //foto de la factura
    public byte[] rutaByte;
    
    //formulario de facturas (para recargar los datos una vez agregada la factura)
    public FrmInvoices formInvoices;
    
    //===========================================
    //almacena el indice de la fila que se ha seleccionado
    //-1 se usa para indicar que no hay una fila seleccionada
    int indexRowSelected = -1;
    
    //almacena el id del item seleccionado en el combobox
    int idSelected = 0;
    
    //agreglo que almacena los ids de los articulos agregados al combo que vienen
    //de la busqueda realizada
    int itemsIDs[] = null;
    
    

    
    MessageErrorDialog errorMessage = new MessageErrorDialog(new JFrame());
    MessageSuccessDialog successMessage = new MessageSuccessDialog(new JFrame());
    
    public void initTableData(){
        scrollTable.setVerticalScrollBar(new ScrollBar());
        scrollTable.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scrollTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scrollTable.getViewport().setBackground(Color.white);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new com.trojasviejas.swing.panels.PanelBorder();
        pnlHeader = new com.trojasviejas.swing.panels.PanelBorder();
        btnClose = new com.trojasviejas.swing.Buttons.ActionButton();
        jLabel1 = new javax.swing.JLabel();
        lblEncabezado = new javax.swing.JLabel();
        pnlData = new com.trojasviejas.swing.panels.PanelShadow();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblProvider = new javax.swing.JLabel();
        lblBuyDate = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        pnlTable1 = new com.trojasviejas.swing.panels.PanelBorder();
        scrollTable = new javax.swing.JScrollPane();
        detailTable = new com.trojasviejas.swing.tables.detail.DetailTable();
        panelBorder3 = new com.trojasviejas.swing.panels.PanelBorder();
        pnlBoxesContainer = new javax.swing.JPanel();
        cbbItems = new com.trojasviejas.swing.ComboBox();
        txtAmount = new com.trojasviejas.swing.fields.MyTextField();
        txtItem = new com.trojasviejas.swing.fields.MyTextField();
        txtCU = new com.trojasviejas.swing.fields.MyTextField();
        btnAdd = new com.trojasviejas.swing.Buttons.Button();
        btnSearch = new com.trojasviejas.swing.Buttons.Button();
        pnlButtons = new javax.swing.JPanel();
        btnUpdate = new com.trojasviejas.swing.Buttons.Button();
        btnDelete = new com.trojasviejas.swing.Buttons.Button();
        btnFinish = new com.trojasviejas.swing.Buttons.Button();
        jPanel1 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        pnlContainer.setBackground(new java.awt.Color(255, 255, 255));

        pnlHeader.setBackground(new java.awt.Color(27, 152, 224));

        btnClose.setBackground(new java.awt.Color(27, 152, 224));
        btnClose.setForeground(new java.awt.Color(200, 0, 20));
        btnClose.setText("X");
        btnClose.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/isotipoSmall.png"))); // NOI18N

        lblEncabezado.setBackground(new java.awt.Color(255, 255, 255));
        lblEncabezado.setFont(new java.awt.Font("Norwester", 0, 24)); // NOI18N
        lblEncabezado.setForeground(new java.awt.Color(255, 255, 255));
        lblEncabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEncabezado.setText("Detalles de factura");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 152, 224));
        jLabel2.setText("Detalles de compra");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(100, 100, 100));
        jLabel3.setText("Proveedor:");

        lblProvider.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblProvider.setForeground(new java.awt.Color(100, 100, 100));
        lblProvider.setText("...");

        lblBuyDate.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblBuyDate.setForeground(new java.awt.Color(100, 100, 100));
        lblBuyDate.setText("...");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(100, 100, 100));
        jLabel8.setText("Fecha de compra:");

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(100, 100, 100));
        jLabel9.setText("Valor de compra:");

        lblPrice.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(100, 100, 100));
        lblPrice.setText("...");

        javax.swing.GroupLayout pnlDataLayout = new javax.swing.GroupLayout(pnlData);
        pnlData.setLayout(pnlDataLayout);
        pnlDataLayout.setHorizontalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(lblProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(lblBuyDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))))
        );
        pnlDataLayout.setVerticalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(20, 20, 20)
                        .addComponent(lblProvider))
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(20, 20, 20)
                        .addComponent(lblPrice))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDataLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(lblBuyDate)))
                .addGap(34, 34, 34))
        );

        pnlTable1.setBackground(new java.awt.Color(255, 255, 255));

        detailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cantidad", "Articulo", "C/U", "Subtotal", "Factura"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        detailTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detailTableMouseClicked(evt);
            }
        });
        scrollTable.setViewportView(detailTable);
        if (detailTable.getColumnModel().getColumnCount() > 0) {
            detailTable.getColumnModel().getColumn(0).setMinWidth(0);
            detailTable.getColumnModel().getColumn(0).setPreferredWidth(0);
            detailTable.getColumnModel().getColumn(0).setMaxWidth(0);
            detailTable.getColumnModel().getColumn(2).setMinWidth(260);
            detailTable.getColumnModel().getColumn(3).setMaxWidth(50);
            detailTable.getColumnModel().getColumn(5).setMinWidth(0);
            detailTable.getColumnModel().getColumn(5).setPreferredWidth(0);
            detailTable.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        javax.swing.GroupLayout pnlTable1Layout = new javax.swing.GroupLayout(pnlTable1);
        pnlTable1.setLayout(pnlTable1Layout);
        pnlTable1Layout.setHorizontalGroup(
            pnlTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTable1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlTable1Layout.setVerticalGroup(
            pnlTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTable1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        panelBorder3.setBackground(new java.awt.Color(232, 241, 242));

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        pnlBoxesContainer.setBackground(new java.awt.Color(255, 255, 255));

        cbbItems.setEditable(true);
        cbbItems.setToolTipText("Nombre del artículo | Categoría del artículo | Tipo del artículo");
        cbbItems.setLabeText("Artículo");
        cbbItems.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbItemsItemStateChanged(evt);
            }
        });
        cbbItems.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbbItemsKeyReleased(evt);
            }
        });

        txtAmount.setToolTipText("Cantidad del artículo");
        txtAmount.setColorFont(new java.awt.Color(27, 152, 224));
        txtAmount.setHint("Cantidad:");
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAmountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAmountKeyTyped(evt);
            }
        });

        txtItem.setEditable(false);
        txtItem.setToolTipText("Nombre del artículo seleccionado");
        txtItem.setColorFont(new java.awt.Color(27, 152, 224));
        txtItem.setHint("Articulo:");

        txtCU.setToolTipText("Precio por unidad del artículo");
        txtCU.setColorFont(new java.awt.Color(27, 152, 224));
        txtCU.setHint("C/U:");
        txtCU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCUKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCUKeyTyped(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 184, 82));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 100, 148));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_small.png"))); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBoxesContainerLayout = new javax.swing.GroupLayout(pnlBoxesContainer);
        pnlBoxesContainer.setLayout(pnlBoxesContainerLayout);
        pnlBoxesContainerLayout.setHorizontalGroup(
            pnlBoxesContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoxesContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBoxesContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBoxesContainerLayout.createSequentialGroup()
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(txtCU, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbbItems, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(pnlBoxesContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlBoxesContainerLayout.setVerticalGroup(
            pnlBoxesContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBoxesContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBoxesContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbItems, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(pnlBoxesContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlButtons.setBackground(new java.awt.Color(255, 255, 255));

        btnUpdate.setBackground(new java.awt.Color(0, 100, 148));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 100, 148));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_small.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFinish.setBackground(new java.awt.Color(0, 184, 82));
        btnFinish.setForeground(new java.awt.Color(255, 255, 255));
        btnFinish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/finish.png"))); // NOI18N
        btnFinish.setText("Finalizar");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTotal.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(27, 152, 224));
        lblTotal.setText("$0.00");

        jLabel4.setFont(new java.awt.Font("Anton", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 152, 224));
        jLabel4.setText("Total: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTotal))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnlBoxesContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(50, 50, 50))
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(pnlData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBoxesContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (cbbItems.getSelectedItem()!=null && !cbbItems.getSelectedItem().equals("")) {
        //buscando item
        ItemDao itemDao = new ItemDao();
        //enviando al metodo de relleno del combo el array con los items encontrados
        //segun la busqueda
        setDataToComboBoxItem(itemDao.findItem(cbbItems.getSelectedItem().toString(),1));         
        }else{
           errorMessage.showMessage("ERROR", "Busqueda vacía. Defina previamente el nombre del item que desea buscar.");
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (indexRowSelected == -1) {
           addRowToTable();
           //si es una factura especial(donacion) es valor por defecto del c/u es 0.00
            if (getProviderType(lblProvider.getText()).equals(" DONANTE")) {
                txtCU.setText("0.00");
            }
            //cbbItems.requestFocus();
            //cbbItems.showPopup();
        }else{
            errorMessage.showMessage("ACCIÓN INVÁLIDA", "No puede agregar más detalles mientras se esta actualizando un registro");
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9'))
        evt.consume();
    }//GEN-LAST:event_txtAmountKeyTyped

    private void txtCUKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCUKeyTyped
        //VK_period indica un punto
        
        char car = evt.getKeyChar();
        if (((car < '0' || car > '9') && (car < KeyEvent.VK_PERIOD ||car > KeyEvent.VK_PERIOD )))
        evt.consume();

    }//GEN-LAST:event_txtCUKeyTyped
 
    private void detailTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailTableMouseClicked
        //guardando el indice de la fila seleccionada
        indexRowSelected = detailTable.getSelectedRow();
        //mandando los datos a las cajas
        txtAmount.setText(detailTable.getValueAt(indexRowSelected, 1).toString());
        txtItem.setText(detailTable.getValueAt(indexRowSelected, 2).toString());
        String pricePerUnit = detailTable.getValueAt(indexRowSelected, 3).toString();
        txtCU.setText(pricePerUnit.substring(1, pricePerUnit.length()));
    }//GEN-LAST:event_detailTableMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        //actualizando fila
        if (indexRowSelected != -1) {
            idSelected = (int)detailTable.getValueAt(detailTable.getSelectedRow(), 0);
            updateRowToTable(indexRowSelected);
            
            //colocando el indicador de la fila seleccionada como no seleccionada luego de haber seleccionado
            indexRowSelected = -1;
            
            //si es una factura especial para donandor entoces el c/u es por defecto 0.0
            if (getProviderType(lblProvider.getText()).equals(" DONANTE")) {
                txtCU.setText("0.00");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        //actualizando fila
        if (indexRowSelected != -1) {
            DefaultTableModel tableModel = (DefaultTableModel) detailTable.getModel();
            tableModel.removeRow(indexRowSelected);
            detailTable.setModel(tableModel);
            cleanDataInBoxes();
            
            //actualizando el total
            lblTotal.setText("$"+updateTotal());
            
            //colocamos el indicador de la fila seleccionada como -1 para indicar que no hay una seleccionada
            //se obliga al usuario a dar click nuevamente 
            indexRowSelected = -1;
            
            cbbItems.requestFocus();
            cbbItems.showPopup();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cbbItemsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbItemsItemStateChanged
         if (cbbItems.getSelectedIndex()!=-1) {
            //guardamos en el idselected el id del items seleccionado
            idSelected = itemsIDs[cbbItems.getSelectedIndex()];
            //colocando el item seleccionado en la caja
            txtItem.setText(cbbItems.getSelectedItem().toString());
            
            txtAmount.requestFocus();
        }
    }//GEN-LAST:event_cbbItemsItemStateChanged

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed

        //verificar que hallan detalles agregados
        if (detailTable.getRowCount()>0) {
            Double pricePurchase = Double.parseDouble(lblPrice.getText().substring(1));
            Double detailsTotal = Double.parseDouble(lblTotal.getText().substring(1));
            //verificar si el precio de la factura es igual a la sumatoria de los subtotales
            if (pricePurchase.equals(detailsTotal)) {
                //saveInvoice guarda la factura y retorna el id de la ultima agregada
                //y saveDetails guarda los detalles a esa ultma factura
                if(saveInvoice(detailsTotal)){
                int lastIdInvoice = getLastIdInvoice();
                //System.out.println("Ultima factura: "+ lastIdInvoice);
                saveDetails(lastIdInvoice);
                
                //recargando datos de las facturas
                formInvoices.initTableData();
                successMessage.showMessage("ÉXITO", "La factura y detalles registrados exitosamente.");
                idInvoice = 0;
                this.dispose();
                }else{
                            WindowInvoice invoice = new WindowInvoice();
                            invoice.cbbProvider.addItem(lblProvider.getText());
                            invoice.ids = new int[1];
                            invoice.ids[0] = idProvider;
                            invoice.txtTotal.setText(lblPrice.getText().substring(1));
                            invoice.txtDate.setDate(dateInvoice);
                            invoice.frmInvoice = formInvoices;
                            WindowHome.main(WindowType.INVOICE, invoice, false);
                            this.dispose();
                }
            }else{
                errorMessage.showMessage("ERROR", "El precio total de la factura no es igual a la sumatoria "
                        + "de los subtotales de los detales.");
            }
            
        }else{
            errorMessage.showMessage("ERROR", "No puede guardar una factura sin detalles de factura.");
        }
    }//GEN-LAST:event_btnFinishActionPerformed

    private void cbbItemsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbItemsKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSearch.doClick();
            cbbItems.showPopup();
        }
    }//GEN-LAST:event_cbbItemsKeyReleased

    private void txtAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCU.requestFocus();
        }
    }//GEN-LAST:event_txtAmountKeyReleased

    private void txtCUKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCUKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.doClick();
        }
    }//GEN-LAST:event_txtCUKeyReleased
    
    //registrará la factura y retornará el id de la ultima factura creada
    private Boolean saveInvoice(Double price){
        
        InvoicesDao invoiceDao = new InvoicesDao();
        InvoicesModel invoice = new InvoicesModel();
        invoice.setTotalAmount(price);
        invoice.setBuyDate(dateInvoice);
        invoice.setPicture(rutaByte);
        invoice.setFkProv(idProvider);
        return  invoiceDao.AddInvoice(invoice);
    }
    
    private int getLastIdInvoice(){
        InvoicesDao invoiceDao = new InvoicesDao();       
        return invoiceDao.getLastIdInvoice();
    }
    
    private void saveDetails(int lastIdInvoice){
        InvoiceDetailsDao detailsDao = new InvoiceDetailsDao();

        //indica el indice de la columna que se esta guardando
        int indexRow = 0;

        for (int i = 0; i < detailTable.getRowCount(); i++) {
            detailsDao.save(
                    new InvoiceDetailsModel(
                            (int) detailTable.getValueAt(indexRow, 1),
                            Double.parseDouble(detailTable.getValueAt(indexRow, 3).toString().substring(1)),
                            (int) detailTable.getValueAt(indexRow, 0),
                            lastIdInvoice
                    )
            );
            //aumenta en uno para guardar la fila en el indice siguiente
            indexRow++;
        }
     
    }
    
    private void addRowToTable(){

        if ((!txtAmount.getText().isBlank() && !txtAmount.getText().isEmpty())
                && ((!txtItem.getText().isBlank() && !txtItem.getText().isEmpty()))
                && (!txtCU.getText().isEmpty() && !txtCU.getText().isEmpty())) {

            try {
                if (cbbItems.getSelectedItem()!=null) {
                    int amount = Integer.parseInt(txtAmount.getText());
                    if (amount > 0) {
                        Double pricePerUnit = Double.parseDouble(txtCU.getText());
                        String item = txtItem.getText();
                        Double subtotal = (double)amount * pricePerUnit;

                        detailTable.addRow(new Object[]{
                            idSelected, amount, item, "$"+pricePerUnit, "$"+subtotal, idInvoice
                        });
                        //System.out.println(""+((double)amount * pricePerUnit));
                        //sumando los subtotales
                        lblTotal.setText("$"+updateTotal());
                        cleanDataInBoxes(); 
                        
                        cbbItems.requestFocus();
                        cbbItems.showPopup();
                    }else{
                        txtAmount.setText("");
                        txtAmount.requestFocus();
                    }
                    
                }else{
                    errorMessage.showMessage("ERROR", "Debe seleccionar un artículo previamente para poder guardar el detalle de factura");
                }
                txtAmount.requestFocus();
            } catch (Exception e) {
                errorMessage.showMessage("ERROR", "Valores inválidos, verifique las datos ingresados.\n" + e.toString());
            }

        } else {
            errorMessage.showMessage("ERROR", "Valores inválidos, campos vacios.");
        }
    }
    
    private double updateTotal(){
        Double total = 0.0;
        for (int i = 0; i < detailTable.getRowCount(); i++) {
            String subtotal = detailTable.getValueAt(i, 4).toString();
            total += Double.parseDouble(subtotal.substring(1));
        }
        
        return total;
    }
   
    private void updateRowToTable(int indexRow){

        if ((!txtAmount.getText().isBlank() && !txtAmount.getText().isEmpty())
                && ((!txtItem.getText().isBlank() && !txtItem.getText().isEmpty()))
                && (!txtCU.getText().isEmpty() && !txtCU.getText().isEmpty())) {

            try {

                int amount = Integer.parseInt(txtAmount.getText());
                Double pricePerUnit = Double.parseDouble(txtCU.getText());
                String item = txtItem.getText();
                //si no se ha seleccionado un item no importa, pues como ya se ha agregado uno, si no lo 
                //cambia se toma el actual
                if (amount > 0) {
                    if (indexRow >= 0) {
                        detailTable.setValueAt(idSelected, indexRow, 0);
                        detailTable.setValueAt(amount, indexRow, 1);
                        detailTable.setValueAt(item, indexRow, 2);
                        detailTable.setValueAt("$"+pricePerUnit, indexRow, 3);
                        detailTable.setValueAt("$"+ (amount * pricePerUnit), indexRow, 4);
                        detailTable.setValueAt(idInvoice, indexRow, 5);
                        cleanDataInBoxes();

                        //actualizando el total
                        lblTotal.setText("$" + updateTotal());
                        cbbItems.requestFocus();
                        cbbItems.showPopup();
                    }                 
                }


            } catch (Exception e) {
                errorMessage.showMessage("ERROR", "Valores inválidos, verifique las datos ingresados.\n" + e.toString());
                cbbItems.requestFocus();
                cbbItems.showPopup();
            }

        } else {
            cbbItems.requestFocus();
            cbbItems.showPopup();
            errorMessage.showMessage("ERROR", "Valores inválidos, campos vacios.");
        }
    }

    private void setDataToComboBoxItem(ArrayList<ItemModel> items) {
        cbbItems.removeAllItems();
        //tamano del array de ids segun el tamano de la busqueda
        itemsIDs = new int[items.size()];
        //indica el indice en el cual se guardará en id
        int index = 0;
        for (var i : items) {
            cbbItems.addItem(i.getName() + ", " + i.getType());
            //guardando el id en el array de ids
            itemsIDs[index] = i.getIdItem();
            //aumentando en uno para guardar el otro id en el siguiente indice
            index++;
        }

        if (!items.isEmpty()) {
            //seleccionando el primer elemento
          cbbItems.setSelectedIndex(0);
          //guardando el id del elemento seleccionado
          idSelected = itemsIDs[cbbItems.getSelectedIndex()];          
        }

    }
    
    private void cleanDataInBoxes(){
        txtAmount.setText("");
        txtItem.setText("");
        cbbItems.setSelectedIndex(-1);
        txtCU.setText("");
    }

    //verifica si es una nueva factura o solo se estan mostrando los detalles
    //de una que ya existe
    private void addOrShowPurchase(){
        if (idInvoice>0) {
            ///se estan mostrando detalles de una existente  
            //ocultando el panel de agregar articulos y de acciones
            pnlBoxesContainer.setVisible(false);
            pnlButtons.setVisible(false);

            InvoiceDetailsDao detailsDao = new InvoiceDetailsDao();
            DefaultTableModel model = (DefaultTableModel) detailTable.getModel();
            for (var i : detailsDao.list(idInvoice)) {
                model.addRow(new Object[]{
                    i.getId(),
                    i.getAmount(),
                    i.getItemName(),
                    "$"+i.getPricerPerUnit(),
                    "$"+i.getSubtotal(),
                    i.getInvoiceFk()
                });

            }
            lblTotal.setText("$"+updateTotal());
        }
        //System.out.println(idInvoice);
        //si no, es una nueva y todo se muestra con normalidad
    }
    
    //retorna el tipo de proveedor concantenado al final del nombre del proveedor
    private String getProviderType(String provider){
        String _provider[] = provider.split(",");
        return _provider[1];
    }
//    public static void main(int _idInvoice) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmDetails(_idInvoice).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.Buttons.Button btnAdd;
    private com.trojasviejas.swing.Buttons.ActionButton btnClose;
    private com.trojasviejas.swing.Buttons.Button btnDelete;
    private com.trojasviejas.swing.Buttons.Button btnFinish;
    private com.trojasviejas.swing.Buttons.Button btnSearch;
    private com.trojasviejas.swing.Buttons.Button btnUpdate;
    private com.trojasviejas.swing.ComboBox cbbItems;
    private com.trojasviejas.swing.tables.detail.DetailTable detailTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblBuyDate;
    public javax.swing.JLabel lblEncabezado;
    public javax.swing.JLabel lblPrice;
    public javax.swing.JLabel lblProvider;
    private javax.swing.JLabel lblTotal;
    private com.trojasviejas.swing.panels.PanelBorder panelBorder3;
    private javax.swing.JPanel pnlBoxesContainer;
    private javax.swing.JPanel pnlButtons;
    private com.trojasviejas.swing.panels.PanelBorder pnlContainer;
    private com.trojasviejas.swing.panels.PanelShadow pnlData;
    private com.trojasviejas.swing.panels.PanelBorder pnlHeader;
    private com.trojasviejas.swing.panels.PanelBorder pnlTable1;
    private javax.swing.JScrollPane scrollTable;
    private com.trojasviejas.swing.fields.MyTextField txtAmount;
    public com.trojasviejas.swing.fields.MyTextField txtCU;
    private com.trojasviejas.swing.fields.MyTextField txtItem;
    // End of variables declaration//GEN-END:variables
}
