/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
 

    public static Connection conectar() throws SQLException {
        try {
            
            
            
        String hostname = "localhost";
            String sqlInstanceName = "DESKTOP-BUQ5QOC"; //computer name 
            String sqlDatabase = "Ferreteria";  //sql server database name
            String sqlUser = "sa";
            String sqlPassword = "Angpro500"; //passwrod sa account

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //jdbc:sqlserver://localhost:1433;instance=COMPUTERBERRY;databaseName=Database;
           String connectURL = "jdbc:sqlserver://localhost:1433;instance="+sqlInstanceName +";databaseName="+sqlDatabase+ ";encrypt=true;trustServerCertificate=true;";

            Connection conn = DriverManager.getConnection(connectURL,sqlUser,sqlPassword);
            System.out.println("Connect to database successful!!"); 
     
            return conn;
            
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al cargar el controlador JDBC: " + e.getMessage());
        }
    }

    public static void desconectar(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
