package fi.xtoxtoxt.tekstiroolipeli;

import java.util.ArrayList;

public class Taulukko {

    private ArrayList<String> taulukko;

    public Taulukko(ArrayList<String> taulukko) {
        this.taulukko = taulukko;
    }

    public ArrayList<String> getTaulukko() {
        return taulukko;
    }

    public void lisaaTaulukkoon(Henkilo sankari) {
        this.taulukko.add(sankari.getNimi());
    }
}
