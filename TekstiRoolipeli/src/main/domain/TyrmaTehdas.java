package main.domain;

public class TyrmaTehdas {
    private String Huone[][];
    private Henkilo sankari;

    public TyrmaTehdas(Henkilo sankari) {
        Huone[][] lista = new Huone[4][4];
        for (int x = 0; x < lista.length; x++) {
            for (int y=0; y<lista[x].length; y++){
                lista[x][y] = new Huone();
            }
        }
        this.sankari = sankari;
    }
    
    public void liikuIlmansuuntaan(String suunta){
        if (suunta.equals("pohjoinen")){
            sankari.setSijaintiY(sankari.getSijaintiY()+1);
        } else if (suunta.equals("itä")){
            sankari.setSijaintiX(sankari.getSijaintiX()+1);
        } else if (suunta.equals("etelä")){
            sankari.setSijaintiY(sankari.getSijaintiY()-1);
        } else if (suunta.equals("länsi")){
            sankari.equals(sankari.getSijaintiX()-1);
        }
        System.out.println(sankari.koordinaateissa());
    }
}
