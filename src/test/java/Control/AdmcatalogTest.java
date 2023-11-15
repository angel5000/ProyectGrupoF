/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Control;

import java.util.List;
import model.CarCompras;
import model.Catalogo;
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
public class AdmcatalogTest {
    
    public AdmcatalogTest() {
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
     * Test of Catalogos method, of class Admcatalog.
     */
    @Test
    public void testCatalogos() {
        System.out.println("Catalogos");
        
        Admcatalog instance = new Admcatalog();
        Catalogo ct = new Catalogo();
        ct.setIdcata(2);
        ct.setDatos("Nombre: Perno Hexagonal 1/4" +
"\nMarca:STANLEY0" +
"\nDescripcion: Perno hexagonal de acero inoxidable, 1/4\" x 2\" " +
"\nPrecio: $10.2");
        
   List<Catalogo> expResult = new java.util.ArrayList<>();
        expResult.add(ct);
        List<Catalogo> result = instance.Catalogos();
       // System.out.println(result.toString());
        assertEquals(expResult.toString(), result.getFirst().toString());
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of Buscar method, of class Admcatalog.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("Buscar");
        String busqueda = "Perno";
        Catalogo ct = new Catalogo();
        ct.setNombre("Perno M8");
        Admcatalog instance = new Admcatalog();
        List<Catalogo> expResult = new java.util.ArrayList<>();
        expResult.add(ct);
        List<Catalogo> result = instance.Buscar(busqueda);
        System.out.println(result);
      //  assertEquals(1, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
