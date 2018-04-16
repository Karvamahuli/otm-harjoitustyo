package fi.xtoxtoxt.tekstiroolipeli;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HenkiloTest {

    public HenkiloTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

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
}