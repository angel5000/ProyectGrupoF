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
     
       crp = cmpr;
     carrito.add(crp);
     System.out.println("metodo: "+crp.getNombre());
    
}    

    public List<CarCompras> MostrarPrecompra()throws Exceptions{
     
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
       return idcompra;
   }
    public void ingresarcompra(int idclient,int idproducto, int iddetaprod,int cantidad,
            double preciounit,double subto, double total) throws SQLException{
         
        
        String consultaCatalogo="{CALL InsertarCompra (?, ?, ?, ?, ?, ?, ?,?)}";
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
Comp= new Compra();
           
             Comp.setIdcompra(idcompra);
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
