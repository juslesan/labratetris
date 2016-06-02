/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.logiikka.palikat;

import labratetris.logiikka.Kentta;
import labratetris.logiikka.Pala;

/**
 *
 * @author juslesan
 */
public class L extends Palikka {

    public L(Kentta kentta) {
        super(kentta);
        super.palat.add(new Pala(kentta.getLeveys() / 2 - 2, 2));
        super.palat.add(new Pala(kentta.getLeveys() / 2 - 1, 2));
        super.palat.add(new Pala(kentta.getLeveys() / 2, 2));
        super.palat.add(new Pala(kentta.getLeveys() / 2, 1));

    }

    public void kaannaAlas() {
        super.palat.get(0).siirra(1, -1);
        super.palat.get(1).siirra(0, 0);
        super.palat.get(2).siirra(-1, 1);
        super.palat.get(3).siirra(0, 2);
        super.kulma = Kulma.ALAS;
    }

    public void kaannaVasen() {
        super.palat.get(0).siirra(1, 1);
        super.palat.get(1).siirra(0, 0);
        super.palat.get(2).siirra(-1, -1);
        super.palat.get(3).siirra(-2, 0);
        super.kulma = Kulma.VASEN;
    }

    public void kaannaYlos() {
        super.palat.get(0).siirra(-1, 1);
        super.palat.get(1).siirra(0, 0);
        super.palat.get(2).siirra(1, -1);
        super.palat.get(3).siirra(0, -2);
        super.kulma = Kulma.YLOS;
    }

    public void kaannaOikea() {
        super.palat.get(0).siirra(-1, -1);
        super.palat.get(1).siirra(0, 0);
        super.palat.get(2).siirra(1, 1);
        super.palat.get(3).siirra(2, 0);
        super.kulma = Kulma.YLOS;
    }
}
