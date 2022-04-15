package com.trojasviejas.component.login;

import com.trojasviejas.swing.login.Button;
import com.trojasviejas.swing.login.MyPasswordField;
import com.trojasviejas.swing.login.MyTextField;
import com.trojasviejas.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class PanelLogin extends javax.swing.JLayeredPane {
    
    public PanelLogin() {
        initComponents();
        initRegister();
        initLogin();
        pnlLogin.setVisible(false);
        pnlRegister.setVisible(true);
    }
    
    private void initRegister(){
        pnlRegister.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        
        JLabel title = new JLabel("Crear una cuenta");
        title.setFont(new Font("Norwester", 1, 30));
        title.setForeground(new Color(0, 100, 148));
        pnlRegister.add(title);
        
        MyTextField txtUser = new MyTextField();
        //txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("../../../../rcs/user.png")));
        txtUser.setHint("Nombre");
        pnlRegister.add(txtUser, "w 60%");
        
        MyPasswordField txtPass = new MyPasswordField();
        //txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/src/main/java/com/trojasviejas/rcs/user.png")));
        txtPass.setHint("Contrase\u00f1a");
        pnlRegister.add(txtPass, "w 60%");
        
        MyPasswordField txtConfirmPass = new MyPasswordField();
        //txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/src/main/java/com/trojasviejas/rcs/user.png")));
        txtConfirmPass.setHint("Confirmar contrase\u00f1a");
        pnlRegister.add(txtConfirmPass, "w 60%");
        
        Button btnRegister = new Button();
        btnRegister.setBackground(new Color(0, 100, 148));
        btnRegister.setForeground(new Color(250, 250, 250));
        btnRegister.setText("Registrarse");
        pnlRegister.add(btnRegister, "w 40%, h 40");
    }
    
    private void initLogin(){
        pnlLogin.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        
        JLabel title = new JLabel("Iniciar sesion");
        title.setFont(new Font("Norwester", 1, 30));
        title.setForeground(new Color(0, 100, 148));
        pnlLogin.add(title);
        
        MyTextField txtLoginUser = new MyTextField();
        //txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/src/main/java/com/trojasviejas/rcs/user.png")));
        txtLoginUser.setHint("Nombre");
        pnlLogin.add(txtLoginUser, "w 60%");
        
        MyPasswordField txtLoginPass = new MyPasswordField();
        //txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/src/main/java/com/trojasviejas/rcs/user.png")));
        txtLoginPass.setHint("Contrase\u00f1a");
        pnlLogin.add(txtLoginPass, "w 60%");
        
        
        JButton btnForget = new JButton("¿Olvidaste tu contrase\u00f1a?");
        btnForget.setForeground(new Color(100, 100, 100));
        btnForget.setFont(new Font("Roboto", 0, 14));
        btnForget.setContentAreaFilled(false);
        btnForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlLogin.add(btnForget);
        
        Button btnLogin = new Button();
        btnLogin.setBackground(new Color(0, 100, 148));
        btnLogin.setForeground(new Color(250, 250, 250));
        btnLogin.setText("Iniciar sesion");
        pnlLogin.add(btnLogin, "w 40%, h 40");
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
