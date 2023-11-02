/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author LARABEL
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ConexionBD;
import model.Usuario;

public class AdmUsuario {
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

