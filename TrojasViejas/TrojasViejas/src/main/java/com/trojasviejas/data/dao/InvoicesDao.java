/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trojasviejas.data.dao;

import com.trojasviejas.data.connectiondb.Conexion;
import com.trojasviejas.models.entity.InvoicesModel;
import com.trojasviejas.models.entity.ProviderModel;
import com.trojasviejas.models.utility.ProviderType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cb272
 */
public class InvoicesDao {
    
    public ArrayList<InvoicesModel> ListInvoices() {
        InvoicesModel invM = null;
        Connection connection = null;
        CallableStatement query = null;
        ResultSet result = null;

        ArrayList<InvoicesModel> invA = null;

        try {
            connection = Conexion.getConnection();
            invA = new ArrayList<InvoicesModel>();

            query = connection.prepareCall("{call sp_s_invoices()}");
            result = query.executeQuery();

            while (result.next()) {

                invM = new InvoicesModel();

                invM.setId(result.getInt("invc_id"));
                invM.setTotalAmount(result.getDouble("invc_total_amount"));
                invM.setBuyDate(result.getString("invc_buy_date"));
                invM.setPicture(result.getBytes("invc_picture"));
                //Solucionar problema con la fk de invoices
                invM.setFkProv(result.getInt("invc_prov_id_fk"));
                
                invA.add(invM);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se han podido mostrar las facturas. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return invA;
    }


    public ArrayList<String> SelectNameProv() {
        Connection connection = null;
        CallableStatement query = null;
        ResultSet result = null;
        ArrayList<String> nameA = null;
        try {
            nameA = new ArrayList<String>();
            connection = Conexion.getConnection();
            query = connection.prepareCall("select prov_name from Providers");
            result = query.executeQuery();

            while (result.next()) {
                nameA.add(result.getString("prov_name"));
            }
            return nameA;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido retornar un proveedor. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Conexion.close(query);
                Conexion.close(connection);
                Conexion.close(result);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }
    
    public String SelectNameProvWfk(int id) {
        Connection connection = null;
        CallableStatement query = null;
        ResultSet result = null;
        ArrayList<String> nameA = null;
        try {
            nameA = new ArrayList<String>();
            connection = Conexion.getConnection();
            query = connection.prepareCall("select prov_name from Providers where prov_id = " + id);
            result = query.executeQuery();

            while (result.next()) {
                nameA.add(result.getString("prov_name"));
            }
            return nameA.toString();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido retornar un proveedor. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Conexion.close(query);
                Conexion.close(connection);
                Conexion.close(result);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    public void AddInvoice(InvoicesModel invM) {

        Connection connection = null;
        CallableStatement query = null;

        try {
            connection = Conexion.getConnection();
            query = connection.prepareCall("{call sp_i_invoices(?,?,?,?)}");

            query.setDouble(1, invM.getTotalAmount());
            query.setString(2, invM.getBuyDate());
            query.setBytes(3, invM.getPicture());
            //query.setBytes(3, null);
            query.setInt(4, invM.getFkProv() + 1);
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

    public void UpdateInvoice(InvoicesModel invM) {

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
        } finally {
            try {

                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void DeleteInvoice(int id) {

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
