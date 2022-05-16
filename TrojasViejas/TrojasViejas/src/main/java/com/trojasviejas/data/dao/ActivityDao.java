package com.trojasviejas.data.dao;

import com.trojasviejas.data.connectiondb.Conexion;
import com.trojasviejas.models.viewmodel.ActivityVM;
import com.trojasviejas.models.entity.ActivityModel;
import com.trojasviejas.models.utility.ActionType;
import com.trojasviejas.models.utility.CategoryType;
import com.trojasviejas.models.utility.ItemType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ActivityDao{

        //variable para la conexion
        Connection connection = null;
        
    public ArrayList<ActivityVM> list() {

        //array a retornar
        ArrayList<ActivityVM> registers = null;
        
        //variable para la consulta
        CallableStatement query = null;
        //variable para almacenar los datos de la consulta
        ResultSet result = null;
        
        try {
            //array a retornar
            registers = new ArrayList<>();
            //abriendo la conexion
            connection = Conexion.getConnection();
            
            //preparando la consulta
            query = connection.prepareCall("{call sp_s_activity_registers()}");
            
            //ejecutando y almacenando el resultado de la consulta
            result = query.executeQuery();
            
            //cargando los datos al array
            //objeto para agregar filas al array
            ActivityVM register;
            while (result.next()) {
                register = new ActivityVM();
                
                register.setId(result.getInt("rgtr_id"));
                register.setTypeAction(ActionType.values()[result.getInt("rgtr_tp_action")-1]);
                register.setItem(result.getString("item_name"));
                register.setCurrentStock(result.getInt("rgtr_current_stock"));
                register.setAmount(result.getString("rgtr_amount"));
                register.setNewStock(result.getInt("rgtr_new_stock"));
                register.setDescription(result.getString("rgtr_description"));
                register.setPricePerUnit(result.getDouble("dtl_price_per_unit"));
                register.setCategory(CategoryType.values()[result.getInt("item_cat")-1]);
                register.setType(ItemType.values()[result.getInt("item_tp")-1]);
                //register.setBuyDate(result.getDate("invc_buy_date"));
                //register.setDate(result.getDate("rgtr_date"));
                
                registers.add(register);
                
//                System.out.println(
//                  register.getId()+" "
//                 +register.getTypeAction()+" "
//                 +register.getItem()+" "
//                 +register.getCurrentStock()+" "
//                 +register.getAmount()+" "
//                 +register.getNewStock()+" "
//                 +register.getDescription()+" "
//                 +register.getPricePerUnit()+" "
//                 +register.getCategory().toString()+" "
//                 +register.getType().toString()+" "
//                 +register.getBuyDate()+" "
//                 +register.getDate().toString()+" \n"
//                  
//                );
            JOptionPane.showMessageDialog(
                        null,
                        "Se ha registrado un retiro de tipo: " + register.getTypeAction() + ", exitosamente. \n",
                        "Registro",
                        JOptionPane.INFORMATION_MESSAGE);
                
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se han podido mostrar los registros de actividad. \n" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        //retornando el array
        return registers;
    }

    public void save(ActivityModel register) {

        //variable para la consulta
        CallableStatement query = null;

        try {
            //abriendo la conexion
            connection = Conexion.getConnection();

            //preparando la consulta
            query = connection.prepareCall("{call sp_i_activity_registers(?, ?, ?, ?, ?)}");
            
            //agregando los parametros
            query.setInt(1, register.getTypeAction().ordinal()+1);
            query.setInt(2, register.getCurrentStock());
            query.setString(3, register.getAmount());
            query.setString(4, register.getDescription());
            query.setInt(5, register.getIdInventory());

            //ejecutando y almacenando el resultado de la consulta
            query.execute();
//
//            System.out.println(
//                    register.getTypeAction() + " "
//                    + register.getCurrentStock() + " "
//                    + register.getAmount() + " "
//                    + register.getDescription() + " \n"
//            );
            JOptionPane.showMessageDialog(
                    null,
                    "Se ha registrado un retiro de tipo: " + register.getTypeAction() + ", exitosamente. \n",
                    "Registro",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null, 
                    "No se ha podido guardar el registro de "+register.getTypeAction()+". \n" + e.toString(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(
                        null, 
                        "No se ha cerrado la conexión",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void update(ActivityModel entity) {

        //variable para la consulta
        CallableStatement query = null;

        try {
            //abriendo la conexion
            connection = Conexion.getConnection();

            //preparando la consulta
            query = connection.prepareCall("{call sp_u_activity_registers(?, ?)}");
            
            //agregando los parametros
            query.setInt(1, entity.getId());
            query.setString(2, entity.getDescription());


            //ejecutando y almacenando el resultado de la consulta
            query.execute();

            System.out.println(
                    entity.getId() + " "
                    + entity.getDescription() + " \n"
            );

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null, 
                    "No se ha podido actualizar la descripcion del registro. \n" + e.toString(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(
                        null, 
                        "No se ha cerrado la conexión",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public ArrayList<ActivityVM> findBy(String month, int year) {
        //array a retornar
        ArrayList<ActivityVM> registers = null;
        
        //variable para la consulta
        CallableStatement query = null;
        //variable para almacenar los datos de la consulta
        ResultSet result = null;
        
        try {
            //array a retornar
            registers = new ArrayList<>();
            //abriendo la conexion
            connection = Conexion.getConnection();
            
            //preparando la consulta
            query = connection.prepareCall("{call sp_filter_by_activity_registers(?,?)}");
            //agreagando los parametros
            query.setString(1, month);
            query.setInt(2, year);
            
            //ejecutando y almacenando el resultado de la consulta
            result = query.executeQuery();
            
            //cargando los datos al array
            //objeto para agregar filas al array
            ActivityVM register;
            while (result.next()) {
                register = new ActivityVM();
                
                register.setId(result.getInt("rgtr_id"));
                register.setTypeAction(ActionType.values()[result.getInt("rgtr_tp_action")-1]);
                register.setItem(result.getString("item_name"));
                register.setCurrentStock(result.getInt("rgtr_current_stock"));
                register.setAmount(result.getString("rgtr_amount"));
                register.setNewStock(result.getInt("rgtr_new_stock"));
                register.setDescription(result.getString("rgtr_description"));
                register.setPricePerUnit(result.getDouble("dtl_price_per_unit"));
                register.setCategory(CategoryType.values()[result.getInt("item_cat")-1]);
                register.setType(ItemType.values()[result.getInt("item_tp")-1]);
//                register.setBuyDate(result.getDate("invc_buy_date"));
//                register.setDate(result.getDate("rgtr_date"));
                
                registers.add(register);
                
                System.out.println(
                  register.getId()+" "
                 +register.getTypeAction()+" "
                 +register.getItem()+" "
                 +register.getCurrentStock()+" "
                 +register.getAmount()+" "
                 +register.getNewStock()+" "
                 +register.getDescription()+" "
                 +register.getPricePerUnit()+" "
                 +register.getCategory().toString()+" "
                 +register.getType().toString()+" "
                 +register.getBuyDate()+" "
                 +register.getDate().toString()+" \n"
                  
                );
                
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "No se han podido mostrar los registros de actividad filtrados. \n" + e.toString(),
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Conexion.close(result);
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(
                        null, 
                        "No se ha cerrado la conexión", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        //retornando el array
        return registers;
    }
    
}
