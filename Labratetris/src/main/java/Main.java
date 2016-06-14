
import java.util.Random;
import javax.swing.SwingUtilities;
import labratetris.gui.*;
import labratetris.logiikka.Kentta;
import labratetris.logiikka.Pala;
import labratetris.logiikka.palikat.*;
import labratetris.peli.Peli;

public class Main {

    public static void main(String[] args) {
//        Random random = new Random();
//        for (int i = 0; i < 100; i++) {
//            System.out.println(random.nextInt(7));
//        }
        Peli tetris = new Peli(22, 12, 2);
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(tetris, 20);
//        SwingUtilities.invokeLater(kayttoliittyma);

        kayttoliittyma.run();
        tetris.lisaaPaivitettava(kayttoliittyma.getPaivitettava());

        tetris.start();
    }

    public void tulostaKentta(Kentta kentta) {
        for (int i = 0; i < 22; i++) {
            for (int x = 0; x < 10; x++) {
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
