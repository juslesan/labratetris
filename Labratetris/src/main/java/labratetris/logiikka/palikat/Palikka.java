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
 * Luokka tarjoaa pohjan kaikille ohjelman käyttämille tetromiinoille.
 */
public abstract class Palikka {

    Kentta kentta;
    ArrayList<Pala> palat;
    Kulma kulma;
    Vari vari;

    public Palikka(Kentta kentta) {
        this.kentta = kentta;
        palat = new ArrayList();
        kulma = Kulma.OIKEA;

    }

    /**
     * Toimii kaiken muotoisten tetromiinojen kääntämisen pohjana.
     */
    public void kaanna() {
        if (this.kulma == Kulma.OIKEA) {
            rotaatioAlas();
            return;
        }
        if (this.kulma == Kulma.ALAS) {
            rotaatioVasen();
            return;
        }
        if (this.kulma == Kulma.VASEN) {
            rotaatioYlos();
            return;
        }
        if (this.kulma == Kulma.YLOS) {
            rotaatioOikea();
            return;
        }
    }

    /**
     * Kääntää palikkaa alas.
     */
    public abstract void kaannaAlas();

    /**
     * Kääntää palikkaa vasemmalle.
     */
    public abstract void kaannaVasen();

    /**
     * Kääntää palikkaa ylös.
     */
    public abstract void kaannaYlos();

    /**
     * Kääntää palikkaa oikealle.
     */
    public abstract void kaannaOikea();

    /**
     * Asettaa palikan pelikentälle sen aloituspaikalle.
     */
    public abstract void aloitusPaikka();

    /**
     * Asettaa palikan piirtopaikalle, jotta sen voi piirtää mm. seuraavana
     * palikkana.
     */
    public abstract void piirtoPaikka();

    /**
     * Siirtää koko palikkaa ruudun verran vasemmalle.
     */
    public void vasen() {
        if (voikoLiikkuaVasen()) {
            for (Pala pala : this.palat) {
                pala.vasen();
            }
        }
    }

    /**
     * Siirtää koko palikkaa ruudun verran oikealle.
     */
    public void oikea() {
        if (voikoLiikkuaOikea()) {
            for (Pala pala : this.palat) {
                pala.oikea();
            }
        }
    }

    /**
     * siirtää koko palikkaa ruudun verran alaspäin.
     */
    public void putoa() {
        if (voikoPudota()) {
            for (Pala pala : this.palat) {
                pala.putoa();
            }
        } else {
            jaadytaKentalle();
        }
    }

    /**
     * Jäädyttää palikan kentälle
     */
    public void jaadytaKentalle() {
        for (Pala pala : palat) {
            pala.pudonnut();
            kentta.tayta(pala.getX(), pala.getY(), pala);
        }
    }

    /**
     * Tarkistaa onko palikan mahdollista siirtyä alaspäin.
     *
     * @return palauttaa true jos voi liikkua, false jos ei.
     */
    public boolean voikoPudota() {
        for (Pala pala : palat) {
            if (kentta.onkoRuudussaPala(pala.getX(), pala.getY() + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * tarkistaa voiko palikkaa liikkua kokonaisuudessaan vasemmalle.
     *
     * @return palauttaa true jos voi liikkua, false jos ei.
     */
    public boolean voikoLiikkuaVasen() {
        for (Pala pala : palat) {
            if (kentta.onkoRuudussaPala(pala.getX() - 1, pala.getY())) {
                return false;
            }
            if (pala.getX() - 1 < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * tarkistaa voiko palikkaa liikkua kokonaisuudessaa oikealle.
     *
     * @return palauttaa true jos voi liikkua, false jos ei.
     */
    public boolean voikoLiikkuaOikea() {
        for (Pala pala : palat) {
            if (kentta.onkoRuudussaPala(pala.getX() + 1, pala.getY())) {
                return false;
            }
            if (pala.getX() + 1 > kentta.getLeveys() - 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * tarkistaa että kaikki palat ovat tyhjissä ruuduissa.
     *
     * @return
     */
    public boolean onkoTyhjallaRuudulla() {
        for (Pala pala : palat) {
            if (kentta.onkoRuudussaPala(pala.getX(), pala.getY())) {
                return false;
            }
        }
        return true;
    }

    /**
     * tarkistaa että kaikki palat ovat kentän rajojen sisäpuolella.
     *
     * @return
     */
    public boolean onkoKentalla() {
        for (Pala pala : palat) {
            if (pala.getX() < 0 || pala.getX() > kentta.getLeveys() - 1 || pala.getY() > kentta.getKorkeus() - 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Pudottaa palikan niin alas kuin mahdollista.
     */
    public void pudota() {
        while (voikoPudota()) {
            putoa();
        }
        for (Pala pala : palat) {
            pala.pudonnut();
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

    public ArrayList<Pala> palat() {
        return palat;
    }

    public Vari getVari() {
        return vari;
    }

    private void rotaatioAlas() {
        kaannaAlas();
        if (!onkoKentalla() || !onkoTyhjallaRuudulla()) {
            kaannaYlos();
            kulma = Kulma.OIKEA;
        }
    }

    private void rotaatioVasen() {
        kaannaVasen();
        if (!onkoKentalla() || !onkoTyhjallaRuudulla()) {
            kaannaOikea();
            kulma = Kulma.ALAS;
        }
    }

    private void rotaatioYlos() {
        kaannaYlos();
        if (!onkoKentalla() || !onkoTyhjallaRuudulla()) {
            kaannaAlas();
            kulma = Kulma.VASEN;
        }
    }

    private void rotaatioOikea() {
        kaannaOikea();
        if (!onkoKentalla() || !onkoTyhjallaRuudulla()) {
            kaannaVasen();
            kulma = Kulma.YLOS;
        }
    }
}
