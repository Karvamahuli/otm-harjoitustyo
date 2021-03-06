package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    @Test
    public void kortillaOikeaSaldo() {
        assertEquals("saldo: 10.0", kortti.toString());      
    }
    @Test
    public void kortillaOikeaSaldoMetodi() {
        assertEquals(1000, kortti.saldo());      
    }
    @Test
    public void rahanLataaminenKortilleKasvattaaSaldoaSummanVerran() {
        kortti.lataaRahaa(500);
        assertEquals("saldo: 15.0", kortti.toString());      
    }
    @Test
    public void rahanOttaminenKortiltaToimii() {
        kortti.otaRahaa(500);
        assertEquals("saldo: 5.0", kortti.toString());      
    }
    @Test
    public void rahanOttaminenKortiltaToimiiBoolean() {
        assertTrue(kortti.otaRahaa(500));      
    }
    @Test
    public void rahanOttaminenKortiltaEiToimiJosRahaaEiTarpeeksi() {
        kortti.otaRahaa(5000);
        assertEquals("saldo: 10.0", kortti.toString());      
    }
    @Test
    public void rahanOttaminenKortiltaEiToimiJosRahaaEiTarpeeksiBoolean() {
        assertTrue(!kortti.otaRahaa(5000));      
    }
}
