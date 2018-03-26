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
    Maksukortti kortti;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(10000);
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

    @Test
    public void kassaanTuleeEdullinenMyyntina() {
        kassa.syoEdullisesti(300);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void kassaanTuleeEdullinenSaldoon() {
        kassa.syoEdullisesti(300);
        assertEquals(100240, kassa.kassassaRahaa());
    }

    @Test
    public void kassaanTuleeEdullinenRahana() {
        assertEquals(60, kassa.syoEdullisesti(300));
    }

    @Test
    public void kassaPalauttaaOikeanKateismaaranJosEiRiittavastiRahaaEdullinen() {
        assertEquals(200, kassa.syoEdullisesti(200));
    }

    @Test
    public void kassaanEiTuleMuutoksiaJosEiRiittavastiRahaaEdullinen() {
        kassa.syoEdullisesti(200);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void kassanMyytyihinEiTuleMuutoksiaJosEiRiittavastiRahaaEdullinen() {
        kassa.syoEdullisesti(200);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void kassaanTuleemaukasMyyntina() {
        kassa.syoMaukkaasti(500);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kassaanTuleeMaukasSaldoon() {
        kassa.syoMaukkaasti(500);
        assertEquals(100400, kassa.kassassaRahaa());
    }

    @Test
    public void kassaanTuleeMaukasRahana() {
        assertEquals(100, kassa.syoMaukkaasti(500));
    }

    @Test
    public void kassaPalauttaaOikeanKateismaaranJosEiRiittavastiRahaaMaukas() {
        assertEquals(300, kassa.syoMaukkaasti(300));
    }

    @Test
    public void kassaanEiTuleMuutoksiaJosEiRiittavastiRahaaMaukas() {
        kassa.syoMaukkaasti(300);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void kassanMyytyihinEiTuleMuutoksiaJosEiRiittavastiRahaaMaukas() {
        kassa.syoMaukkaasti(300);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kortillaMaksaminenBooleanOikein() {
        assertTrue(kassa.syoEdullisesti(kortti));
    }
    @Test
    public void kortillaMaksaminenKortinSaldoOikein() {
        kassa.syoEdullisesti(kortti);
        assertEquals(9760, kortti.saldo());
    }
    @Test
    public void kortillaMaksaminenMyydytEdullisetOikein() {
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void kortillaMaksaminenBooleanOikeinMaukas() {
        assertTrue(kassa.syoMaukkaasti(kortti));
    }
    @Test
    public void kortillaMaksaminenKortinSaldoOikeinMaukas() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(9600, kortti.saldo());
    }
    @Test
    public void kortillaMaksaminenMyydytMaukkaatOikein() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void kortillaMaksaminenKunEiRiittävästiRahaaBooleanEdullinen() {
        Maksukortti pieniKortti = new Maksukortti(200);
        assertTrue(!kassa.syoEdullisesti(pieniKortti));
    }
    @Test
    public void kortillaMaksaminenKunEiRiittävästiRahaaMyytyjaLounaitaEdullinen() {
        Maksukortti pieniKortti = new Maksukortti(200);
        kassa.syoEdullisesti(pieniKortti);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void kortillaMaksaminenKunEiRiittävästiRahaaSaldonMuutosOikeinEdullinen() {
        Maksukortti pieniKortti = new Maksukortti(200);
        kassa.syoEdullisesti(pieniKortti);
        assertEquals(200, pieniKortti.saldo());
    }
    @Test
    public void kortillaMaksaminenKunEiRiittävästiRahaaBooleanMaukas() {
        Maksukortti pieniKortti = new Maksukortti(200);
        assertTrue(!kassa.syoMaukkaasti(pieniKortti));
    }
    @Test
    public void kortillaMaksaminenKunEiRiittävästiRahaaMyytyjaLounaitaMaukas() {
        Maksukortti pieniKortti = new Maksukortti(200);
        kassa.syoMaukkaasti(pieniKortti);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void kortillaMaksaminenKunEiRiittävästiRahaaSaldonMuutosOikeinMaukas() {
        Maksukortti pieniKortti = new Maksukortti(200);
        kassa.syoMaukkaasti(pieniKortti);
        assertEquals(200, pieniKortti.saldo());
    }
    @Test
    public void kortillaMaksaminenKunEiRiittävästiRahaaEiMuutaKassaaEdullinen() {
        Maksukortti pieniKortti = new Maksukortti(200);
        kassa.syoEdullisesti(pieniKortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    @Test
    public void kortillaMaksaminenKunEiRiittävästiRahaaEiMuutaKassaaMaukas() {
        Maksukortti pieniKortti = new Maksukortti(200);
        kassa.syoMaukkaasti(pieniKortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    @Test
    public void kortinLataaminenOnnistuu() {
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals(10100, kortti.saldo());
    }
    @Test
    public void kortinLataaminenEiOnnistuuNegatiivisella() {
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(10000, kortti.saldo());
    }
    @Test
    public void kortinLataaminenOnnistuuKassapaatteessa() {
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals(100100, kassa.kassassaRahaa());
    }
    @Test
    public void kortinLataaminenEiOnnistuuNegatiivisellaRahallaKassapaatteessa() {
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    

}
