/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Control;

import java.util.List;
import model.Factura;
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
public class AdmFacturaTest {
    
    public AdmFacturaTest() {
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
     * Test of Mostrarfactura method, of class AdmFactura.
     */
    @Test
    public void testMostrarfactura() throws Exception {
        System.out.println("Mostrarfactura");
        int idcliente = 100;
        AdmFactura instance = new AdmFactura();
        List<Factura> expResult = null;
        List<Factura> result = instance.Mostrarfactura(idcliente);
        assertEquals(expResult, result);
     
    }

    /**
     * Test of Mostrarfacturaitem method, of class AdmFactura.
     */
    @Test
    public void testMostrarfacturaitem() throws Exception {
        System.out.println("Mostrarfacturaitem");
        int idcliente = 100;
        AdmFactura instance = new AdmFactura();
        List<Factura> expResult = null;
        List<Factura> result = instance.Mostrarfacturaitem(idcliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
