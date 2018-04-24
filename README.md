## Tuhkimon *Tuoreet* Turinat
Tässä Gitissä on javalla kirjoitettu tekstiroolipeli. Ensin valitaan seikkailevalle sankarille nimi, minkä jälkeen päästään itse peliin kirjoittamaan komentoja sankarille, joka joko tottelee niitä tai epäonnistuu. Pelissä on tarkoitus päästä äidin karkkilaatikolle ja ottaa se parempaan talteen.

### Dokumentaatio

[Määrittelydokumentti.md](https://github.com/Karvamahuli/otm-harjoitustyo/blob/master/laskarit/viikko1/alustava%20m%C3%A4%C3%A4rittelydokumentti.md)

[Arkkitehtuuri.md](https://github.com/Karvamahuli/otm-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Työaikakirjanpito](https://github.com/Karvamahuli/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

## Releaset

[Viikko 5](https://github.com/Karvamahuli/otm-harjoitustyo/releases/tag/viikko5)

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _TekstiRoolipeli-1.0-SNAPSHOT.jar_

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/Karvamahuli/otm-harjoitustyo/blob/master/TekstiRoolipeli/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
