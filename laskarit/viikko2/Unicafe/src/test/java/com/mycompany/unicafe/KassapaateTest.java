package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    public KassapaateTest() {
    }
    
    Kassapaate kassa;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void tyhjassaKassassaOikeaSaldo() {
         assertEquals(100000, kassa.kassassaRahaa());
     }
     @Test
     public void tyhjassaKassassaOikeaMyytyjaEdulliset() {
         assertEquals(0, kassa.edullisiaLounaitaMyyty());
     }
     @Test
     public void tyhjassaKassassaOikeaMyytyjaMaukkauita() {
         assertEquals(0, kassa.maukkaitaLounaitaMyyty());
     }
     
}
