package fi.xtoxtoxt.tekstiroolipeli;

public class TekstiRoolipeli {

    public static void aloitaPeli() {
        TyrmaTehdas kentta = new TyrmaTehdas();
        Tuloste.alkuteksti();
        kentta.hahmonLuonti();
        kentta.kaynnistaPeli();
    }

    public static void main(String[] args) {

        TekstiRoolipeli.aloitaPeli();
        
//        Henkilo urho = new Henkilo("Uljas Urho");
//        TyrmaTehdas alue = new TyrmaTehdas();
//        alue.setSankari(urho);
//        System.out.println(urho.koordinaateissa());
//        alue.liikuIlmansuuntaan("pohjoinen");

    }

}
