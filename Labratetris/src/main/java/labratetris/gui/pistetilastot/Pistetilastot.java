/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.gui.pistetilastot;

import labratetris.gui.pistetilastot.PistetilastotPaneelinKuuntelija;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import labratetris.lukija.PisteidenLukija;

/**
 *
 * @author Santeri Juslenius
 *
 * Luokka luo näkymän pistetilastoille.
 */
public class Pistetilastot implements Runnable {

    private JFrame frame;

    public Pistetilastot() {

    }

    @Override
    public void run() {
        frame = new JFrame("Labratetris");
        frame.setLayout(new BorderLayout());

        frame.setPreferredSize(new Dimension(350, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            luoKomponentit(frame.getContentPane());
        } catch (FileNotFoundException ex) {
        }

        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container container) throws FileNotFoundException {
        JPanel listaus = new JPanel(new GridLayout(6, 1));
        String[] pistetilastot = pistetilasto();

        JLabel otsikko = new JLabel("Ennätyspisteet:");
        listaus.add(otsikko);
        JLabel ensimmainen = new JLabel(pistetilastot[0]);
        listaus.add(ensimmainen);
        JLabel toinen = new JLabel(pistetilastot[1]);
        listaus.add(toinen);
        JLabel kolmas = new JLabel(pistetilastot[2]);
        listaus.add(kolmas);
        JLabel neljas = new JLabel(pistetilastot[3]);
        listaus.add(neljas);
        JLabel viides = new JLabel(pistetilastot[4]);
        listaus.add(viides);

        JPanel paneeli = new JPanel(new GridLayout(1, 2));
        JButton takaisin = new JButton("Takaisin");
        paneeli.add(takaisin);
        JButton nollaa = new JButton("Nollaa");
        paneeli.add(nollaa);

        container.add(listaus);
        container.add(paneeli, BorderLayout.PAGE_END);
        PistetilastotPaneelinKuuntelija kuuntelija = new PistetilastotPaneelinKuuntelija(frame, takaisin, nollaa);
        takaisin.addActionListener(kuuntelija);
        nollaa.addActionListener(kuuntelija);
    }

    public String[] pistetilasto() throws FileNotFoundException {
        PisteidenLukija lukija = new PisteidenLukija();
        return lukija.getPistetilastot();
    }
}
