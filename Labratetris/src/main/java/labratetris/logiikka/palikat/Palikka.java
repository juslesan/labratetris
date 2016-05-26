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
public abstract class Palikka {

    Kentta kentta;
    ArrayList<Pala> palat;
    Kulma kulma;

    public Palikka(Kentta kentta) {
        this.kentta = kentta;
        palat = new ArrayList();
        kulma = Kulma.OIKEA;
    }

    public abstract void kaanna();

    public void vasen() {
        for (Pala pala : this.palat) {
            pala.vasen();
        }
    }

    public void oikea() {
        for (Pala pala : this.palat) {
            pala.oikea();
        }
    }

    public void putoa() {
        for (Pala pala : this.palat) {
            pala.putoa();
        }
    }

    public void jaadytaKentalle() {
        for (Pala pala : palat) {
            kentta.tayta(pala.getX(), pala.getY(), pala);
            
        }
    }
    public String toString() {
        String palikat = "";
        for (Pala pala : palat) {
            palikat += pala.toString();
        }
        return palikat;
    }
}
