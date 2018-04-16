# Tuhkimon *Tuoreet* Turinat
Vanha kunnon tekstipohjainen roolipeli, jossa kuljet lapsi Tuhkimon jalanjälkiä ja kohtaat vaarallisia tilanteita ja palkitsevia hetkiä. 

### Dokumentaatio

[Määrittelydokumentti.md](https://github.com/Karvamahuli/otm-harjoitustyo/blob/master/laskarit/viikko1/alustava%20m%C3%A4%C3%A4rittelydokumentti.md)

[Arkkitehtuuri.md](https://github.com/Karvamahuli/otm-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Työaikakirjanpito](https://github.com/Karvamahuli/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

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

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/Karvamahuli/otm-harjoitustyo/blob/master/TekstiRoolipeli/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
