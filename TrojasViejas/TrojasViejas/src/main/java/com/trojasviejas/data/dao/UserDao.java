package com.trojasviejas.data.dao;

import com.trojasviejas.data.Hash;
import com.trojasviejas.data.connectiondb.Conexion;
import com.trojasviejas.demo.form.FrmMain;
import com.trojasviejas.models.entity.*;
import com.trojasviejas.models.viewmodel.LoginVM;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

public class UserDao {

    public ArrayList<UserModel> ListUser() throws SQLException {
        UserModel user = null;
        Connection connection = null;
        CallableStatement query = null;
        ResultSet result = null;

        ArrayList<UserModel> users = null;

        connection = Conexion.getConnection();
        users = new ArrayList<UserModel>();

        query = connection.prepareCall("{call sp_s_users}");
        result = query.executeQuery();

        while (result.next()) {

            user = new UserModel();
            user.setUserId(result.getInt("usr_id"));
            user.setUsername(result.getString("usr_name"));
            user.setPassword(result.getString("usr_password"));

            users.add(user);

            Conexion.close(result);
            Conexion.close(query);
            Conexion.close(connection);
        }
        return users;

    }

    public void register(UserModel model) throws SQLException {
        //ResultSet result = null;
        Connection connection = Conexion.getConnection();

        CallableStatement query = connection.prepareCall("call sp_i_user(?,?,?)");
        query.setString(1, model.getUsername());
        query.setString(2, model.getPassword());
        query.setString(3, model.getVerifyPassword());
        query.execute();

        Conexion.close(query);
        Conexion.close(connection);
    }

    public void Update(UserModel model) {

        Connection connection = null;
        PreparedStatement query = null;
        int result = 0;

        try {
            connection = Conexion.getConnection();
            query = connection.prepareStatement("{call sp_u_user(?,?,?,?)}");

            query.setInt(1, model.getUserId());
            query.setString(2, model.getUsername());
            query.setString(3, model.getPassword());
            query.setString(4, model.getVerifyPassword());
            
            result = query.executeUpdate();
            
            if(result == 1){
                JOptionPane.showMessageDialog(null, "Actualizado exitosamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "Contraseña no coincide.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se han podido actualizar sus datos. \n" + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Conexion.close(query);
                Conexion.close(connection);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void delete(int id) throws SQLException {
        Connection connection = Conexion.getConnection();
        CallableStatement query = connection.prepareCall("call sp_d_users(?)");

        query.setInt(1, id);
        query.execute();

        Conexion.close(query);
        Conexion.close(connection);
    }

    public boolean login(LoginVM login) throws SQLException {
        boolean isLogin = false;
        Connection connection = Conexion.getConnection();

        CallableStatement query = connection.prepareCall("call sp_s_user(?,?)");
        query.setString(1, login.getUsername());
        query.setString(2, Hash.getHash(login.getPassword(), "SHA1"));

        ResultSet result = query.executeQuery();
        if (result.next()) {
            FrmMain.idLogin = result.getInt("usr_id");
            isLogin = true;
        }

        Conexion.close(result);
        Conexion.close(query);
        Conexion.close(connection);

        return isLogin;
    }

}
