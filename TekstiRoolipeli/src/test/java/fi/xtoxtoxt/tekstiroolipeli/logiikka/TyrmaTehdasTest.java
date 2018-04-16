package fi.xtoxtoxt.tekstiroolipeli.logiikka;

import fi.xtoxtoxt.tekstiroolipeli.Huone;
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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tyrmanKonstruktorinHuoneidenTesti() {
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                assertEquals(null, tyrma.getHuoneet()[x][y].getKuvaus());
            }
        }
    }

//    @Test
//    public void huoneidenLuonminen() {
//        tyrma.kaynnistaPeli();
//        assertEquals("Olet Tuhkimon omassa tunkkaisessa komerossa. "
//                + "Huoneessa on kulunut sänky länsiseinustalla, "
//                + "pienehkö ikkuna eteläpuolella ja matala ovi pohjoisseinällä.",
//                tyrma.getHuoneet()[0][0].getKuvaus());
//    }
}
