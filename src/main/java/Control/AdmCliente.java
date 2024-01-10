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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.ConexionBD;

public class AdmCliente {
    //LIST DE LA CLAS CLIENTE
    List<Cliente> clientes = new ArrayList<>();
       
    public List<Cliente> Mostrardatosclientes(int id)throws Exceptions {
        
        String query = "{CALL  DATOSCLIENTE (?)}";//QUERY DE PROCEDIMIENTO ALMACENADO
        
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             CallableStatement stmt = conn.prepareCall(query);
             ) {
             stmt.setInt(1, id);//INGRESO DE ID DEL CLIENTE
            stmt.execute();//EJECUCINO DEL QUERY
            
             try (ResultSet rs = stmt.executeQuery()) {
                 if(!rs.next()){
                     throw new Exceptions("ID INCORRECTO O ALGUN ERROR EN CODIGO O BD");
                 }
            while (rs.next()) {//RECORRIDO DE DATOS
                Cliente cliente = new Cliente();//OBJETO CLIENTE
                cliente.setCedula(rs.getString("Cedula"));//DATOS CLIENTES
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("Apellidos"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setCorreo_electronico(rs.getString("correo_electronico"));
                cliente.setTelefono(rs.getString("Telefono"));
                cliente.setFecha_Nacimineto(rs.getDate("Fecha_Nacimineto"));
                clientes.add(cliente);//INGRESO DE DATOS AL LIST
            }} catch (Exceptions ex) {
                Logger.getLogger(AdmCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return clientes;
    }
    
}

