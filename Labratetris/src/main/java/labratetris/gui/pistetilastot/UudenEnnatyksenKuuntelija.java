/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.gui.pistetilastot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import labratetris.gui.ValikkoKali;
import labratetris.lukija.PisteidenLukija;

/**
 *
 * @author Santeri Juslenius
 * 
 * Luokan tarkoitus on 
 */
public class UudenEnnatyksenKuuntelija implements ActionListener {

    private JFrame frame;
    private JTextField nimi;
    private JButton ok;
    private int pisteet;

    public UudenEnnatyksenKuuntelija(JFrame frame, JTextField nimi, JButton ok, int pisteet) {
        this.frame = frame;
        this.nimi = nimi;
        this.ok = ok;
        this.pisteet = pisteet;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            PisteidenLukija lukija = new PisteidenLukija();
            try {
                lukija.uusiEnnatys(nimi.getText(), pisteet);
                ValikkoKali kali = new ValikkoKali();
                kali.run();
                frame.dispose();
            } catch (Exception ex) {
                frame.dispose();
                ValikkoKali kali = new ValikkoKali();
                kali.run();
            }
        }
    }
}
