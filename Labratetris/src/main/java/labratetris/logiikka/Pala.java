package labratetris.logiikka;

public class Pala {

    private int y;
    private int x;
    private boolean pudonnut;

    public Pala(int x, int y) {
        this.x = x;
        this.y = y;
        this.pudonnut = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void putoa() {
        this.y++;
    }

    public void oikea() {
        this.x++;
    }

    public void vasen() {
        this.x--;
    }

    public boolean onkoPudonnut() {
        return this.pudonnut;
    }

    public void pudonnut() {
        this.pudonnut = true;
    }

    public void siirra(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
