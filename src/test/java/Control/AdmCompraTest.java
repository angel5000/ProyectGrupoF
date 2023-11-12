/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Control;

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
     * Test of Carrito method, of class AdmCompra.
     */
    @Test
    public void testCarrito() throws Exception {
        System.out.println("Carrito");
        AdmCompra instance = new AdmCompra();
        List<CarCompras> expResult = null;
        List<CarCompras> result = instance.Carrito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of IngresarItemCarrito method, of class AdmCompra.
     */
    @Test
    public void testIngresarItemCarrito() throws Exception {
        System.out.println("IngresarItemCarrito");
        int IDCatalogo = 1004;
        int cantidad = 1;
        AdmCompra instance = new AdmCompra();
        instance.IngresarItemCarrito(IDCatalogo, cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RemoverItem method, of class AdmCompra.
     */
    @Test
    public void testRemoverItem() {
        System.out.println("RemoverItem");
        int idProducto = 0;
        AdmCompra instance = new AdmCompra();
        int expResult = 0;
        int result = instance.RemoverItem(idProducto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of VerificarItems method, of class AdmCompra.
     */
    @Test
    public void testVerificarItems() throws Exception {
        System.out.println("VerificarItems");
        int IDCatalogo = 0;
        AdmCompra instance = new AdmCompra();
        int expResult = 0;
        int result = instance.VerificarItems(IDCatalogo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ExcepcionVerificar method, of class AdmCompra.
     */
    @Test
    public void testExcepcionVerificar() throws Exception {
        System.out.println("ExcepcionVerificar");
        AdmCompra.ExcepcionVerificar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ExcepcionIngresoCRP method, of class AdmCompra.
     */
    @Test
    public void testExcepcionIngresoCRP() throws Exception {
        System.out.println("ExcepcionIngresoCRP");
        AdmCompra.ExcepcionIngresoCRP();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
