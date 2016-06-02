/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.logiikka.palikat;

import java.util.ArrayList;
import labratetris.logiikka.Kentta;
import labratetris.logiikka.Pala;
import labratetris.logiikka.palikat.O;
import labratetris.logiikka.palikat.Palikka;
import labratetris.logiikka.palikat.Z;
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
public class PalikkaTest {

    Kentta kentta;
    Palikka palikka;

    @Before
    public void setUp() {
        kentta = new Kentta(22, 10);
        palikka = new Z(kentta);
    }

    @Test
    public void liikuVasen() {
        palikka.vasen();
        assertEquals("(2,1)(3,1)(3,2)(4,2)", palikka.toString());
    }

    @Test
    public void liikuOikea() {
        palikka.oikea();
        assertEquals("(4,1)(5,1)(5,2)(6,2)", palikka.toString());
    }

    @Test
    public void putoa() {
        palikka.putoa();
        assertEquals("(3,2)(4,2)(4,3)(5,3)", palikka.toString());
    }

    @Test
    public void pudotaMaahan() {
        palikka.pudota();
        assertEquals("(3,20)(4,20)(4,21)(5,21)", palikka.toString());

    }

    @Test
    public void eiLiikutaSeinille() {
        palikka.oikea();
        palikka.oikea();
        palikka.oikea();
        palikka.oikea();
        palikka.oikea();
        palikka.oikea();
        assertEquals("(7,1)(8,1)(8,2)(9,2)", palikka.toString());
        for (int i = 0; i < 15; i++) {
            palikka.vasen();
        }
        assertEquals("(0,1)(1,1)(1,2)(2,2)", palikka.toString());

    }

    @Test
    public void eiLiikutaMuidenPalikoidenPaalle() {
        O o = new O(kentta);
        o.pudota();

        palikka.pudota();
        assertEquals("(3,18)(4,18)(4,19)(5,19)", palikka.toString());
    }

    @Test
    public void eiMennaLattianLapi() {
        for (int i = 0; i < 30; i++) {
            palikka.putoa();
        }
        assertEquals("(3,20)(4,20)(4,21)(5,21)", palikka.toString());
    }

    @Test
    public void onkoTyhjallaRuudulla() {
        assertEquals(true, palikka.onkoTyhjallaRuudulla());

        Pala pala = new Pala(3, 1);
        kentta.tayta(3, 1, pala);

        assertEquals(false, palikka.onkoTyhjallaRuudulla());

    }

    @Test
    public void onkoPalikkaKentalla() {
        assertEquals(true, palikka.onkoKentalla());
        ArrayList<Pala> palat = palikka.palat();

        palat.get(0).siirra(-6, 0);
        palat.get(1).siirra(-6, 0);
        palat.get(2).siirra(-6, 0);
        palat.get(3).siirra(-6, 0);

        assertEquals(false, palikka.onkoKentalla());

    }

    @Test
    public void voikoLiikkuaVasen() {
        assertEquals(true, palikka.voikoLiikkuaVasen());
        palikka.vasen();
        palikka.vasen();
        palikka.vasen();
        palikka.vasen();
        palikka.vasen();
        palikka.vasen();

        assertEquals(false, palikka.voikoLiikkuaVasen());
    }

    @Test
    public void voikoLiikkuaOikea() {
        assertEquals(true, palikka.voikoLiikkuaOikea());
        palikka.oikea();
        palikka.oikea();
        palikka.oikea();
        palikka.oikea();
        palikka.oikea();
        palikka.oikea();

        assertEquals(false, palikka.voikoLiikkuaOikea());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
