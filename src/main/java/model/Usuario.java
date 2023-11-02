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

public class Usuario {
    private int ID_Administrador;
    private String NombreUsuario;
    private String Contraseña;
    private String NombreCompleto;
    private String CorreoElectronico;
    private int Rol;
    private Date FechaRegistro;

    public Usuario() {
    }

    public Usuario(int ID_Administrador, String NombreUsuario, String Contraseña, String NombreCompleto,
            String CorreoElectronico, int Rol, Date FechaRegistro) {
        this.ID_Administrador = ID_Administrador;
        this.NombreUsuario = NombreUsuario;
        this.Contraseña = Contraseña;
        this.NombreCompleto = NombreCompleto;
        this.CorreoElectronico = CorreoElectronico;
        this.Rol = Rol;
        this.FechaRegistro = FechaRegistro;
    }

    public int getID_Administrador() {
        return ID_Administrador;
    }

    public void setID_Administrador(int ID_Administrador) {
        this.ID_Administrador = ID_Administrador;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public int getRol() {
        return Rol;
    }

    public void setRol(int Rol) {
        this.Rol = Rol;
    }

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }
}
