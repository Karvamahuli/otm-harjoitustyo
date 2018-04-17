package fi.xtoxtoxt.tekstiroolipeli;

public class Huone {

    private String kuvaus;

    public Huone() {
    }

    public Huone(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public String getKuvaus() {
        return this.kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    @Override
    public String toString() {
        return this.kuvaus;
    }

}
