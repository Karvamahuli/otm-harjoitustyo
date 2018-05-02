package fi.xtoxtoxt.tekstiroolipeli;

import java.util.ArrayList;

/**
 * Hall of Fame -taulukkoa hallinnoiva luokka.
 */
public class Taulukko {

    private ArrayList<String> taulukko;

    public Taulukko(ArrayList<String> taulukko) {
        this.taulukko = taulukko;
    }

    public ArrayList<String> getTaulukko() {
        return taulukko;
    }

    /**
     * Lisää taulukkoon henkilon nimen.
     *
     * @param sankari Henkilo, jonka nimi lisätään
     */
    public void lisaaTaulukkoon(Henkilo sankari) {
        this.taulukko.add(sankari.getNimi());
    }
}
