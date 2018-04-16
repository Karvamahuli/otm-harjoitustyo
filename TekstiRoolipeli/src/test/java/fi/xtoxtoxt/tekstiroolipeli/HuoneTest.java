package fi.xtoxtoxt.tekstiroolipeli;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HuoneTest {

    public HuoneTest() {
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
    public void huoneenLuontiTyhjallaKonstruktorilla() {
        Huone huone = new Huone();
        assertEquals(null, huone.getKuvaus());
    }

    @Test
    public void huoneenLuontiKonstruktorilla() {
        Huone huone = new Huone("kuvaus");
        assertEquals("kuvaus", huone.getKuvaus());
    }

    @Test
    public void huoneenToString() {
        Huone huone = new Huone("kuvaus");
        assertEquals("kuvaus", huone.toString());
    }
}
