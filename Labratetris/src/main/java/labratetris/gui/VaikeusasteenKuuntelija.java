/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import labratetris.gui.peli.PelinKali;
import labratetris.peli.Peli;

/**
 *
 * @author Santeri Juslenius
 *
 * Luokka antaa toiminnalisuuden VaikeusasteenValinta-luokan JButtoneille.
 */
public class VaikeusasteenKuuntelija implements ActionListener {

    private JFrame frame;
    private JButton taso1;
    private JButton taso2;
    private JButton taso3;
    private JButton taso4;
    private JButton taso5;
    private JButton taso6;
    private JButton takaisin;

    public VaikeusasteenKuuntelija(JFrame frame, JButton taso1, JButton taso2, JButton taso3, JButton taso4, JButton taso5, JButton taso6, JButton takaisin) {
        this.frame = frame;
        this.taso1 = taso1;
        this.taso2 = taso2;
        this.taso3 = taso3;
        this.taso4 = taso4;
        this.taso5 = taso5;
        this.taso6 = taso6;
        this.takaisin = takaisin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == takaisin) {
            ValikkoKali kayttoliittyma = new ValikkoKali();
            kayttoliittyma.run();
            frame.dispose();
        } else {
            int vaikeus = vaikeus(e);

            Peli peli = new Peli(24, 12, vaikeus);
            PelinKali kayttoliittyma = new PelinKali(peli, 20);
            kayttoliittyma.run();
            peli.start();
            frame.dispose();
        }

    }

    private int vaikeus(ActionEvent e) {
        if (e.getSource() == taso1) {
            return 1;
        }
        if (e.getSource() == taso2) {
            return 2;
        }
        if (e.getSource() == taso3) {
            return 3;
        }
        if (e.getSource() == taso4) {
            return 4;
        }
        if (e.getSource() == taso5) {
            return 5;
        }
        if (e.getSource() == taso6) {
            return 6;
        }

        return 2;

    }
}
