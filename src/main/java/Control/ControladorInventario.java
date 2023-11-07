/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.util.List;
import model.Inventario;
import model.InventarioDAO;

/**
 *
 * 
 */
public class ControladorInventario {
    private InventarioDAO inventarioDAO;

    public ControladorInventario(InventarioDAO inventarioDAO) {
        this.inventarioDAO = inventarioDAO;
    }

    public List<Inventario> obtenerInventario() {
        return inventarioDAO.listarInventario();
    }
}
