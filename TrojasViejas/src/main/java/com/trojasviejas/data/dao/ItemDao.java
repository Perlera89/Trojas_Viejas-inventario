package com.trojasviejas.data.dao;

import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.component.login.MessageSuccessDialog;
import com.trojasviejas.data.connectiondb.Conexion;
import com.trojasviejas.models.entity.ItemModel;
import com.trojasviejas.models.utility.CategoryType;
import com.trojasviejas.models.utility.ItemType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import javax.swing.JFrame;

public class ItemDao {
    MessageErrorDialog errorMessage = new MessageErrorDialog(new JFrame());
    MessageSuccessDialog successMessage = new MessageSuccessDialog(new JFrame());
 
    public ArrayList<ItemModel> ListItems(int state) {
        ItemModel item = null;
        Connection connection = null;
        CallableStatement query = null;
        ResultSet result = null;

        ArrayList<ItemModel> items = null;

        try {
            connection = Conexion.getConnection();
            items = new ArrayList<>();

            query = connection.prepareCall("{call sp_s_items(?)}");
            query.setInt(1, state);
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
            errorMessage.showMessage("ERROR", "No se ha podido mostrar los articulos. \n" + e.toString());
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                errorMessage.showMessage("ERROR", "No se ha cerrado la conexión correctamente.");
            }
        }

        return items;
    }

    public void AddItem(ItemModel itemM) {

        Connection connection = null;
        CallableStatement query = null;

        try {
            connection = Conexion.getConnection();
            query = connection.prepareCall("{call sp_i_items(?,?,?,?,?,?)}");

            query.setString(1, itemM.getName());
            query.setString(2, itemM.getDescription());
            query.setInt(3, itemM.getMinimunAmount());
            query.setInt(4, itemM.getCategory().ordinal() + 1);
            query.setInt(5, itemM.getType().ordinal() + 1);
            query.setInt(6, 1);
            
            query.execute();

            successMessage.showMessage("ÉXITO", "El artículo "+itemM.getName()+" ha sido agregado exitosamente.");

        } catch (Exception e) {
            errorMessage.showMessage("ERROR", "No se ha podido agregar el articulo. \n" + e.toString());
        } finally {
            try {
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                errorMessage.showMessage("ERROR", "No se ha cerrado la conexión correctamente.");
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

            successMessage.showMessage("ÉXITO", "Artículo actualizado exitosamente.");

        } catch (SQLException e) {
            errorMessage.showMessage("ERROR", "No se ha podido actualizar el articulo. \n" + e.toString());
        } finally {
            try {

                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                errorMessage.showMessage("ERROR",  "No se ha cerrado la conexión correctamente.");
            }

        }
    }

    public void changeStateInItem(int id, int state) {

        Connection connection = null;
        CallableStatement query = null;

        try {
            connection = Conexion.getConnection();
            query = connection.prepareCall("{call sp_change_state_items(?,?)}");

            query.setInt(1, id);
            query.setInt(2, state);
            query.execute();
            successMessage.showMessage("ÉXITO",  "Datos de estado actualizados exitosamente.");

        } catch (SQLException e) {
             try{
                SQLIntegrityConstraintViolationException ex = (SQLIntegrityConstraintViolationException) e;
                errorMessage.showMessage("ERROR", "Este artículo está siendo referenciado en una o más facturas. "
                        + "Puede actualizar sus datos, no eliminarlo. \n" + ex.toString());
            }catch(Exception ez){
                errorMessage.showMessage("ERROR", "No se han podido eliminar el articulo. \n" + e.toString());
            }
            
        } finally {
            try {
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                errorMessage.showMessage("ERROR", "No se ha cerrado la conexión correctamente.");
            }

        }

    }

    public ArrayList<ItemModel> findItem(String search_string, int state) {

        ItemModel item = null;
        Connection connection = null;
        CallableStatement query = null;
        ResultSet result = null;

        ArrayList<ItemModel> items = null;

        try {
            connection = Conexion.getConnection();

            items = new ArrayList<>(); //entiende el tipo que es

            query = connection.prepareCall("{call sp_find_items(?,?)}");         
            query.setString(1, search_string);
            query.setInt(2, state);
            
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
            errorMessage.showMessage("ERROR", "No se pudo mostrar los articulos. \n" + e.toString());
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                errorMessage.showMessage("ERROR", "No se ha cerrado la conexión correctamente.");
            }
        }

        return items;

    }
}
