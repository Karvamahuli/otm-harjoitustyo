package fi.xtoxtoxt.tekstiroolipeli;

import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class HenkiloTest {

    @Test
    public void henkilonLuonti() {
        Henkilo sakari = new Henkilo("Sakari");
        assertEquals("Sakari", sakari.toString());
    }

    @Test
    public void henkilonLuontiSijainnillaSijainti() {
        Henkilo sakari = new Henkilo("Sakari", 1, 1);
        assertEquals("1, 1", sakari.koordinaateissa());
    }

    @Test
    public void henkilonLuontiSijainnillaNimi() {
        Henkilo sakari = new Henkilo("Sakari", 1, 1);
        assertEquals("Sakari", sakari.toString());
    }

    @Test
    public void henkilonKoordinaatitTulostuuOikein() {
        Henkilo sakari = new Henkilo("Sakari");
        assertEquals("0, 0", sakari.koordinaateissa());
    }

    @Test
    public void henkilonSiirtoKohtaan() {
        Henkilo sakari = new Henkilo("Sakari");
        sakari.siirraKohtaan(2, 2);
        assertEquals("2, 2", sakari.koordinaateissa());
    }

    @Test
    public void esineListausLuodaanOikein() {
        Henkilo sakari = new Henkilo("Sakari");
        assertEquals(false, sakari.getEsineet().get("avain"));
    }

    @Test
    public void esineetOlemassa() {
        Henkilo sakari = new Henkilo("Sakari");
        assertTrue(sakari.getEsineet() instanceof HashMap);
    }

    @Test
    public void esineenLisays() {
        Henkilo sakari = new Henkilo("Sakari");
        sakari.saaOmistukseen("avain");
        assertEquals(true, sakari.getEsineet().get("avain"));
    }

    @Test
    public void esineenLisaysVaarallaEsineella() {
        Henkilo sakari = new Henkilo("Sakari");
        sakari.saaOmistukseen("jakoavain");
        assertEquals(false, sakari.getEsineet().get("avain"));
    }

    @Test
    public void esineenOmistusNakyy() {
        Henkilo sakari = new Henkilo("Sakari");
        sakari.saaOmistukseen("avain");
        assertEquals(true, sakari.omistaaEsineen("avain"));
    }

    @Test
    public void esineenOmistusNakyyJosEiEsinetta() {
        Henkilo sakari = new Henkilo("Sakari");
        assertEquals(false, sakari.omistaaEsineen("avain"));
    }
}
