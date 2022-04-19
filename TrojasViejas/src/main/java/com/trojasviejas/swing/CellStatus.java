package com.trojasviejas.swing;

import com.trojasviejas.models.utility.ProviderType;

public class CellStatus extends javax.swing.JPanel {

    public CellStatus(ProviderType type) {
        initComponents();
        status.setType(type);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        status = new com.trojasviejas.swing.tables.ProvidersStatus();

        setBackground(new java.awt.Color(255, 255, 255));

        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText("tableStatus1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.tables.ProvidersStatus status;
    // End of variables declaration//GEN-END:variables
}
