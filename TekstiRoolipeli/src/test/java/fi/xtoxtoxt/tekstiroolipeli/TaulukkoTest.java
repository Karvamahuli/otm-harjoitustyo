package fi.xtoxtoxt.tekstiroolipeli;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaulukkoTest {
    
    public TaulukkoTest() {
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
     public void taulukkoonLisays() {
         ArrayList<String> lista = new ArrayList<>();
         Taulukko taulukko = new Taulukko(lista);
         Henkilo sakari = new Henkilo("Sakari");
         taulukko.lisaaTaulukkoon(sakari);
         assertEquals("Sakari", taulukko.getTaulukko().get(0));
     }
}
