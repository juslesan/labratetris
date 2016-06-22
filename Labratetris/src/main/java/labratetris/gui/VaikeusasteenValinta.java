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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Santeri Juslenius
 *
 * Ennen pelin aloittamista pelin vaikeusasteen valitsemiseen käytettävä
 * graafinen käyttöliittymä.
 */
public class VaikeusasteenValinta implements Runnable {

    private JFrame frame;

    public VaikeusasteenValinta(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void run() {
        frame.getContentPane().removeAll();

        frame.setPreferredSize(new Dimension(500, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container container) {
        JPanel paneeli = new JPanel(new GridLayout(1, 6));

        JButton taso1 = new JButton("1");
        paneeli.add(taso1);
        JButton taso2 = new JButton("2");
        paneeli.add(taso2);
        JButton taso3 = new JButton("3");
        paneeli.add(taso3);
        JButton taso4 = new JButton("4");
        paneeli.add(taso4);
        JButton taso5 = new JButton("5");
        paneeli.add(taso5);
        JButton taso6 = new JButton("6");
        paneeli.add(taso6);

        JButton takaisin = new JButton("Takaisin");

        container.add(new JLabel("-----------------------------------------------Valitse vaikeustaso----------------------------------------------"));
        container.add(paneeli);
        container.add(takaisin);

        VaikeusasteenKuuntelija kuuntelija = new VaikeusasteenKuuntelija(frame, taso1, taso2, taso3, taso4, taso5, taso6, takaisin);
        taso1.addActionListener(kuuntelija);
        taso2.addActionListener(kuuntelija);
        taso3.addActionListener(kuuntelija);
        taso4.addActionListener(kuuntelija);
        taso5.addActionListener(kuuntelija);
        taso6.addActionListener(kuuntelija);
        takaisin.addActionListener(kuuntelija);

    }
}
