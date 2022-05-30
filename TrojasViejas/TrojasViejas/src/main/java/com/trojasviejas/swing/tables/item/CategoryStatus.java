package com.trojasviejas.swing.tables.item;

import com.trojasviejas.models.utility.*;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

public class CategoryStatus extends JLabel {

    public CategoryType getType() {
        return type;
    }

    public CategoryStatus() {
        setForeground(Color.WHITE);
    }

    private CategoryType type;

    public void setType(CategoryType type) {
        this.type = type;
        setText(type.toString());
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        if (type != null) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint g;
            if (type == CategoryType.HERRAMIENTAS) {
                g = new GradientPaint(0, 0, new Color(255,123,0), 0, getHeight(), new Color(255,136,0));
            }  else {
                g = new GradientPaint(0, 0, new Color(27,67,50), 0, getHeight(), new Color(45,106,79));
            }
            
            g2.setPaint(g);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 1, 1);
        }
        super.paintComponent(grphcs);
    }
}