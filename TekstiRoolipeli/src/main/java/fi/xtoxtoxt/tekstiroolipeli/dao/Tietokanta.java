package fi.xtoxtoxt.tekstiroolipeli.dao;

import java.sql.*;

public class Tietokanta {

    private String tietokannanPolku;

    public Tietokanta(String tietokannanPolku) throws ClassNotFoundException {
        this.tietokannanPolku = tietokannanPolku;
    }

    public Connection getYhteys() throws SQLException {
        return DriverManager.getConnection(tietokannanPolku);
    }
}
