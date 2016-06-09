/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import labratetris.logiikka.Kentta;
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

    @Test
    public void ruutujenTaytto() {
        assertEquals(false, kentta.onkoRuudussaPala(0, 0));
        kentta.tayta(0, 0, new Pala(0, 0));
        assertEquals(true, kentta.onkoRuudussaPala(0, 0));
    }

    @Test
    public void ruutujenTyhjennys() {
        kentta.tayta(0, 0, new Pala(0, 0));
        assertEquals(true, kentta.onkoRuudussaPala(0, 0));
        kentta.tyhjenna(0, 0);
        assertEquals(false, kentta.onkoRuudussaPala(0, 0));
    }

    @Test
    public void onkoRiviTaynna() {
        for (int i = 0; i < 10; i++) {
            kentta.tayta(i, 0, new Pala(i, 0));
        }
        assertEquals(true, kentta.onkoRiviTaynna(0));

        kentta.tyhjenna(0, 0);
        assertEquals(false, kentta.onkoRiviTaynna(0));
    }

    @Test
    public void rivinTyhjennys() {
        for (int i = 0; i < 10; i++) {
            kentta.tayta(i, 0, new Pala(i, 0));
        }
        assertEquals(true, kentta.onkoRiviTaynna(0));

        kentta.tyhjennaRivi(0);
        assertEquals(false, kentta.onkoRiviTaynna(0));
    }

    @Test
    public void kaikkienRivienTyhjennysToimii() {
        kentta.tayta(0, 0, new Pala(0, 0));
        kentta.tyhjennaTaydetRivit();
        assertEquals(true, kentta.onkoRuudussaPala(0, 0));

        for (int i = 0; i < kentta.getKorkeus(); i++) {
            for (int x = 0; x < kentta.getLeveys(); x++) {
                kentta.tayta(x, i, new Pala(x, i));
            }
        }
        kentta.tyhjennaTaydetRivit();
        assertEquals(false, kentta.onkoRuudussaPala(0, 0));
    }

    // TODO add test methods here.
// The methods must be annotated with annotation @Test. For example:
//
// @Test
// public void hello() {}
}
