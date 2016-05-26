/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import labratetris.logiikka.Pala;
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
public class PalaTest {

    Pala pala;

    @Before
    public void setUp() {
        pala = new Pala(5, 5);
    }

    @Test
    public void putoaToimii() {
        pala.putoa();

        assertEquals(6, pala.getY());

        pala.putoa();
        pala.putoa();
        pala.putoa();
        assertEquals(9, pala.getY());
    }

    @Test
    public void vasemmalleLiikkuminen() {
        pala.vasen();
        assertEquals(4, pala.getX());
        pala.vasen();
        pala.vasen();
        pala.vasen();
        assertEquals(1, pala.getX());
    }

    @Test
    public void oikealleLiikkuminen() {
        pala.oikea();
        assertEquals(6, pala.getX());
        pala.oikea();
        pala.oikea();
        pala.oikea();
        assertEquals(9, pala.getX());
    }

    @Test
    public void siirtaminenToimii() {
        pala.siirra(2, 2);
        assertEquals("(7,7)", pala.toString());
        pala.siirra(-2, -2);
        assertEquals("(5,5)", pala.toString());
        pala.siirra(-5, -5);
        assertEquals("(0,0)", pala.toString());

    }

}
