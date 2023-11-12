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
public class Catalogo extends Inventario {
    
    char Disponible='S';
 String datos="";
 BufferedImage imagen;
 int idcata=0,idprod, iddetall ;
    public Catalogo(){
        //CONSTRUCTOR VACIO EVITA EL INGRESO INNCESARIO DE DATOS DEL CONSTRUCCION INFERIOR
        
    }
    
     //CONSTRUCTOR DE DATOS RESUMIDOS
    public Catalogo(int id,int idprod,int iddetall ,String datos ,BufferedImage Imagen){
        this.idprod=idprod;
        this.iddetall=iddetall;
        this.idcata=id;
        this.datos=datos;
       this.imagen=Imagen;
    }
    public Catalogo(int id, String datos ,BufferedImage Imagen){
     
        this.idcata=id;
        this.datos=datos;
       this.imagen=Imagen;
    }
     //CONSTRUCTOR
    
    public Catalogo(String nombre_proveedor,String Nombre,BufferedImage imagen, int cantidad, String tipo, String Marca, 
            String Detalles, float precio, char disponible){
       super( nombre_proveedor,
        Nombre,imagen,cantidad,tipo,Marca,Detalles,precio);
        this.Disponible=disponible;
    }

    public int getIdcata() {
        return idcata;
    }

    public void setIdcata(int idcata) {
        this.idcata = idcata;
    }

    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public int getIddetall() {
        return iddetall;
    }

    public void setIddetall(int iddetall) {
        this.iddetall = iddetall;
    }

    
    
    @Override
    public BufferedImage img() {
        return imagen;
    }

   

    public char getDisponible() {
        return Disponible;
    }

    public void setDisponible(char Disponible) {
        this.Disponible = Disponible;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

   

   
    
}
