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
public class CarCompras {
    
    byte Imagen; private String Nombre=""; private int cantidad; 
    private String tipo; private String Marca; private String Detalles; private float precio;
    int idUsua=0,idelemnt=0;
    BufferedImage imagen;int idCarrito=0, iddetalle, idcompra;
    public CarCompras(){
        
    }
     public CarCompras(int idUsua,String Nombre, int cantidad, String tipo, String Marca, String Detalles, float precio ){
  this.idUsua=idUsua;

       this.Nombre=Nombre;
       this.cantidad=cantidad;
       this.tipo=tipo;
       this.Marca=Marca;
       this.Detalles=Detalles;
       this.precio=precio;
         
   }
    
    
     public CarCompras(int idUsua,int idCarrito,int idelemnt,int id_Detalle,byte Imagen,String Nombre, int cantidad, String tipo, String Marca, String Detalles, float precio ){
      this.idelemnt=idelemnt;
        this.iddetalle=id_Detalle;
       this.idCarrito= idCarrito;
       this.idUsua=idUsua;
       this.Imagen=Imagen;
       this.Nombre=Nombre;
       this.cantidad=cantidad;
       this.tipo=tipo;
       this.Marca=Marca;
       this.Detalles=Detalles;
       this.precio=precio;
         
   }
///METODOS SET Y GETS

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

     
    public int getIdelemnt() {
        return idelemnt;
    }

    public void setIdelemnt(int idelemnt) {
        this.idelemnt = idelemnt;
    }

    public int getIdUsua() {
        return idUsua;
    }

    public int getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }

    public void setIdUsua(int idUsua) {
        this.idUsua = idUsua;
    }
    
     public void setBufferedImage(BufferedImage img) {
        this.imagen= img;
    }
      public BufferedImage img(){
        return imagen;
    }
    public byte getImagen() {
        return Imagen;
    }

    public void setImagen(byte Imagen) {
        this.Imagen = Imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getDetalles() {
        return Detalles;
    }

    public void setDetalles(String Detalles) {
        this.Detalles = Detalles;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "CarCompras{" + "Imagen=" + Imagen + ", Nombre=" + Nombre + ", cantidad=" + cantidad + ", tipo=" + tipo + ", Marca=" + Marca + ", Detalles=" + Detalles + ", precio=" + precio + ", idUsua=" + idUsua + ", idelemnt=" + idelemnt + ", imagen=" + imagen + '}';
    }

    
}
