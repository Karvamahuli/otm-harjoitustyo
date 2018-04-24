package fi.xtoxtoxt.tekstiroolipeli.logiikka;

import fi.xtoxtoxt.tekstiroolipeli.Henkilo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TyrmaTehdasTest {

    TyrmaTehdas tyrma;

    public TyrmaTehdasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tyrma = new TyrmaTehdas();
        tyrma.hahmonLuonti("Sakari");
    }

    @After
    public void tearDown() {
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

//    @Test
//    public void seuraavaAskelPohjoiseen() {
//        tyrma.huoneidenLuonti();
//        tyrma.seuraavaAskel("p");
//        assertEquals(0, tyrma.getSankari().getSijaintiX());
//        assertEquals(1, tyrma.getSankari().getSijaintiY());
//    }
}
