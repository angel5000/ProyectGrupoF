/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.util.ArrayList;
import java.util.List;
import model.CarCompras;

/**
 *
 * @author angeldvvp
 */
public class AdmVenta {
 
    
   List<CarCompras>  carrito = new ArrayList<>();
     CarCompras crp;

   
 public void IngresarPrecompra(CarCompras cmpr )throws Exceptions{
     
       crp = cmpr;
     carrito.add(crp);
     System.out.println("metodo: "+crp.getNombre());
    
}    

    public List<CarCompras> MostrarPrecompra()throws Exceptions{
     
return carrito;
}

   
    
    
 
}
