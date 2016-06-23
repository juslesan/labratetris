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
 * Luokan tarkoitus on näyttää mikä on tallennettu palikka.
 */
public class NaytaVaihtoPalikka extends JPanel implements Paivitettava {

//    private Palikka palikka;
    private int palanSivunPituus;
    private Peli peli;

    public NaytaVaihtoPalikka(Peli peli, int palanSivunPituus) {
        this.peli = peli;
        this.palanSivunPituus = palanSivunPituus;
        super.setPreferredSize(new Dimension(palanSivunPituus * 5, palanSivunPituus * 3));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.peli.getVaihtoPalikka() == null) {
            piirraReunat(g);
            return;
        }
        piirraReunat(g);

        Palikka palikka = this.peli.getVaihtoPalikka();
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

    private void piirraReunat(Graphics g) {
        g.setColor(java.awt.Color.BLACK);
        g.fillRect(0, 0, (5 * palanSivunPituus), 10);
        g.fillRect((5 * palanSivunPituus), 0, 10, (4 * palanSivunPituus));
        g.fillRect(0, (4 * palanSivunPituus), (5 * palanSivunPituus) + 10, 10);
    }

}
