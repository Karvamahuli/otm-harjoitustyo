package fi.xtoxtoxt.tekstiroolipeli.logiikka;

public class Tuloste {

    public static void alkuteksti() {
        System.out.println("Tässä pelin alkuteksti\n");
    }

    public static void nimenValinta() {
        System.out.format("Mikä on mahtavan sankarisi nimi? \n");
    }

    public static void huoneenKuvaus(String kuvaus) {
        System.out.println(kuvaus);
        System.out.println();
    }

    public static void ohjeet() {
        System.out.format("Liikkuaksesi alueelta toiselle kirjoita kirjoita ilmansuunta tai sen ensimmäinen kirjain ja paina Enteriä.\n"
                + "\"p\" tai \"pohjoinen \" liikkuaksesi pohjoiseen.\n"
                + "\"i\" tai \"itä \" liikkuaksesi itään.\n"
                + "\"e\" tai \"etelä \" liikkuaksesi etelään.\n"
                + "\"l\" tai \"länsi \" liikkuaksesi länteen.\n");
        System.out.println("Tällä hetkellä on olemassa vain kaksi huonetta: "
                + "\nkoordinaateissa (0,0) ja siitä pohjoiseen koordinaateissa (0,1)");
    }

    public static void virheellinenSuunta() {
        System.out.println("Valittuun suuntaan ei ole reittiä.");
    }
    
    public static void virheellinenKomento(String syote) {
        System.out.println("Antamasi komento \""+syote+"\" on virheellinen");
    }
    
}
