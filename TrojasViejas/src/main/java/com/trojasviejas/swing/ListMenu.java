package com.trojasviejas.swing;

import com.trojasviejas.models.MenuModel;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ListMenu<E extends Object> extends JList<E>{
    
    private final DefaultListModel model;
    private int selectedIndex = -1;
    
    public ListMenu(){
        model = new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)){
                    int index = locationToIndex(e.getPoint());
                    Object obj = model.getElementAt(index);
                    if(obj instanceof MenuModel){
                        MenuModel menu = (MenuModel) obj;
                        if(menu.getType() == MenuModel.MenuType.MENU){
                            selectedIndex = index;
                        }
                    } else{
                        selectedIndex = index;
                    }
                    
                    repaint();
                }
            }
            
        });
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean focus) {
                MenuModel data;
                if(value instanceof MenuModel){
                    data = (MenuModel) value;
                } else{
                    data = new MenuModel("", value + "", MenuModel.MenuType.EMPTY);
                }
                
                MenuItem item = new MenuItem(data);
                item.setSelected(selectedIndex == index);
                return item;
            }
            
        };
    }
    
    public void addItem(MenuModel data){
        model.addElement(data);
    }
}
