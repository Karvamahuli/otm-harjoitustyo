package fi.xtoxtoxt.tekstiroolipeli;

public class Huone {
    private String kuvaus;
    private boolean huoneOlemassa;

    public Huone() {
    }
    

    public Huone(String kuvaus) {
        this.kuvaus = kuvaus;
        this.huoneOlemassa = true;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public boolean isHuoneOlemassa() {
        return huoneOlemassa;
    }
    

    @Override
    public String toString() {
        return this.kuvaus;
    }
    
    
}
