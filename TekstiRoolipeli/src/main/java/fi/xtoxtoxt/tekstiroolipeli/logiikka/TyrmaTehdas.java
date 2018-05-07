package fi.xtoxtoxt.tekstiroolipeli.logiikka;

import fi.xtoxtoxt.tekstiroolipeli.Henkilo;
import fi.xtoxtoxt.tekstiroolipeli.Huone;

/**
 * Pelin sankarin ja huoneiden hallinnointia suorittava luokka.
 */
public class TyrmaTehdas {

    private Huone[][] huoneet;
    private Henkilo sankari;

    public TyrmaTehdas() {
        this.huoneet = new Huone[5][5];
        for (int x = 0; x < this.huoneet.length; x++) {
            for (int y = 0; y < this.huoneet[x].length; y++) {
                this.huoneet[x][y] = new Huone();
            }
        }
    }

    private void liikuPohjoiseen() {
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

    private void liikuItaan() {
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

    private void liikuEtelaan() {
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

    private void liikuLanteen() {
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

    /**
     * Metodi luo Henkilo -olion tyrmälle, joka toimii sitten seikkailevana
     * sankarina.
     *
     * @param nimi Käyttäjän haluama nimi.
     */
    public void hahmonLuonti(String nimi) {
        Henkilo paahenkilo = new Henkilo(nimi);
        this.setSankari(paahenkilo);
    }

    /**
     * Metodi luo tyrmälle ennalta määrätyt huoneet.
     */
    public void huoneidenLuonti() {
        Huone aloitusHuone = new Huone("Olet Tuhkimon omassa tunkkaisessa komerossa. "
                + "Huoneessa on kulunut sänky länsiseinustalla, "
                + "pienehkö ikkuna eteläpuolella ja matala ovi pohjoisseinällä.");
        this.huoneet[0][0] = aloitusHuone;
        Huone kaytava = new Huone("Olet keittiöön menevällä käytävällä. Maassa olevan pitkän maton vieressä on jotain kiiltävää. "
                + "Tarkemmalla tarkastelulla huomaat sen olevan avain.");
        this.huoneet[0][1] = kaytava;
        Huone keittio = new Huone("Olet talon suuressa keittiössä. Ruoan tuoksu osuu kantautuu nenääsi. "
                + "Iso paha äiti seisoo hellan äärellä "
                + "ja valmistaa ruokaa eikä huomaa kun astut huoneeseen."
                + "Pohjoispuolella on ruokakomeron lukittu ovi ja eteläpuolella on ovi käytävälle.");
        this.huoneet[1][1] = keittio;
        Huone ruokakomero = new Huone("Saat avattua oven nostamallasi avaimella ja pääset talon ahtaaseen ruokakomeroon. "
                + "Näet ympärilläsi erilaisia säilykkeitä "
                + "ja mausteita ynnä muita ruokatarvikkeita. Näet pohjoispäädyssä olevan kaapin päällä äidin "
                + "karkkilaatikon. Se on kuitenkin melko korkealla.");
        this.huoneet[1][2] = ruokakomero;
    }

    /**
     * Metodi ajaa mahdollisesti peliä eteenpäin kutsumalla muita luokan
     * sisäisiä metodeja syötteestä riippuen. Jos syöte ei vastaa mitään
     * komentoa niin se tulostaa virheilmoituksen.
     *
     * @param alkuperainenSyote Käyttäjän antama syöte
     */
    public void seuraavaAskel(String alkuperainenSyote) {
        String syote = alkuperainenSyote.trim().toLowerCase();
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

    private void nostaEsine(String syote) {
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

        } else if ((esine.equals("karkkilaatikko") || syote.contains("laatikko"))
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

    /**
     * Metodi tarkastaa onko pelaaja aloitushuoneessa karkkilaatikon kanssa ja
     * palauttaa sen mukaan joko true tai false.
     *
     * @return true jos sankari on aloitushuoneessa karkkilaatikon kanssa,
     * muuten false.
     */
    public boolean voititPelin() {
        return this.sankari.getSijaintiX() == 0 && this.sankari.getSijaintiY() == 0
                && this.sankari.omistaaEsineen("karkkilaatikko");
    }

    /**
     * Tyrmän huoneet koordinaatistossa.
     *
     * @return Tyrmän huoneet kaksiulotteisessa listassa.
     */
    public Huone[][] getHuoneet() {
        return huoneet;
    }

    /**
     * Tyrmän sankari
     *
     * @return Tyrmän sankari.
     */
    public Henkilo getSankari() {
        return sankari;
    }

}
