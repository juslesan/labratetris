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
 * Luokka on O muotoisen palikan pohja.
 */
public class O extends Palikka {

    public O(Kentta kentta) {
        super(kentta);
        super.vari = vari.KELTAINEN;
        aloitusPaikka();
    }

    @Override
    public void kaanna() {
    }

    @Override
    public void kaannaAlas() {
    }

    @Override
    public void kaannaVasen() {
    }

    @Override
    public void kaannaYlos() {
    }

    @Override
    public void kaannaOikea() {
    }

    @Override
    public void aloitusPaikka() {
        palat.clear();
        palat.add(new Pala(kentta.getLeveys() / 2 - 1, 1, super.vari));
        palat.add(new Pala(kentta.getLeveys() / 2 - 0, 1, super.vari));
        palat.add(new Pala(kentta.getLeveys() / 2 - 1, 2, super.vari));
        palat.add(new Pala(kentta.getLeveys() / 2 - 0, 2, super.vari));
    }

    @Override
    public void piirtoPaikka() {
        palat.get(0).setPaikka(1, 1);
        palat.get(1).setPaikka(2, 1);
        palat.get(2).setPaikka(1, 2);
        palat.get(3).setPaikka(2, 2);
    }

}
