/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trojasviejas.data.dao;

import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.component.main.ReportsCard;
import com.trojasviejas.data.connectiondb.Conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Willian
 */
public class ReportDao {

    MessageErrorDialog errorMessege = new MessageErrorDialog(new JFrame());
    
    public void generateItemReport() {
        Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

        Map parametro = new HashMap();
        parametro.put("logo", getInputStream("src/main/resources/img/isotipo.png"));

        String archive = "src/main/java/com/trojasviejas/report/itemsReport.jasper";
        try {
            connection = Conexion.getConnection();
            jr = (JasperReport) JRLoader.loadObjectFromFile(archive);
            print = JasperFillManager.fillReport(jr, parametro, connection);
        } catch (SQLException ex) {
             errorMessege.showMessage("ERROR", "Ha ocurrido un error al conectarse a la base de datos. \n" + ex.toString());
        } catch (JRException ex) {
            errorMessege.showMessage("ERROR", "Ha ocurrido un error en Jasper Report. \n" + ex.toString());
        }

        JasperViewer jv = new JasperViewer(print, false);
        jv.setVisible(true);
    }

    public void generateInventoryReport() {
        Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

        Map parametro = new HashMap();
        parametro.put("logo", getInputStream("src/main/resources/img/isotipo.png"));

        String archive = "src/main/java/com/trojasviejas/report/inventoriesReport.jasper";
        try {
            connection = Conexion.getConnection();
            jr = (JasperReport) JRLoader.loadObjectFromFile(archive);
            print = JasperFillManager.fillReport(jr, parametro, connection);
        } catch (SQLException ex) {
             errorMessege.showMessage("ERROR", "Ha ocurrido un error al conectarse a la base de datos. \n" + ex.toString());
        } catch (JRException ex) {
            errorMessege.showMessage("ERROR", "Ha ocurrido un error en Jasper Report. \n" + ex.toString());
        }

        JasperViewer jv = new JasperViewer(print, false);
        jv.setVisible(true);
    }

    public void generateInvoiceReport(int year, ReportsCard reportsCard3) {
        Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

        Map parametro = new HashMap();
        parametro.put("parameter1", "" + year);
        parametro.put("logo", getInputStream("src/main/resources/img/isotipo.png"));

        // String archive = "C:/Users/cb272/Documents/GitHub/Trojas_Viejas-inventario/TrojasViejas/src/main/java/com/trojasviejas/report/invoiceReport.jasper";
        String archive = "src/main/java/com/trojasviejas/report/invoiceReport.jasper";
        try {
            connection = Conexion.getConnection();
            jr = (JasperReport) JRLoader.loadObjectFromFile(archive);
            print = JasperFillManager.fillReport(jr, parametro, connection);
        } catch (SQLException ex) {
             errorMessege.showMessage("ERROR", "Ha ocurrido un error al conectarse a la base de datos. \n" + ex.toString());
        } catch (JRException ex) {
            errorMessege.showMessage("ERROR", "Ha ocurrido un error en Jasper Report. \n" + ex.toString());
        }

        JasperViewer jv = new JasperViewer(print, false);
        jv.setVisible(true);
        reportsCard3.txtYear.setText("");
    }

    public void generateRegistersReport(String month, int year, ReportsCard reportsCard4) {
        Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

        Map parametro = new HashMap();
        parametro.put("p_month", month);
        parametro.put("p_year", year);
        parametro.put("logo", getInputStream("src/main/resources/img/isotipo.png"));

        String archive = "src/main/java/com/trojasviejas/report/ActivityRegisters.jasper";
        try {
            connection = Conexion.getConnection();
            jr = (JasperReport) JRLoader.loadObjectFromFile(archive);
            print = JasperFillManager.fillReport(jr, parametro, connection);
        } catch (SQLException ex) {
             errorMessege.showMessage("ERROR", "Ha ocurrido un error al conectarse a la base de datos. \n" + ex.toString());
        } catch (JRException ex) {
            errorMessege.showMessage("ERROR", "Ha ocurrido un error en Jasper Report. \n" + ex.toString());
        }

        JasperViewer jv = new JasperViewer(print, false);
        jv.setVisible(true);
        reportsCard4.txtMonth.setText("");
        reportsCard4.txtYear.setText("");
    }

    public void generateRegistersReportByInvoice(int idInvoice, int items, int usedItems, int stock) {
        Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

        Map parametro = new HashMap();
        parametro.put("p_id_invoice", idInvoice);
        parametro.put("items", items);
        parametro.put("usedItems", usedItems);
        parametro.put("stock", stock);
        parametro.put("logo", getInputStream("src/main/resources/img/isotipo.png"));

        String archive = "src/main/java/com/trojasviejas/report/RegistersByInvoiceId.jasper";
        try {
            connection = Conexion.getConnection();
            jr = (JasperReport) JRLoader.loadObjectFromFile(archive);
            print = JasperFillManager.fillReport(jr, parametro, connection);
        } catch (SQLException ex) {
             errorMessege.showMessage("ERROR", "Ha ocurrido un error al conectarse a la base de datos. \n" + ex.toString());
        } catch (JRException ex) {
            errorMessege.showMessage("ERROR", "Ha ocurrido un error en Jasper Report. \n" + ex.toString());
        }

        JasperViewer jv = new JasperViewer(print, false);
        jv.setVisible(true);
    }

    public void printInvoiceImage(int idInvoice) {
        Connection connection = null;
        JasperPrint print = null;
        JasperReport jr = null;

        Map parametro = new HashMap();
        parametro.put("idInvoice", idInvoice);
        parametro.put("logo", getInputStream("src/main/resources/img/isotipo.png"));

        String archive = "src/main/java/com/trojasviejas/report/InvoiceImage.jasper";
        try {
            connection = Conexion.getConnection();
            jr = (JasperReport) JRLoader.loadObjectFromFile(archive);
            print = JasperFillManager.fillReport(jr, parametro, connection);
        } catch (SQLException ex) {
             errorMessege.showMessage("ERROR", "Ha ocurrido un error al conectarse a la base de datos. \n" + ex.toString());
        } catch (JRException ex) {
            errorMessege.showMessage("ERROR", "Ha ocurrido un error en Jasper Report. \n" + ex.toString());
        }

        JasperViewer jv = new JasperViewer(print, false);
        jv.setVisible(true);
    }

    private InputStream getInputStream(String Ruta) {
        File imagen = new File(Ruta);
        try {
            //byte[] icono = new byte[(int) imagen.length()];
            InputStream input = new FileInputStream(imagen);
            //input.read(icono);
            return input;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }

    }
}
