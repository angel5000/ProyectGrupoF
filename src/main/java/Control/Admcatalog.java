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
         String datos="";
           String query = "SELECT C.ID_cata,c.Producto,C.Detalle_Producto ,IP.NombreProducto,DP.Descripcion, IP.PrecioUnitario,IP.Imagen"
        + " FROM CATALOGO_PRODUCTO AS C JOIN INVENTARIO IP ON C.Producto = IP.ID_Invent " +
"JOIN Detalles_Productos DP ON C.Detalle_Producto = DP.ID_DetallesPRD";
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {//RECORRIDO DE DATOS
                 Catalogo ctg = new Catalogo();
                
              int id=rs.getInt("ID_cata");
              int idpro=rs.getInt("Producto");
              int iddetll=rs.getInt("Detalle_Producto");
                String dato1=rs.getString("NombreProducto");
                String dato2=rs.getString("Descripcion");
                float dato3=rs.getFloat("PrecioUnitario");
                datos=dato1+dato2+dato3;
                
           // datos=rs.getString("NombreProducto");
                    /*+rs.getString("Descripcion")+
                    rs.getString("PrecioUnitario"); */
             
                //ct.img(rs.getString("Imagen")); 
              
               byte[] imagenBytes=rs.getBytes("Imagen");
               BufferedImage imagen = null;
        if (imagenBytes!= null) {
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(imagenBytes);
                imagen = ImageIO.read(bis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
                //catalogo.add( new Catalogo(datos,imagen));
                catalogo.add(new Catalogo(id,idpro,iddetll,datos, imagen));
           
              
            }
        
        ///System.out.println(ctg.getDatos()+datos);
        
        
        }
            catch(SQLException e){
                e.printStackTrace();
                  //  System.out.println(e.getErrorCode());
                    }
         
         
         return catalogo;
     }
     
     public void Buscar(String busqueda){
         String sql = "SELECT CATALOGO_PRODUCTO.*, INVENTARIO.NombreProducto " +
                     "FROM CATALOGO_PRODUCTO " +
                     "INNER JOIN INVENTARIO ON CATALOGO_PRODUCTO.Producto = INVENTARIO.ID_Invent " +
                     "WHERE INVENTARIO.NombreProducto LIKE ?";

        try (Connection conn = ConexionBD.conectar();
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, "%" + busqueda + "%"); // El % se usa para buscar coincidencias parciales

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Recupera los datos de las columnas
                int idCata = resultSet.getInt("ID_cata");
                int productoId = resultSet.getInt("Producto");
                int detalleProductoId = resultSet.getInt("Detalle_Producto");
                String disponible = resultSet.getString("Disponible");
                String nombreProducto = resultSet.getString("NombreProducto");
             
                System.out.println("ID_Cata: " + idCata);
                System.out.println("Producto ID: " + productoId);
                System.out.println("Detalle Producto ID: " + detalleProductoId);
                System.out.println("Disponible: " + disponible);
                System.out.println("Nombre Producto: " + nombreProducto);
                // Resto de las columnas
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }
     
     
     
     
     
     
     
     
    
}
