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
 *
 * Luokka on J muotoisen palikan pohja.
 */
public class J extends Palikka {

    public J(Kentta kentta) {
        super(kentta);
        super.vari = vari.SININEN;
        aloitusPaikka();
    }

    public void kaannaAlas() {
        this.palat.get(0).siirra(2, 0);
        this.palat.get(1).siirra(1, -1);
        this.palat.get(2).siirra(0, 0);
        this.palat.get(3).siirra(-1, 1);
        this.kulma = Kulma.ALAS;
    }

    public void kaannaVasen() {
        this.palat.get(0).siirra(0, 2);
        this.palat.get(1).siirra(1, 1);
        this.palat.get(2).siirra(0, 0);
        this.palat.get(3).siirra(-1, -1);
        this.kulma = Kulma.VASEN;
    }

    public void kaannaYlos() {
        this.palat.get(0).siirra(-2, 0);
        this.palat.get(1).siirra(-1, 1);
        this.palat.get(2).siirra(0, 0);
        this.palat.get(3).siirra(1, -1);
        this.kulma = Kulma.YLOS;
    }

    public void kaannaOikea() {
        this.palat.get(0).siirra(0, -2);
        this.palat.get(1).siirra(-1, -1);
        this.palat.get(2).siirra(0, 0);
        this.palat.get(3).siirra(1, 1);
        this.kulma = Kulma.OIKEA;
    }

    @Override
    public void aloitusPaikka() {
        palat.clear();
        palat.add(new Pala(kentta.getLeveys() / 2 - 2, 1));
        palat.add(new Pala(kentta.getLeveys() / 2 - 2, 2));
        palat.add(new Pala(kentta.getLeveys() / 2 - 1, 2));
        palat.add(new Pala(kentta.getLeveys() / 2, 2));
    }

}
