
import labratetris.logiikka.Kentta;
import labratetris.logiikka.Pala;

public class Main {

    public static void main(String[] args) {
        Kentta kentta = new Kentta(22, 10);
        for (int i = 0; i < 10; i++) {
            kentta.tayta(i, 0, new Pala(i, 0));
        }
        System.out.println(kentta.onkoRiviTaynna(0));
    }
}
