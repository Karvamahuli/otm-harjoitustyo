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

    public void liikuPohjoiseen() {
        if (this.sankari.getSijaintiX() == 1 && this.sankari.getSijaintiY() == 1) {
            if (this.sankari.omistaaEsineen("avain")) {
                sankari.setSijaintiY(sankari.getSijaintiY() + 1);
                Tuloste.huoneenKuvaus(this.huoneet[this.sankari.getSijaintiX()][this.sankari.getSijaintiY()].getKuvaus());
            } else {
                Tuloste.avainPuuttuu();
            }
        } else if (this.sankari.getSijaintiY() + 1 < this.huoneet[this.sankari.getSijaintiX()].length) {
            if (this.huoneet[this.sankari.getSijaintiX()][this.sankari.getSijaintiY() + 1].getKuvaus() != null) {
                sankari.setSijaintiY(sankari.getSijaintiY() + 1);
                Tuloste.huoneenKuvaus(this.huoneet[this.sankari.getSijaintiX()][this.sankari.getSijaintiY()].getKuvaus());
            } else {
                Tuloste.virheellinenSuunta();
            }
        } else {
            Tuloste.virheellinenSuunta();
        }
    }

    public void liikuItaan() {
        if (this.sankari.getSijaintiX() < this.huoneet.length) {
            if (this.huoneet[this.sankari.getSijaintiX() + 1][this.sankari.getSijaintiY()].getKuvaus() != null) {
                sankari.setSijaintiX(sankari.getSijaintiX() + 1);
                Tuloste.huoneenKuvaus(this.huoneet[this.sankari.getSijaintiX()][this.sankari.getSijaintiY()].getKuvaus());
            } else {
                Tuloste.virheellinenSuunta();
            }
        } else {
            Tuloste.virheellinenSuunta();
        }
    }

    public void liikuEtelaan() {
        if (this.sankari.getSijaintiY() - 1 >= 0) {
            if (this.huoneet[this.sankari.getSijaintiX()][this.sankari.getSijaintiY() - 1].getKuvaus() != null) {
                sankari.setSijaintiY(sankari.getSijaintiY() - 1);
                Tuloste.huoneenKuvaus(this.huoneet[this.sankari.getSijaintiX()][this.sankari.getSijaintiY()].getKuvaus());
            } else {
                Tuloste.virheellinenSuunta();
            }
        } else {
            Tuloste.virheellinenSuunta();
        }
    }

    public void liikuLanteen() {
        if (this.sankari.getSijaintiX() - 1 >= 0) {
            if (this.huoneet[this.sankari.getSijaintiX() - 1][this.sankari.getSijaintiY()].getKuvaus() != null) {
                sankari.setSijaintiX(sankari.getSijaintiX() - 1);
                Tuloste.huoneenKuvaus(this.huoneet[this.sankari.getSijaintiX()][this.sankari.getSijaintiY()].getKuvaus());
            } else {
                Tuloste.virheellinenSuunta();
            }
        } else {
            Tuloste.virheellinenSuunta();
        }
    }

    private void setSankari(Henkilo sankari) {
        this.sankari = sankari;
    }

    public void hahmonLuonti() {
        Tuloste.nimenValintaOhje();
        String nimi = lukija.nextLine();
        Henkilo paahenkilo = new Henkilo(nimi);
        this.setSankari(paahenkilo);
    }

    private void huoneidenLuonti() {
        Huone aloitusHuone = new Huone("Olet Tuhkimon omassa tunkkaisessa komerossa. "
                + "Huoneessa on kulunut sänky länsiseinustalla, "
                + "pienehkö ikkuna eteläpuolella ja matala ovi pohjoisseinällä.");
        this.huoneet[0][0] = aloitusHuone;
        Huone kaytava = new Huone("Olet keittiöön menevällä käytävällä. Maassa olevan pitkän maton vieressä on jotain kiiltävää. "
                + "\nTarkemmalla tarkastelulla huomaat, että sen olevan avain.");
        this.huoneet[0][1] = kaytava;
        Huone keittio = new Huone("Olet talon suuressa keittiössä. Ruoan tuoksu osuu kantautuu nenääsi. "
                + "\nIso paha äiti seisoo hellan äärellä "
                + "ja tekee ruokaa eikä huomaa kun astut huoneeseen.");
        this.huoneet[1][1] = keittio;
        Huone ruokakomero = new Huone("Saat avattua oven nostamallasi avaimella ja pääset talon ahtaassa ruokakomerossa. "
                + "Näet ympärilläsi erilaisia säilykkeitä "
                + "\nja mausteita ynnä muita ruokatarvikkeita. Näet pohjois pädyssä olevan kaapin päällä äidin "
                + "\nkarkkilaatikon. Se on kuitenkin melko korkealla.");
        this.huoneet[1][2] = ruokakomero;
    }

    public void kaynnistaPeli() {
        this.huoneidenLuonti();
        Tuloste.ohjeet();
        Tuloste.huoneenKuvaus(this.huoneet[this.sankari.getSijaintiX()][this.sankari.getSijaintiY()].getKuvaus());
        while (true) {

            if (voititPelin()) {
                break;
            }

            String alkuperainenSyote = this.lukija.nextLine();
            String syote = alkuperainenSyote.toLowerCase().trim();
            if (syote.equals("pohjoinen") || syote.equals("p")) {
                this.liikuPohjoiseen();
            } else if (syote.equals("itä") || syote.equals("i")) {
                this.liikuItaan();
            } else if (syote.equals("etelä") || syote.equals("e")) {
                this.liikuEtelaan();
            } else if (syote.equals("länsi") || syote.equals("l")) {
                this.liikuLanteen();
            } else if (syote.startsWith("nosta ") || syote.startsWith("poimi ")
                    || syote.startsWith("nouki ") || syote.startsWith("ota ")) {
                this.nostaEsine(syote);
            } else {
                Tuloste.virheellinenKomento(alkuperainenSyote);
            }
        }
    }

    public void nostaEsine(String syote) {
        String[] esineSyote = syote.split(" ", 2);
        String esine = esineSyote[1];
        if (esine.equals("avain") && this.sankari.getSijaintiX() == 0
                && this.sankari.getSijaintiY() == 1) {

            if (!this.sankari.omistaaEsineen("avain")) {
                this.sankari.saaOmistukseen("avain");
                Tuloste.nostaEsine(this.sankari.getNimi(), "avain");
            } else {
                Tuloste.omistatJoEsineen("avain");
            }

        } else if (esine.equals("karkkilaatikko") || syote.contains("laatikko")
                && this.sankari.getSijaintiX() == 1 && this.sankari.getSijaintiY() == 2) {

            if (!this.sankari.omistaaEsineen("karkkilaatikko")) {
                this.sankari.saaOmistukseen("karkkilaatikko");
                Tuloste.nostaEsine(this.sankari.getNimi(), "karkkilaatikko");
            } else {
                Tuloste.omistatJoEsineen("karkkilaatikko");
            }

        } else {
            Tuloste.esinettaEiLoytynyt(esine);
        }
    }

    public boolean voititPelin() {
        if (this.sankari.getSijaintiX() == 0 && this.sankari.getSijaintiY() == 0
                && this.sankari.omistaaEsineen("karkkilaatikko")) {
            return true;
        }
        return false;
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
