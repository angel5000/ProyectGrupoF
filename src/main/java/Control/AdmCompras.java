/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CarCompras;
import model.Compra;
import model.ConexionBD;

/**
 *
 * @author angeldvvp
 */
public class AdmCompras {
       int idcompra=0;
   List<CarCompras>  carrito = new ArrayList<>();
     List<Compra>  compras = new ArrayList<>();
     CarCompras crp;
Compra Comp;
   
 public void IngresarPrecompra(CarCompras cmpr )throws Exceptions{
     //METODO QUE RECIVE LOS DATOS DEL CARRITO
       crp = cmpr;
     carrito.add(crp);
    
    
}    

    public List<CarCompras> MostrarPrecompra()throws Exceptions{
     //METODO QUE DEVUELVE LOS DATOS DEL CARRITO EN LA PARTE DE VENTA
return carrito;
}
public void ingresarcodcompra(int idclient){
    String codcomp="{CALL InsertarCompraRealiza (?,?)}";
        try (Connection conn = ConexionBD.conectar();
           CallableStatement stmt = conn.prepareCall(codcomp);)
            {
                stmt.setInt(1, idclient);
                 stmt.registerOutParameter(2, java.sql.Types.INTEGER); // Configura el parámetro de salida

                stmt.execute();
                 idcompra= stmt.getInt(2);
                System.out.println("Codigo compra ingresado."+ idcompra);
            }
         catch (SQLException e) {
            e.printStackTrace();
        }
}
   public int idcomra(){
       //DEVUELVE EL ID DE LA COMPRA PARA PODER SER REGISTRADA COMO UN SOLO REGISTRO DE VARIOS.
       return idcompra;
   }
    public void ingresarcompra(int idclient,int idproducto, int iddetaprod,int cantidad,
            double preciounit,double subto, double total) throws SQLException{
         //METODO QUE INGRESA LA COMPRA DEL CLIENTE
        
        String consultaCatalogo="{CALL InsertarCompra (?, ?, ?, ?, ?, ?, ?,?)}";//QUERY 
        try (Connection conn = ConexionBD.conectar();
           CallableStatement stmt = conn.prepareCall(consultaCatalogo);)
            {
                stmt.setInt(1, idclient);
                stmt.setInt(2, idproducto);
                stmt.setInt(3, iddetaprod);
                stmt.setInt(4, cantidad);
                stmt.setDouble(5, preciounit);
                stmt.setDouble(6, subto);
                stmt.setDouble(7, total);
                 stmt.setInt(8, idcomra());
Comp= new Compra();//OBJETO DE LA CLASE
           
             Comp.setIdcompra(idcompra); //INGRESO DE DATOS DE LA CLASE
             Comp.setSubtotal(subto);
              Comp.setTotal(total);
       compras.add(Comp);
                stmt.execute();
                System.out.println("Inserción exitosa.");
                System.out.println(compras.toString());
            }
         catch (SQLException e) {
            e.printStackTrace();
        }
}
}
