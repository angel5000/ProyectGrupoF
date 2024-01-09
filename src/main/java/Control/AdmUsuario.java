/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author LARABEL
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.ConexionBD;
import model.Factura;
import model.Usuario;

public class AdmUsuario {
    
    public int Login(String usu, String pass) throws Exceptions{
        int IDCLIENTE=0;
         String consultaCatalogo="{CALL VerificarUsuario ( ?, ?, ?)}";
        try (Connection conn = ConexionBD.conectar();
           CallableStatement stmt = conn.prepareCall(consultaCatalogo);)
            {
               
                 stmt.setString(1, usu);
                  stmt.setString(2, pass);
                stmt.registerOutParameter(3, java.sql.Types.INTEGER); 

                 stmt.execute();
                  IDCLIENTE = stmt.getInt(3);
   
                    System.out.println("IDCLIENTE: " + IDCLIENTE);
               if(IDCLIENTE==0){
                throw new  Exceptions("VERIFIQUE SUS CREDENCIALES");
               }
                  
              
               
            }
         catch (SQLException e) {
            
           e.printStackTrace();
        } 
        return IDCLIENTE;
    }
     
    
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM Usuario";
        
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setID_Administrador(rs.getInt("ID_Administrador"));
                usuario.setNombreUsuario(rs.getString("NombreUsuario"));
                usuario.setContraseña(rs.getString("Contraseña"));
                usuario.setNombreCompleto(rs.getString("NombreCompleto"));
                usuario.setCorreoElectronico(rs.getString("CorreoElectronico"));
                usuario.setRol(rs.getInt("Rol"));
                usuario.setFechaRegistro(rs.getDate("FechaRegistro"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return usuarios;
    }
    
    public boolean guardarUsuario(Usuario usuario) {
        String query = "INSERT INTO Usuario (NombreUsuario, Contraseña, NombreCompleto, CorreoElectronico, Rol, FechaRegistro) " +
                       "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getContraseña());
            stmt.setString(3, usuario.getNombreCompleto());
            stmt.setString(4, usuario.getCorreoElectronico());
            stmt.setInt(5, usuario.getRol());
            stmt.setDate(6, new java.sql.Date(usuario.getFechaRegistro().getTime()));
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

