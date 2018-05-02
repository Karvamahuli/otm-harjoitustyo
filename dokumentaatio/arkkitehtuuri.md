# Arkkitehtuurikuvaus

Luokka/pakkauskaavio

<img src="https://github.com/Karvamahuli/otm-harjoitustyo/blob/master/dokumentaatio/TekstiRoolipeliLuokkakaavio.jpg" width="350">


Ja vaadittu UML (mahdollista tulevaisuuden muutosta varten):

[TekstiRoolipeli], [Henkilo], [Huone], [TyrmaTehdas], [Tuloste], [Taulukko], [Dao], [TaulukkoDao], [Tietokanta], [TekstiRoolipeli]1-1[TyrmaTehdas], [TekstiRoolipeli]1-*[Tuloste], [TyrmaTehdas]1-*[Tuloste], [TyrmaTehdas]1-1[Henkilo], [TyrmaTehdas]1-*[Huone], [TaulukkoDao]1-1[TekstiRoolipeli], [Taulukko]-[TaulukkoDao], [TaulukkoDao]->[Dao], [Tietokanta]1-*[TaulukkoDao], [Tietokanta]1-1[TekstiRoolipeli]

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
