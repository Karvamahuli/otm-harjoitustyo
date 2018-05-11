# Testausdokumentti

Ohjelman testaus on suoritettu automatisoiduin JUnit -testein sekä suurin osa tehty manuaalisen testauksen kautta.

### Sovelluslogiikka

Automatisoituja testejä suorittaa aina jokaista paukkasta vastaava Test -pakkaus. Esimerkiksi pakkauksen 
_fi.xtoxtoxt.tekstiroolipeli.logiikka_ luokan TyrmaTehdas testit suorittaa testi pakkauksen luokka TyrmaTehdasTest.

### Testauskattavuus

Automatisoitujen testien kattavuus, käyttöliittymä -luokkia lukuunottamatta, on rivikkattavuuden suhteen 36% ja 
haarautumakattavuuden suhteen 15%. Testaamatta jäivät tilanteet, joille oli hankaluuksia kirjoittaa testejä. 

### Asennus ja konfigurointi

Ohjelma on ladattu ja suoritettu käyttöohjeen ohjeiden mukaisesti Linux:lle ja se on toiminut moitteitta. Ohjelma on testattu 
_tietokanta.db_:n ollessa olemassa projektikansiossa sekä sillä tavalla että sitä ei ole ollut olemassa, jolloin ohjelma on 
luonut tyhjän _tietokanta.db_:n.

### Toiminnallisuudet

Ohjelman eri toiminnallisuuksia on testattu manuaalisesti syöttämällä tekstikenttiin sekä ohjelman tunnistamia arvoja että ohjelmalle
tuntemattomia arvoja. Ohjelma on toiminut tällöin halutulla tavalla. 

Ohjelma ei kuitenkaan suostu käynnistymään omilla yliopiston tunnuksilla _TMC_:n kautta, mutta terminaalin/_jar_:in kautta ohjelma 
käynnistyy moitteettomasti. 
