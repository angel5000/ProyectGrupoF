/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
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
    Factura fact;
         List<Factura>  factura= new ArrayList<>();
  public List<Factura> Mostrarfactura(int idcliente)throws Exceptions{
      //METODO QUE INGRESA Y DEVUELVE LOS DATOS DE FACTURA Y PERSONALES DEL CLIENTE
        String consultaCatalogo="{CALL MostrarDatosFactura (?)}";//QUERY PROCEDIMINETO ALMACENADO
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
           CallableStatement stmt = conn.prepareCall(consultaCatalogo);)
            {
                stmt.setInt(1, idcliente);//ID DEL CLIENTE

                stmt.execute();
            
                    try (ResultSet resultSet =  stmt.getResultSet()) {
                        if(!resultSet.next()){
                            throw new Exceptions("NO SE PUDO CARGAR LOS DATOS A LA FACTURA");
                        }else{
                        while (resultSet.next()) {
                            fact = new Factura();
                            fact.setIdfactura(resultSet.getInt("Num_Factura"));
                              fact.setFechavencimiento(resultSet.getDate("Fecha_Vencimiento"));
                                  fact.setFechaCompra(resultSet.getDate("fecha_venta"));
                                  fact.setCedula(resultSet.getString("CedulaCliente"));
                            fact.setNombres(resultSet.getString("NombreCliente"));
                            fact.setApellidos(resultSet.getString("ApellidoCliente"));
                             fact.setDireccion(resultSet.getString("DireccionCliente"));
                            fact.setCorreo_electronico(resultSet.getString("CorreoCliente"));
                            fact.setTelefono(resultSet.getString("TelefonoCliente"));
                            fact.setSubtofac(resultSet.getFloat("Subtotal"));
                              fact.setTotalfac(resultSet.getFloat("total_venta"));
                            System.out.println(resultSet.getFloat("Subtotal")+"subtotal");
        factura.add(fact);
                            
                        }
                        }
                   
                }
            }
         catch (SQLException e) {
            e.printStackTrace();
        }
      
return factura;
}
        
    
    
         List<Factura>  facturaitem= new ArrayList<>();
  public List<Factura> Mostrarfacturaitem(int idcliente)throws Exceptions{
    //METODO QUE INGRESA Y DEVUELVE LOS ITEMS COMPRADOS Y SUS DATOS
         String factu="{CALL ItemsFactura (?)}";//QUERY PROCEDIMINETO ALMACENADO
      try (Connection conn = ConexionBD.conectar();
           CallableStatement stmt = conn.prepareCall(factu);)
            {
                stmt.setInt(1, idcliente);
                
                 
                stmt.execute();
              
                    try (ResultSet resultSet =  stmt.getResultSet()) {
                        while (resultSet.next()) {
                            fact= new Factura();
                               fact.setNombre(resultSet.getString("NombreProducto"));
                             fact.setMarca(resultSet.getString("Marca"));
                             fact.setCantidad(resultSet.getInt("Cantidad"));
                            fact.setPrecio(resultSet.getFloat("PrecioUnitario"));
                            fact.setSubtotal(resultSet.getFloat("Subttotal_compra"));
     fact.setTotal(resultSet.getFloat("Total_compra"));
      
      
        
        
        facturaitem.add(fact);
                            System.out.println(facturaitem.toString());
                        }
                  
                }
            }
         catch (SQLException e) {
            e.printStackTrace();
        }
     
return  facturaitem;
}
}
