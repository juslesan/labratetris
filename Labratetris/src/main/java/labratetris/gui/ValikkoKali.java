/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Santeri Juslenius
 *
 * Pelin alkuvalikon graafinen käyttöliittymä.
 */
public class ValikkoKali implements Runnable {

    private JFrame frame;

    public ValikkoKali() {

    }

    @Override
    public void run() {
        frame = new JFrame("Labratetris");
        frame.setLayout(new BorderLayout());

        frame.setPreferredSize(new Dimension(500, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container container) {
        GridLayout asettelija = new GridLayout(3, 1);
        container.setLayout(asettelija);

        JPanel paneeli = new JPanel(new GridLayout(1, 3));
        paneeli.setFocusable(true);
        JButton uusiPeli = new JButton("Uusi peli");
        paneeli.add(uusiPeli);
        JButton pisteet = new JButton("Pistetilastot");
        paneeli.add(pisteet);
        JButton poistu = new JButton("Poistu");
        paneeli.add(poistu);
        container.add(paneeli);
        ValikonKuuntelija kuuntelija = (new ValikonKuuntelija(frame, uusiPeli, pisteet, poistu));

        uusiPeli.addActionListener(kuuntelija);
        pisteet.addActionListener(kuuntelija);
        poistu.addActionListener(kuuntelija);
    }

}
