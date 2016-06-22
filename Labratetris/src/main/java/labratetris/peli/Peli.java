/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;
import labratetris.gui.Paivitettava;
import labratetris.gui.ValikkoKali;
import labratetris.gui.pistetilastot.UusiEnnatys;
import labratetris.logiikka.*;
import labratetris.logiikka.palikat.*;
import labratetris.lukija.PisteidenLukija;

/**
 *
 * @author Santeri Juslenius
 *
 * Luokan tarkoitus on pyörittää tetrispeliä kokonaisuudessaan.
 */
public class Peli extends Timer implements ActionListener {

    private Kentta kentta;
    private Random palikkaArpa;
    private int pisteet;
    private ArrayList<Palikka> seuraavat;
    private Palikka palikka;
    private Palikka vaihtoPala;
    private boolean jatkuuko;
    private int korkeus;
    private int leveys;
    private ArrayList<Paivitettava> paivitettavat;
    private int vaikeus;
    private int vaikeusTasonVaihto;
    private JFrame frame;
    private PisteidenLukija lukija;

    public Peli(int korkeus, int leveys, int vaikeus) {
        super(1200 / vaikeus, null);
        this.kentta = new Kentta(korkeus, leveys);
        this.palikkaArpa = new Random();
        this.vaihtoPala = null;
        this.seuraavat = new ArrayList();
        for (int i = 0; i < 3; i++) {
            seuraavat.add(arvoPalikka());
            seuraavat.get(i).piirtoPaikka();
        }
        this.palikka = arvoPalikka();
        this.pisteet = 0;
        this.jatkuuko = true;
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.vaikeus = vaikeus;
        this.paivitettavat = new ArrayList();
        this.vaikeusTasonVaihto = 0;
        this.lukija = new PisteidenLukija();
        addActionListener(this);
        setInitialDelay(1200 / vaikeus);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!jatkuuko) {
            return;
        }
        if (!this.palikka.voikoPudota()) {
            this.palikka.jaadytaKentalle();
            int tyhjennettyja = this.kentta.tyhjennaTaydetRivit();
            pisteet += Math.pow(vaikeus, tyhjennettyja);
            vaikeusTasonVaihto(tyhjennettyja);
            uusiPalikka();
        }
        if (this.kentta.meneekoLiianKorkealle()) {
            jatkuuko = false;
            try {
                if (this.lukija.onkoUusiEnnatys(pisteet)) {
                    UusiEnnatys uusi = new UusiEnnatys(pisteet);
                    uusi.run();
                } else {
                    ValikkoKali kali = new ValikkoKali();
                    kali.run();
                }
            } catch (Exception error) {
                System.out.println(error);
            }
            frame.dispose();
        }
        this.palikka.putoa();
        paivita();
        super.setDelay(1200 / vaikeus);

    }

    /**
     *
     * Metodi valitsee ensimmäisen seuraavat-listalla olevan palikan ja lisää
     * listan perälle uuden palikan.
     */
    public void uusiPalikka() {
        this.palikka = seuraavat.remove(0);
        this.palikka.aloitusPaikka();
        this.seuraavat.add(arvoPalikka());
        seuraavat.get(2).piirtoPaikka();

    }

    /**
     * Metodi lukitsee tämän hetkisen palikan pelaajan käyttöön tulevaisuudessa
     * ja valitsee aikaisemmin lukitun palikan käyttöön mikäli jokin palikka on
     * lukittu aikaisemmin.
     */
    public void vaihtoPalikka() {
        if (this.vaihtoPala == null) {
            this.vaihtoPala = this.palikka;
            uusiPalikka();
            this.vaihtoPala.piirtoPaikka();
        } else {
            Palikka vaihdetaan = this.vaihtoPala;
            this.vaihtoPala = this.palikka;
            this.palikka = vaihdetaan;
            this.palikka.aloitusPaikka();
            this.vaihtoPala.piirtoPaikka();
        }
    }

    public Kentta getKentta() {
        return this.kentta;
    }

    public Palikka getPalikka() {
        return this.palikka;
    }

    /**
     * Metodin tarkoitus on valita yksi seitsemästä mahdollisesta
     * palikanmuodosta.
     *
     * @return palauttaa arvotun palikan
     */
    public Palikka arvoPalikka() {
        int arvottu = palikkaArpa.nextInt(7);
        if (arvottu == 0) {
            return new I(kentta);
        }
        if (arvottu == 1) {
            return new J(kentta);
        }
        if (arvottu == 2) {
            return new L(kentta);
        }
        if (arvottu == 3) {
            return new O(kentta);
        }
        if (arvottu == 4) {
            return new S(kentta);
        }
        if (arvottu == 5) {
            return new T(kentta);
        }
        if (arvottu == 6) {
            return new Z(kentta);
        }
        return null;
    }

    public int getKorkeus() {
        return this.korkeus;
    }

    public int getLeveys() {
        return this.leveys;
    }

    /**
     * lisätään päivitettäviä komponentteja tässä.
     *
     * @param paivitettava uusi päivitettävä olio
     */
    public void lisaaPaivitettava(Paivitettava paivitettava) {
        paivitettavat.add(paivitettava);
    }

    public void paivita() {
        for (Paivitettava paivitettava : paivitettavat) {
            paivitettava.paivita();
        }
    }

    public int getPisteet() {
        return this.pisteet;
    }

    /**
     * Metodi vaihtaa vaikeustasoa aina kun rivejä on tyhjennetty 6 kappaletta.
     *
     * @param luku juuri tyhjennettyjen rivin määrä
     */
    public void vaikeusTasonVaihto(int luku) {
        this.vaikeusTasonVaihto += luku;
        if (this.vaikeusTasonVaihto >= 6) {
            this.vaikeusTasonVaihto = this.vaikeusTasonVaihto - 6;
            this.vaikeus++;
        }
    }

    public void setPaivitettavat(ArrayList<Paivitettava> lista) {
        paivitettavat = lista;
    }

    public int getVaikeus() {
        return this.vaikeus;
    }

    public Palikka getVaihtoPalikka() {
        return this.vaihtoPala;
    }

    public ArrayList<Palikka> getSeuraavat() {
        return this.seuraavat;
    }

    public boolean getJatkuuko() {
        return this.jatkuuko;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
