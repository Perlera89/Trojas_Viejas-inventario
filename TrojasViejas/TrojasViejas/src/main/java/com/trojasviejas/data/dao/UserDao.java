package com.trojasviejas.data.dao;

import com.trojasviejas.data.Hash;
import com.trojasviejas.data.connectiondb.Conexion;
import com.trojasviejas.models.entity.*;
import com.trojasviejas.models.viewmodel.LoginVM;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UserDao {

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

    public boolean login(LoginVM login) throws SQLException {
        boolean isLogin = false;
        Connection connection = Conexion.getConnection();

        CallableStatement query = connection.prepareCall("call sp_s_user(?,?);");
        query.setString(1, login.getUsername());
        query.setString(2, Hash.getHash(login.getPassword(), "SHA1"));
        System.out.println(login.getUsername());
        System.out.println(Hash.getHash(login.getPassword(), "SHA1"));

        ResultSet result = query.executeQuery();
        if (result.next()) {
            isLogin = true;
        }

        Conexion.close(result);
        Conexion.close(query);
        Conexion.close(connection);

        return isLogin;
    }

}
