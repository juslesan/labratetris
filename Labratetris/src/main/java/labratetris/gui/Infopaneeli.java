/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.gui;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import labratetris.peli.Peli;

/**
 *
 * @author Santeri Juslenius
 * 
 * Luokka luo komponentin joka näyttää pisteet sekä vaikeusasteen
 */
public class Infopaneeli extends JPanel implements Paivitettava {
    
    private Peli peli;
    private JLabel pisteet;
    private JLabel vaikeus;
    private JPanel paneeli;
    
    public Infopaneeli(Peli peli) {
        this.peli = peli;
        this.setLayout(new GridLayout(1, 2));
        this.pisteet = new JLabel("Pisteet: " + Integer.toString(this.peli.getPisteet()));
        this.add(pisteet);
        this.vaikeus = new JLabel("Vaikeustaso: " + Integer.toString(this.peli.getVaikeus()));
        this.add(vaikeus);
        
    }
    
    @Override
    public void paivita() {
        pisteet.setText("Pisteet: " + this.peli.getPisteet());
        vaikeus.setText("Vaikeustaso: " + this.peli.getVaikeus());
    }
    
}
