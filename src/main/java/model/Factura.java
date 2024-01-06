/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.image.BufferedImage;

/**
 *
 * @author angeldvvp
 */
public class Factura extends CarCompras{
     int idfactura=0;
     public Factura(int idfactura,int idUsua,int idelemnt,String Nombre, int cantidad, String tipo, String Marca, String Detalles, float precio ){
    super( idUsua,idelemnt,Nombre, cantidad, tipo, Marca, Detalles, precio);
       this.idfactura=idfactura;
    /* 
         this.idelemnt=idelemnt;
       this.idCarrito= idCarrito;
       this.idUsua=idUsua;
       this.Imagen=Imagen;
       this.Nombre=Nombre;
       this.cantidad=cantidad;
       this.tipo=tipo;
       this.Marca=Marca;
       this.Detalles=Detalles;
       this.precio=precio;*/
         
   }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }
    
    
}
