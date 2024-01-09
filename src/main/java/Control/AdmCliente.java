/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author angeldvvp
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.ConexionBD;

public class AdmCliente {
    //LIST DE LA CLAS CLIENTE
    List<Cliente> clientes = new ArrayList<>();
       
    public List<Cliente> Mostrardatosclientes(int id) {
        
        String query = "{CALL  DATOSCLIENTE (?)}";
        
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             CallableStatement stmt = conn.prepareCall(query);
             ) {
             stmt.setInt(1, id);
            stmt.execute();
             try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {//RECORRIDO DE DATOS
                Cliente cliente = new Cliente();
                cliente.setCedula(rs.getString("Cedula"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("Apellidos"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setCorreo_electronico(rs.getString("correo_electronico"));
                cliente.setTelefono(rs.getString("Telefono"));
                cliente.setFecha_Nacimineto(rs.getDate("Fecha_Nacimineto"));
                clientes.add(cliente);
            }}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return clientes;
    }
    
    public boolean guardarCliente(Cliente cliente) {//INGRESO DE DATOS HACIA LA BD
        String query = "INSERT INTO CLIENTE (Cedula, nombres, Apellidos, Rol, Direccion, correo_electronico, Telefono, Fecha_Nacimineto) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, cliente.getCedula());
            stmt.setString(2, cliente.getNombres());
            stmt.setString(3, cliente.getApellidos());
            stmt.setInt(4, cliente.getRol());
            stmt.setString(5, cliente.getDireccion());
            stmt.setString(6, cliente.getCorreo_electronico());
            stmt.setString(7, cliente.getTelefono());
            stmt.setDate(8, new java.sql.Date(cliente.getFecha_Nacimineto().getTime()));
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

