/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author angeldvvp
 */
import java.util.Date;

public class Cliente {
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

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getRol() {
        return Rol;
    }

    public void setRol(int Rol) {
        this.Rol = Rol;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public Date getFecha_Nacimineto() {
        return Fecha_Nacimineto;
    }

    public void setFecha_Nacimineto(Date Fecha_Nacimineto) {
        this.Fecha_Nacimineto = Fecha_Nacimineto;
    }
}
