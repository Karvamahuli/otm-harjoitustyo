package fi.xtoxtoxt.tekstiroolipeli.logiikka;

import fi.xtoxtoxt.tekstiroolipeli.dao.TaulukkoDao;
import fi.xtoxtoxt.tekstiroolipeli.dao.Tietokanta;
import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class TekstiRoolipeli extends Application {

    static TextFlow lipuvaTekstikentta;
    private TextField tekstikentta;
    private TyrmaTehdas tyrma;

    private Scene aloitusNakyma;
    private Scene taulukkoNakyma;
    private Scene hahmonLuontiNakyma;
    private Scene peliNakyma;

    private TaulukkoDao taulukkoDao;

    @Override
    public void init() throws Exception {
        lipuvaTekstikentta = new TextFlow();
        tekstikentta = new TextField();

        tyrma = new TyrmaTehdas();

        Tietokanta tietokanta = new Tietokanta("jdbc:sqlite:taulukko.db");
        taulukkoDao = new TaulukkoDao(tietokanta);
    }

    @Override
    public void start(Stage ikkuna) throws Exception {
//        Aloitus nakyman rakennus

        BorderPane aloitusAsettelu = new BorderPane();
        aloitusAsettelu.setPrefSize(400, 400);

        Button aloitusNappi = new Button("Aloita peli");
        Button aloitusNappiTaulukkoon = new Button("Hall of Fame");
        Text aloitusTeksti = new Text(Tuloste.alkuteksti());

        aloitusNappi.setOnAction(aktivointi -> {

            ikkuna.setScene(hahmonLuontiNakyma);
        });
        
        aloitusNappiTaulukkoon.setOnAction(aktivointi -> {

            ikkuna.setScene(taulukkoNakyma);
        });

        aloitusAsettelu.setCenter(aloitusTeksti);
        aloitusAsettelu.setBottom(aloitusNappi);

//        Hall of Fame nakyman rakennus
        BorderPane taulukkoAsettelu = new BorderPane();
        taulukkoAsettelu.setPrefSize(400, 400);

        Text taulukkoEsittelyTeksti = new Text("Pelin läpäisseiden sankarien nimet: ");
        VBox taulukkoLista = new VBox();
        Button taulukonTakaisinNappi = new Button("Takaisin aloitus sivulle");

        List<String> taulukko = taulukkoDao.getTaulukko();

        for (int i = 0; i < taulukko.size(); i++) {
            taulukkoLista.getChildren().add(new Text(taulukko.get(i)));
        }
        
        taulukonTakaisinNappi.setOnAction(aktivointi -> {
            
            ikkuna.setScene(aloitusNakyma);
        });
        
        taulukkoAsettelu.setTop(taulukkoEsittelyTeksti);
        taulukkoAsettelu.setCenter(taulukkoLista);

//        Hahmonluonti nakyman rakennus
        BorderPane hahmonLuontiAsettelu = new BorderPane();
        hahmonLuontiAsettelu.setPrefSize(400, 400);
        VBox hahmonLuontiValikko = new VBox();

        Text hahmonLuontiTeksti = new Text(Tuloste.nimenValintaOhje());
        TextField hahmonLuontiTekstikentta = new TextField();
        Button hahmonluontiNappi = new Button("Aloita");
        Text virheellinenNimiTeksti = new Text("Virheellinen nimi! Valitse epätyhjä nimi.");

        hahmonLuontiValikko.getChildren().addAll(hahmonLuontiTeksti, hahmonLuontiTekstikentta);
        hahmonLuontiAsettelu.setCenter(hahmonLuontiValikko);
        hahmonLuontiAsettelu.setBottom(hahmonluontiNappi);

        hahmonluontiNappi.setOnAction(aktivointi -> {

            if (!hahmonLuontiTekstikentta.getText().equals("")) {
                tyrma.hahmonLuonti(hahmonLuontiTekstikentta.getText().trim());
                hahmonLuontiTekstikentta.setText("");

                ikkuna.setScene(peliNakyma);
                tyrma.huoneidenLuonti();
                Tuloste.ohjeet();
                Tuloste.huoneenKuvaus(tyrma.getHuoneet()[tyrma.getSankari().getSijaintiX()][tyrma.getSankari().getSijaintiY()].getKuvaus());
            } else {
                virheellinenNimiTeksti.setFill(Color.RED);
                if (!hahmonLuontiValikko.getChildren().get(1).equals(virheellinenNimiTeksti)) {
                    hahmonLuontiValikko.getChildren().add(1, virheellinenNimiTeksti);
                }
            }
        });

//        Peli nakyman rakennus
        BorderPane peliAsettelu = new BorderPane();
        peliAsettelu.setPrefSize(400, 400);

        HBox lisaysKentta = new HBox();

        Button nappi = new Button("Lähetä");

        lisaysKentta.getChildren().addAll(tekstikentta, nappi);

        peliAsettelu.setBottom(lisaysKentta);
        peliAsettelu.setCenter(lipuvaTekstikentta);

        nappi.setOnAction(aktivointi -> {

            nappiaPainettu();

            if (tyrma.voititPelin()) {
//                Tulevaisuudessa tähän sankarin nimen lisääminen Hall of Fameen
                ikkuna.close();
            }
        });

        lisaysKentta.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                nappiaPainettu();

                if (tyrma.voititPelin()) {
//                Tulevaisuudessa tähän sankarin nimen lisääminen Hall of Fameen
                    ikkuna.close();
                }
            }
        });

//        Ikkunoiden rakennus
        aloitusNakyma = new Scene(aloitusAsettelu);
        hahmonLuontiNakyma = new Scene(hahmonLuontiAsettelu);
        peliNakyma = new Scene(peliAsettelu);

        ikkuna.setScene(aloitusNakyma);

        ikkuna.show();
    }

    public void nappiaPainettu() {
        String syote = tekstikentta.getText();
        tekstikentta.setText("");
        Text lisattava = new Text("\n\n" + syote);
        lisattava.setStyle("-fx-font-weight: bold");
        lipuvaTekstikentta.getChildren().add(lisattava);

        tyrma.seuraavaAskel(syote);
        tekstikentta.requestFocus();
    }

    public static void lisaaTeksti(String tuloste) {
        Text lisattava = new Text("\n" + tuloste);
        lipuvaTekstikentta.getChildren().add(lisattava);
    }

    public static void main(String[] args) {

        launch(args);
    }

}
