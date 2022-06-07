/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trojasviejas.data.dao;

import com.trojasviejas.data.connectiondb.Conexion;
import com.trojasviejas.models.entity.InvoicesModel;
import com.trojasviejas.models.entity.ProviderModel;
import com.trojasviejas.models.utility.Months;
import com.trojasviejas.models.utility.ProviderType;
import com.trojasviejas.models.viewmodel.InvoicesVM;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cb272
 */
public class InvoicesDao {
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    public ArrayList<InvoicesVM> ListInvoices() {
        InvoicesVM invM = null;
        Connection connection = null;
        CallableStatement query = null;
        ResultSet result = null;

        ArrayList<InvoicesVM> invA = null;

        try {
            connection = Conexion.getConnection();
            invA = new ArrayList<InvoicesVM>();

            query = connection.prepareCall("{call sp_s_invoices()}");
            result = query.executeQuery();

            while (result.next()) {

                invM = new InvoicesVM();

                invM.setId(result.getInt("invc_id"));
                invM.setTotalAmount(result.getDouble("invc_total_amount"));
                invM.setBuyDate(formatter.format((result.getDate("invc_buy_date"))));
                invM.setPicture(result.getBytes("invc_picture"));
                //Solucionar problema con la fk de invoices
                invM.setName(result.getString("prov_name"));
                invM.setAmountItems(result.getInt("dtl_amount"));
                invM.setStock(result.getInt("inventory_stock"));
                
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
    
    public ArrayList<InvoicesVM> ListInvoices(String months, int year) {
        InvoicesVM invM = null;
        Connection connection = null;
        CallableStatement query = null;
        ResultSet result = null;

        ArrayList<InvoicesVM> invA = null;

        try {
            connection = Conexion.getConnection();
            invA = new ArrayList<InvoicesVM>();

            query = connection.prepareCall("{call sp_filter_invoices(?,?)}");
            query.setString(1, months);
            query.setInt(2, year);
            result = query.executeQuery();

            while (result.next()) {

                invM = new InvoicesVM();

                invM.setId(result.getInt("invc_id"));
                invM.setTotalAmount(result.getDouble("invc_total_amount"));
                invM.setBuyDate(formatter.format((result.getDate("invc_buy_date"))));
                invM.setPicture(result.getBytes("invc_picture"));
                //Solucionar problema con la fk de invoices
                invM.setName(result.getString("prov_name"));
                invM.setAmountItems(result.getInt("dtl_amount"));
                invM.setStock(result.getInt("inventory_stock"));
                
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
    
    

    public int getLastIdInvoice() {
        Connection connection = null;
        CallableStatement query = null;
        ResultSet result = null;
        ArrayList<Integer> ids = null;
        int id = 0;
        int index = 0;
        try {
            ids = new ArrayList<>();
            connection = Conexion.getConnection();
            query = connection.prepareCall("SELECT * FROM invoices;");
            result = query.executeQuery();

            
            while (result.next()) {
                ids.add(result.getInt("invc_id"));
            }
            //obtenemos el numero de elementos
            index = ids.size();
            //restamos uno para que coincida con el ultimo indice del arreglo y retornamos el id
            id = ids.get(index - 1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido retornar el id de la última factura. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Conexion.close(query);
                Conexion.close(connection);
                Conexion.close(result);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return id;
    }
    
    public String SelectNameProvWfk(int id) {
        Connection connection = null;
        CallableStatement query = null;
        ResultSet result = null;
        //ArrayList<String> nameA = null;
        String name = "";
        try {
            //nameA = new ArrayList<String>();
            connection = Conexion.getConnection();
            query = connection.prepareCall("select prov_name from Providers where prov_id = " + id);
            result = query.executeQuery();

            while (result.next()) {
                //nameA.add(result.getString("prov_name"));
                name = result.getString("prov_name");
            }
            //return nameA.toString();

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
        return name;
    }

    public void AddInvoice(InvoicesModel invM) {

        Connection connection = null;
        CallableStatement query = null;

        try {
            connection = Conexion.getConnection();
            query = connection.prepareCall("{call sp_i_invoices(?,?,?,?)}");

            query.setDouble(1, invM.getTotalAmount());
            query.setDate(2, new java.sql.Date(invM.getBuyDate().getTime()));
            query.setBytes(3, invM.getPicture());
            //query.setBytes(3, null);
            query.setInt(4, invM.getFkProv());
            query.execute();

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
            query.setDate(3, new java.sql.Date(invM.getBuyDate().getTime()));
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
