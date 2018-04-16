package fi.xtoxtoxt.tekstiroolipeli.logiikka;

import fi.xtoxtoxt.tekstiroolipeli.Henkilo;
import fi.xtoxtoxt.tekstiroolipeli.Huone;
import java.util.Scanner;

public class TyrmaTehdas {

    private Huone[][] huoneet;
    private Henkilo sankari;
    private Scanner lukija;

    public TyrmaTehdas() {
        this.huoneet = new Huone[5][5];
        for (int x = 0; x < this.huoneet.length; x++) {
            for (int y = 0; y < this.huoneet[x].length; y++) {
                this.huoneet[x][y] = new Huone();
            }
        }
        this.lukija = new Scanner(System.in);
    }

    public void liikuIlmansuuntaan(String suunta) {
        if (suunta.equals("pohjoinen")
                && this.sankari.getSijaintiY() + 1 < this.huoneet[this.sankari.getSijaintiX()].length) {
            if (this.huoneet[this.sankari.getSijaintiX()][this.sankari.getSijaintiY() + 1].getKuvaus() != null) {
                sankari.setSijaintiY(sankari.getSijaintiY() + 1);
            } else {
                Tuloste.virheellinenSuunta();
            }
        } else if (suunta.equals("itä")
                && this.sankari.getSijaintiX() < this.huoneet.length) {
            if (this.huoneet[this.sankari.getSijaintiX() + 1][this.sankari.getSijaintiY()].getKuvaus() != null) {
                sankari.setSijaintiX(sankari.getSijaintiX() + 1);
            } else {
                Tuloste.virheellinenSuunta();
            }
        } else if (suunta.equals("etelä")
                && this.sankari.getSijaintiY() - 1 >= 0) {
            if (this.huoneet[this.sankari.getSijaintiX()][this.sankari.getSijaintiY() - 1].getKuvaus() != null) {
                sankari.setSijaintiY(sankari.getSijaintiY() - 1);
            } else {
                Tuloste.virheellinenSuunta();
            }
        } else if (suunta.equals("länsi")
                && this.sankari.getSijaintiX() - 1 >= 0) {
            if (this.huoneet[this.sankari.getSijaintiX() - 1][this.sankari.getSijaintiY()].getKuvaus() != null) {
                sankari.setSijaintiX(sankari.getSijaintiX() - 1);
            } else {
                Tuloste.virheellinenSuunta();
            }
        } else {
            Tuloste.virheellinenSuunta();
        }
        System.out.println(sankari.koordinaateissa());
    }

    private void setSankari(Henkilo sankari) {
        this.sankari = sankari;
    }

    public void hahmonLuonti() {
        Tuloste.nimenValinta();
        String nimi = lukija.nextLine();
        Henkilo paahenkilo = new Henkilo(nimi);
        this.setSankari(paahenkilo);
    }

    private void huoneidenLuonti() {
        Huone aloitusHuone = new Huone("Olet Tuhkimon omassa tunkkaisessa komerossa. "
                + "Huoneessa on kulunut sänky länsiseinustalla, "
                + "pienehkö ikkuna eteläpuolella ja matala ovi pohjoisseinällä.");
        this.huoneet[0][0] = aloitusHuone;
        Huone kaytava = new Huone("Olet keittiöön menevällä käytävällä.");
        this.huoneet[0][1] = kaytava;
        Huone testiHuone = new Huone("Tämä on testi huone");
        this.huoneet[1][0] = testiHuone;
    }

    public void kaynnistaPeli() {
        this.huoneidenLuonti();
        Tuloste.ohjeet();
        while (true) {
            Tuloste.huoneenKuvaus(this.huoneet[this.sankari.getSijaintiX()][this.sankari.getSijaintiY()].getKuvaus());
            String syote = this.lukija.nextLine();
            if (syote.equals("pohjoinen") || syote.equals("p")) {
                this.liikuIlmansuuntaan("pohjoinen");
            } else if (syote.equals("itä") || syote.equals("i")) {
                this.liikuIlmansuuntaan("itä");
            } else if (syote.equals("etelä") || syote.equals("e")) {
                this.liikuIlmansuuntaan("etelä");
            } else if (syote.equals("länsi") || syote.equals("l")) {
                this.liikuIlmansuuntaan("länsi");
            } else {
                Tuloste.virheellinenKomento(syote);
            }
        }
    }

    public Huone[][] getHuoneet() {
        return huoneet;
    }

    public Scanner getLukija() {
        return lukija;
    }

    public Henkilo getSankari() {
        return sankari;
    }

}
