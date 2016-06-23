
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
import labratetris.logiikka.Pala;
import labratetris.logiikka.palikat.*;
import labratetris.peli.Peli;

/**
 *
 * @author Santeri Juslenius
 *
 * Luokan tarkoitus on näyttää mikä on seuraavista palikoista ensimmäinen
 */
public class NaytaSeuraavaPalikka1 extends JPanel implements Paivitettava {

    private Peli peli;
    private int palanSivunPituus;

    public NaytaSeuraavaPalikka1(Peli peli, int palanSivunPituus) {
        this.peli = peli;
        this.palanSivunPituus = palanSivunPituus;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Palikka palikka = this.peli.getSeuraavat().get(0);
        for (Pala pala : palikka.palat()) {
            palikanVari(g, palikka);
            g.fill3DRect(pala.getX() * palanSivunPituus, pala.getY() * palanSivunPituus, palanSivunPituus, palanSivunPituus, true);
        }
    }

    @Override
    public void paivita() {
        super.removeAll();
        super.revalidate();
        super.repaint();
    }

    private void palikanVari(Graphics g, Palikka palikka) {
        PalojenVarit varit = new PalojenVarit();
        varit.palikanVarit(g, palikka);
    }
}
