/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.gui;

import java.awt.Graphics;
import javax.swing.JPanel;
import labratetris.logiikka.Pala;
import labratetris.logiikka.palikat.*;

/**
 *
 * @author Santeri Juslenius
 *
 * Luokan tarkoitus on näyttää mikä on tallennettu palikka ja mitkä ovat kolme
 * seuraavaa palikkaa.
 */
public class naytaPalikka extends JPanel implements Paivitettava {

    private Palikka palikka;
    private int palanSivunPituus;

    public naytaPalikka(Palikka palikka, int palanSivunPituus) {
        this.palikka = palikka;
        this.palanSivunPituus = palanSivunPituus;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Pala pala : this.palikka.palat()) {
            palikanVari(g, this.palikka);
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
