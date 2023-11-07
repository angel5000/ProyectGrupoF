
package Control;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import model.CarCompras;
import model.Compra;
import model.ConexionBD;


/**
 *
 * @author angeldvvp
 */
public class AdmCompra {
    List<CarCompras> carrito = new ArrayList<>();

    public List<CarCompras> Carrito(){
        //CONSULTA HACIA LA BASE DE DATOS ENTRE LAS TABLAS CLIENTE INVENTARIO Y CARRITO
         String query = "SELECT C.ID_cliente, I.NombreProducto, DP.Descripcion, I.Imagen , ID_producto FROM Carrito AS C "
                 + "JOIN INVENTARIO AS I ON C.ID_Producto = I.ID_Invent "
                 + "JOIN Detalles_productos AS DP ON C.ID_DetallesProd = DP.ID_DetallesPRD";
        
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {//RECORRIDO DE DATOS
              CarCompras crp= new CarCompras();
              
             crp.setIdUsua(rs.getInt("ID_cliente")); 
             crp.setIdelemnt(rs.getInt("ID_producto")); 
              crp.setIdUsua(rs.getInt("ID_cliente")); 
               crp.setNombre(rs.getString("NombreProducto")); 
                crp.setDetalles(rs.getString("Descripcion")); 
              
               byte[] imagenBytes=rs.getBytes("Imagen");
               BufferedImage imagen = null;
        if (imagenBytes!= null) {
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(imagenBytes);
                imagen = ImageIO.read(bis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }crp.setBufferedImage(imagen);
                carrito.add( crp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        return carrito;
        
        
    }
    
    public void IngresarItemCarrito(int IDCatalogo){
       
    //METODO QUE INGRESADO LOS ITEM A LA CLASE CARRITO
         String sql = "INSERT INTO Carrito (ID_Cliente, ID_Producto, ID_DetallesProd) VALUES (?, ?, ?)";
//CONSULTA HACIA LA BD PARA INGRESAR DATOS EN TABLA CARRITO
     
                //CONSULTAR LOS DATOS DE CATALOGO POR ID
                String consultaCatalogo = "SELECT Producto, Detalle_Producto FROM CATALOGO_PRODUCTO WHERE ID_cata = ?";
            try ( Connection conn = ConexionBD.conectar();
                    PreparedStatement statement = conn.prepareStatement(consultaCatalogo)) {
                statement.setInt(1, IDCatalogo);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    int idProducto = resultSet.getInt("Producto");
                    int idDetalleProducto = resultSet.getInt("Detalle_Producto");
//INGRESA LSO DATOS EN EL CARRITO SEGUN DATOS PEDIDOS
                  
                    String insertCarrito = "INSERT INTO Carrito (ID_cliente, ID_producto, ID_detallesProd) VALUES (?, ?, ?)";
                    try (PreparedStatement insertStatement = conn.prepareStatement(insertCarrito)) {
                        insertStatement.setInt(1, 100);
                        insertStatement.setInt(2, idProducto);
                        insertStatement.setInt(3, idDetalleProducto);
                        int filasAfectadas = insertStatement.executeUpdate();
                        if (filasAfectadas > 0) {
                            System.out.println("Datos agregados a la tabla Carrito.");
                        } else {
                            System.out.println("No se pudieron agregar los datos a la tabla Carrito.");
                        }
                    }
                } else {
                    System.out.println("No se encontró el ID_cata en la tabla CATALOGO_PRODUCTO.");
                }

                
                 } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    
    public int RemoverItem(int idProducto){
         
            String sentenciaSQL = "DELETE FROM Carrito WHERE ID_producto = ?";
            try (Connection conn = ConexionBD.conectar();
                    PreparedStatement statement = conn.prepareStatement(sentenciaSQL)) {
                statement.setInt(1, idProducto);
                int filasAfectadas = statement.executeUpdate();

                if (filasAfectadas > 0) {
                   return 1;
                } 
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return 0;
    }
    
    
    //METODO QUE VERIFICA SI YA EXITES UN PRODUCTO EN EL CARRITO
    public int VerificarItems(int IDCatalogo) throws SQLException{
        
     int idProducto=0;
          String consultaCatalogo = "SELECT Producto, Detalle_Producto FROM CATALOGO_PRODUCTO WHERE ID_cata = ?";
            try ( Connection conn = ConexionBD.conectar();
                 PreparedStatement statement = conn.prepareStatement(consultaCatalogo)) {
                statement.setInt(1, IDCatalogo);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    idProducto = resultSet.getInt("Producto");
                }
                     } catch (SQLException e) {
            e.printStackTrace();
        }
                    String consultaCarrito = "SELECT ID_carrito FROM Carrito WHERE ID_cliente = ? AND ID_producto = ?";
            try (  Connection conn = ConexionBD.conectar();
                    PreparedStatement statement = conn.prepareStatement(consultaCarrito)) {
                statement.setInt(1, 100);
                statement.setInt(2, idProducto);
         
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                 
                   return 1;
                } 

            } catch (SQLException e) {
            e.printStackTrace();
        }

        
        return 0;
    }
    
    
}
