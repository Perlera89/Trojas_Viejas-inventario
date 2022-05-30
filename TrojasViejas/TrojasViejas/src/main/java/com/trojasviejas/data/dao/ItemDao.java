package com.trojasviejas.data.dao;

import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.data.connectiondb.Conexion;
import com.trojasviejas.demo.form.FrmLogin;
import com.trojasviejas.models.entity.ItemModel;
import com.trojasviejas.models.utility.CategoryType;
import com.trojasviejas.models.utility.ItemType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ItemDao {
 MessageErrorDialog dialogResult = new MessageErrorDialog(new FrmLogin());
 
    public ArrayList<ItemModel> ListItems() {
        ItemModel item = null;
        Connection connection = null;
        CallableStatement query = null;
        ResultSet result = null;

        ArrayList<ItemModel> items = null;

        try {
            connection = Conexion.getConnection();
            items = new ArrayList<>();

            query = connection.prepareCall("{call sp_s_items()}");
            result = query.executeQuery();

            while (result.next()) {

                item = new ItemModel();

                item.setIdItem(result.getInt("item_id"));
                item.setName(result.getString("item_name"));
                item.setCategory(CategoryType.values()[result.getInt("item_cat") - 1]);
                item.setMinimunAmount(result.getInt("item_minimun_amount"));
                item.setDescription(result.getString("item_description"));
                item.setType(ItemType.values()[result.getInt("item_tp") - 1]);

                items.add(item);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se han podido mostrar los articulos. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return items;
    }

    public void AddItem(ItemModel itemM) {

        Connection connection = null;
        CallableStatement query = null;

        try {
            connection = Conexion.getConnection();
            query = connection.prepareCall("{call sp_i_items(?,?,?,?,?)}");

            query.setString(1, itemM.getName());
            query.setString(2, itemM.getDescription());
            query.setInt(3, itemM.getMinimunAmount());
            query.setInt(4, itemM.getCategory().ordinal() + 1);
            query.setInt(5, itemM.getType().ordinal() + 1);
            query.execute();

            JOptionPane.showMessageDialog(null, "Agregado exitosamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido agregar el articulo. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void UpdateItems(ItemModel itemM) {

        Connection connection = null;
        CallableStatement query = null;
        try {
            connection = Conexion.getConnection();
            query = connection.prepareCall("{call sp_u_items(?, ?, ?, ?, ?, ?)}");
            
            query.setInt(1, itemM.getIdItem());
            query.setString(2, itemM.getName());
            query.setString(3, itemM.getDescription());
            query.setInt(4, itemM.getMinimunAmount());
            query.setInt(5, itemM.getCategory().ordinal() + 1);
            query.setInt(6, itemM.getType().ordinal() + 1);
            query.execute();

            JOptionPane.showMessageDialog(null, "Actualizado exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar el articulo. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {

                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void DeleteItem(int id) {

        Connection connection = null;
        CallableStatement query = null;

        try {
            connection = Conexion.getConnection();
            query = connection.prepareCall("call sp_d_items(?)");

            query.setInt(1, id);
            query.execute();
            JOptionPane.showMessageDialog(null, "Eliminado exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se han podido eliminar el articulo. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {

                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    public ArrayList<ItemModel> findItem(String search_string) {

        ItemModel item = null;
        Connection connection = null;
        CallableStatement query = null;
        ResultSet result = null;

        ArrayList<ItemModel> items = null;

        try {
            connection = Conexion.getConnection();

            items = new ArrayList<>(); //entiende el tipo que es

            query = connection.prepareCall("{call sp_find_items(?)}");
            
            query.setString(1, search_string);
            
            result = query.executeQuery();

            while (result.next()) {

                item = new ItemModel();

                item.setIdItem(result.getInt("item_id"));
                item.setName(result.getString("item_name"));
                item.setCategory(CategoryType.values()[result.getInt("item_cat") - 1]);
                item.setMinimunAmount(result.getInt("item_minimun_amount"));
                item.setDescription(result.getString("item_description"));
                item.setType(ItemType.values()[result.getInt("item_tp") - 1]);

                items.add(item);
            }

        } catch (SQLException e) {
            dialogResult.showMessage("ERROR", "No se pudo mostrar los articulos. \n" + e.toString());
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                dialogResult.showMessage(null, "No se ha cerrado la conexión");
            }
        }

        return items;

    }
}
