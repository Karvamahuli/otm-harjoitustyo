package fi.xtoxtoxt.tekstiroolipeli;

import java.util.HashMap;

public class Henkilo {

    private String nimi;
    private int sijaintiX;
    private int sijaintiY;
    private HashMap<String, Boolean> esineet;

    public Henkilo(String nimi, int sijaintiX, int sijaintiY) {
        this.nimi = nimi;
        this.sijaintiX = sijaintiX;
        this.sijaintiY = sijaintiY;
        this.esineet = luoEsinePaikat();
    }

    public Henkilo(String nimi) {
        this.nimi = nimi;
        this.sijaintiX = 0;
        this.sijaintiY = 0;
        this.esineet = luoEsinePaikat();
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getSijaintiX() {
        return sijaintiX;
    }

    public int getSijaintiY() {
        return sijaintiY;
    }

    public void setSijaintiX(int sijaintiX) {
        this.sijaintiX = sijaintiX;
    }

    public void setSijaintiY(int sijaintiY) {
        this.sijaintiY = sijaintiY;
    }

    public void siirraKohtaan(int sijaintiX, int sijaintiY) {
        this.sijaintiX = sijaintiX;
        this.sijaintiY = sijaintiY;
    }

    public String koordinaateissa() {
        return this.sijaintiX + ", " + this.sijaintiY;
    }

    private HashMap luoEsinePaikat() {
        HashMap<String, Boolean> esinePaikat = new HashMap<>();
        esinePaikat.put("avain", false);
        esinePaikat.put("karkkilaatikko", false);

        return esinePaikat;
    }

    public HashMap<String, Boolean> getEsineet() {
        return esineet;
    }

    public void saaOmistukseen(String esine) {
        if (this.esineet.entrySet().stream().anyMatch(asia -> asia.getKey().equals(esine))) {
            this.esineet.put(esine, Boolean.TRUE);
        }
    }

    public boolean omistaaEsineen(String esine) {
        return this.esineet.getOrDefault(esine, Boolean.FALSE);
    }

    @Override
    public String toString() {
        return this.nimi;
    }

}
