package com.trojasviejas.data.dao;

import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.component.login.MessageSuccessDialog;
import com.trojasviejas.data.connectiondb.Conexion;
import com.trojasviejas.models.utility.CategoryType;
import com.trojasviejas.models.utility.ItemType;
import com.trojasviejas.models.viewmodel.InventoryVM;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;

public class InventoryDao{

    //variable para almacenar para la conexion
    Connection connection = null;
    MessageErrorDialog errorMessage = new MessageErrorDialog(new JFrame());
    MessageSuccessDialog successMessage = new MessageSuccessDialog(new JFrame());

    public ArrayList<InventoryVM> list() {
        
        ArrayList<InventoryVM> inventories = null;
        InventoryVM inventory;
        
        CallableStatement query = null;
        ResultSet result = null;
        
        try {
            inventories = new ArrayList<>();
            //abriendo conexion
            connection = Conexion.getConnection();
       
            //preparando la consulta
            query =  connection.prepareCall("{call sp_s_inventories()}");
            
            //ejecutando y almacenado el resultado
            result = query.executeQuery();
            
            //cargando los datos en una array           
            while (result.next()) {                
                inventory = new InventoryVM();
                inventory.setId(result.getInt("inventory_id"));
                inventory.setAmount(result.getInt("dtl_amount"));
                inventory.setItem(result.getString("item_name"));
                inventory.setStock(result.getInt("inventory_stock"));
                inventory.setPricePerUnit(result.getDouble("dtl_price_per_unit"));
                inventory.setMinimunAmount(result.getInt("item_minimun_amount"));
                inventory.setCategory(CategoryType.values()[result.getInt("item_cat")-1]);
                inventory.setType(ItemType.values()[result.getInt("item_tp")-1]);
                inventory.setBuyDate(result.getDate("invc_buy_date"));
                
                inventories.add(inventory);
                
            }
            
        
        } catch (SQLException e) {
            errorMessage.showMessage("ERROR", "No se ha podido mostrar el inventario. \n" + e.toString());
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException ex) {
               errorMessage.showMessage("ERROR", "No se ha cerrado la conexión");
            }
            
        }
        //retornando el array
        return inventories;

    }

    public ArrayList<InventoryVM> findBy(String search_string) {
        //sp_find_inventories
            
        ArrayList<InventoryVM> inventories = null;
        InventoryVM inventory;
        
        CallableStatement query = null;
        ResultSet result = null;
        
        try {
            inventories = new ArrayList<>();
            //abriendo conexion
            connection = Conexion.getConnection();
       
            //preparando la consulta
            query =  connection.prepareCall("{call sp_find_inventories(?)}");
            
            //agregando a proc la cadena de busqueda
            query.setString(1, search_string);
            
            //ejecutando y almacenado el resultado
            result = query.executeQuery();
            
            //cargando los datos en una array           
            while (result.next()) {                
                inventory = new InventoryVM();
                inventory.setId(result.getInt("inventory_id"));
                inventory.setAmount(result.getInt("dtl_amount"));
                inventory.setItem(result.getString("item_name"));
                inventory.setStock(result.getInt("inventory_stock"));
                inventory.setPricePerUnit(result.getDouble("dtl_price_per_unit"));
                inventory.setMinimunAmount(result.getInt("item_minimun_amount"));
                inventory.setCategory(CategoryType.values()[result.getInt("item_cat")-1]);
                inventory.setType(ItemType.values()[result.getInt("item_tp")-1]);
                inventory.setBuyDate(result.getDate("invc_buy_date"));
                
                inventories.add(inventory);
            }
            
        
        } catch (SQLException e) {
            errorMessage.showMessage("ERROR", "No se ha podido mostrar el inventario. \n" + e.toString());
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException ex) {
               errorMessage.showMessage("ERROR","No se ha cerrado la conexión");
            }
            
        }
        //retornando el array
        return inventories;
    }
    
}
