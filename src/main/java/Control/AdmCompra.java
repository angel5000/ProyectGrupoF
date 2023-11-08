
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
import javax.swing.JOptionPane;
import model.CarCompras;
import model.Compra;
import model.ConexionBD;


/**
 *
 * @author angeldvvp
 */
public class AdmCompra {
    List<CarCompras> carrito = new ArrayList<>();
int idProducto=0;int resultado=0, valor=0;
    public List<CarCompras> Carrito()throws Exceptions, SQLException{
        //CONSULTA HACIA LA BASE DE DATOS ENTRE LAS TABLAS CLIENTE INVENTARIO Y CARRITO
         String query = "SELECT C.ID_cliente, I.NombreProducto, DP.Descripcion, I.Imagen , ID_producto, cantidad FROM Carrito AS C "
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
              crp.setCantidad(rs.getInt("cantidad"));
               byte[] imagenBytes=rs.getBytes("Imagen");
               
               BufferedImage imagen = null;
               
        if (imagenBytes!= null) {
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(imagenBytes);
                imagen = ImageIO.read(bis);
                //  ExcepcionIngresoCRP();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }crp.setBufferedImage(imagen);
                carrito.add( crp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
              JOptionPane.showMessageDialog(null,  e.getStackTrace()+"");
        }/*
        catch (Exceptions e) {
  e.printStackTrace();
             JOptionPane.showMessageDialog(null,  e.getMessage()+"");
}*/
        
        
        
        return carrito;
        
        
    }
    
    public void IngresarItemCarrito(int IDCatalogo, int cantidad) throws Exceptions, SQLException{
       
    //METODO QUE INGRESADO LOS ITEM A LA CLASE CARRITO
         String sql = "INSERT INTO Carrito (ID_Cliente, ID_Producto, ID_DetallesProd,cantidad) VALUES (?, ?, ?, ?)";
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
                  
                    String insertCarrito = "INSERT INTO Carrito (ID_cliente, ID_producto, ID_detallesProd, cantidad) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement insertStatement = conn.prepareStatement(insertCarrito)) {
                        insertStatement.setInt(1, 100);
                        insertStatement.setInt(2, idProducto);
                        insertStatement.setInt(3, idDetalleProducto);
                         insertStatement.setInt(4, cantidad);
                        int filasAfectadas = insertStatement.executeUpdate();
                        if (filasAfectadas > 0) {
                            System.out.println("Datos agregados a la tabla Carrito.");
                        } else {
                             ExcepcionVerificar();
                            System.out.println("No se pudieron agregar los datos a la tabla Carrito.");
                        }
                    }
                } else {
                    System.out.println("No se encontró el ID_cata en la tabla CATALOGO_PRODUCTO.");
                }

                
                 } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exceptions e) {
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
    public int VerificarItems(int IDCatalogo) throws Exceptions, SQLException{
       
     
String consultaCatalogo = "SELECT Producto, Detalle_Producto FROM CATALOGO_PRODUCTO WHERE ID_cata = ?";
PreparedStatement statementCatalogo = null;
ResultSet resultSetCatalogo = null;

try (Connection conn = ConexionBD.conectar()) {
    statementCatalogo = conn.prepareStatement(consultaCatalogo);
    statementCatalogo.setInt(1, IDCatalogo);
    resultSetCatalogo = statementCatalogo.executeQuery();

    if (resultSetCatalogo.next()) {
        idProducto = resultSetCatalogo.getInt("Producto");

        String consultaCarrito = "IF EXISTS (SELECT 1 FROM Carrito WHERE ID_Producto = ? AND ID_cliente=?) SELECT 1 ELSE SELECT 0";
        PreparedStatement statementCarrito = null;
        ResultSet resultSetCarrito = null;

        try {
            statementCarrito = conn.prepareStatement(consultaCarrito);
            statementCarrito.setInt(1,idProducto);
             statementCarrito.setInt(2,  100);

            resultSetCarrito = statementCarrito.executeQuery();

            if (resultSetCarrito.next()  ) {
                // ExcepcionVerificar();
                resultado = resultSetCarrito.getInt(1);
                if (resultado == 1) {
                  
                    return resultado;
                } if (resultado == 0){
                   
                    return resultado;
                }
                ExcepcionVerificar();}
            
         
        } catch (SQLException e) {
            e.printStackTrace();
            
        } 
    }
} catch (SQLException e) {
    e.printStackTrace();
 
}  catch (Exceptions e) {
  e.printStackTrace();
           
}
        
        return resultado;
        
    }
    
     public static void ExcepcionVerificar() throws Exceptions,SQLException {
        // Lanzamos la excepción personalizada
      //  throw new SQLException("Error de SQL");
        throw new Exceptions("Error al identificar los ID de Producto o el ID del cliente" );
    }
     public static void ExcepcionIngresoCRP() throws Exceptions,SQLException {
        // Lanzamos la excepción personalizada
        throw new Exceptions("Verifique que el nombre de las tablas o columnas esten correctas ");
    }
    
    
    
}
