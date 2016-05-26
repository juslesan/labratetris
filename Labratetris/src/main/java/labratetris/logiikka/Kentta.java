package labratetris.logiikka;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author juslesan
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

    public boolean onkoRuudussaPala(int x, int y) {
        if (this.kentta[y][x] == null) {
            return false;
        }
        return true;
    }

    public boolean onkoRiviTaynna(int y) {
        for (int i = 0; i < this.leveys; i++) {
            if (onkoRuudussaPala(i, y) == false) {
                return false;
            }
        }
        return true;
    }

    public void tayta(int x, int y, Pala pala) {
        this.kentta[y][x] = pala;
    }

    public void tyhjenna(int x, int y) {
        this.kentta[y][x] = null;
    }

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

}
