package main.domain;

public class Huone {
    private String kuvaus;

    public Huone(String kuvaus) {
        this.kuvaus = kuvaus;
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
