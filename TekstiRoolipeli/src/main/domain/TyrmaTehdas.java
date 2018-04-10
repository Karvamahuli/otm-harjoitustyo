package main.domain;

import java.util.Scanner;

public class TyrmaTehdas {

    private Huone[][] Huone;
    private Henkilo sankari;
    private Scanner lukija;

    public TyrmaTehdas() {
        this.Huone = new Huone[4][4];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                this.Huone[x][y] = new Huone();
            }
        }
        this.lukija = new Scanner(System.in);
    }

    public void liikuIlmansuuntaan(String suunta) {
        if (suunta.equals("pohjoinen")) {
            sankari.setSijaintiY(sankari.getSijaintiY() + 1);
        } else if (suunta.equals("itä")) {
            sankari.setSijaintiX(sankari.getSijaintiX() + 1);
        } else if (suunta.equals("etelä")) {
            sankari.setSijaintiY(sankari.getSijaintiY() - 1);
        } else if (suunta.equals("länsi")) {
            sankari.equals(sankari.getSijaintiX() - 1);
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
    
    private void huoneidenLuonti(){
        Huone aloitusHuone = new Huone("Olet Tuhkimon omassa tunkkaisessa komerossa. "
                + "Huoneessa on kulunut sänky länsiseinustalla, pienehkö ikkuna eteläpuolella ja matala ovi pohjoisseinällä.");
        this.Huone[0][0] = aloitusHuone;
        Huone kaytava = new Huone("Olet keittiöön menevällä käytävällä.");
        this.Huone[0][1] = kaytava;
    }

    public void kaynnistaPeli() {
        this.huoneidenLuonti();
        Tuloste.ohjeet();
        while (true) {
            Tuloste.huoneenKuvaus(Huone[this.sankari.getSijaintiX()][this.sankari.getSijaintiY()].getKuvaus());
            String syote = this.lukija.nextLine();
            if (syote.equals("pohjoinen") || syote.equals("p")){
                this.liikuIlmansuuntaan("pohjoinen");
            } else if (syote.equals("itä") || syote.equals("i")){
                this.liikuIlmansuuntaan("itä");
            } else if (syote.equals("etelä") || syote.equals("e")){
                this.liikuIlmansuuntaan("etelä");
            } else if (syote.equals("länsi") || syote.equals("l")){
                this.liikuIlmansuuntaan("länsi");
            }
        }
    }
}
