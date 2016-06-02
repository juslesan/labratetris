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
public class TTest {

    Kentta kentta;
    T t;

    @Before
    public void setUp() {
        kentta = new Kentta(22, 10);
        t = new T(kentta);
    }

    @Test
    public void KonstruktoriToimii() {
        assertEquals("(3,2)(4,2)(4,1)(5,2)", t.toString());
    }

    @Test
    public void kaanna360() {
        t.kaanna();
        t.kaanna();
        t.kaanna();
        t.kaanna();
        assertEquals("(3,2)(4,2)(4,1)(5,2)", t.toString());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
