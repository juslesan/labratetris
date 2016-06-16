/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import labratetris.logiikka.palikat.*;
import labratetris.peli.Peli;

/**
 *
 * @author Santeri Juslenius
 *
 * GraafistÃ¤ kÃ¤yttÃ¶liittymÃ¤Ã¤ kokonaisuudessaan pyÃ¶rittÃ¤vÃ¤ luokka.
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Peli peli;
    private int sivunPituus;
    private Tetriskentta tetriskentta;
    private NaytaVaihtoPalikka vaihtoPalikka;
    private NaytaSeuraavaPalikka1 seuraavaPalikka1;
    private NaytaSeuraavaPalikka2 seuraavaPalikka2;
    private NaytaSeuraavaPalikka3 seuraavaPalikka3;
    private Infopaneeli infopaneeli;

    public Kayttoliittyma(Peli peli, int sivunPituus) {
        this.peli = peli;
        this.sivunPituus = sivunPituus;

    }

    @Override
    public void run() {
        frame = new JFrame("Labratetris");
        frame.setLayout(new BorderLayout());
        int leveys = (peli.getLeveys() * sivunPituus) + sivunPituus * 9;
        int korkeus = (peli.getKorkeus() * sivunPituus) + sivunPituus * 2 + 30;

//        frame.setLayout(new GridLayout(1, 1));
        frame.setPreferredSize(new Dimension(leveys, korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());
        this.tetriskentta.paivita();

        paivitaPalikkakentat();
        paivitaInfopaneeli();
        
        lisaaPaivitettavat();
        
        frame.pack();
        frame.setVisible(true);
        this.peli.setFrame(frame);
    }

    /**
     * Metodi luo kaikki pelin graafisen käyttöliittymän komponentit
     * @param container JFramen contentpane
     */
    public void luoKomponentit(Container container) {
        this.tetriskentta = new Tetriskentta(this.peli, this.sivunPituus);
        frame.addKeyListener(new Nappaimistonkuuntelija(this.peli));
        JPanel palikkapaneeli = new JPanel();
        palikkapaneeli.setLayout(new BoxLayout(palikkapaneeli, BoxLayout.PAGE_AXIS));

        JLabel seuraavat = new JLabel("Seuraavat Palikat:");
        palikkapaneeli.add(seuraavat);

        this.seuraavaPalikka1 = new NaytaSeuraavaPalikka1(this.peli, this.sivunPituus);
        palikkapaneeli.add(seuraavaPalikka1);

        this.seuraavaPalikka2 = new NaytaSeuraavaPalikka2(this.peli, this.sivunPituus);
        palikkapaneeli.add(seuraavaPalikka2);

        this.seuraavaPalikka3 = new NaytaSeuraavaPalikka3(this.peli, this.sivunPituus);
        palikkapaneeli.add(seuraavaPalikka3);
//
        JLabel vaihto = new JLabel("Vaihto:");
        palikkapaneeli.add(vaihto);

        this.vaihtoPalikka = new NaytaVaihtoPalikka(this.peli, this.sivunPituus);
        palikkapaneeli.add(this.vaihtoPalikka);

        this.infopaneeli = new Infopaneeli(this.peli);

//        container.add(panel, BorderLayout.EAST);
        container.add(tetriskentta, BorderLayout.CENTER);
        container.add(infopaneeli, BorderLayout.SOUTH);
        container.add(palikkapaneeli, BorderLayout.LINE_END);
//        container.add(seuraavaPalikka2);

//        container.add(vaihtoPalikka, BorderLayout.EAST);
    }

    public JFrame getFrame() {
        return frame;
    }

    public Paivitettava getTetriskentta() {
        return this.tetriskentta;
    }
    
    /**
     * Metodi päivittää kaikki komponentit mitkä kuvaavat seuraavia palikkoja tai varattua palikkaa.
     */
    public void paivitaPalikkakentat() {

        this.vaihtoPalikka.paivita();
        this.seuraavaPalikka1.paivita();
        this.seuraavaPalikka2.paivita();
        this.seuraavaPalikka3.paivita();
    }
    
    /**
     * Päivittää pisteet ja vaikeustason GUI:ssa
     */
    public void paivitaInfopaneeli() {
        this.infopaneeli.paivita();
    }

    public Paivitettava getSeuraava1() {
        return this.seuraavaPalikka1;
    }

    public Paivitettava getSeuraava2() {
        return this.seuraavaPalikka2;
    }

//    public Paivitettava getSeuraava3() {
//        return this.seuraavaPalikka3;
//    }
    public Paivitettava getVaihto() {
        return this.vaihtoPalikka;
    }

    public Paivitettava getInfopaneeli() {
        return this.infopaneeli;
    }

    /**
     * Lisää Peli luokalle päivitettävät komponentit
     */
    public void lisaaPaivitettavat() {
        this.peli.lisaaPaivitettava(tetriskentta);
        this.peli.lisaaPaivitettava(seuraavaPalikka1);
        this.peli.lisaaPaivitettava(seuraavaPalikka2);
        this.peli.lisaaPaivitettava(seuraavaPalikka3);
        this.peli.lisaaPaivitettava(infopaneeli);
        this.peli.lisaaPaivitettava(this.vaihtoPalikka);
    }

//    public void paivitaKaikki() {
//        ArrayList<Paivitettava> paivitettavat = getPaivitettava();
//        for (Paivitettava paivitettava : paivitettavat) {
//            paivitettava.paivita();
//        }
//    }
}
