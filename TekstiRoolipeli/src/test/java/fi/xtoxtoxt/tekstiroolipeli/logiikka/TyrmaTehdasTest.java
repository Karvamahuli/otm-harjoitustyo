package fi.xtoxtoxt.tekstiroolipeli.logiikka;

import fi.xtoxtoxt.tekstiroolipeli.Henkilo;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
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
        for (int x = 0; x < tyrma.getHuoneet().length; x++) {
            for (int y = 0; y < tyrma.getHuoneet()[x].length; y++) {
                assertEquals(null, tyrma.getHuoneet()[x][y].getKuvaus());
            }
        }
    }
}
