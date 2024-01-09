/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.image.BufferedImage;
import java.util.Date;


/**
 *
 * @author angeldvvp
 */
public class Inventario extends Productos{
    //CONSTRUCTORES DE LA CLASE INVENTARIO CON HERENCIA A PRODUCTOS
    public Inventario(){
        //CONSTRUCTOR VACIO EVITA EL INGRESO INNCESARIO DE DATOS DEL CONSTRUCCION INFERIOR
    }
    String datos;BufferedImage imagen; 
    Date fechaingreso;
    int idinven=0;
    int iddetal=0;
    char catalogo='N';
    //CONSTRUCTOR DE DATOS RESUMIDOS
    public Inventario(String datos, BufferedImage imagen){
        this.datos=datos;
        this.imagen=imagen;
    }
    String UbicAlmacen;
    //CONSTRUCTOR
    public Inventario( String nombre_proveedor,String Nombre,BufferedImage imagen, int cantidad, String tipo, String Marca, String Detalles, float precio){
        
    }
    
    public Inventario(int idinven,int iddetal,int ID_proveedor, String nombre_proveedor, String Tipo_Proveedor, String RUC, String direccion,
            String Correo_electronico, String telefono,byte Imagen,String Nombre, int cantidad, String tipo, 
            String Marca, String Detalles, float precio, String UbicAlma, Date fechaingreso, char catalogo){
       super( ID_proveedor,  nombre_proveedor,  Tipo_Proveedor, RUC,  direccion,
         Correo_electronico, telefono,Imagen,Nombre,cantidad,tipo,Marca,Detalles,precio);
       this.UbicAlmacen=UbicAlma;
       this.fechaingreso=fechaingreso;
       this.idinven=idinven;
       this.iddetal= iddetal;
       this.catalogo=catalogo;
    }
//SET Y GETS

    public int getIddetal() {
        return iddetal;
    }

    public void setIddetal(int iddetal) {
        this.iddetal = iddetal;
    }

    public int getIdinven() {
        return idinven;
    }

    public void setIdinven(int idinven) {
        this.idinven = idinven;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }
    
    public String getdatos(){
        return datos;
    }
    public BufferedImage img(){
        return imagen;
    }
    public String getUbicAlmacen() {
        return UbicAlmacen;
    }

    public void setUbicAlmacen(String UbicAlmacen) {
        this.UbicAlmacen = UbicAlmacen;
    }

    public byte getImagen() {
        return Imagen;
    }

    public void setImagen(byte Imagen) {
        this.Imagen = Imagen;
    }

    public String getNserie() {
        return Nserie;
    }

    public void setNserie(String Nserie) {
        this.Nserie = Nserie;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public char getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(char catalogo) {
        this.catalogo = catalogo;
    }
    
}




