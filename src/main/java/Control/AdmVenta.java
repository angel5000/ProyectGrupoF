/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;


import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ConexionBD;
import model.Factura;

/**
 *
 * @author angeldvvp
 */
public class AdmVenta {
 Factura fact; int idmetpago=0;
    public void IngresarMETPAGO(int idclient, int metodo){
        String consultaCatalogo="{CALL InsertarFormaPago (?, ?,?)}";//QUERY
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
           CallableStatement stmt = conn.prepareCall(consultaCatalogo);)
            {
                stmt.setInt(1, idclient);//INGRESO ID DEL CLIENTE
                stmt.setInt(2, metodo);//ID INGRESO METODO DE PAGO
                   stmt.registerOutParameter(3, java.sql.Types.INTEGER); // DEVUELVE EL ID GENERADO DE LA INSERCION

               
                 
                stmt.execute();
               idmetpago= stmt.getInt(3);
                System.out.println("Codigo compra ingresado."+  idmetpago);
                System.out.println("Metopago ingresado"+idclient+" "+metodo);
             stmt.close();
            }
         catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int idpago(){
        return  idmetpago;
    }
    
      public  List<Factura> factura = new ArrayList<>();
    public void ingresarfactura(int idCliente,int metodoPago, String estado,
            String fechaVencimiento,double subtotal, double totalVenta ,int idCompra)throws Exceptions, SQLException{
        //SE INGRESA LOS DATOS (IDS) EN LA TABLA FACTURA
        int numfac=0;
     String consultaCatalogo="{CALL InsertarFactura ( ?, ?, ?, ?, ?, ?, ?,?)}";//QUERY
        try (Connection conn = ConexionBD.conectar();
           CallableStatement stmt = conn.prepareCall(consultaCatalogo);)
            {
               System.out.println("ingreso factura");
                
                stmt.setInt(1, idCliente);
                stmt.setInt(2, metodoPago);
                stmt.setString(3, estado);
                stmt.setString(4, fechaVencimiento);
                stmt.setDouble(5, subtotal);
                stmt.setDouble(6, totalVenta);
                stmt.setDouble(7, idCompra);
                stmt.registerOutParameter(8, java.sql.Types.INTEGER); // DEVUELVE EL ID DE LA FACTURA

                 stmt.execute();
                   numfac = stmt.getInt(8);
   
                    System.out.println("Número de factura generado: " + numfac);
                
                 
                fact= new Factura();
                
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            Date fecha = formato.parse(fechaVencimiento);
  Date fechaActual = new Date();//CONVERSION DE DATOS

        
               
                System.out.println("Inserción exitosa.");
              
            }
         catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
         Logger.getLogger(AdmVenta.class.getName()).log(Level.SEVERE, null, ex);
     }
       
    }
public Factura fac(){
    return fact;
}
}
 

