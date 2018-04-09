package main.domain;

import java.util.Arrays;

public class TekstiRoolipeli {

    public static void main(String[] args) {
        Huone[][] lista = new Huone[4][4];
        for (int x = 0; x < lista.length; x++) {
            for (int y=0; y<lista.length; y++){
                lista[x][y] = new Huone("Tässä huoneessa koordinaatit: "+x+", "+y);
            }
        }
        lista[2][2] = new Huone("Tässä on salahuone");
        for (int x = 0; x < lista.length; x++) {
            for (int y=0; y<lista.length; y++){
                System.out.println(""+lista[x][y].getKuvaus());
            }
        }
        
    }

}
