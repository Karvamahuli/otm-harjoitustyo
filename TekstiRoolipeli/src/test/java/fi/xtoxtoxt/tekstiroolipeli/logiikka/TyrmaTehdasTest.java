package fi.xtoxtoxt.tekstiroolipeli.logiikka;

import fi.xtoxtoxt.tekstiroolipeli.Henkilo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TyrmaTehdasTest {

    TyrmaTehdas tyrma;

    @Before
    public void setUp() {
        tyrma = new TyrmaTehdas();
        tyrma.hahmonLuonti("Sakari");
    }

    @Test
    public void tyrmanKonstruktorinHuoneidenTesti() {
        for (int x = 0; x < tyrma.getHuoneet().length; x++) {
            for (int y = 0; y < tyrma.getHuoneet()[x].length; y++) {
                assertEquals(null, tyrma.getHuoneet()[x][y].getKuvaus());
            }
        }
    }

    @Test
    public void hahmonLuonti() {
        assertTrue(tyrma.getSankari() instanceof Henkilo);
        assertEquals("Sakari", tyrma.getSankari().getNimi());
    }

    @Test
    public void huoneideinLuonti() {
        tyrma.huoneidenLuonti();
        assertEquals("Olet Tuhkimon omassa tunkkaisessa komerossa. "
                + "Huoneessa on kulunut sänky länsiseinustalla, "
                + "pienehkö ikkuna eteläpuolella ja matala ovi pohjoisseinällä.", tyrma.getHuoneet()[0][0].getKuvaus());
    }

    @Test
    public void voititPelinPalauttaaFalsenEsineenPerusteella() {
        assertTrue(!tyrma.voititPelin());
    }

    @Test
    public void voititPelinPalauttaaFalsenXKoordinaattienPerusteella() {
        tyrma.getSankari().saaOmistukseen("karkkilaatikko");
        tyrma.getSankari().setSijaintiX(1);
        assertTrue(!tyrma.voititPelin());
    }

    @Test
    public void voititPelinPalauttaaFalsenYKoordinaattienPerusteella() {
        tyrma.getSankari().saaOmistukseen("karkkilaatikko");
        tyrma.getSankari().setSijaintiY(1);
        assertTrue(!tyrma.voititPelin());
    }

    @Test
    public void voititPelinPalauttaaTruen() {
        tyrma.getSankari().saaOmistukseen("karkkilaatikko");
        assertTrue(tyrma.voititPelin());
    }
}
