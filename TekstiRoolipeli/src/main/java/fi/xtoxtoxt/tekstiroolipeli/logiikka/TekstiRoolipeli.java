package fi.xtoxtoxt.tekstiroolipeli.logiikka;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class TekstiRoolipeli extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {

        BorderPane asettelu = new BorderPane();

        HBox lisaysKentta = new HBox();

        TextField tekstikentta = new TextField();
        Button nappi = new Button("Lähetä");

        lisaysKentta.getChildren().addAll(tekstikentta, nappi);

        asettelu.setBottom(lisaysKentta);

        TextFlow lipuvaTekstikentta = new TextFlow();
        lipuvaTekstikentta.setPrefSize(400, 400);

        Text teksti1 = new Text("Tässä on kasa kirjaimia/merkkejä");

        lipuvaTekstikentta.getChildren().add(teksti1);

        asettelu.setCenter(lipuvaTekstikentta);

        nappi.setOnAction(aktivointi -> {
            String syote = tekstikentta.getText();
            tekstikentta.clear();
            Text lisattava = new Text("\n" + syote);
            System.out.println(lisattava.getFont());
            lisattava.setStyle("-fx-font-weight: bold");
            lipuvaTekstikentta.getChildren().add(lisattava);
        });

        Scene nakyma = new Scene(asettelu);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void aloitaPeli() {
        TyrmaTehdas kentta = new TyrmaTehdas();
        Tuloste.alkuteksti();
        kentta.hahmonLuonti();
        kentta.kaynnistaPeli();
    }

    public static void main(String[] args) {

        launch(args);
        TekstiRoolipeli.aloitaPeli();

    }

}
