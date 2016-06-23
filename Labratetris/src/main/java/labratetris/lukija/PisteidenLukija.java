/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratetris.lukija;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santeri Juslenius
 *
 * Luokan on tarkoitus toimia huippupisteitä lukevana ja tallentavana luokkana.
 *
 */
public class PisteidenLukija {

    private File tiedosto;

    public PisteidenLukija() {
        this.tiedosto = new File("src/main/resources/pistetilastot.txt");
    }

    /**
     * Metodin tarkoituksena on muokata pistetilastot.txt-tiedoston sisältö
     * muotoon, jossa se voidaan esittää käyttöliittymässä.
     *
     * @return Palauttaa listan String muotoisia arvoja
     * @throws FileNotFoundException Virhe ilmoitus mikäli tiedostoa ei
     * löydetty.
     */
    public String[] getPistetilastot() {
        try {
            Scanner lukija = new Scanner(this.tiedosto);
            String[] tilastot = new String[5];

            for (int i = 0; i < 5; i++) {
                String lisattava = (i + 1) + ".  ";
                String[] osat = lukija.nextLine().split(":");
                lisattava += osat[0] + ":   " + osat[1];
                tilastot[i] = lisattava;
            }
            return tilastot;
        } catch (FileNotFoundException ex) {
            nollaa();
            return getPistetilastot();
        }
    }

    /**
     * Metodi tarkistaa onko pelin loputtua saavutettu pistemäärä top 5 listaan
     * kuuluva.
     *
     * @param pisteet Pelin aikana saavutetut pisteet.
     * @return palauttaa true mikäli tulos kuulu top viiteen
     */
    public boolean onkoUusiEnnatys(int pisteet) {
        try {
            Scanner lukija = new Scanner(this.tiedosto);

            for (int i = 0; i < 5; i++) {
                String[] osat = lukija.nextLine().split(":");
                int tarkistettava = Integer.parseInt(osat[1]);
                if (pisteet > tarkistettava) {
                    return true;
                }
            }
        } catch (Exception error) {
            nollaa();
            return false;
        }
        return false;
    }

    /**
     * Metodi käy läpi kaikki pistetilastot.txt -tiedoston rivit ja löytää
     * sieltä paikan, johon tulos sijoittuu.
     *
     * @param nimi Ennätyksen tehnyt pelaaja
     * @param pisteet Ennätyspisteet
     */
    public void uusiEnnatys(String nimi, int pisteet) {
        try {
            Scanner lukija = new Scanner(this.tiedosto);

            int i = 0;
            while (lukija.hasNextLine()) {
                String[] osat = lukija.nextLine().split(":");
//                System.out.println(osat[0] + " , " + osat[1]);
                int tarkistettava = Integer.parseInt(osat[1]);
                if (pisteet > tarkistettava) {
                    kirjoitaUusiEnnatys(nimi, pisteet, i);
                    return;
                }
                i++;
            }
        } catch (Exception error) {
            nollaa();
        }
    }

    /**
     * Kirjoittaa pistetilastot.txt tiedostoon uuden ennätyksen, sekä siirtää
     * vanhoja ennätyksiä tarpeen mukaisesti poistaen myös entisen sijan 5.
     *
     * @param nimi pelaajan nimimerkki
     * @param pisteet pelissä saavutettu pistemäärä
     * @param paikka uuden ennätyksen sijoitus
     * @throws IOException Virheilmoitus, jos tiedostoa ei löydy.
     */
    public void kirjoitaUusiEnnatys(String nimi, int pisteet, int paikka) throws IOException {
        String[] kirjoitettavat = tiedostonSisalto();
        String[] korvattavat = new String[kirjoitettavat.length];
        int x = 0;
        for (int i = 0; i < korvattavat.length; i++) {
            if (i == paikka) {
                korvattavat[i] = nimi + ":" + pisteet;

            } else {
                korvattavat[i] = kirjoitettavat[x];
                x++;
            }

        }
        kirjoitettavat = korvattavat;
//        kirjoitettavat[paikka] = nimi + ":" + pisteet;

        FileWriter kirjoittaja = new FileWriter(this.tiedosto);
        for (int i = 0; i < kirjoitettavat.length; i++) {
            kirjoittaja.write(kirjoitettavat[i] + "\n");
        }
        kirjoittaja.close();

    }

    /**
     * Palauttaa pistetilastot.txt tiedoston rivit listana.
     *
     * @return Tiedoston rivit listana
     */
    public String[] tiedostonSisalto() {
        try {
            Scanner lukija = new Scanner(this.tiedosto);
            String[] lista = new String[5];
            int i = 0;
            while (lukija.hasNextLine()) {
                lista[i] = lukija.nextLine();
                i++;
            }
            return lista;
        } catch (FileNotFoundException error) {
            nollaa();
            return tiedostonSisalto();
        }
    }

    /**
     * Asettaa pistetilastot.txt -tiedoston rivit oletusarvoisiksi.
     *
     * @throws IOException Virheilmoitus mikäli tiedostoa ei löydy.
     */
    public void nollaa() {
        FileWriter kirjoittaja = null;
        try {
            kirjoittaja = new FileWriter(this.tiedosto);
            kirjoittaja.write("Jone:500\nPave:400\nPena:300\nPate:200\nPasi:50");
            kirjoittaja.close();
        } catch (IOException ex) {
            Logger.getLogger(PisteidenLukija.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                kirjoittaja.close();
            } catch (IOException ex) {
                Logger.getLogger(PisteidenLukija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
