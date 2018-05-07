package fi.xtoxtoxt.tekstiroolipeli;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaulukkoTest {

    @Test
    public void taulukkoonLisays() {
        ArrayList<String> lista = new ArrayList<>();
        Taulukko taulukko = new Taulukko(lista);
        Henkilo sakari = new Henkilo("Sakari");
        taulukko.lisaaTaulukkoon(sakari);
        assertEquals("Sakari", taulukko.getTaulukko().get(0));
    }
}
