/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.logiikka.palikat;

import labratetris.logiikka.Kentta;
import labratetris.logiikka.palikat.O;
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
public class OTest {

    Kentta kentta;
    O o;

    @Before
    public void setUp() {
        kentta = new Kentta(22, 10);
        o = new O(kentta);
    }

    @Test
    public void KonstruktoriToimii() {
        assertEquals("(4,1)(5,1)(4,2)(5,2)", o.toString());
    }

    public void OEiKaanny() {
        o.kaanna();
        o.kaannaAlas();
        o.kaannaOikea();
        o.kaannaVasen();
        o.kaannaYlos();
        o.kaanna();
        assertEquals("(4,1)(5,1)(4,2)(5,2)", o.toString());
    }
}
