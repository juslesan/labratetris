package labratetris.logiikka;

import labratetris.logiikka.palikat.Vari;

/**
 *
 * @author juslesan
 *
 * Luokan tarkoituksena on toimia yksittäisiä paloja ylläpitävänä.
 */
public class Pala {

    private int y;
    private int x;
    private boolean pudonnut;
    private Vari vari;

    public Pala(int x, int y) {
        this.x = x;
        this.y = y;
        this.pudonnut = false;
    }

    public Pala(int x, int y, Vari vari) {
        this.x = x;
        this.y = y;
        this.pudonnut = false;
        this.vari = vari;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Pudottaa yksittäistä palaa alaspäin ruudun verran.
     */
    public void putoa() {
        this.y++;
    }

    /**
     * Siirtää yksittäistä palaa oikealle yhden ruudun verran.
     */
    public void oikea() {
        this.x++;
    }

    /**
     * Siirtää yksittäistä palaa vasemmalle yhden ruudun verran.
     */
    public void vasen() {
        this.x--;
    }

    public boolean onkoPudonnut() {
        return this.pudonnut;
    }

    public void pudonnut() {
        this.pudonnut = true;
    }

    /**
     * Siirtää palaa paramterien arvojen verran.
     *
     * @param x siirrettävä määrä leveyssuunnassa.
     * @param y siirrettävä määrä korkeussuunnassa.
     */
    public void siirra(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void setVari(Vari vari) {
        this.vari = vari;
    }

    public Vari getVari() {
        return this.vari;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
