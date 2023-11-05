/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author angeldvvp
 */
public class Inventario extends Productos{
    
    public Inventario(){
        
    }
    String UbicAlmacen;
    public Inventario(int ID_proveedor, String nombre_proveedor, String Tipo_Proveedor, String RUC, String direccion,
            String Correo_electronico, String telefono,byte Imagen,String Nombre, int cantidad, String tipo, String Marca, String Detalles, float precio, String UbicAlma){
       super( ID_proveedor,  nombre_proveedor,  Tipo_Proveedor, RUC,  direccion,
         Correo_electronico, telefono,Imagen,Nombre,cantidad,tipo,Marca,Detalles,precio);
       this.UbicAlmacen=UbicAlma;
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
    
}




