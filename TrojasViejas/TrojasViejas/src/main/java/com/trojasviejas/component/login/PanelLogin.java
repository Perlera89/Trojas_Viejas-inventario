package com.trojasviejas.component.login;

import com.trojasviejas.models.entity.UserModel;
import com.trojasviejas.swing.buttons.Button;
import com.trojasviejas.swing.fields.MyPasswordField;
import com.trojasviejas.swing.fields.MyTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class PanelLogin extends javax.swing.JLayeredPane {
    
    private UserModel user;
    
    public UserModel getUser(){
        return user;
    }
    
    public PanelLogin(ActionListener eventRegister) {
        initComponents();
        initRegister(eventRegister);
        initLogin();
        pnlLogin.setVisible(false);
        pnlRegister.setVisible(true);
    }
    
    private void initRegister(ActionListener eventRegister){
        pnlRegister.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        
        JLabel title = new JLabel("Crear una cuenta");
        title.setFont(new Font("Norwester", 1, 30));
        title.setForeground(new Color(0, 100, 148));
        pnlRegister.add(title);
        
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/img/user.png")));
        txtUser.setHint("Nombre");
        pnlRegister.add(txtUser, "w 60%");
        
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/img/pass.png")));
        txtPass.setHint("Contrase\u00f1a");
        pnlRegister.add(txtPass, "w 60%");
        
        MyPasswordField txtConfirmPass = new MyPasswordField();
        txtConfirmPass.setPrefixIcon(new ImageIcon(getClass().getResource("/img/pass.png")));
        txtConfirmPass.setHint("Confirmar contrase\u00f1a");
        pnlRegister.add(txtConfirmPass, "w 60%");
        
        Button btnRegister = new Button();
        btnRegister.setBackground(new Color(0, 100, 148));
        btnRegister.setForeground(new Color(250, 250, 250));
        btnRegister.addActionListener(eventRegister);
        btnRegister.setText("Registrarse");
        pnlRegister.add(btnRegister, "w 40%, h 40");
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aqui va el codigo para el registro
                System.out.println("Registrado");
            }
        });
        
        txtUser.requestFocus();
    }
    
    private void initLogin(){
        pnlLogin.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        
        JLabel title = new JLabel("Iniciar sesion");
        title.setFont(new Font("Norwester", 1, 30));
        title.setForeground(new Color(0, 100, 148));
        pnlLogin.add(title);
        
        MyTextField txtLoginUser = new MyTextField();
        txtLoginUser.setPrefixIcon(new ImageIcon(getClass().getResource("/img/user.png")));
        txtLoginUser.setHint("Nombre");
        pnlLogin.add(txtLoginUser, "w 60%");
        
        MyPasswordField txtLoginPass = new MyPasswordField();
        txtLoginPass.setPrefixIcon(new ImageIcon(getClass().getResource("/img/pass.png")));
        txtLoginPass.setHint("Contrase\u00f1a");
        pnlLogin.add(txtLoginPass, "w 60%");
        
        
        JButton btnForget = new JButton("¿Olvidaste tu contrase\u00f1a?");
        btnForget.setForeground(new Color(100, 100, 100));
        btnForget.setFont(new Font("Roboto", 0, 14));
        btnForget.setContentAreaFilled(false);
        btnForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlLogin.add(btnForget);
        btnForget.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aqui va el codigo para recuperar la contraseña
                System.out.println("Registrado");
            }
        });
        
        Button btnLogin = new Button();
        btnLogin.setBackground(new Color(0, 100, 148));
        btnLogin.setForeground(new Color(250, 250, 250));
        btnLogin.setText("Iniciar sesion");
        pnlLogin.add(btnLogin, "w 40%, h 40");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aqui va el codigo para el logueo
                System.out.println("Logueado");
            }
        });
        
        txtLoginUser.requestFocus();
    }
    
    public void showRegister(boolean isShow){
        if(isShow){
            pnlRegister.setVisible(true);
            pnlLogin.setVisible(false);
        } else{
            pnlRegister.setVisible(false);
            pnlLogin.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        pnlRegister = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        pnlLogin.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(pnlLogin, "card3");

        pnlRegister.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlRegisterLayout = new javax.swing.GroupLayout(pnlRegister);
        pnlRegister.setLayout(pnlRegisterLayout);
        pnlRegisterLayout.setHorizontalGroup(
            pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pnlRegisterLayout.setVerticalGroup(
            pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(pnlRegister, "card2");
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlRegister;
    // End of variables declaration//GEN-END:variables
}
