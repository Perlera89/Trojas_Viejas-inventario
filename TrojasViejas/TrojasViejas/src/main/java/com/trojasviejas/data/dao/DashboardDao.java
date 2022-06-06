/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trojasviejas.data.dao;

import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.data.connectiondb.Conexion;
import com.trojasviejas.models.utility.InvoicesAverageReport;
import com.trojasviejas.models.utility.PurchaseReport;
import com.trojasviejas.models.utility.TypeRegisterReport;
import com.trojasviejas.models.utility.ActionType;
import com.trojasviejas.models.utility.Months;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Willian
 */
public class DashboardDao {
    //mensajes personalizados
    MessageErrorDialog message = new MessageErrorDialog(new JFrame());
    
    //variable para la conexion
    Connection connection = null;
 
    /*=========================REPORDE DE FACTURAS===================================================================*/
    public ArrayList<PurchaseReport> reportPurchases(int year){
        
        //variable para preparar la consulta
        CallableStatement query = null;
        //variable para almacenar el resultado de la consulta
        ResultSet result = null;
        
        //array a retornar
        ArrayList<PurchaseReport> report = null;
        try {
            connection = Conexion.getConnection();
            report = new ArrayList<>();
            
            //preparando la consulta
            query = connection.prepareCall("{call sp_report_purchases(?,?)}");
            //agrendo el year por el cual hará el filtro
            query.setString(1, "NULL");
            query.setInt(2, year);
            //ejecutando la consulta y almacenando el resultado
            result = query.executeQuery();
            
            //agregando los datos al array
            PurchaseReport purchase = new PurchaseReport();
            int amountPurchases = 0;
            int amountItems = 0;
            double value = 0.0;
            while(result.next()){
                amountPurchases += result.getInt("amount_purshases");
                amountItems += result.getInt("amount_items");
                value += result.getDouble("value");
            }
            purchase.setAmountPurchases(amountPurchases);
            purchase.setAmountItems(amountItems);
            purchase.setValue(value);
            report.add(purchase);
            
        } catch (SQLException e) {
                        JOptionPane.showMessageDialog(
                        null,
                        "Error al obtener los datos del reporte de compras por año. \n" + e.toString(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                         JOptionPane.showMessageDialog(
                        null,
                        "Error al cerrar las conexiones con la base de datos, "
                                + "al intener los datos del reporte de compras por año. \n" + e.toString(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return report;
    }
    
    /*=================================REPORTE DE PROMEDIOS================================================*/
    public ArrayList<InvoicesAverageReport> getAverages(ArrayList<Integer> years){
        ArrayList<InvoicesAverageReport> averages = null;
        //variable para preparar la consulta a la db
        CallableStatement _query;
        //variable para almacenar el resultado de la consulta
        ResultSet _result;
        try {
            averages = new ArrayList<>();
            connection = Conexion.getConnection();
            
            //obtendremos los promedios por cada año  en donde hay facturas
            for (Integer i : years) {
                //buscando los promedios por años
                _query = connection.prepareCall("{call sp_report_purchases(?,?)}");
                _query.setString(1, "NULL");
                _query.setInt(2, i);
                _result = _query.executeQuery();
                
                InvoicesAverageReport purchase = new InvoicesAverageReport();
                int amountPurchases = 0;
                int amountItems = 0;
                double value = 0.0;
                while(_result.next()){
                    amountPurchases += _result.getInt("amount_purshases");
                    amountItems += _result.getInt("amount_items");
                    value += _result.getDouble("value");
                }
                purchase.setAmountPurchases(amountPurchases);
                purchase.setAmountItems(amountItems);
                purchase.setValue(value);
                averages.add(purchase);
             
                //cerrando conexiones
                Conexion.close(_result);
                Conexion.close(_query);
            }
            
        } catch (SQLException e) {
            message.showMessage("ERROR", "Ha ocurrido un error al consultar los promedios en los datos de facturas. \n"
            + e.toString());
            
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                message.showMessage("ERROR", "Ha ocurrido un error al cerrar las conexiones luego luego de consultar"
                        + " los promedios en los datos de facturas. \n"+ ex.toString());
            }

        }
        return averages;
    }
    
    
    public ArrayList<Integer> getYears(){
        ArrayList<Integer> years = null;
        //variable para preparar la consulta a la db
        CallableStatement query = null;
        //variable para almacenar el resultado de la consulta
        ResultSet result = null;
        try {
            years = new ArrayList<>();
            connection = Conexion.getConnection();
            
            //obteniendo los años en los que hay facturas
            query = connection.prepareCall("{call sp_years_in_invoices()}");
            result= query.executeQuery();
            
                //obteniendo año actual
            int currentYear = LocalDateTime.now().getYear();
            
            while (result.next()) {
                //solo mostramos los year que hay facturas en los menores al year actual
                if (result.getInt("years_with_invoices")<currentYear) {
                    System.out.println(result.getInt("years_with_invoices"));
                    years.add(result.getInt("years_with_invoices"));                  
                }

            }
        } catch (SQLException e) {
            message.showMessage("ERROR", "Ha ocurrido un error al consultar los años en los que hay facturas. \n"
            + e.toString());
            
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException ex) {
                message.showMessage("ERROR", "Ha ocurrido un error al cerrar las conexiones luego luego de consultar"
                        + " los años en los que hay facturas. \n"+ ex.toString());
            }

        }
        return years;
    }


    
    public TypeRegisterReport EntriesAndOutPutsByMonth(int month, int Year){
        
        //array a retornar
        TypeRegisterReport report = null;
        //almacena y prepara la consulta
        CallableStatement query=null;
        //almacena el resultado de la consulta
        ResultSet result=null;
        
        try {
            report = new TypeRegisterReport();
             //abrimos una conexion
            connection = Conexion.getConnection();
             /*==================DATOS DE LAS ENTRADAS=================================*/
            //preparamos la consulta
            query = connection.prepareCall("{call sp_report_registers_by_month(?,?,?)}");
            query.setInt(1, month);
            query.setInt(2, Year);
            query.setInt(3, ActionType.ENTRADA.ordinal()+1);
            //ejecutando la consulta y almacenando el resultado
            result = query.executeQuery();
            
            report.setMonth(Months.values()[month-1]);
            while (result.next()) {                
                    //entradas
                        report.setEntries(result.getInt("amount_action"));
                    //cantidad de entradas
                        report.setAmountEntries(result.getInt("amount"));
                    //salidas
                        report.setOutputs(0);
                    //cantidad de salidas
                        report.setAmountOutPuts(0);
                                     
            }
              
        report = setOutputsByMonth(report,month,Year);
        

        } catch (SQLException e) {
            message.showMessage("ERROR", "Error al mostrar los datos de entradas para el gráfico.\n"+e.toString());
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                message.showMessage("ERROR", "Error al cerrar las conexiones.\n"+e.toString());
            }
        }
        
           return report; 
           

    }
    
    public TypeRegisterReport setOutputsByMonth(TypeRegisterReport report, int month, int Year){
        

        //almacena y prepara la consulta
        CallableStatement query = null;
        //almacena el resultado de la consulta
        ResultSet result = null;
        
        try {
             //abrimos una conexion
            connection = Conexion.getConnection();

            /*==================DATOS DE LAS SALIDAS=================================*/
            query = connection.prepareCall("{call sp_report_registers_by_month(?,?,?)}");
            query.setInt(1, month);
            query.setInt(2, Year);
            query.setInt(3, ActionType.SALIDA.ordinal()+1);
            result = query.executeQuery();
            //agregamos las dos columnas de datos que faltan
            while(result.next()){
                report.setOutputs(result.getInt("amount_action"));
                report.setAmountOutPuts(result.getInt("amount"));                
            }
        

        } catch (SQLException e) {
            message.showMessage("ERROR", "Error al mostrar los datos de salidas para el gráfico.\n"+e.toString());
        } finally {
            try {

                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                message.showMessage("ERROR", "Error al cerrar las conexiones.\n"+e.toString());
            }
        }
        
           return report; 
           

    }

  //obteniendo año actual
    int year = LocalDateTime.now().getYear();
    //obteniendo el mes actual
    int month = LocalDateTime.now().getMonthValue();
    
    /*obteniendo las entradas y salidas de los ultimos 6 meses*/
    
    public ArrayList<TypeRegisterReport> getDataCharI(){
        ArrayList<TypeRegisterReport> reportList = new ArrayList<>();
        //agregagos seis filas para agregar los datos del final al inicio
        for (int i = 0; i < 6; i++) {
            reportList.add(new TypeRegisterReport());
        }
        
        int _month = month;
        int _year = year;
        int _index = 5;
        //ciclo de 6(seis meses)
        for (int i = 0; i < 6; i++) {
            //si el mese llega a cero(ya se buscó a enero)
            //se reduce un year
            //y el mes comienza en diciembre (12)
            // (enero,2022) --> (diciembre, 2021)
            if (_month==0) {
                _year --;
                _month = 12;
            }
            //agregar al array en la posicion (ultima a primera) 
            reportList.set(_index,EntriesAndOutPutsByMonth(_month,_year));
            //reduce en uno el indice que comieza en la ultima posicio y el mes
            _index--;
            _month --;
        }

                    
        return reportList;
    }
    
    /*=====reporte de compras por mes y year=====*/
    public PurchaseReport reportPurchasesByMonth(Months month, int year){
        
        //variable para preparar la consulta
        CallableStatement query = null;
        //variable para almacenar el resultado de la consulta
        ResultSet result = null;
        
        //array a retornar
        PurchaseReport report = null;
        try {
            connection = Conexion.getConnection();
            report = new PurchaseReport();
            
            //preparando la consulta
            query = connection.prepareCall("{call sp_report_purchases(?,?)}");
            //agrendo el year por el cual hará el filtro
            query.setString(1, String.valueOf(month.ordinal()+1));
            query.setInt(2, year);
            //ejecutando la consulta y almacenando el resultado
            result = query.executeQuery();
            
            report.setMonth(month);
            //agregando los datos al array
            int amountPurchases = 0;
            int amountItems = 0;
            double value = 0.0;
            while(result.next()){
                amountPurchases += result.getInt("amount_purshases");
                amountItems += result.getInt("amount_items");
                value += result.getDouble("value");
            }
            report.setAmountPurchases(amountPurchases);
            report.setAmountItems(amountItems);
            report.setValue(value);      
            
        } catch (SQLException e) {
                        JOptionPane.showMessageDialog(
                        null,
                        "Error al obtener los datos del reporte de compras por año. \n" + e.toString(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException e) {
                         JOptionPane.showMessageDialog(
                        null,
                        "Error al cerrar las conexiones con la base de datos, "
                                + "al intener los datos del reporte de compras por año. \n" + e.toString(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return report;
    }
    
        /*obteniendo las compras de los ultimos 6 meses*/
    
    public ArrayList<PurchaseReport> getDataCharII(){
        ArrayList<PurchaseReport> reportList = new ArrayList<>();
        
        for (int i = 0; i < 6; i++) {
            reportList.add(new PurchaseReport());
        }
        //es la misma logica de primero
        int _month = month;
        int _year = year;
        int _index = 5;
        for (int i = 0; i < 6; i++) {
            if (_month==0) {
                _year --;
                _month = 12;
            }
            reportList.set(_index,reportPurchasesByMonth(Months.values()[_month-1],_year));
            _index--;
            _month --;
        }
           
        return reportList;
    }
}
