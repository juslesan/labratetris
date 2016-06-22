package labratetris.peli;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import javax.swing.SwingUtilities;
import labratetris.gui.*;
import labratetris.gui.pistetilastot.UusiEnnatys;
import labratetris.logiikka.Kentta;
import labratetris.logiikka.Pala;
import labratetris.logiikka.palikat.*;
import labratetris.lukija.PisteidenLukija;
import labratetris.peli.Peli;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ValikkoKali kayttoliittyma = new ValikkoKali();
        kayttoliittyma.run();
    }

    public void tulostaKentta(Kentta kentta) {
        for (int i = 0; i < kentta.getKorkeus(); i++) {
            for (int x = 0; x < kentta.getLeveys(); x++) {
                if (kentta.onkoRuudussaPala(x, i)) {
                    System.out.print("X");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println("");
        }
        System.out.println("***********************");
    }
}
