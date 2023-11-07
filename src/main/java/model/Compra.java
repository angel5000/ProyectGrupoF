
package model;

import java.util.Date;

/**
 *
 * @author angeldvvp
 */
public class Compra extends CarCompras {
    ///CONSTRUCTOR DE LA CALSE COMPRA
   
   public Compra(){
       //CONSTRUCTOR VACIO EVITA EL INGRESO INNCESARIO DE DATOS DEL CONSTRUCCION INFERIOR
   }
   /*byte Imagen; private String Nombre=""; private int cantidad; 
    private String tipo; private String Marca; private String Detalles; private float precio;
    String idUsua="",*/ Date FechaCompra;
    //CONSTRUCTOR 
   public Compra(int idUsua,int idelemnt,byte Imagen,String Nombre, int cantidad, String tipo, String Marca, String Detalles, float precio, Date FechaCompra){
      
       super(idUsua,  idelemnt,Imagen, Nombre, cantidad, tipo, Marca, Detalles, precio);
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
