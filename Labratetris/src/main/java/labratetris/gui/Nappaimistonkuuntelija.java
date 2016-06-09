/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import labratetris.peli.Peli;

/**
 *
 * @author Santeri Juslenius
 *
 * Kaikki pelin vaatimat näppäinkomennot tulevat tänne.
 */
public class Nappaimistonkuuntelija implements KeyListener {

    private Peli peli;

    public Nappaimistonkuuntelija(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            peli.getPalikka().vasen();
            peli.paivita();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            peli.getPalikka().oikea();
            peli.paivita();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            peli.getPalikka().pudota();
            peli.paivita();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            peli.getPalikka().putoa();
            peli.paivita();
        }
        if (e.getKeyCode() == KeyEvent.VK_PERIOD) {
            peli.getPalikka().kaanna();
            peli.paivita();
        }
        if (e.getKeyCode() == KeyEvent.VK_MINUS) {
            peli.vaihtoPalikka();
            peli.paivita();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
