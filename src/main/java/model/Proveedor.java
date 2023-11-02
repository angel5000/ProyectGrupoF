/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author angeldvvp
 */
public class Proveedor {
    private int ID_proveedor;
    private String nombre_proveedor;
    private String Tipo_Proveedor;
    private String RUC;
    private String direccion;
    private String Correo_electronico;
    private String telefono;

    public Proveedor() {
    }

    public Proveedor(int ID_proveedor, String nombre_proveedor, String Tipo_Proveedor, String RUC, String direccion,
            String Correo_electronico, String telefono) {
        this.ID_proveedor = ID_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.Tipo_Proveedor = Tipo_Proveedor;
        this.RUC = RUC;
        this.direccion = direccion;
        this.Correo_electronico = Correo_electronico;
        this.telefono = telefono;
    }

    public int getID_proveedor() {
        return ID_proveedor;
    }

    public void setID_proveedor(int ID_proveedor) {
        this.ID_proveedor = ID_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getTipo_Proveedor() {
        return Tipo_Proveedor;
    }

    public void setTipo_Proveedor(String Tipo_Proveedor) {
        this.Tipo_Proveedor = Tipo_Proveedor;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo_electronico() {
        return Correo_electronico;
    }

    public void setCorreo_electronico(String Correo_electronico) {
        this.Correo_electronico = Correo_electronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
