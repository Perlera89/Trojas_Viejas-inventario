package com.trojasviejas.demo.form.window;

import com.trojasviejas.data.dao.ItemDao;
import com.trojasviejas.demo.form.FrmItems;
import com.trojasviejas.models.entity.ItemModel;
import com.trojasviejas.models.utility.CategoryType;
import com.trojasviejas.models.utility.ItemType;
import com.trojasviejas.swing.scroll.ScrollBar;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class WindowItem extends javax.swing.JPanel {
    
    public FrmItems frmItem;
    public WindowHome home;
    public int idRegistro;

    public WindowItem() {
        setOpaque(false);
        initComponents();
        txtName.requestFocus();
        txtDescription.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 0));
        txtDescription.setLineWrap(true);
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.white);
        CargarComboBox();
    }
    
    public void CargarComboBox() {

        for (var i : CategoryType.values()) {
            cbbCategory.addItem(i.toString());
        }
        
        
        for (var i : ItemType.values()) {
            cbbItemType.addItem(i.toString());
        }

    }
    public void clean(){
        txtName.setText("");
        txtAmount.setText("");
        txtDescription.setText("");
        cbbCategory.setSelectedItem(CategoryType.values()[0].toString());
        cbbItemType.setSelectedItem(ItemType.values()[0].toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new com.trojasviejas.swing.fields.LinearTextField();
        cbbCategory = new com.trojasviejas.swing.ComboBox();
        txtAmount = new com.trojasviejas.swing.fields.LinearTextField();
        btnAdd = new com.trojasviejas.swing.buttons.Button();
        btnCancel = new com.trojasviejas.swing.buttons.Button();
        scroll = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        cbbItemType = new com.trojasviejas.swing.ComboBox();

        setBackground(new java.awt.Color(255, 255, 255));

        txtName.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtName.setLabelText("Nombre");

        cbbCategory.setForeground(new java.awt.Color(100, 100, 100));
        cbbCategory.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbbCategory.setLabeText("Categoria");

        txtAmount.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtAmount.setLabelText("Cantidad minima");
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAmountKeyTyped(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 184, 82));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Guardar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 5, 0));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(150, 150, 150));
        txtDescription.setRows(5);
        txtDescription.setText("Descripcion");
        txtDescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtDescriptionMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDescriptionMousePressed(evt);
            }
        });
        scroll.setViewportView(txtDescription);

        cbbItemType.setForeground(new java.awt.Color(100, 100, 100));
        cbbItemType.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbbItemType.setLabeText("Tipo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scroll)
                    .addComponent(cbbItemType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(cbbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(cbbItemType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9'))
        evt.consume();
    }//GEN-LAST:event_txtAmountKeyTyped

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        //Agregar o Actualizar
        if (idRegistro > 0) {
            ItemModel item = new ItemModel();
            ItemDao items = new ItemDao();

            item.setIdItem(idRegistro);
            item.setName(txtName.getText());
            item.setMinimunAmount(Integer.parseInt(txtAmount.getText()));
            item.setDescription(txtDescription.getText());
            item.setCategory(CategoryType.values()[cbbCategory.getSelectedIndex()]);
            item.setType(ItemType.values()[cbbItemType.getSelectedIndex()]);

            items.UpdateItems(item);
            frmItem.initTableData();
            //this.dispose();
            clean();

        } else {
            ItemModel item = new ItemModel();
            ItemDao items = new ItemDao();

            item.setName(txtName.getText());
            item.setMinimunAmount(Integer.parseInt(txtAmount.getText()));
            item.setDescription(txtDescription.getText());
            item.setCategory(CategoryType.values()[cbbCategory.getSelectedIndex()]);
            item.setType(ItemType.values()[cbbItemType.getSelectedIndex()]);

            items.AddItem(item);
            frmItem.init();
            clean();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        home.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtDescriptionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescriptionMouseEntered
        txtDescription.setBorder(BorderFactory.createLineBorder(new Color(3,150,200), 0));
    }//GEN-LAST:event_txtDescriptionMouseEntered

    private void txtDescriptionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescriptionMousePressed
        if (txtDescription.getText().equals("Descripcion")) {
            txtDescription.setText("");
            txtDescription.setForeground(Color.black);
            txtDescription.setBorder(BorderFactory.createLineBorder(new Color(3,155,216), 0));
        }
    }//GEN-LAST:event_txtDescriptionMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.buttons.Button btnAdd;
    private com.trojasviejas.swing.buttons.Button btnCancel;
    public com.trojasviejas.swing.ComboBox cbbCategory;
    public com.trojasviejas.swing.ComboBox cbbItemType;
    private javax.swing.JScrollPane scroll;
    public com.trojasviejas.swing.fields.LinearTextField txtAmount;
    public javax.swing.JTextArea txtDescription;
    public com.trojasviejas.swing.fields.LinearTextField txtName;
    // End of variables declaration//GEN-END:variables
}
