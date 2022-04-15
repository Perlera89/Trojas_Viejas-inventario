package com.trojasviejas.component.login;

import com.trojasviejas.swing.login.Button;
import com.trojasviejas.swing.login.ButtonOutline;
import com.trojasviejas.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class PanelCover extends javax.swing.JPanel {
    
    private final DecimalFormat df = new DecimalFormat("##0.###");
    final ImageIcon imagenLogo = new ImageIcon("/Users/perlera/Documents/GitHub/Trojas_Viejas-inventario/TrojasViejas/src/main/src/isotipo.png");
    private ActionListener event;
    private MigLayout layout;
    private JLabel lblLogo;
    private JLabel title;
    private JLabel description;
    private JLabel slogan;
    private ButtonOutline button;
    private Button btnClose;
    private boolean isLogin;
    
    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]","push[]10[]10[]20[]10[]push");
        setLayout(layout);
        init();
        btnCloseActionPerformed();
    }
    
    private void btnCloseActionPerformed(){
        ActionListener eventoAccion = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aqui va ir el codigo de accion
            }
            
        };
        
        btnClose.addActionListener(eventoAccion);
    }
    
    private void init(){
        lblLogo = new JLabel();
        lblLogo.setSize(200, 200);
        lblLogo.setIcon(new ImageIcon(imagenLogo.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH)));
        add(lblLogo);
        
        title = new JLabel("Trojas Viejas");
        title.setFont(new Font("Norwester", 1, 40));
        title.setForeground(new Color(232, 241, 242));
        add(title);
        
        slogan = new JLabel("Inventario");
        slogan.setFont(new Font("Anton", 0, 18));
        slogan.setForeground(new Color(232, 241, 242));
        add(slogan);
        
        description = new JLabel("Iniciar sesion con una cuenta existente");
        description.setFont(new Font("Roboto", 0, 14));
        description.setForeground(new Color(232, 241, 242));
        add(description);
        
        button = new ButtonOutline();
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(new Color(255, 255, 255));
        button.setText("Inicia sesion");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.actionPerformed(e);
            }
        });
        
        add(button, "w 60%, h 40");
        
        btnClose = new Button();
        btnClose.setBackground(Color.red);
        btnClose.setForeground(Color.white);
        btnClose.setFont(new Font("Roboto", 1, 14));
        btnClose.setText("Salir");
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        add(btnClose, "w 30%, h 10");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(0, 0, new Color(27, 152, 224), 0, getHeight(), new Color(19, 41, 61));
        g2.setPaint(gradient);
        g2.fillRect(0, 0, getWidth(), getHeight());
        
        super.paintComponent(g); 
    }
    
    public void addEvent(ActionListener event){
        this.event = event;
    }
    
    public void registerLeft(double valor){
        valor = Double.valueOf(df.format(valor));
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + valor + "% 0 0");
        layout.setComponentConstraints(description, "pad 0 -" + valor + "% 0 0");
        layout.setComponentConstraints(slogan, "pad 0 -" + valor + "% 0 0");
    }
    
    public void registerRight(double valor){
        valor = Double.valueOf(df.format(valor));
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + valor + "% 0 0");
        layout.setComponentConstraints(description, "pad 0 -" + valor + "% 0 0");
        layout.setComponentConstraints(slogan, "pad 0 -" + valor + "% 0 0");
    }
    
    public void loginLeft(double valor){
        valor = Double.valueOf(df.format(valor));
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + valor + "% 0 "+valor+"%");
        layout.setComponentConstraints(description, "pad 0 " + valor + "% 0 "+valor+"%");
        layout.setComponentConstraints(slogan, "pad 0 " + valor + "% 0 "+valor+"%");
    }
    
    public void loginRight(double valor){
        valor = Double.valueOf(df.format(valor));
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + valor + "% 0 "+valor+"%");
        layout.setComponentConstraints(description, "pad 0 " + valor + "% 0 "+valor+"%");
        layout.setComponentConstraints(slogan, "pad 0 " + valor + "% 0 "+valor+"%");
        
    }
    
    private void login(boolean login){
        if(this.isLogin != login){
            if(login){
                title.setText("Trojas Viejas");
                slogan.setText("Inventario");
                description.setText("Crea una nueva cuenta y registrate");
                button.setText("Registrate");
            } else{
                title.setText("Trojas Viejas");
                slogan.setText("Inventario");
                description.setText("Iniciar sesion con una cuenta existente");
                button.setText("Inicia sesion");
            }
            
            this.isLogin = login;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
