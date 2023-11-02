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
    private static final String HOSTNAME = "localhost";
    private static final String SQL_INSTANCE_NAME = "NITRO-5";
    private static final String SQL_DATABASE = "TuercaTornillo";
    private static final String SQL_USER = "usersql";
    private static final String SQL_PASSWORD = "root";

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectURL = "jdbc:sqlserver://" + HOSTNAME + ":1433"
                    + ";instance=" + SQL_INSTANCE_NAME + ";databaseName=" + SQL_DATABASE
                    + ";user=" + SQL_USER + ";password=" + SQL_PASSWORD;
            Connection conn = DriverManager.getConnection(connectURL);
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
