/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import labratetris.peli.Peli;

/**
 *
 * @author Santeri Juslenius
 *
 * Graafistä käyttöliittymää kokonaisuudessaan pyörittävä luokka.
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Peli peli;
    private int sivunPituus;
    private Tetriskentta tetriskentta;

    public Kayttoliittyma(Peli peli, int sivunPituus) {
        this.peli = peli;
        this.sivunPituus = sivunPituus;
    }

    @Override
    public void run() {
        frame = new JFrame("Labratetris");
        int leveys = (peli.getLeveys() * sivunPituus) + sivunPituus;
        int korkeus = (peli.getKorkeus() * sivunPituus) + sivunPituus * 2;

        frame.setPreferredSize(new Dimension(leveys, korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    public void luoKomponentit(Container container) {
        this.tetriskentta = new Tetriskentta(this.peli, this.sivunPituus);
        container.add(tetriskentta);
        frame.addKeyListener(new Nappaimistonkuuntelija(this.peli));
    }

    public JFrame getFrame() {
        return frame;
    }

    public Paivitettava getPaivitettava() {
        return this.tetriskentta;
    }

}
