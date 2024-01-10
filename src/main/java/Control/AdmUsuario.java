/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author LARABEL
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.ConexionBD;
import model.Factura;
import model.Usuario;

public class AdmUsuario {
    
    public int Login(String usu, String pass) throws Exceptions{
        int IDCLIENTE=0;
            String QUERY="{CALL VerificarUsuario ( ?, ?, ?)}";//QUERY
        try (Connection conn = ConexionBD.conectar();//CONEXION HACIA LA BD
           CallableStatement stmt = conn.prepareCall(QUERY);)
            {
               
                 stmt.setString(1, usu);//RECIVE USUARIO
                  stmt.setString(2, pass);//RECIVE CONTRASEÑA
                stmt.registerOutParameter(3, java.sql.Types.INTEGER);//DEVUELVE EL ID 

                 stmt.execute();
                  IDCLIENTE = stmt.getInt(3);//SE GUARDA EL ID
   
                    System.out.println("IDCLIENTE: " + IDCLIENTE);
               if(IDCLIENTE==0){
                throw new  Exceptions("VERIFIQUE SUS CREDENCIALES");
               }
                  
              
               
            }
         catch (SQLException e) {
            
           e.printStackTrace();
        } 
        return IDCLIENTE;
    }
     
    
    
}

