# Arkkitehtuurikuvaus

## Rakenne

Ohjelma on rakennettu kolmetasoiseksi pakkauksien avulla. Paukkauksessa _fi.xtoxtoxt.tekstiroolipeli.logiikka_ on koko käyttöliittymä ja sen lisäksi peli toiminnallisuuden suorittava TyrmäTehdas -luokka. Pakkauksessa _fi.xtoxtoxt.tekstiroolpeli_ on oliohin liittyvät luokat. Pakkauksessa _fi.xtoxtoxt.tekstiroolipeli.dao_ on kaikki tietokantoihin liittyvät toiminnallisuudet.

Luokka/pakkauskaavio

<img src="https://github.com/Karvamahuli/otm-harjoitustyo/blob/master/dokumentaatio/TekstiRoolipeliLuokkakaavio.jpg" width="350">

<img src="https://github.com/Karvamahuli/otm-harjoitustyo/blob/master/dokumentaatio/Nappia%20painettu%20peliss%C3%A4.png" width="800">
 
 ja vaadittu koodi
 title Nappia painettu pelissä

Käyttäjä->TekstiRoolipeli: painaa nappia/Enteriä pelissä \nja tekstikentässä "p"
TekstiRoolipeli->TekstiRoolipeli: nappiaPainettu()
TekstiRoolipeli->TyrmaTehdas: seuraavaAskel("p")
TyrmaTehdas->TyrmaTehdas: this.liikuPohjoiseen()
TyrmaTehdas->Henkilo: Jos pohjoiseen voi liikkua\n niin this.sankari.setSijaintiY(...)
Henkilo->TyrmaTehdas: Sankari on liikkunut
TyrmaTehdas->Tuloste: Tulosta.huoneenKuvaus(...)
Tuloste->TekstiRoolipeli: TekstiRoolipeli.lisaaTeksti(...)
TekstiRoolipeli-->Tuloste: 
Tuloste-->TyrmaTehdas:
TyrmaTehdas-->TekstiRoolipeli:
TekstiRoolipeli-->Käyttäjä: 
