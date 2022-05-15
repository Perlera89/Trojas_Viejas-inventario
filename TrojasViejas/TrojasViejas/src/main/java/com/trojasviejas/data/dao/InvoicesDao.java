/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trojasviejas.data.dao;

import com.trojasviejas.data.connectiondb.Conexion;
import com.trojasviejas.models.entity.InvoicesModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cb272
 */
public class InvoicesDao {
    
    
//    public ArrayList<ItemModel> ListItems() {
//        ItemModel item = null;
//        Connection connection = null;
//        CallableStatement query = null;
//        ResultSet result = null;
//
//        ArrayList<ItemModel> items = null;
//
//        try {
//            connection = Conexion.getConnection();
//            items = new ArrayList<ItemModel>();
//
//            query = connection.prepareCall("{call sp_s_items()}");
//            result = query.executeQuery();
//
//            while (result.next()) {
//                
//                item = new ItemModel();
//                
//                item.setIdItem(result.getInt("item_id"));
//                item.setName(result.getString("item_name"));
//                item.setCategory(CategoryType.values()[result.getInt("item_cat") - 1]);
//                item.setMinimunAmount(result.getInt("item_minimun_amount"));
//                item.setDescription(result.getString("item_description"));
//                item.setType(ItemType.values()[result.getInt("item_tp") - 1]);
//
//                items.add(item);
//            }
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "No se han podido mostrar los articulos. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
//        } finally {
//            try {
//                Conexion.close(result);
//                Conexion.close(query);
//                Conexion.close(connection);
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//
//        return items;
//    }
//    
    public void AddInvoice(InvoicesModel InvM){
        Connection connection = null;
        CallableStatement query = null;
        
        try {
            connection = Conexion.getConnection();
            query = connection.prepareCall("{call sp_i_invoices(?,?,?,?)}");


            query.setDouble(1, InvM.getTotalAmount());
            query.setString(2, InvM.getBuyDate());
            query.setBytes(3, InvM.getPicture());
            query.setInt(4, InvM.getFkProv()); //fk de proveedores
            query.execute();
            
            JOptionPane.showMessageDialog(null, "Agregado exitosamente.");
       
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido agregar el articulo. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
     finally {
            try {
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void UpdateItems(InvoicesModel invM) {

        Connection connection = null;
        CallableStatement query = null;
        try {
            connection = Conexion.getConnection();
            query = connection.prepareCall("{call sp_u_invoices(?, ?, ?, ?, ?)}");


            query.setInt(1, invM.getId());
            query.setDouble(2, invM.getTotalAmount());
            query.setString(3, invM.getBuyDate());
            query.setBytes(4, invM.getPicture());
            query.setInt(5, invM.getFkProv());
            query.execute();

            JOptionPane.showMessageDialog(null, "Actualizado exitosamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar la facturaa. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            try {
           
            Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
     public void DeleteItem(int id){
     
     
        Connection connection = null;
        CallableStatement query = null;
    
        try {
            connection = Conexion.getConnection();
            query = connection.prepareCall("call sp_d_invoices(?)");

             query.setInt(1, id);
             query.execute();
            JOptionPane.showMessageDialog(null, "Eliminado exitosamente.");

         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "No se han podido eliminar la factura. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
         }
        finally {
            try {
 
            Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }
}
