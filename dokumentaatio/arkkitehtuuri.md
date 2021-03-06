# Arkkitehtuurikuvaus

## Rakenne

Ohjelma on rakennettu kolmetasoiseksi pakkauksien avulla. Paukkauksessa _fi.xtoxtoxt.tekstiroolipeli.logiikka_ on koko käyttöliittymä ja sen lisäksi peli toiminnallisuuden suorittava TyrmaTehdas -luokka. Pakkauksessa _fi.xtoxtoxt.tekstiroolipeli_ on oliohin liittyvät luokat. Pakkauksessa _fi.xtoxtoxt.tekstiroolipeli.dao_ on kaikki tietokantoihin liittyvät toiminnallisuudet. Kuvassa vihreä väri edustaa logiikka -pakkausta, oranssi väri dao -pakkausta ja valkoinen tekstiroolipeli -pakkausta.

Luokka/pakkauskaavio

<img src="https://github.com/Karvamahuli/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/TekstiRoolipeliKaavio.jpg" width="450">

## Käyttöliittymä

Käyttöliittymä rakentuu neljästä Scenestä:
- Aloitusnäkymästä
- Hall of Fame -luettelosta
- Hahmonluontivalikosta
- Peliruudusta

Scenet on sijoitettu ikkunaan/Stageen ja ne vaihtelevat kun käyttäjä painaa nappia. Aloitusnäkymästä pääsee Hall of Fame -luetteloon ja hahmonluontivalikkoon. Hall of Famesta pääsee vain takaisin aloitus näkymään. Hahmonluontivalikosta pääsee peliruutuun ja peliruudusta ei pääse pois läpäisemättä peliä.

Peliruudussa on kirjoitettava tekstikenttä ja pohja tekstille. Käyttäjän syöte ja syötteestä johtuva pelin edistyminen tulevat esille pohjalle, josta ne ovat tarkasteltavissa koko pelin ajan. 

## Sovelluslogiikka

Sovelluksen toiminnallisen kokonaisuuden muodostaa lähinnä TyrmaTehdas -luokka, jonka toimintaa aktivoi käyttäjän antamat syötteet ja niiden lähetys TyrmaTehdas -luokalle. TyrmaTehdas käsittelee käyttäjän lähettämän syötteen ja kutsuu toista luokan sisäistä metodia sen mukaan mitä käyttäjän syöte oli. Sen jälkeen luokka tekee mahdollisia muutoksia pelin Henkilo -oliolle. TyrmaTehdas -luokka lähettää Tuloste -luokalle kutsuja tulostaa tekstipohjaan uutta tekstiä riippuen siitä miten peli reagoi. 

## Tietojen pysyväistallennus

Kaikki pelin tiedot talletetaan tietokantaan. Tällä hetkellä tämä sisältää vain Hall of Fame -luettelon tiedot pelin läpäisseistä pelaajista. Tiedot tallettaa DAO -suunnitelumallia noudattava TaulukkoDao -luokka, joka tallentaa tiedot projektikansiossa olevaan tietokanta.db tietokantaan. 

Tietokanta tietokanta.db tallettaa sankareista pelkästään nimen seuraavassa muodossa:

<pre>
Taulukko (
nimi varchar(50)
);
</pre>

Lopputulos näyttää tulostettuna seuraavalta:

<pre>
Tuhkimo
Harald Hirmuinen
Samvais Gamgi
</pre>

## Päätoiminnallisuudet

Seuraavaksi muutamia sovelluksen toiminnallisuuksia sekvenssikaaviona.

### Käyttäjä syöttää peliruudussa tekstin "p"

Peliruudussa käyttäjä kirjoittaa tekstikenttään "p" ja painaa "Lähetä" -nappia tai painaa Enter -painiketta.

<img src="https://github.com/Karvamahuli/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/Nappia%20painettu%20peliss%C3%A4.png" width="800">
 
Samalla periaatteella toimivat myös suurin osa muistakin käyttäjän antamista syötteistä, kuten esimerkiksi "e", "l", "i" ja 
"nosta karkkilaatikko".

### Käyttäjä luo uuden hahmon nimellä "Tuhkimo"

Hahmonluontivalikossa käyttäjä kirjoittaa tekstikenttään "Tuhkimo" ja painaa "Aloita" -nappia tai Enter -painiketta. 

<img src="https://github.com/Karvamahuli/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/Hahmon%20luonti.png" width="800">

### Käyttäjä läpäisee pelin

Käyttäjä päätyy pelin alkuhuoneeseen kantaen karkkilaatikkoa. Peli tallentaa käyttäjän mahtavan sankarin nimen Hall of Fame -luetteloon jonka jälkeen se sulkee pelin.

<img src="https://github.com/Karvamahuli/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/Pelin%20l%C3%A4p%C3%A4isy.png">
