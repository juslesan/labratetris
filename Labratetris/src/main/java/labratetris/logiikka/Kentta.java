package labratetris.logiikka;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author juslesan
 *
 * Luokan tarkoituksena on toimia tetrispelikenttää ylläpitävänä.
 */
public class Kentta {

//    private ArrayList<ArrayList<Boolean>> kentta;
    private Pala[][] kentta;
    private int korkeus;
    private int leveys;

    public Kentta(int korkeus, int leveys) {
//        this.kentta = new ArrayList();
//        for (int i = 0; i < korkeus; i++) {
//            kentta.add(new ArrayList());
//            for (int x = 0; x < leveys; x++) {
//                kentta.get(i).add(Boolean.FALSE);
//            }
//
//        }
        this.kentta = new Pala[korkeus][leveys];
        this.korkeus = korkeus;
        this.leveys = leveys;

    }

    /**
     * Metodi kertoo onko parametrinä annetussa ruudussa palaa.
     *
     * @param x ruudun x koordinaatti
     * @param y ruudun y koordinaatti
     * @return palauttaa true jos ruudussa pala, false jos tyhjä.
     */
    public boolean onkoRuudussaPala(int x, int y) {
        if (y >= korkeus || x < 0 || x >= leveys) {
            return true;
        }
        if (this.kentta[y][x] == null) {
            return false;
        }
        return true;
    }

    /**
     * Metodi kertoo jos yksittäinen rivi on täynnä ja täten valmis
     * tyhjennettäväksi.
     *
     * @param y kertoo miltä riviltä haetaan.
     * @return palauttaa true jos täysi, false jos ei.
     */
    public boolean onkoRiviTaynna(int y) {
        for (int i = 0; i < this.leveys; i++) {
            if (onkoRuudussaPala(i, y) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodin tarkoitksena on täyttää yksittäinen ruutu.
     *
     * @param x ruudun x-koordinaatti
     * @param y ruudun y-koordinaatti
     * @param pala ruutuun lisättävä pala.
     */
    public void tayta(int x, int y, Pala pala) {
        this.kentta[y][x] = pala;
    }

    /**
     * Metodin tarkoituksena on tyhjentää ruutu.
     *
     * @param x ruudun x-koordinaatti.
     * @param y ruudun y-koordinaatti.
     * @return palauttaa poistetun palan
     */
    public Pala tyhjenna(int x, int y) {
        Pala pala = this.kentta[y][x];
        this.kentta[y][x] = null;

        return pala;
    }

    /**
     * Metodin tarkoituksena on tyhjentää kaikilta rivin ruuduilta palat pois.
     *
     * @param y kertoo miltä riviltä tyhjennetään.
     */
    public void tyhjennaRivi(int y) {
        for (int i = 0; i < leveys; i++) {
            tyhjenna(i, y);
        }
    }

    public int getKorkeus() {
        return this.korkeus;
    }

    public int getLeveys() {
        return this.leveys;
    }

    public Pala[][] getKentta() {
        return this.kentta;
    }

    /**
     * Metodi etsii kaikki täydet rivit ja tyhjentää ne.
     *
     * @return palauttaa tyhjennettyjen rivien määrän.
     */
    public int tyhjennaTaydetRivit() {
        int montako = 0;
        for (int i = 0; i < this.korkeus; i++) {
            if (onkoRiviTaynna(i)) {
                tyhjennaRivi(i);
                pudotaTyhjennetynRivinYlapuolisetRivit(i);
                montako++;
            }
        }
        return montako;
    }

    /**
     * Metodin tarkoitus on tarkistaa että paloja ei ole päässyt liian
     * korkealle, mikäli on niin peli loppuu.
     *
     * @return palauuttaa true jos paloja on liian korkealla.
     */
    public boolean meneekoLiianKorkealle() {
        for (int i = 0; i < this.leveys; i++) {
            if (onkoRuudussaPala(i, 1)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Pala> kentanPalat() {
        ArrayList<Pala> palat = new ArrayList();
        for (int y = 0; y < this.korkeus; y++) {
            for (int x = 0; x < this.leveys; x++) {
                if (onkoRuudussaPala(x, y)) {
                    palat.add(kentta[y][x]);
                }
            }
        }

        return palat;
    }

    /**
     * Metodin tarkoitus on siirtää kentällä olevia paloja alas kun rivejä tyhjennetään.
     * 
     * @param y 
     */
    public void pudotaTyhjennetynRivinYlapuolisetRivit(int y) {
        for (; y > 0; y--) {
            for (int x = 0; x < this.leveys; x++) {
                if (onkoRuudussaPala(x, y)) {
                    Pala pala = tyhjenna(x, y);
                    pala.putoa();
                    tayta(x, y + 1, pala);
                }
            }
        }
    }
}
