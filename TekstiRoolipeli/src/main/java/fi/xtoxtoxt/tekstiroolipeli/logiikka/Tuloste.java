package fi.xtoxtoxt.tekstiroolipeli.logiikka;

public class Tuloste {

    public static String alkuteksti() {
        return "Tervetuloa peliin!";
    }

    public static String nimenValintaOhje() {
        return "Mikä on mahtavan sankarisi nimi? \n";
    }

    public static void huoneenKuvaus(String kuvaus) {
        TekstiRoolipeli.lisaaTeksti(kuvaus);
    }

    public static void ohjeet() {
        TekstiRoolipeli.lisaaTeksti("Liikkuaksesi alueelta toiselle kirjoita kirjoita ilmansuunta "
                + "tai sen ensimmäinen kirjain ja paina Enteriä.\n"
                + "\"p\" tai \"pohjoinen \" liikkuaksesi pohjoiseen.\n"
                + "\"i\" tai \"itä \" liikkuaksesi itään.\n"
                + "\"e\" tai \"etelä \" liikkuaksesi etelään.\n"
                + "\"l\" tai \"länsi \" liikkuaksesi länteen.\n");
    }

    public static void virheellinenSuunta() {
        TekstiRoolipeli.lisaaTeksti("Valittuun suuntaan ei ole reittiä.\n");
    }

    public static void virheellinenKomento(String syote) {
        TekstiRoolipeli.lisaaTeksti("Antamasi komentoa \"" + syote + "\" ei tunnistettu.");
    }

    public static void nostaEsine(String nimi, String esine) {
        TekstiRoolipeli.lisaaTeksti(nimi + " nosti esineen " + esine + ".");
    }

    public static void esinettaEiLoytynyt(String esine) {
        TekstiRoolipeli.lisaaTeksti("Esinettä \"" + esine + "\" ei löytynyt huoneesta.");
    }

    public static void omistatJoEsineen(String esine) {
        TekstiRoolipeli.lisaaTeksti("Omistat jo esineen " + esine);
    }

    public static void avainPuuttuu() {
        TekstiRoolipeli.lisaaTeksti("Tarvitset avaimen avataksesi pohjoispuolella olevan oven.");
    }

}
