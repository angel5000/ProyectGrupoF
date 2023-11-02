/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author angeldvvp
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ConexionBD;
import model.Proveedor;

public class AdmProveedor {
    public List<Proveedor> listarProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        String query = "SELECT * FROM PROVEEDOR";
        
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setID_proveedor(rs.getInt("ID_proveedor"));
                proveedor.setNombre_proveedor(rs.getString("nombre_proveedor"));
                proveedor.setTipo_Proveedor(rs.getString("Tipo_Proveedor"));
                proveedor.setRUC(rs.getString("RUC"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setCorreo_electronico(rs.getString("Correo_electronico"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return proveedores;
    }
    
    public boolean guardarProveedor(Proveedor proveedor) {
        String query = "INSERT INTO PROVEEDOR (nombre_proveedor, Tipo_Proveedor, RUC, direccion, Correo_electronico, telefono) " +
                       "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, proveedor.getNombre_proveedor());
            stmt.setString(2, proveedor.getTipo_Proveedor());
            stmt.setString(3, proveedor.getRUC());
            stmt.setString(4, proveedor.getDireccion());
            stmt.setString(5, proveedor.getCorreo_electronico());
            stmt.setString(6, proveedor.getTelefono());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

