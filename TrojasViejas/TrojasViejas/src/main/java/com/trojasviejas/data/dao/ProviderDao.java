/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trojasviejas.data.dao;

import com.trojasviejas.data.connectiondb.Conexion;
import com.trojasviejas.models.entity.ProviderModel;
import com.trojasviejas.models.utility.ProviderType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cb272
 */
public class ProviderDao {

    public ArrayList<ProviderModel> ListProviders() {
        ProviderModel provM = null;
        Connection connection = null;
        CallableStatement query = null;
        ResultSet result = null;

        ArrayList<ProviderModel> aLProvM = null;

        try {
            connection = Conexion.getConnection();
            aLProvM = new ArrayList<ProviderModel>();

            query = connection.prepareCall("{call sp_s_providers()}");
            result = query.executeQuery();

            while (result.next()) {

                provM = new ProviderModel();

                provM.setId(result.getInt("prov_id"));
                provM.setName(result.getString("prov_name"));
                provM.setNumberPhone(result.getString("prov_num_phone"));
                provM.setEmail(result.getString("prov_email"));
                provM.setAddress(result.getString("prov_direction"));
                provM.setType(ProviderType.values()[result.getInt("prov_tp") - 1]);
                //provM.setType(ProviderType.COMERCIAL);
                aLProvM.add(provM);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se han podido mostrar los proveedores. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return aLProvM;
    }

    public void AddProvider(ProviderModel provM) {

        Connection connection = null;
        CallableStatement query = null;

        try {
            connection = Conexion.getConnection();
            query = connection.prepareCall("{call sp_i_providers(?,?,?,?,?)}");

            query.setString(1, provM.getName());
            query.setString(2, provM.getNumberPhone());
            query.setString(3, provM.getEmail());
            query.setString(4, provM.getAddress());
            query.setInt(5, provM.getType().ordinal() + 1);
            query.execute();

            JOptionPane.showMessageDialog(null, "Agregado exitosamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido agregar el proveedor. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void UpdateProvider(ProviderModel provM) {

        Connection connection = null;
        CallableStatement query = null;
        try {
            connection = Conexion.getConnection();
            query = connection.prepareCall("{call sp_u_providers(?, ?, ?, ?, ?, ?)}");

            query.setInt(1, provM.getId());
            query.setString(2, provM.getName());
            query.setString(3, provM.getNumberPhone());
            query.setString(4, provM.getEmail());
            query.setString(5, provM.getAddress());
            query.setInt(6, provM.getType().ordinal() + 1);
            query.execute();

            JOptionPane.showMessageDialog(null, "Actualizado exitosamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar el proveedor. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {

                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void DeleteProvider(int id) {

        Connection connection = null;
        CallableStatement query = null;

        try {
            connection = Conexion.getConnection();
            query = connection.prepareCall("call sp_d_providers(?)");

            query.setInt(1, id);
            query.execute();
            JOptionPane.showMessageDialog(null, "Eliminado exitosamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se han podido eliminar el proveedor. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {

                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

}
