package main.domain;

public class Henkilo {

    private String nimi;
    private int sijaintiX;
    private int sijaintiY;

    public Henkilo(String nimi, int sijaintiX, int sijaintiY) {
        this.nimi = nimi;
        this.sijaintiX = sijaintiX;
        this.sijaintiY = sijaintiY;
    }

    public Henkilo(String nimi) {
        this.nimi = nimi;
        this.sijaintiX = 0;
        this.sijaintiY = 0;
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
        return this.sijaintiX+", "+this.sijaintiY;
    }
}
