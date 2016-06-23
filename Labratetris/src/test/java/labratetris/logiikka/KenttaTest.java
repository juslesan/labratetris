/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
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

    @Test
    public void rivitPutoavatTyhjennettaessa() {
        for (int i = 0; i < kentta.getKorkeus(); i++) {
            for (int x = 0; x < kentta.getLeveys() - 1; x++) {
                kentta.tayta(x, i, new Pala(x, i));
            }
        }
        kentta.tayta(9, 19, new Pala(10, 20));
        kentta.tayta(9, 18, new Pala(10, 19));
        kentta.tayta(9, 17, new Pala(10, 18));
        kentta.tyhjennaTaydetRivit();
        assertEquals(false, kentta.onkoRiviTaynna(2));
        assertEquals(false, kentta.onkoRiviTaynna(1));
        assertEquals(false, kentta.onkoRiviTaynna(0));
    }

    @Test
    public void rivitPutoavatOikeinJosValissaOnVajaaRivi() {
        for (int i = 0; i < kentta.getKorkeus(); i++) {
            for (int x = 0; x < kentta.getLeveys() - 1; x++) {
                kentta.tayta(x, i, new Pala(x, i));
            }
        }
        kentta.tyhjenna(8, 18);
        kentta.tayta(9, 19, new Pala(9, 19));
        kentta.tayta(9, 17, new Pala(9, 17));
        kentta.tyhjennaTaydetRivit();
        assertEquals(false, kentta.onkoRuudussaPala(8, 19));
    }

    @Test
    public void meneekoLiianKorkealleToimii() {
        assertEquals(false, kentta.meneekoLiianKorkealle());
        kentta.tayta(5, 1, new Pala(5, 1));
        assertEquals(true, kentta.meneekoLiianKorkealle());
    }

    @Test
    public void tyhjennaTaydetRivitPalauttaaOikein() {
        for (int i = 0; i < kentta.getKorkeus(); i++) {
            for (int x = 0; x < kentta.getLeveys(); x++) {
                kentta.tayta(x, i, new Pala(x, i));
            }
        }
        assertEquals(22, kentta.tyhjennaTaydetRivit());
    }

    @Test
    public void ruudunTyhjennysPalauttaaPoistetunPalan() {
        kentta.tayta(0, 0, new Pala(0, 0));
        assertEquals("(0,0)", kentta.tyhjenna(0, 0).toString());
    }

    @Test
    public void getKentanPalat() {
        Pala pala1 = new Pala(0, 0);
        Pala pala2 = new Pala(1, 0);
        Pala pala3 = new Pala(2, 0);
        Pala pala4 = new Pala(3, 0);
        Pala pala5 = new Pala(4, 0);
        ArrayList<Pala> lista = new ArrayList();
        lista.add(pala1);
        lista.add(pala2);
        lista.add(pala3);
        lista.add(pala4);
        lista.add(pala5);
        kentta.tayta(0, 0, pala1);
        kentta.tayta(1, 0, pala2);
        kentta.tayta(2, 0, pala3);
        kentta.tayta(3, 0, pala4);
        kentta.tayta(4, 0, pala5);
        assertEquals(lista, kentta.kentanPalat());
    }

    @Test
    public void virheellisetSyotteet() {
        kentta.tayta(-1, 0, new Pala(0, 0));
        assertEquals(true, kentta.kentanPalat().isEmpty());
        assertEquals(false, kentta.onkoRiviTaynna(-1));
        assertEquals(false, kentta.onkoRiviTaynna(kentta.getKorkeus() + 1));
        assertEquals(null, kentta.tyhjenna(-1, -1));
        assertEquals(null, kentta.tyhjenna(kentta.getLeveys() + 1, kentta.getKorkeus() + 1));
    }
    // TODO add test methods here.
// The methods must be annotated with annotation @Test. For example:
//
// @Test
// public void hello() {}
}
