/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.logiikka.palikat;

import labratetris.logiikka.Kentta;

/**
 *
 * @author juslesan
 */
public class J extends Palikka {

    public J(Kentta kentta) {
        super(kentta);
    }

    @Override
    public void kaanna() {
if (this.kulma == Kulma.OIKEA) {
            this.palat.get(0).siirra(2, 0);
            this.palat.get(1).siirra(1, -1);
            this.palat.get(2).siirra(0, 0);
            this.palat.get(3).siirra(-1, 1);
            this.kulma = Kulma.ALAS;
        }
        if (this.kulma == Kulma.ALAS) {
            this.palat.get(0).siirra(0, 2);
            this.palat.get(1).siirra(1, 1);
            this.palat.get(2).siirra(0, 0);
            this.palat.get(3).siirra(-1, -1);
            this.kulma = Kulma.VASEN;
        }
        if (this.kulma == Kulma.VASEN) {
            this.palat.get(0).siirra(-2, 0);
            this.palat.get(1).siirra(-1, 1);
            this.palat.get(2).siirra(0, 0);
            this.palat.get(3).siirra(1, -1);
            this.kulma = Kulma.YLOS;
        }
        if (this.kulma == Kulma.YLOS) {
            this.palat.get(0).siirra(0, -2);
            this.palat.get(1).siirra(-1, -1);
            this.palat.get(2).siirra(0, 0);
            this.palat.get(3).siirra(1, 1);
        }    }

}
