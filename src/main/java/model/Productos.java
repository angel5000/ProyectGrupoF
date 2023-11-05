/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author angeldvvp
 */
public class Productos extends Proveedor{
    //CLASE PRODUCTOS CON HERENCIA A PROVEEDOR
     byte Imagen; private String Nombre=""; private int cantidad; 
    private String tipo; private String Marca; private String Detalles; private float precio;String Nserie; String Proveedor;
    public Productos(){
         //CONSTRUCTOR VACIO EVITA EL INGRESO INNCESARIO DE DATOS DEL CONSTRUCCION INFERIOR
    }
    //CONSTRUCTOR
   public Productos(int ID_proveedor, String nombre_proveedor, String Tipo_Proveedor, String RUC, String direccion,
            String Correo_electronico, String telefono,byte Imagen,String Nombre, int cantidad, String tipo, String Marca, String Detalles, float precio ){
       super(ID_proveedor, nombre_proveedor,Tipo_Proveedor,RUC,direccion, Correo_electronico,telefono);
       
       this.Imagen=Imagen;
       this.Nombre=Nombre;
       this.cantidad=cantidad;
       this.tipo=tipo;
       this.Marca=Marca;
       this.Detalles=Detalles;
       this.precio=precio;
               
   }
//SET Y GETS
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
