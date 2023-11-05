/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *dd
 * @author angeldvvp
 */
public class Compra {
    ///CONSTRUCTOR DE LA CALSE COMPRA
   
   public Compra(){
       //CONSTRUCTOR VACIO EVITA EL INGRESO INNCESARIO DE DATOS DEL CONSTRUCCION INFERIOR
   }
    byte Imagen; private String Nombre=""; private int cantidad; 
    private String tipo; private String Marca; private String Detalles; private float precio;
    String idUsua="";
    //CONSTRUCTOR 
   public Compra(String idUsua,byte Imagen,String Nombre, int cantidad, String tipo, String Marca, String Detalles, float precio ){
      
       
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
   
    
}
