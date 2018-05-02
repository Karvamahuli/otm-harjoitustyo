package fi.xtoxtoxt.tekstiroolipeli.dao;

import fi.xtoxtoxt.tekstiroolipeli.Henkilo;
import fi.xtoxtoxt.tekstiroolipeli.Taulukko;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaulukkoDao implements Dao {

    private Tietokanta tietokanta;

    public TaulukkoDao(Tietokanta tietokanta) {
        this.tietokanta = tietokanta;
    }

    @Override
    public List<String> getTaulukko() throws SQLException {
        List<String> taulukko = new ArrayList<>();

        try (Connection yhteys = tietokanta.getYhteys();
                ResultSet tulos = yhteys.prepareStatement("SELECT * FROM Taulukko").executeQuery()) {

            while (tulos.next()) {
                taulukko.add(tulos.getString("nimi"));
            }

            tulos.close();
            yhteys.close();
        }

        return taulukko;
    }

    @Override
    public void lisaaSankari(Henkilo sankari) throws Exception {

        try (Connection yhteys = tietokanta.getYhteys()) {

            PreparedStatement lauseke = yhteys.prepareStatement("INSERT INTO Taulukko (nimi) VALUES (?)");
            lauseke.setString(1, sankari.getNimi());
            lauseke.executeUpdate();

            lauseke.close();
            yhteys.close();
        }
    }

}
