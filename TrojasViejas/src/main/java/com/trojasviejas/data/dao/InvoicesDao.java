/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trojasviejas.data.dao;

import com.mysql.cj.jdbc.exceptions.PacketTooBigException;
import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.component.login.MessageSuccessDialog;
import com.trojasviejas.data.connectiondb.Conexion;
import com.trojasviejas.models.entity.InvoicesModel;
import com.trojasviejas.models.viewmodel.InvoicesVM;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author cb272
 */
public class InvoicesDao {
    
    MessageErrorDialog errorMessage = new MessageErrorDialog(new JFrame());
    MessageSuccessDialog successMessage = new MessageSuccessDialog(new JFrame());
    
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    public ArrayList<InvoicesVM> ListInvoices() {
        InvoicesVM invM = null;
        Connection connection = null;
        CallableStatement query = null;
        ResultSet result = null;

        ArrayList<InvoicesVM> invA = null;

        try {
            connection = Conexion.getConnection();
            invA = new ArrayList<>();

            query = connection.prepareCall("{call sp_s_invoices()}");
            result = query.executeQuery();

            while (result.next()) {

                invM = new InvoicesVM();

                invM.setId(result.getInt("invc_id"));
                invM.setTotalAmount(result.getString("invc_total_amount"));
                invM.setBuyDate(formatter.format((result.getDate("invc_buy_date"))));
                invM.setPicture(result.getBytes("invc_picture"));
                //Solucionar problema con la fk de invoices
                invM.setName(result.getString("prov_name"));
                invM.setAmountItems(result.getInt("dtl_amount"));
                invM.setStock(result.getInt("inventory_stock"));
                
                invA.add(invM);
            }

        } catch (Exception e) {
            errorMessage.showMessage("ERROR", "No se han podido mostrar las facturas. \n" + e.toString());
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                errorMessage.showMessage("ERROR","No se ha cerrado la conexión correctamente. \n" + e.toString());
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
            invA = new ArrayList<>();

            query = connection.prepareCall("{call sp_filter_invoices(?,?)}");
            query.setString(1, months);
            query.setInt(2, year);
            result = query.executeQuery();

            while (result.next()) {

                invM = new InvoicesVM();

                invM.setId(result.getInt("invc_id"));
                invM.setTotalAmount(result.getString("invc_total_amount"));
                invM.setBuyDate(formatter.format((result.getDate("invc_buy_date"))));
                invM.setPicture(result.getBytes("invc_picture"));
                //Solucionar problema con la fk de invoices
                invM.setName(result.getString("prov_name"));
                invM.setAmountItems(result.getInt("dtl_amount"));
                invM.setStock(result.getInt("inventory_stock"));
                
                invA.add(invM);
            }

        } catch (Exception e) {
            errorMessage.showMessage("ERROR","No se han podido mostrar las facturas. \n" + e.toString());
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                errorMessage.showMessage("ERROR", "No se ha cerrado la conexión");
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
            errorMessage.showMessage("ERROR", "No se ha podido retornar el id de la última factura. \n" + e.toString());
        } finally {
            try {
                Conexion.close(query);
                Conexion.close(connection);
                Conexion.close(result);
            } catch (SQLException e) {
                errorMessage.showMessage("ERROR", "No se ha cerrado la conexión");
            }
        }
        return id;
    }

    public Boolean AddInvoice(InvoicesModel invM) {

        Connection connection = null;
        CallableStatement query = null;
        Boolean validatePicture = false;

        try {
            connection = Conexion.getConnection();
            query = connection.prepareCall("{call sp_i_invoices(?,?,?,?)}");
            query.setDouble(1, invM.getTotalAmount());
            query.setDate(2, new java.sql.Date(invM.getBuyDate().getTime()));
            query.setBytes(3, invM.getPicture());
            query.setInt(4, invM.getFkProv());
            query.execute();
            
            validatePicture = true;
        } catch (Exception e) {
            validatePicture = false;
            try {
                PacketTooBigException pk = (PacketTooBigException) e;
                validatePicture = false;
                errorMessage.showMessage("ERROR","El tamaño de la foto es demaciado grande, ingrese una de menor tamaño.\n" + e.toString());
            } catch (Exception ex) {
             errorMessage.showMessage("ERROR", "No se ha podido agregar la factura.\n" + ex.toString());               
            }
            errorMessage.showMessage("ERROR","No se ha podido agregar la factura. El proceso se reiniciará nuevamente. \n" + e.toString());
        } finally {
            try {
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                errorMessage.showMessage("ERROR", "No se ha cerrado la conexión");
            }
        }
        return validatePicture;

    }


    public void DeleteInvoice(int id) {

        Connection connection = null;
        CallableStatement query = null;

        try {
            connection = Conexion.getConnection();
            query = connection.prepareCall("{call sp_d_invoices(?)}");

            query.setInt(1, id);
            query.execute();
            successMessage.showMessage("ÉXITO", "Eliminado exitosamente.");

        } catch (Exception e) {
            errorMessage.showMessage("ERROR", "No se han podido eliminar la factura. \n" + e.toString());
        } finally {
            try {
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                errorMessage.showMessage("ERROR", "No se ha cerrado la conexión");
            }

        }

    }
    
   
    
}
