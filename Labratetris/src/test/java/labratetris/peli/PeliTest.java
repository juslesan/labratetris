/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.peli;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Santeri Juslenius
 * 
 * 
 */
public class PeliTest {

    Peli peli;

    @Before
    public void setUp() {
        peli = new Peli(22, 12, 2);
    }

    @Test
    public void arvoPalikkaEiPalautaNull() {
        for (int i = 0; i < 200; i++) {
            peli.arvoPalikka();
            assertNotEquals(null, peli.getPalikka());
        }
    }

    @Test
    public void tasonVaihtoPToimii() {
        peli.vaikeusTasonVaihto(4);
        peli.vaikeusTasonVaihto(4);
        peli.vaikeusTasonVaihto(4);
        assertEquals(4, peli.getVaikeus());
    }

    @Test
    public void palanVaihtoToimii() {
        assertEquals(null, peli.getVaihtoPalikka());
        peli.vaihtoPalikka();
        assertNotEquals(null, peli.getVaihtoPalikka());
    }

    @Test
    public void seuraaviaPalikoitaAinaKolme() {
        assertEquals(3, peli.getSeuraavat().size());
        peli.uusiPalikka();
        peli.uusiPalikka();
        peli.uusiPalikka();
        peli.uusiPalikka();
        peli.uusiPalikka();
        peli.uusiPalikka();
        assertEquals(3, peli.getSeuraavat().size());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
