/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.logiikka.palikat;

import java.util.ArrayList;
import labratetris.logiikka.Kentta;
import labratetris.logiikka.Pala;

/**
 *
 * @author juslesan
 */
public class I extends Palikka {

//    public ArrayList<Pala> palat;
//    public Enum kulma;

    public I(Kentta kentta) {
        super(kentta);
//        this.kulma = Kulma.OIKEA;
//        this.palat = new ArrayList();

        palat.add(new Pala(kentta.getLeveys() / 2 - 2, kentta.getKorkeus() - 2));
        palat.add(new Pala(kentta.getLeveys() / 2 - 1, kentta.getKorkeus() - 2));
        palat.add(new Pala(kentta.getLeveys() / 2, kentta.getKorkeus() - 2));
        palat.add(new Pala(kentta.getLeveys() / 2 - 1, kentta.getKorkeus() - 2));

    }

    public void kaanna() {
        if (this.kulma == Kulma.OIKEA) {
            this.palat.get(0).siirra(2, -1);
            this.palat.get(1).siirra(1, 0);
            this.palat.get(2).siirra(0, 1);
            this.palat.get(3).siirra(-1, 2);
            this.kulma = Kulma.ALAS;
        }
        if (this.kulma == Kulma.ALAS) {
            this.palat.get(0).siirra(1, 2);
            this.palat.get(1).siirra(0, 1);
            this.palat.get(2).siirra(-1, 0);
            this.palat.get(3).siirra(-2, -1);
            this.kulma = Kulma.VASEN;
        }
        if (this.kulma == Kulma.VASEN) {
            this.palat.get(0).siirra(-2, 1);
            this.palat.get(1).siirra(-1, 0);
            this.palat.get(2).siirra(0, -1);
            this.palat.get(3).siirra(1, -2);
            this.kulma = Kulma.YLOS;
        }
        if (this.kulma == Kulma.YLOS) {
            this.palat.get(0).siirra(-1, -2);
            this.palat.get(1).siirra(0, -1);
            this.palat.get(2).siirra(-1, 0);
            this.palat.get(3).siirra(2, 1);
        }

    }

//    public void vasen() {
//        for (Pala pala : this.palat) {
//            pala.vasen();
//        }
//    }
//
//    public void oikea() {
//        for (Pala pala : this.palat) {
//            pala.oikea();
//        }
//    }
//
//    public void putoa() {
//        for (Pala pala : this.palat) {
//            pala.putoa();
//        }
//    }

}
