package main.domain;

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

    @Override
    public String toString() {
        return this.kuvaus;
    }
    
    
}
