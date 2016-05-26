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
        assertEquals("(4,21)(5,21)(4,20)(5,20)", o.toString());
    }

}
