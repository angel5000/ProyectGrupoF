/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Catalogo;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import model.ConexionBD;
/**
 *
 * @author angeldvvp
 */
public class Admcatalog {
   
     List<Catalogo> catalogo= new ArrayList<>();
     public List<Catalogo> Catalogos(){
      
           String query = "SELECT C.ID_cata,c.Producto,C.Detalle_Producto ,IP.NombreProducto,DP.Marca,DP.Descripcion, IP.PrecioUnitario,IP.Imagen"
        + " FROM CATALOGO_PRODUCTO AS C JOIN INVENTARIO IP ON C.Producto = IP.ID_Invent " +
"JOIN Detalles_Productos DP ON C.Detalle_Producto = DP.ID_DetallesPRD";
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {//RECORRIDO DE DATOS
                 Catalogo ctg = new Catalogo();
                
              ctg.setIdcata(rs.getInt("ID_cata"));
              ctg.setIdprod(rs.getInt("Producto"));
              ctg.setIddetall(rs.getInt("Detalle_Producto"));
                ctg.setNombre(rs.getString("NombreProducto"));
                ctg.setMarca( rs.getString("Marca"));
                ctg.setDetalles(rs.getString("Descripcion"));
                
              ctg.setPrecio(rs.getFloat("PrecioUnitario"));
              
            
               byte[] imagenBytes=rs.getBytes("Imagen");
               BufferedImage imagen = null;
        if (imagenBytes!= null) {
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(imagenBytes);
                imagen = ImageIO.read(bis);
                ctg.setimg(imagen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
             
                catalogo.add(ctg);
           
              
            }
        
        
        }
            catch(SQLException e){
               e.printStackTrace();

                    }
         
         return catalogo;
     }
     
     public List<Catalogo>Buscar(String busqueda) throws Exceptions{
          String datos="";
         byte[] imagenBytes=null; 
         String sql = "SELECT  CATALOGO_PRODUCTO.ID_cata, INVENTARIO.PrecioUnitario,INVENTARIO.Imagen,INVENTARIO.NombreProducto,"
                 + "Detalles_Productos.Descripcion, Detalles_Productos.Marca " +
"FROM CATALOGO_PRODUCTO " +
"INNER JOIN INVENTARIO ON CATALOGO_PRODUCTO.Producto = INVENTARIO.ID_Invent " +
"INNER JOIN Detalles_Productos ON CATALOGO_PRODUCTO.Detalle_Producto = Detalles_Productos.ID_DetallesPRD " +
"WHERE INVENTARIO.NombreProducto LIKE ? ";

        try (Connection conn = ConexionBD.conectar();
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, "%" + busqueda + "%"); // El % se usa para buscar coincidencias parciales

            ResultSet rs = statement.executeQuery();
            if(!rs.next()){
             throw new Exceptions(" Producto no encontrado.");
            }else{
                rs = statement.executeQuery();
           while(rs.next()){
                  Catalogo ctg = new Catalogo();
               ctg.setIdcata(rs.getInt("ID_cata"));
                ctg.setNombre(rs.getString("NombreProducto"));
                ctg.setMarca( rs.getString("Marca"));
                ctg.setDetalles(rs.getString("Descripcion"));
                
              ctg.setPrecio(rs.getFloat("PrecioUnitario"));
                imagenBytes=rs.getBytes("Imagen");
              
              System.out.println("Producto Encontrado:" +ctg.getNombre());
               BufferedImage imagen = null;
        if (imagenBytes!= null) {
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(imagenBytes);
                imagen = ImageIO.read(bis);
                  ctg.setimg(imagen);
            } catch (IOException e) {
                e.printStackTrace();
               throw new Exceptions("No se encuentra imagen");
            }
        }
                
                catalogo.add(ctg);
                        
            }
            }
           
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return catalogo;
     }
     
    
}
