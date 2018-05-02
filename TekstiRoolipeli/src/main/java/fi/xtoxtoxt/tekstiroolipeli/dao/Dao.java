package fi.xtoxtoxt.tekstiroolipeli.dao;

import fi.xtoxtoxt.tekstiroolipeli.Henkilo;
import fi.xtoxtoxt.tekstiroolipeli.Taulukko;
import java.util.List;

public interface Dao {

    void lisaaSankari(Henkilo sankari) throws Exception;

    List<String> getTaulukko() throws Exception;
}
