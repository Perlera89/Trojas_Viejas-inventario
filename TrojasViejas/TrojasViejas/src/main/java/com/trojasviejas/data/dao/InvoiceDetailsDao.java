/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trojasviejas.data.dao;

import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.data.connectiondb.Conexion;
import com.trojasviejas.models.entity.InvoiceDetailsModel;
import com.trojasviejas.models.viewmodel.InvoiceDetailsVM;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author wilian
 */
public class InvoiceDetailsDao {
    //mensajes personalizados
    MessageErrorDialog message = new MessageErrorDialog(new JFrame());
    //variable para establecer una conexion a la db
    Connection connection = null;
    
    public ArrayList<InvoiceDetailsVM> list(int idFactura){
       
        ArrayList<InvoiceDetailsVM> invoiceDetalis = null;
        CallableStatement query = null;
        ResultSet result = null;
        
        try {
            connection = Conexion.getConnection();
            invoiceDetalis = new ArrayList<>();
            //preparando la consulta
            query = connection.prepareCall("{call sp_s_invoice_details(?)}");
            query.setInt(1, idFactura);
            //ejecutando la consulta y almacenando el resultado
            result = query.executeQuery();

            while (result.next()) {                
                invoiceDetalis.add(new InvoiceDetailsVM(
                        result.getInt("dtl_id"),
                        result.getInt("dtl_amount"),
                        result.getString("item_name"),
                        result.getDouble("dtl_price_per_unit"),
                        result.getDouble("dtl_subtotaL"),
                        result.getInt("dtl_invc_id_fk")
                ));
            }
            
            
        } catch (SQLException e) {
                message.showMessage("ERROR", "Ha ocurrido un error al mostrar los detalles de facturas.\n"+e.toString());
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                message.showMessage("ERROR", "Ha ocurrido un error al cerrar las conexiones al mostrar los detalles de facturas.\n"+e.toString());
            }
        }
        return invoiceDetalis;
    }
    
    public void save(InvoiceDetailsModel detail){
         
        CallableStatement query = null;
        
        try {
            connection = Conexion.getConnection();
            //preparando la consulta
            query = connection.prepareCall("{call sp_i_invoice_details(?,?,?,?)}");
            query.setInt(1, detail.getAmount());
            query.setDouble(2, detail.getPricerPerUnit());
            query.setInt(3, detail.getItemFk());
            query.setInt(4, detail.getInvoiceFk());

            //ejecutando la consulta y almacenando el resultado
            query.execute();
            
        } catch (SQLException e) {
                message.showMessage("ERROR", "Ha ocurrido un error al agregar un detalle de factura.\n"+e.toString());
        } finally {
            try {
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                message.showMessage("ERROR", "Ha ocurrido un error al cerrar las conexiones al agregar un detalle de factura.\n"+e.toString());
            }
        }
    }
    
}
