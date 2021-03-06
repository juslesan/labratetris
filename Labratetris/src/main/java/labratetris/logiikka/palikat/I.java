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
 *
 * Luokka on I muotoisen palikan pohja.
 */
public class I extends Palikka {

//    public ArrayList<Pala> palat;
//    public Enum kulma;
    public I(Kentta kentta) {
        super(kentta);
        super.vari = vari.SYAANI;
        aloitusPaikka();
    }

    public void kaannaAlas() {
        this.palat.get(0).siirra(2, -1);
        this.palat.get(1).siirra(1, 0);
        this.palat.get(2).siirra(0, 1);
        this.palat.get(3).siirra(-1, 2);
        this.kulma = Kulma.ALAS;
    }

    public void kaannaVasen() {
        this.palat.get(0).siirra(1, 2);
        this.palat.get(1).siirra(0, 1);
        this.palat.get(2).siirra(-1, 0);
        this.palat.get(3).siirra(-2, -1);
        this.kulma = Kulma.VASEN;
    }

    public void kaannaYlos() {
        this.palat.get(0).siirra(-2, 1);
        this.palat.get(1).siirra(-1, 0);
        this.palat.get(2).siirra(0, -1);
        this.palat.get(3).siirra(1, -2);
        this.kulma = Kulma.YLOS;
    }

    public void kaannaOikea() {
        this.palat.get(0).siirra(-1, -2);
        this.palat.get(1).siirra(0, -1);
        this.palat.get(2).siirra(1, 0);
        this.palat.get(3).siirra(2, 1);
        kulma = Kulma.OIKEA;
    }

    @Override
    public void aloitusPaikka() {
        palat.clear();
        palat.add(new Pala(kentta.getLeveys() / 2 - 2, 2, super.vari));
        palat.add(new Pala(kentta.getLeveys() / 2 - 1, 2, super.vari));
        palat.add(new Pala(kentta.getLeveys() / 2, 2, super.vari));
        palat.add(new Pala(kentta.getLeveys() / 2 + 1, 2, super.vari));

    }

    @Override
    public void piirtoPaikka() {
        palat.get(0).setPaikka(0, 2);
        palat.get(1).setPaikka(1, 2);
        palat.get(2).setPaikka(2, 2);
        palat.get(3).setPaikka(3, 2);
    }

}
