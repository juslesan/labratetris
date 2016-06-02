/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.logiikka.palikat;

import labratetris.logiikka.Kentta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Santeri Juslenius
 */
public class STest {

    Kentta kentta;
    S s;

    @Before
    public void setUp() {
        kentta = new Kentta(22, 10);
        s = new S(kentta);
    }

    @Test
    public void KonstruktoriToimii() {
        assertEquals("(3,2)(4,2)(4,1)(5,1)", s.toString());
    }

    @Test
    public void kaanna360() {
        s.kaanna();
        s.kaanna();
        s.kaanna();
        s.kaanna();
        assertEquals("(3,2)(4,2)(4,1)(5,1)", s.toString());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
