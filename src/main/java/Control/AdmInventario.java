/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import model.Cliente;
import model.ConexionBD;
import model.Inventario;

/**
 *
 * @author angeldvvp
 */

public class AdmInventario {
    Inventario inv = new Inventario();
    List< Inventario> inventario = new ArrayList<>();
   ////MUESTRA CIERTOS DATOS QUE HAY EN INVENTARIO
    public List<Inventario> MostrarInventario(){
          //List<String> inventario2 = new ArrayList<>();
       String query="{CALL MOSTRARINVENTARIO}";
        
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {//RECORRIDO DE DATOS
                inv = new Inventario();
                  inv.setIdinven(rs.getInt("ID_Invent"));
                inv.setNombre(rs.getString("NombreProducto"));
                inv.setCantidad(rs.getInt("Stock"));
                inv.setFechaingreso(rs.getDate("Fecha_Ingreso"));
                inv.setPrecio(rs.getFloat("PrecioUnitario"));
                 inv.setIddetal(rs.getInt("ID_DetallesPRD"));
                 inv.setDetalles(rs.getString("Descripcion"));
                 inv.setMarca(rs.getString("Marca"));
               String valor=rs.getString("catalogo");
        inv.setCatalogo(valor.charAt(0));
                
                

        inventario.add(inv);
    
    
     
               
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return inventario;
    }
    
    public void IngresarCatalogo(){
        
        String query="{CALL MOSTRARINVENTARIO}";
        
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {//RECORRIDO DE DATOS
                inv = new Inventario();
                 inv.setIdinven(rs.getInt("ID_Invent"));
                inv.setNombre(rs.getString("NombreProducto"));
                inv.setCantidad(rs.getInt("Stock"));
                inv.setFechaingreso(rs.getDate("Fecha_Ingreso"));
                inv.setPrecio(rs.getFloat("PrecioUnitario"));
                 inv.setIddetal(rs.getInt("ID_DetallesPRD"));
                 inv.setDetalles(rs.getString("Descripcion"));
                 inv.setMarca(rs.getString("Marca"));
               String valor=rs.getString("catalogo");
        inv.setCatalogo(valor.charAt(0));
                
                

        inventario.add(inv);
    
     
               
            }
            
            
            
            
            
            
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<String> lista(){
        String datos="";
         List<String> inventario2 = new ArrayList<>();
         for(Inventario vt : inventario)
            {
               datos ="Nombre: "+ vt.getNombre()+" Precio: "+vt.getPrecio();
                inventario2.add(datos);
            }
    
        return inventario2;
    }
    
    
    ///CONVERTIDOR DE LA IMAGEN A BYTE
    public byte[] img(){
         byte[] imagenEnBytes=null;
        try {
          
      String rutaImagen = "C:/Users/angeldvvp/Desktop/Proyecto_SisControl_Pernos_y_TuercaGrupoF_Venta/BD/imagenes/"
              + "Pernohexagonal.jpg"; 

            File imagen = new File(rutaImagen);
            FileInputStream fileInputStream = new FileInputStream(imagen);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

             imagenEnBytes = byteArrayOutputStream.toByteArray();


            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagenEnBytes;
    }
    
    //ENVIA LA IMAGEN A LA TABLA
    public void imageninv(){
            try {
           

            String sql = "UPDATE INVENTARIO SET Imagen = ? WHERE ID_Invent = ?";
Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             PreparedStatement stmt = conn.prepareStatement(sql);
           
            byte[] nuevaImagen = img();
            int idInventarioAActualizar = 1; // ID de la fila a actualizar

      
            stmt.setBytes(1, nuevaImagen);
           stmt.setInt(2, idInventarioAActualizar);

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Imagen actualizada con éxito.");
            } else {
                System.out.println("No se pudo actualizar la imagen.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        }
    

    
    
    
}
