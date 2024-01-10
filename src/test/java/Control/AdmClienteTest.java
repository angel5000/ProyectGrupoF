/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Control;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
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
public class AdmClienteTest {
    
    public AdmClienteTest() {
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
     * Test of Mostrardatosclientes method, of class AdmCliente.
     */
    @Test
    public void testMostrardatosclientes() {
        System.out.println("Mostrardatosclientes");
        int id = 100;
        AdmCliente instance = new AdmCliente();
        AdmCliente instance2 = new AdmCliente();
        List<Cliente> expResult = instance2.Mostrardatosclientes(100);
        List<Cliente> result = new ArrayList<>();
        for(int i=0;i<1;i++){
            result=instance.Mostrardatosclientes(id);
        }
        assertEquals(expResult.toString(), result.toString());
        System.out.println(expResult.toString()+"\n"+ result.toString());
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
