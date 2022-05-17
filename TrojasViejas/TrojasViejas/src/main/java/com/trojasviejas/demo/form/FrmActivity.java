package com.trojasviejas.demo.form;

import com.trojasviejas.component.main.PanelMenu;
import com.trojasviejas.data.dao.ActivityDao;
import com.trojasviejas.demo.form.window.*;
import com.trojasviejas.models.utility.*;
import com.trojasviejas.swing.scroll.ScrollBar;
import javax.swing.*;
import java.awt.*;
import com.trojasviejas.models.viewmodel.ActivityVM;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class FrmActivity extends javax.swing.JPanel {

    public FrmActivity() {
        setOpaque(false);
        initComponents();
        initCard();
        initTableData();
    }

    private void initCard() {
        pnlCard1.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/register.png")), "REGISTROS", String.valueOf(countRegisters)));
        pnlCard2.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/income.png")), "ENTRADAS", String.valueOf(countEntries)));
        pnlCard3.setData(new CardModel(new ImageIcon(getClass().getResource("/icons/output.png")), "SALIDAS", String.valueOf(countOutputs)));
    
        //muestra todos los registros nuevamente
        pnlCard1.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showActivityRegistersFilterBy("ALL");
            }

        });
        //filtra los registros de tipo de Entrada
        pnlCard2.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showActivityRegistersFilterBy(ActionType.ENTRADA.toString());
            }

        });
        //filtra los registros de tipo de Salida
        pnlCard3.setFilter(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showActivityRegistersFilterBy(ActionType.SALIDA.toString());
            }

        });
    
    }

    private void initTableData() {
        //Agregar registro

        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.white);

        //cargando datos a la tabla
        showActivityRegistersFilterBy("ALL");
        
        if (FrmMain.main.getExtendedState() == JFrame.NORMAL) {
            tblActivity.getColumnModel().getColumn(0).setMaxWidth(0);
            tblActivity.getColumnModel().getColumn(0).setMinWidth(0);
            tblActivity.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblActivity.getColumnModel().getColumn(0).setResizable(false);
        }
    }
    //Array De busqueda
    ArrayList<ActivityVM> listFound = null;

    public void runSearch(String _search) {
        //resetendo el array de busqueda
        listFound = null;
        if (!_search.isBlank() || !_search.isEmpty()) {

            int year=0;
            String month="";
            //obteniendo el mes y año
            try {
                String search[] = _search.split("_");
                month = search[0];
                year = Integer.parseInt(search[1]);
                
                System.out.println("mes: "+month+" año: "+year);

                ActivityDao activitiesDao = new ActivityDao();

                //verificando que los resultados de la busqueda no vengan vacios
                if (month.isBlank()==true) {
                   // if (!activitiesDao.findBy("NULL", year).isEmpty()) { 
                         //guardando la busqueda en una array para ser usada en los filtros de cajas          
                        listFound = activitiesDao.findBy("NULL", year);                   
                    //}

                } else {
                    //verificando que los resultados de la busqueda no vengan vacios
                       // if ( !activitiesDao.findBy(month, year).isEmpty()) {
                        //guardando la busqueda en una array para ser usada en los filtros de cajas          
                        listFound = activitiesDao.findBy(month, year); 
                    //}

                }


            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Formato de búsqueda no válido.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }
        
        
        
        int countRegisters = 0;
        int countEntries = 0;
        int countOutputs = 0;
    public void showActivityRegistersFilterBy(String tipo_filtro){
        //RESETEANDO LOS CONTADORES      
        countRegisters = 0;
        countEntries = 0;
        countOutputs = 0;

        
        //LIMPIANDO LA TABLA
        clearRowsInTable();
        
       ActivityDao activitiesDao = new ActivityDao();
       ArrayList<ActivityVM> activity = activitiesDao.list();  
        
        if (listFound != null) {
            activity = listFound;
        }
        //MOSTRAR TODOS LOS DATOS
        switch (tipo_filtro) {
            case "ALL" -> {
                for (var i : activity) {
                    if (i.getTypeAction().equals(ActionType.ENTRADA)) {
                        countEntries++;
                    }
                    if (i.getTypeAction().equals(ActionType.SALIDA)) {
                        countOutputs++;
                    }

                    //AGREGANDO LA FILA A LA TABLA
                    add_rows_to_table(i);
                    //Sumando los registros de actividades
                    countRegisters ++;
                }
                //ACTUALIZANDO LOS CONTADORES
                initCard();
            }

            //FILTRAR LAAS FILAS POR LA ACCION DE ENTRADA
            case "ENTRADA" -> {
                for (var i : activity) {
                    if (i.getTypeAction().equals(ActionType.ENTRADA)) {

                        //contando los registros de tipo entrada
                        countEntries++;
                        //AGREGANDO LA FILA A LA TABLA
                        add_rows_to_table(i);
                        countRegisters++;
                    }
                }
                //ACTUALIZANDO LOS CONTADORES
                initCard();
            }
            //FILTRAR LAS FILAS POR LA CATEGORIA DE ACCESORIOS
            case "SALIDA" -> {
                for (var i : activity) {
                    if (i.getTypeAction().equals(ActionType.SALIDA)) {
                        
                        //contando los registros de tipo salida
                        countOutputs ++; 
                        
                        //AGREGANDO LA FILA A LA TABLA 
                        add_rows_to_table(i);
                        countRegisters++;
                    }
                }
                //ACTUALIZANDO LOS CONTADORES
                initCard();

            }
            default -> {
            }
        } 
    }
    
      //formato para la fecha
     SimpleDateFormat formatDate  = new SimpleDateFormat("dd-MM-yyyy");
    private void add_rows_to_table(ActivityVM register) {
        //AGREGANDO FILA A  lA TABLA
        tblActivity.addRow(new Object[]{
            register.getId(),
            register.getTypeAction(),
            register.getItem(),
            register.getCurrentStock(),
            register.getAmount(),
            register.getNewStock(),
            register.getDescription(),
            "$" + register.getPricePerUnit(),
            register.getCategory(),
            register.getType(),
            formatDate.format(register.getBuyDate()),
            formatDate.format(register.getDate())
        });
    }
    //borrado de las filas de la tabla
        private void clearRowsInTable(){
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblActivity.getModel();
            int filas = tblActivity.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toggle = new javax.swing.JToggleButton();
        pnlTable = new com.trojasviejas.swing.panels.PanelBorder();
        lblActivity = new javax.swing.JLabel();
        btnRegister = new com.trojasviejas.swing.Buttons.ActionButton();
        btnRefresh = new com.trojasviejas.swing.Buttons.ActionButton();
        scroll = new javax.swing.JScrollPane();
        tblActivity = new com.trojasviejas.swing.tables.activity.ActivityTable();
        pnlContainer = new javax.swing.JLayeredPane();
        pnlCard1 = new com.trojasviejas.component.main.PanelCard();
        pnlCard2 = new com.trojasviejas.component.main.PanelCard();
        pnlCard3 = new com.trojasviejas.component.main.PanelCard();

        toggle.setText("jToggleButton1");

        setBackground(new java.awt.Color(232, 241, 242));

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        lblActivity.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblActivity.setForeground(new java.awt.Color(127, 127, 127));
        lblActivity.setText("Actividad");

        btnRegister.setBackground(new java.awt.Color(0, 184, 82));
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        btnRegister.setText("Registro");
        btnRegister.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnRegister.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        scroll.setBorder(null);

        tblActivity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Accion", "Articulo", "Existencias", "Retiro", "En inventario", "Descripción", "C/U", "Categoria", "Tipo", "Fecha de compra", "Fecha de registro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(tblActivity);

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scroll)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblActivity)
                            .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addComponent(lblActivity)
                        .addGap(20, 20, 20)
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlContainer.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        pnlCard1.setColor1(new java.awt.Color(0, 40, 85));
        pnlCard1.setColor2(new java.awt.Color(2, 62, 125));
        pnlContainer.add(pnlCard1);

        pnlCard2.setColor1(new java.awt.Color(0, 58, 1));
        pnlCard2.setColor2(new java.awt.Color(0, 71, 2));
        pnlContainer.add(pnlCard2);

        pnlCard3.setColor1(new java.awt.Color(108, 5, 0));
        pnlCard3.setColor2(new java.awt.Color(162, 0, 0));
        pnlContainer.add(pnlCard3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                    .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    FrmActivity thisForm = this;
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        WindowActivity.main();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        if (FrmMain.main.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
            //tblActivity.getColumnModel().getColumn(6).setMaxWidth(0);
            tblActivity.getColumnModel().getColumn(6).setMinWidth(150);
            tblActivity.getColumnModel().getColumn(6).setPreferredWidth(150);
            tblActivity.getColumnModel().getColumn(6).setResizable(true);
        }
        listFound = null;
        showActivityRegistersFilterBy("ALL");
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.Buttons.ActionButton btnRefresh;
    private com.trojasviejas.swing.Buttons.ActionButton btnRegister;
    private javax.swing.JLabel lblActivity;
    private com.trojasviejas.component.main.PanelCard pnlCard1;
    private com.trojasviejas.component.main.PanelCard pnlCard2;
    private com.trojasviejas.component.main.PanelCard pnlCard3;
    private javax.swing.JLayeredPane pnlContainer;
    private com.trojasviejas.swing.panels.PanelBorder pnlTable;
    private javax.swing.JScrollPane scroll;
    private com.trojasviejas.swing.tables.activity.ActivityTable tblActivity;
    private javax.swing.JToggleButton toggle;
    // End of variables declaration//GEN-END:variables
}
