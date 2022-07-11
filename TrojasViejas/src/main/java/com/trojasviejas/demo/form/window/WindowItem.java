package com.trojasviejas.demo.form.window;

import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.data.dao.ItemDao;
import com.trojasviejas.demo.form.FrmItems;
import com.trojasviejas.models.entity.ItemModel;
import com.trojasviejas.models.utility.CategoryType;
import com.trojasviejas.models.utility.ItemType;
import com.trojasviejas.swing.fields.LinearTextField;
import com.trojasviejas.swing.scroll.ScrollBar;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
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
        txtDescription.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 0));
        txtDescription.setLineWrap(true);
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.white);
        CargarComboBox();
        txtName.requestFocus();
    }
    
    MessageErrorDialog errorMessage = new MessageErrorDialog(new JFrame());
    
    public void CargarComboBox() {

        for (var i : CategoryType.values()) {
            cbbCategory.addItem(i.toString());
        }
        cbbCategory.setSelectedIndex(0);
    }
    

    //Método para limpiar cajas de texto
    public void clean() {
        txtName.setText("");
        txtAmount.setText("");
        txtDescription.setText("Sin descripción");
        cbbCategory.setSelectedItem(CategoryType.values()[0].toString());
        cbbItemType.setSelectedItem(ItemType.values()[0].toString());
        txtName.requestFocus();
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

        txtName.setToolTipText("Nombre del artículo");
        txtName.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtName.setLabelText("Nombre");
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        cbbCategory.setForeground(new java.awt.Color(100, 100, 100));
        cbbCategory.setToolTipText("Categoría del artículo");
        cbbCategory.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbbCategory.setLabeText("Categoria");
        cbbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbCategoryActionPerformed(evt);
            }
        });
        cbbCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbbCategoryKeyReleased(evt);
            }
        });

        txtAmount.setToolTipText("Alerta de cantidad mínima del artículo");
        txtAmount.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtAmount.setLabelText("Cantidad minima");
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAmountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAmountKeyTyped(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 184, 82));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btnAdd.setText("Guardar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 5, 0));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.png"))); // NOI18N
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
        txtDescription.setText("Sin descripción");
        txtDescription.setToolTipText("Descripción, comentarios, recordatorio, etc., del artículo");
        txtDescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtDescriptionMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDescriptionMousePressed(evt);
            }
        });
        txtDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescriptionKeyReleased(evt);
            }
        });
        scroll.setViewportView(txtDescription);

        cbbItemType.setForeground(new java.awt.Color(100, 100, 100));
        cbbItemType.setToolTipText("Tipo del artículo según la categoría");
        cbbItemType.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbbItemType.setLabeText("Tipo");
        cbbItemType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbbItemTypeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scroll)
                    .addComponent(cbbItemType, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        //VALIDACIONES
        if ((!txtName.getText().isBlank() && !txtName.getText().isEmpty())
                && (!txtAmount.getText().isBlank() && !txtAmount.getText().isEmpty())) {
            if (Integer.parseInt(txtAmount.getText()) > 0) {
                //Agregar o Actualizar
                if (idRegistro > 0) {
                    ItemModel item = new ItemModel();
                    ItemDao items = new ItemDao();

                    item.setIdItem(idRegistro);
                    item.setName(txtName.getText());
                    item.setMinimunAmount(Integer.parseInt(txtAmount.getText()));
                    item.setDescription(txtDescription.getText());
                    item.setCategory(CategoryType.valueOf(cbbCategory.getSelectedItem().toString()));
                    item.setType(ItemType.valueOf(cbbItemType.getSelectedItem().toString()));

                    items.UpdateItems(item);
                    frmItem.reloadChoosedFilter();

                    home.dispose();

                } else {
                    ItemModel item = new ItemModel();
                    ItemDao items = new ItemDao();

                    item.setName(txtName.getText());
                    item.setMinimunAmount(Integer.parseInt(txtAmount.getText()));
                    item.setDescription(txtDescription.getText());
                    item.setCategory(CategoryType.valueOf(cbbCategory.getSelectedItem().toString()));
                    item.setType(ItemType.valueOf(cbbItemType.getSelectedItem().toString()));

                    items.AddItem(item);
                    frmItem.reloadChoosedFilter();
                    clean();
                }
            } else {
                errorMessage.showMessage("ERROR", "El campo de catidad mínima solo acepta valores mayores a cero.");

            }

        } else {
            errorMessage.showMessage("ERROR", "No puede guardar un registro con valores nulos o vacios.");
        }


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        home.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtDescriptionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescriptionMouseEntered
        txtDescription.setBorder(BorderFactory.createLineBorder(new Color(3,150,200), 0));
    }//GEN-LAST:event_txtDescriptionMouseEntered

    private void txtDescriptionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescriptionMousePressed
        if (txtDescription.getText().equals("Sin descripcion")) {
            txtDescription.setText("");
            txtDescription.setForeground(Color.black);
            txtDescription.setBorder(BorderFactory.createLineBorder(new Color(3,155,216), 0));
        }
    }//GEN-LAST:event_txtDescriptionMousePressed

    private void cbbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbCategoryActionPerformed
        cbbItemType.removeAllItems();
        if (cbbCategory.getSelectedItem().toString().equals(CategoryType.HERRAMIENTAS.toString())) {
            cbbItemType.addItem(ItemType.GENERICO);
        }else{
            cbbItemType.addItem(ItemType.GALVANIZADO);  
            cbbItemType.addItem(ItemType.PVC);
        }
    }//GEN-LAST:event_cbbCategoryActionPerformed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        charCounter(txtName, 50);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtAmount.requestFocus();
        }
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbbCategory.requestFocus();
            cbbCategory.showPopup();
        }
    }//GEN-LAST:event_txtAmountKeyReleased

    private void cbbCategoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbCategoryKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbbItemType.requestFocus();
            cbbItemType.showPopup();
        }
    }//GEN-LAST:event_cbbCategoryKeyReleased

    private void cbbItemTypeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbItemTypeKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDescription.requestFocus();
        }
    }//GEN-LAST:event_cbbItemTypeKeyReleased

    private void txtDescriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyReleased
        if (255  < txtDescription.getText().length()) {
            txtDescription.setText(txtDescription.getText().substring(0, txtDescription.getText().length() - 1));
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.doClick();
        }
    }//GEN-LAST:event_txtDescriptionKeyReleased

        private void charCounter(LinearTextField txtField, int max){
        if (max  < txtField.getText().length()) {
            txtField.setText(txtField.getText().substring(0, txtField.getText().length() - 1));
        }
    }

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
