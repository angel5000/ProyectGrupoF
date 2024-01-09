/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Control.DatosCliente;
import java.util.Date;

/**
 *
 * @author angeldvvp
 */
public class Factura extends Compra implements DatosCliente{
     int idfactura=0; Date fechavencimiento;
     String Cedula, nombres, Apellidos,   Direccion,
             correo_electronico,  Telefono;
     double subtofac=0,totalfac=0;
     public Factura(){}
     
     public Factura(String Cedula, String nombres, String Apellidos,  String Direccion,
            String correo_electronico, String Telefono,
             
             int idfactura,int idUsua,int idcompra,String Nombre, int cantidad, String tipo, String Marca, String Detalles, float precio,
           double subtotal,double total,Date FechaCompra, Date fechavencimiento, double subtofac,double totalfac){
    super( idUsua, idcompra, Nombre, cantidad, tipo, Marca,Detalles, precio,
           subtotal, total, FechaCompra);
    this.Cedula = Cedula;
        this.nombres = nombres;
        this.Apellidos = Apellidos;
        
        this.Direccion = Direccion;
        this.correo_electronico = correo_electronico;
        this.Telefono = Telefono;
       
       this.idfactura=idfactura;
    this.fechavencimiento=fechavencimiento;
    this.subtofac=subtofac;
    this.totalfac=totalfac;
         
   }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

     
    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    @Override
    public String toString() {
        return "Factura{" + "idfactura=" + idfactura + ", fechavencimiento=" + fechavencimiento + '}';
    }

    @Override
    public String getCedula() {
      return Cedula;
    }

    @Override
    public String getNombres() {
       return nombres;
    }

    @Override
    public String getApellidos() {
      return Apellidos;
    }

    @Override
    public String getDireccion() {
        
        return   Direccion;
    }

    @Override
    public String getCorreoElectronico() {
       return    correo_electronico;
    }

    @Override
    public String getTelefono() {
   return Telefono;
    
    }


    @Override
    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    

    @Override
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

  

    @Override
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

   

    
    @Override
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

 
    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

  

    @Override
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

   
    @Override
    public void setCorreoElectronico(String email) {
        email= correo_electronico;
    }

    public double getSubtofac() {
        return subtofac;
    }

    public void setSubtofac(double subtofac) {
        this.subtofac = subtofac;
    }

    public double getTotalfac() {
        return totalfac;
    }

    public void setTotalfac(double totalfac) {
        this.totalfac = totalfac;
    }
    
    
}
