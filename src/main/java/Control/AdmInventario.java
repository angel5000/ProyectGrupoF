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
    byte a;
    public List<Inventario> inv(){
          //List<String> inventario2 = new ArrayList<>();
        String query = "SELECT * FROM INVENTARIO";
        
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {//RECORRIDO DE DATOS
                
                 String valorColumna1 = rs.getString("NombreProducto");
                  float valorColumna2 = rs.getFloat("PrecioUnitario");
                  byte[] imagenBytes = rs.getBytes("Imagen");
                
              String datos="Nombre: "+valorColumna1+" Precio: "+valorColumna2;
       
        
        BufferedImage imagen = null;
        if (imagenBytes != null) {
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(imagenBytes);
                imagen = ImageIO.read(bis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        inventario.add(new Inventario(datos, imagen));
    
     
               
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return inventario;
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
    public byte[] img(){
         byte[] imagenEnBytes=null;
        try {
          
      String rutaImagen = "C:/Users/angeldvvp/Desktop/Proyecto_SisControl_Pernos_y_TuercaGrupoF_Venta/BD/imagenes/"
              + "Pernohexagonal.jpg"; // Reemplaza con la ruta de tu imagen

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
    
    public void imageninv(){
            try {
           

            String sql = "UPDATE INVENTARIO SET Imagen = ? WHERE ID_Invent = ?";
Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             PreparedStatement stmt = conn.prepareStatement(sql);
            // Supongamos que tienes los datos binarios de la nueva imagen y el ID de la fila a actualizar
            byte[] nuevaImagen = img();
            int idInventarioAActualizar = 1; // ID de la fila a actualizar

          

            // Establece los valores en la consulta
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
