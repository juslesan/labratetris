/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.gui.pistetilastot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import labratetris.gui.ValikkoKali;
import labratetris.lukija.PisteidenLukija;

/**
 * @author Santeri Juslenius
 *
 * Luokan tarkoitus on antaa toiminnallisuudet Pistetilastot-luokassa
 * esintyyville JButtoneille.
 */
public class PistetilastotPaneelinKuuntelija implements ActionListener {

    private JFrame frame;
    private JButton takaisin;
    private JButton nollaa;

    public PistetilastotPaneelinKuuntelija(JFrame frame, JButton takaisin, JButton nollaa) {
        this.frame = frame;
        this.takaisin = takaisin;
        this.nollaa = nollaa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.takaisin) {
            ValikkoKali kayttoliittyma = new ValikkoKali();
            kayttoliittyma.run();
            frame.dispose();
        }
        if (e.getSource() == this.nollaa) {
            PisteidenLukija lukija = new PisteidenLukija();

            try {
                lukija.nollaa();
                Pistetilastot pisteet = new Pistetilastot();
                pisteet.run();
                frame.dispose();

            } catch (Exception error) {
                System.out.println(error);
            }
        }

    }

}
