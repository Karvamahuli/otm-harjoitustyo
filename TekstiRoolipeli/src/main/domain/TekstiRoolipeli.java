package main.domain;

public class TekstiRoolipeli {

    public static void main(String[] args) {
        
        Henkilo urho = new Henkilo("Uljas Urho");
        TyrmaTehdas alue = new TyrmaTehdas(urho);
        System.out.println(urho.koordinaateissa());
        alue.liikuIlmansuuntaan("pohjoinen");  
        
    }

}
