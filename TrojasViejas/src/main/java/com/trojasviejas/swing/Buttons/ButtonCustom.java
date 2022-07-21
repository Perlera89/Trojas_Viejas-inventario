package com.trojasviejas.swing.Buttons;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonCustom  extends JButton{
    
    private Color background = new Color(69, 191, 71);
    private Color colorHover = new Color(76, 206, 78);
    private Color colorPressed = new Color(63, 175, 65);
    private boolean mouseOver = false;
    
    public ButtonCustom(){
        initComponents();
    }
    
    private void initComponents(){
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(background);
        setForeground(Color.white);
        setOpaque(true);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
                ButtonCustom.super.setBackground(getColorHover());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ButtonCustom.super.setBackground(getColorPressed());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(mouseOver){
                    ButtonCustom.super.setBackground(getColorHover());
                } else{
                    ButtonCustom.super.setBackground(background);
                }
            }    
        });
    }
    
    @Override
    public void setBackground(Color bg){
        background = bg;
        super.setBackground(bg);
    }
    
    public Color getColorHover(){
        return colorHover;
    }
    
    public void setColorHover(Color colorHover){
        this.colorHover = colorHover;
    }
    
    public Color getColorPressed(){
        return colorPressed;
    }
    
    public void setColorPressed(Color colorPressed){
        this.colorPressed = colorPressed;
    }
}
