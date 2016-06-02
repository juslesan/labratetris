
import labratetris.logiikka.Kentta;
import labratetris.logiikka.Pala;
import labratetris.logiikka.palikat.*;

public class Main {

    public static void main(String[] args) {
        Kentta kentta = new Kentta(22, 10);

        tulostaKentta(kentta);
        J j = new J(kentta);
//        J j = new J(kentta);

//        j.vasen();
        j.kaanna();
        j.kaanna();
        j.kaanna();
        j.kaanna();
//        j.vasen();
//        j.vasen();
//        j.vasen();
//        j.kaanna();
//        j.vasen();
//        j.kaanna();
//        j.oikea();
//        j.kaanna();
//        l.kaanna();
        j.jaadytaKentalle();
        tulostaKentta(kentta);
//        l.pudota();
//        L l2 = new L(kentta);
//        tulostaKentta(kentta);
//        l2.pudota();
//        tulostaKentta(kentta);
    }

    public static void tulostaKentta(Kentta kentta) {
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
