
package model;

import java.util.Date;

/**
 *dd
 * @author angeldvvp
 */
public class Compra extends CarCompras {
    ///CONSTRUCTOR DE LA CALSE COMPRA
   
   public Compra(){
       //CONSTRUCTOR VACIO EVITA EL INGRESO INNCESARIO DE DATOS DEL CONSTRUCCION INFERIOR
   }
   Date FechaCompra;
    //CONSTRUCTOR 
   public Compra(int idUsua,int idCarrito,int idelemnt,byte Imagen,String Nombre, int cantidad, String tipo, String Marca, String Detalles, float precio, Date FechaCompra){
      
       super(idUsua, idCarrito, idelemnt,Imagen, Nombre, cantidad, tipo, Marca, Detalles, precio);
      this.FechaCompra=FechaCompra;
         
   }
///METODOS SET Y GETS

    public Date getFechaCompra() {
        return FechaCompra;
    }

    public void setFechaCompra(Date FechaCompra) {
        this.FechaCompra = FechaCompra;
    }
   
   
    
}
