/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.gui.peli;

import java.awt.Graphics;
import labratetris.logiikka.Pala;
import labratetris.logiikka.palikat.Palikka;
import labratetris.logiikka.palikat.Vari;

/**
 *
 * @author Santeri Juslenius
 */
public class PalojenVarit {

    public PalojenVarit() {

    }

    public void palikanVarit(Graphics g, Palikka palikka) {
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

    public void palanVari(Graphics g, Pala pala) {
        if (pala.getVari() == Vari.SYAANI) {
            g.setColor(java.awt.Color.CYAN);
        }
        if (pala.getVari() == Vari.KELTAINEN) {
            g.setColor(java.awt.Color.YELLOW);
        }
        if (pala.getVari() == Vari.ORANSSI) {
            g.setColor(java.awt.Color.ORANGE);
        }
        if (pala.getVari() == Vari.PUNAINEN) {
            g.setColor(java.awt.Color.RED);
        }
        if (pala.getVari() == Vari.VIHREA) {
            g.setColor(java.awt.Color.GREEN);
        }
        if (pala.getVari() == Vari.SININEN) {
            g.setColor(java.awt.Color.BLUE);
        }
        if (pala.getVari() == Vari.PURPPURA) {
            g.setColor(java.awt.Color.MAGENTA);
        }
    }
}
