/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Control;

import java.awt.image.BufferedImage;
import java.util.List;
import model.CarCompras;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author angeldvvp
 */
public class AdmCompraTest {
    
    public AdmCompraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Carrito method, of class AdmCarrito.
     */
    @Test
    public void testCarrito() throws Exception {
        System.out.println("Carrito");
        AdmCarrito instance = new AdmCarrito();
       // List<CarCompras> expResult = null;
     //   List<CarCompras> result = instance.Carrito();
       // System.out.println(result.toString());
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of IngresarItemCarrito method, of class AdmCarrito.
     */
    @Test
    public void testIngresarItemCarrito() throws Exception {
        System.out.println("IngresarItemCarrito");
        int IDCatalogo = 2;
        int cantidad = 4;
        AdmCarrito instance = new AdmCarrito();
        instance.IngresarItemCarrito(IDCatalogo, cantidad);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarItemcarrito method, of class AdmCarrito.
     */
    @Test
    public void testBuscarItemcarrito() throws Exception {
        System.out.println("BuscarItemcarrito");
        String Buscar = "Perno"; 
          byte img=0;
          CarCompras Item = new CarCompras();
    
        AdmCarrito instance = new AdmCarrito();
        
        List<CarCompras> expResult = new java.util.ArrayList<>();
        expResult.add(new CarCompras(100,104,1,img,"Perno Hexagonal 1/4",1,
                "", "STANLEY1", "Perno galvanizado, 1/4\" x 1.5\" ", 5));
       
       // List<CarCompras> result = instance.BuscarItemcarrito(Buscar,expResult);
       // assertEquals(1, result.size()); // Verifica que solo hay un elemento en la lista de resultados
    }

    /**
     * Test of RemoverItem method, of class AdmCarrito.
     */
    @Test
    public void testRemoverItem() throws Exceptions {
        System.out.println("RemoverItem");
        CarCompras gt = new CarCompras();
        gt.setIdCarrito(110);
        int idProducto = 110;
        CarCompras elem = gt;
        AdmCarrito instance = new AdmCarrito();
        int expResult = 1;
        int result = instance.RemoverItem(idProducto, elem);
        assertEquals(expResult, result);
       
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of VerificarItems method, of class AdmCompra.
     */
   

    /**
     * Test of ExcepcionVerificar method, of class AdmCompra.
     */


    /**
     * Test of ExcepcionIngresoCRP method, of class AdmCompra.
     */

}
