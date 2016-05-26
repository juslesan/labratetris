/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import labratetris.logiikka.Kentta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juslesan
 */
public class KenttaTest {

    Kentta kentta;

    @Before
    public void setUp() {
        kentta = new Kentta(22, 10);

    }
    
    @Test
    public void konstruktoriToimii() {
        assertEquals(22, kentta.getKorkeus());
        assertEquals(10, kentta.getLeveys());
        assertEquals(false, kentta.onkoRuudussaPala(9, 21));
        assertEquals(false, kentta.onkoRuudussaPala(0, 0));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
