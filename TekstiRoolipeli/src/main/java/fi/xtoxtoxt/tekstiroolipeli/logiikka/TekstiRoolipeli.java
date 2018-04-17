package fi.xtoxtoxt.tekstiroolipeli.logiikka;

public class TekstiRoolipeli {

    public static void aloitaPeli() {
        TyrmaTehdas kentta = new TyrmaTehdas();
        Tuloste.alkuteksti();
        kentta.hahmonLuonti();
        kentta.getSankari().getEsineet().toString();
        kentta.kaynnistaPeli();
    }

    public static void main(String[] args) {

        TekstiRoolipeli.aloitaPeli();

    }

}
