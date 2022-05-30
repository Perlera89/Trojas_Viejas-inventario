package com.trojasviejas.component.login;

import com.trojasviejas.demo.form.FrmLogin;
import com.trojasviejas.swing.Glass;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MessageErrorDialog extends javax.swing.JDialog {
    
    private final JFrame window;
    private Glass glass;
    private Animator animator;
    private boolean show;
    private MessageType messageType = MessageType.CANCEL;

    public MessageErrorDialog(JFrame window) {
        super(window, true);
        this.window = window;
        initComponents();
        init();
    }
    
    private void init(){
        setBackground(new Color(0, 0, 0, 0));
        StyledDocument doc = lblContent.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        lblContent.setOpaque(false);
        lblContent.setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                closeMessage();
            }     
        });
        animator = new Animator(350, new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                float fractionDialog = show ? fraction : 1f - fraction;
                glass.setAlpha(fractionDialog - fractionDialog * 0.5f);
                setOpacity(fractionDialog);
            }

            @Override
            public void end() {
                if(show == false){
                    dispose();
                    glass.setVisible(false);
                }
            }        
        });
        
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        setOpacity(0f);
        glass = new Glass();
    }
    
    private void startAnimator(boolean show){
        if(animator.isRunning()){
            float fraction = animator.getTimingFraction();
            animator.stop();
            animator.setStartFraction(1f - fraction);
        } else{
            animator.setStartFraction(0f);
        }
        
        this.show = show;
        animator.start();
    }
    
    public void showMessage(String title, String message){
        window.setGlassPane(glass);
        glass.setVisible(true);
        lblTitle.setText(title);
        lblContent.setText(message);
        setLocationRelativeTo(new FrmLogin());
        startAnimator(true);
        setVisible(true);
    }
    
    public void closeMessage(){
        startAnimator(false);
    }
    
    public MessageType getMessageType(){
        return messageType;
    }
    
    public void setMessageType(MessageType messageType){
        this.messageType = messageType;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundDialog1 = new com.trojasviejas.swing.BackgroundDialog();
        btnOk = new com.trojasviejas.swing.buttons.ButtonCustom();
        btnCancel = new com.trojasviejas.swing.buttons.ButtonCustom();
        jLabel1 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblContent = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        backgroundDialog1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        btnOk.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        btnOk.setText("Ok");
        btnOk.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(245, 71, 71));
        btnCancel.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        btnCancel.setText("Cancel");
        btnCancel.setColorHover(new java.awt.Color(255, 74, 74));
        btnCancel.setColorPressed(new java.awt.Color(235, 61, 61));
        btnCancel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alert.png"))); // NOI18N

        lblTitle.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(245, 71, 71));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Titulo del mensaje");

        lblContent.setEditable(false);
        lblContent.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblContent.setForeground(new java.awt.Color(76, 76, 76));
        lblContent.setText("Contenido\ndel mensaje\n");
        lblContent.setFocusable(false);

        javax.swing.GroupLayout backgroundDialog1Layout = new javax.swing.GroupLayout(backgroundDialog1);
        backgroundDialog1.setLayout(backgroundDialog1Layout);
        backgroundDialog1Layout.setHorizontalGroup(
            backgroundDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundDialog1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(backgroundDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundDialog1Layout.createSequentialGroup()
                        .addComponent(lblContent, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        backgroundDialog1Layout.setVerticalGroup(
            backgroundDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundDialog1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(lblContent, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(backgroundDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundDialog1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundDialog1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        messageType = MessageType.CANCEL;
        closeMessage();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        messageType = MessageType.OK;
        closeMessage();
    }//GEN-LAST:event_btnOkActionPerformed

    public static enum MessageType{
        CANCEL, OK
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.BackgroundDialog backgroundDialog1;
    private com.trojasviejas.swing.buttons.ButtonCustom btnCancel;
    private com.trojasviejas.swing.buttons.ButtonCustom btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextPane lblContent;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
