/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.gui;

import java.awt.Graphics;
import javax.swing.JPanel;
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
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Pala pala : this.peli.getPalikka().palat()) {
            palikanVari(g, this.peli.getPalikka());
            g.fill3DRect(pala.getX() * palanSivunPituus, pala.getY() * palanSivunPituus, palanSivunPituus, palanSivunPituus, true);
        }

    }

    @Override
    public void paivita() {
        super.repaint();
    }

    public void palikanVari(Graphics g, Palikka palikka) {
        if (palikka.getVari() == Vari.SYAANI) {
            g.setColor(java.awt.Color.CYAN);
        }
        if (palikka.getVari() == Vari.KELTAINEN) {
            g.setColor(java.awt.Color.YELLOW);
        }
        if (palikka.getVari() == Vari.ORANSSI) {
            g.setColor(java.awt.Color.ORANGE);
        }
        if (palikka.getVari() == Vari.PUNAINEN) {
            g.setColor(java.awt.Color.RED);
        }
        if (palikka.getVari() == Vari.VIHREA) {
            g.setColor(java.awt.Color.GREEN);
        }
        if (palikka.getVari() == Vari.SININEN) {
            g.setColor(java.awt.Color.BLUE);
        }
        if (palikka.getVari() == Vari.PURPPURA) {
            g.setColor(java.awt.Color.MAGENTA);
        }
    }

}
