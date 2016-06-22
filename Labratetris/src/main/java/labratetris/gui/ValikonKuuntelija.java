/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.gui;

import labratetris.gui.pistetilastot.Pistetilastot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import labratetris.gui.peli.PelinKali;
import labratetris.peli.Peli;

/**
 *
 * @author Santeri Juslenius
 *
 * Luokka antaa toiminnallisuuden ValikkoKali-luokan JButtoneille.
 */
public class ValikonKuuntelija implements ActionListener {

    private JFrame frame;
    private JButton uusiPeli;
    private JButton poistu;
    private JButton pistetilastot;

    public ValikonKuuntelija(JFrame frame, JButton uusiPeli, JButton pistetilastot, JButton poistu) {
        this.frame = frame;
        this.uusiPeli = uusiPeli;
        this.poistu = poistu;
        this.pistetilastot = pistetilastot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == uusiPeli) {
            VaikeusasteenValinta vaikeus = new VaikeusasteenValinta(frame);
            vaikeus.run();

        }
        if (e.getSource() == pistetilastot) {
            Pistetilastot pisteet = new Pistetilastot();
            pisteet.run();
            frame.dispose();
        }
        if (e.getSource() == poistu) {
            System.exit(0);
        }

    }

}
