# Käyttöohje

Lataa tiedosto [TekstiRoolipeli-1.0-SNAPSHOT.jar](https://github.com/Karvamahuli/otm-harjoitustyo/releases/tag/v1.0)

## Ohjelman käynnistäminen

Ohjelman saa käynnistettyä terminaalin komennolla

```
java -jar TekstiRoolipeli-1.0-SNAPSHOT.jar
```

Ohjelma ei kuitenkaan (ainakaan omilla yliopisto -tunnuksilla) suostu käynnistymään _TMC_:n kautta vain terminaalin/_jar_:in kautta.

## Aloitus näkymä

Ohjelma aukeaa aloitus näkymällä, jossa on kaksi nappia yksi vie Hall of Fame -luettelo näkymään 
ja toinen vie hahmonluonti valikkoon. 

## Hall of Fame -luettelo

Tässä valikossa näet kaikki mahtavat sankari, jotka ovat läpäisseet pelin. 
Näkymässä on myös nappi, jota painamalla pääse takaisin aloitus näkymään.

## Hahmonluonti valikko

Hahmonluonti valikossa on mahtavan sankarin nimelle tekstikenttä, joka yhdistetää kyseisen pelikerran ajan pelin sankarin nimeksi 
siihen syötetyn nimen. Valitse nimi tarkkaan, sillä jos läpäiset pelin niin se ikuistetaan Hall of Fame -luetteloon. Nimen 
valittua voi "Aloita" -nappia painamalla aloittaa pelin.

## Peliruutu

Peliruudussa on tekstipohja, johon tulee kaikki peliin liittyvät tekstit, ja "Lähetä" -napilla varustettu tekstikenttä, johon 
voi kirjoittaa haluamansa toiminnon johon peli vastaa joko myönteisesti taikka kielteisesti. Peli etenee jos sille antaa oikeita 
komentoja ja loppuu jos mahtava sankari pääsee karkkien kanssa takaisin omaan huoneeseensa. Jos pelin saa läpäistyä niin oman 
sankarin nimi ikuistetaan pelin Hall of Fame -luetteloon.
