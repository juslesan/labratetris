/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.gui.pistetilastot;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Santeri Juslenius
 *
 * Luokan tarkoitus on luoda näkymä, jonka avulla kirjataan uusi ennätys.
 */
public class UusiEnnatys implements Runnable {

    private int pisteet;
    private JFrame frame;

    public UusiEnnatys(int pisteet) {
        this.pisteet = pisteet;
    }

    @Override
    public void run() {
        frame = new JFrame("Uusi ennätys!");
        frame.setLayout(new BorderLayout());

        frame.setPreferredSize(new Dimension(200, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JPanel paneeli = new JPanel(new GridLayout(3, 1));

        JLabel ennatys = new JLabel("Uusi ennätys!  Pisteet:  " + pisteet);
        paneeli.add(ennatys);
        JTextField nimi = new JTextField("Nimi");
        paneeli.add(nimi);
        JButton ok = new JButton("OK");
        paneeli.add(ok);
        container.add(paneeli);

        UudenEnnatyksenKuuntelija kuuntelija = new UudenEnnatyksenKuuntelija(frame, nimi, ok, pisteet);
        nimi.addActionListener(kuuntelija);
        ok.addActionListener(kuuntelija);

    }

}
