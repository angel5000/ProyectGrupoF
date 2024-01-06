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



public abstract class AbstractCarrito {
    protected List<CarCompras> carrito;
    
 
   public AbstractCarrito(List<CarCompras> carrito) {
        this.carrito = carrito;
    }

    public abstract List<CarCompras> mostrarPrecompra() throws Exception;

}