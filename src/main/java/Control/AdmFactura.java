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
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.CarCompras;
import model.ConexionBD;
import model.Factura;

/**
 *
 * @author angeldvvp
 */
public class AdmFactura  {
        
        public  List<Factura> factura = new ArrayList<>();
int idProducto=0;int resultado=0, valor=0;
    public List<Factura> ingresarfactura()throws Exceptions, SQLException{
        //CONSULTA HACIA LA BASE DE DATOS ENTRE LAS TABLAS CLIENTE INVENTARIO Y CARRITO
         String query = "SELECT C.ID_cliente, I.NombreProducto, DP.Descripcion, I.Imagen , ID_producto, c.ID_carrito,c.cantidad "
                 + ",i.PrecioUnitario FROM Carrito AS C "
                 + "JOIN INVENTARIO AS I ON C.ID_Producto = I.ID_Invent "
                 + "JOIN Detalles_productos AS DP ON C.ID_DetallesProd = DP.ID_DetallesPRD";
        
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
             PreparedStatement stmt = conn.prepareStatement(query);
           ) {
              ResultSet rs = stmt.executeQuery();
            if(!rs.next()){
                throw new  Exceptions("Su carrito esta vacio");
            }else{
                rs = stmt.executeQuery();
            while (rs.next()) {//RECORRIDO DE DATOS
             /*  crp= new CarCompras();
             crp.setIdCarrito(rs.getInt("ID_carrito"));
             crp.setIdUsua(rs.getInt("ID_cliente")); 
             crp.setIdelemnt(rs.getInt("ID_producto")); 
               crp.setNombre(rs.getString("NombreProducto")); 
                crp.setDetalles(rs.getString("Descripcion")); 
              crp.setCantidad(rs.getInt("cantidad"));
              crp.setPrecio(rs.getFloat("PrecioUnitario"));*/
              
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
        }/*crp.setBufferedImage(imagen);
                carrito.add( crp);*/
            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
              JOptionPane.showMessageDialog(null,  e.getMessage());
        }
   
        
        
        
        return factura;
        
        
    }
   
        
    
    
}
