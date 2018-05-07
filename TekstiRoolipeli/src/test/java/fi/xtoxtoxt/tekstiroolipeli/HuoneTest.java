package fi.xtoxtoxt.tekstiroolipeli;

import org.junit.Test;
import static org.junit.Assert.*;

public class HuoneTest {

    @Test
    public void huoneenLuontiTyhjallaKonstruktorilla() {
        Huone huone = new Huone();
        assertEquals(null, huone.toString());
    }

    @Test
    public void huoneenLuontiKonstruktorilla() {
        Huone huone = new Huone("kuvaus");
        assertEquals("kuvaus", huone.toString());
    }
}
