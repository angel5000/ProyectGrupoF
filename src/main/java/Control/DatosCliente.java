/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Control;

/**
 *
 * @author angeldvvp
 */
public interface DatosCliente {
   
    String getCedula();
    String getNombres();
    String getApellidos();
    String getDireccion();
    String getCorreoElectronico();
    String getTelefono();
 void setCedula(String cedula);
     void setNombres(String nombres);
     void setApellidos(String apellidos);
     void setDireccion(String dire);
    void setCorreoElectronico(String email);
     void setTelefono(String telefono);
}
