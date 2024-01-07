
package model;

import java.util.Date;

/**
 *dd
 * @author angeldvvp
 */
public class Compra extends CarCompras {
    ///CONSTRUCTOR DE LA CALSE COMPRA
   double subtotal=0,total=0;
   int idcompra=0;
   public Compra(){
       //CONSTRUCTOR VACIO EVITA EL INGRESO INNCESARIO DE DATOS DEL CONSTRUCCION INFERIOR
   }
   Date FechaCompra;
    //CONSTRUCTOR 
   public Compra(int idUsua,int idcompra,String Nombre, int cantidad, String tipo, String Marca, String Detalles, float precio,
           double subtotal,double total,Date FechaCompra){
      
       super( idUsua,Nombre, cantidad, tipo,  Marca,  Detalles,  precio);
       this.idcompra=idcompra;
      this.FechaCompra=FechaCompra;
      this.idcompra=idcompra;
         
   }
///METODOS SET Y GETS

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaCompra() {
        return FechaCompra;
    }

    public void setFechaCompra(Date FechaCompra) {
        this.FechaCompra = FechaCompra;
    }

    @Override
    public String toString() {
        return "Compra{" + "subtotal=" + subtotal + ", total=" + total + ", idcompra=" + idcompra + ", FechaCompra=" + FechaCompra + '}';
    }
   
   
    
}
