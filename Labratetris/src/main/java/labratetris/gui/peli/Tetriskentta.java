/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.gui.peli;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import labratetris.gui.Paivitettava;
import labratetris.logiikka.*;
import labratetris.peli.Peli;
import labratetris.logiikka.palikat.*;

/**
 *
 * @author Santeri Juslenius
 *
 * Tetriskentän graafista käyttöliittymää ohjaava luokka.
 */
public class Tetriskentta extends JPanel implements Paivitettava {

    private Peli peli;
    private int palanSivunPituus;

    public Tetriskentta(Peli peli, int palanSivunPituus) {
        this.peli = peli;
        this.palanSivunPituus = palanSivunPituus;
//        super.setPreferredSize(new Dimension(palanSivunPituus * 5, palanSivunPituus * 3));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        kentanReunat(g);
        kentanPalat(g);
        for (Pala pala : this.peli.getPalikka().palat()) {
            palikanVari(g, this.peli.getPalikka());
            g.fill3DRect(pala.getX() * palanSivunPituus, pala.getY() * palanSivunPituus, palanSivunPituus, palanSivunPituus, true);
        }

    }

    @Override
    public void paivita() {
        super.removeAll();
        super.revalidate();
        super.repaint();
    }

    private void kentanPalat(Graphics g) {
        for (Pala pala : this.peli.getKentta().kentanPalat()) {
            palanVari(g, pala);
            g.fill3DRect(pala.getX() * palanSivunPituus, pala.getY() * palanSivunPituus, palanSivunPituus, palanSivunPituus, true);
        }
    }

    private void palikanVari(Graphics g, Palikka palikka) {
        PalojenVarit varit = new PalojenVarit();
        varit.palikanVarit(g, palikka);
    }

    private void palanVari(Graphics g, Pala pala) {
        PalojenVarit varit = new PalojenVarit();
        varit.palanVari(g, pala);
    }

    private void kentanReunat(Graphics g) {
        g.setColor(java.awt.Color.BLACK);
        g.fillRect(0, 0, (peli.getLeveys() * palanSivunPituus), 10);
        g.fillRect((peli.getLeveys() * palanSivunPituus), 0, 10, (peli.getKorkeus() * palanSivunPituus));
        g.fillRect(0, (peli.getKorkeus() * palanSivunPituus), (peli.getLeveys() * palanSivunPituus) + 10, 10);
    }
}
