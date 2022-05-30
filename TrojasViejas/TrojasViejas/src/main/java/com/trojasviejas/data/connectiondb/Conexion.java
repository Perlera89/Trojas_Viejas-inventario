package com.trojasviejas.data.connectiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/trojas_viejas_db?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
//    private static final String USER = "perlera";
//    private static final String PASSWORD = "12345678";
    
    private static final String USER = "perlera";
    private static final String PASSWORD = "12345678";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }

    public static void close(Statement st) throws SQLException{
        st.close();
    }

    public static void close(Connection cn) throws SQLException{
        cn.close();
    }
}
