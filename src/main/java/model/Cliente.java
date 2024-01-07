/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author angeldvvp
 */
import Control.DatosCliente;
import java.util.Date;

public class Cliente implements DatosCliente {
    private int ID_cliente;
    private String Cedula;
    private String nombres;
    private String Apellidos;
    private int Rol;
    private String Direccion;
    private String correo_electronico;
    private String Telefono;
    private Date Fecha_Nacimineto;

    public Cliente() {
    }
public Cliente( String Cedula, String nombres, String Apellidos,  String Direccion,
            String correo_electronico, String Telefono){
        this.Cedula = Cedula;
        this.nombres = nombres;
        this.Apellidos = Apellidos;
        
        this.Direccion = Direccion;
        this.correo_electronico = correo_electronico;
        this.Telefono = Telefono;
       
    
}
    public Cliente(int ID_cliente, String Cedula, String nombres, String Apellidos, int Rol, String Direccion,
            String correo_electronico, String Telefono, Date Fecha_Nacimineto) {
        this.ID_cliente = ID_cliente;
        this.Cedula = Cedula;
        this.nombres = nombres;
        this.Apellidos = Apellidos;
        this.Rol = Rol;
        this.Direccion = Direccion;
        this.correo_electronico = correo_electronico;
        this.Telefono = Telefono;
        this.Fecha_Nacimineto = Fecha_Nacimineto;
    }

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    @Override
    public String getCedula() {
        return Cedula;
    }

    @Override
    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    @Override
    public String getNombres() {
        return nombres;
    }

    @Override
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Override
    public String getApellidos() {
        return Apellidos;
    }

    @Override
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getRol() {
        return Rol;
    }

    public void setRol(int Rol) {
        this.Rol = Rol;
    }

    @Override
    public String getDireccion() {
        return Direccion;
    }

    @Override
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    @Override
    public String getTelefono() {
        return Telefono;
    }

    @Override
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public Date getFecha_Nacimineto() {
        return Fecha_Nacimineto;
    }

    public void setFecha_Nacimineto(Date Fecha_Nacimineto) {
        this.Fecha_Nacimineto = Fecha_Nacimineto;
    }

    @Override
    public String getCorreoElectronico() {
        return correo_electronico;
    }

    @Override
    public void setCorreoElectronico(String email) {
        email= correo_electronico;
    }

    @Override
    public String toString() {
        return "Cliente{" + "ID_cliente=" + ID_cliente + ", Cedula=" + Cedula + ", nombres=" + nombres + ", Apellidos=" + Apellidos + ", Rol=" + Rol + ", Direccion=" + Direccion + ", correo_electronico=" + correo_electronico + ", Telefono=" + Telefono + ", Fecha_Nacimineto=" + Fecha_Nacimineto + '}';
    }
    
    
}
