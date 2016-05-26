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
public class O extends Palikka {

    public O(Kentta kentta) {
        super(kentta);

        palat.add(new Pala(kentta.getLeveys() / 2 - 1, kentta.getKorkeus() - 1));
        palat.add(new Pala(kentta.getLeveys() / 2 - 0, kentta.getKorkeus() - 1));
        palat.add(new Pala(kentta.getLeveys() / 2 - 1, kentta.getKorkeus() - 2));
        palat.add(new Pala(kentta.getLeveys() / 2 - 0, kentta.getKorkeus() - 2));
    }

    @Override
    public void kaanna() {
    }

    
}
