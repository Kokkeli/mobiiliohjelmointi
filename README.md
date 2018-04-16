# Harjoitustyö ja oppimispäiväkirja mobiiliohjelmoinnin kurssille. PLA-32820 2018
Harjoitustyö tulee löytymään tämän repositoryn master haarasta. Kurssin varrella tehtävät pienemmän harjoitustehtävät löytyvät niille erikseen tehdyistä haaroista/tageista. Oppimispäiväkirjaa päivitän tähän readme-tiedoston jatkoksi.
# Oppimispäiväkirja
___
### Harjoitus 1
Palautus erikseen PDF:nä
___
### Harjoitus 2
Github tunnukset minulla oli jo valmiiksi. Repositoryn luominen onnistui myös rutiininomaisesti.
___
### Harjoitus 3
Andoird työkalujen asentaminen OSX:lle onnistui vaivatta. https://developer.android.com/studio/index.html Sivustolta ladattu Android Studio latautui ja asentui ongelmitta seuraamalla asennus prosessin ohjeita.

Hello world projektin aloittaminen oli Android studiolla helppoa. Helposti ymmärrettävistä valikoista kliksuteltiin halutut alkuasetukset ja annettiin projektille nimi. Tämän jälkeen Android studio loi tarvittavat tiedostot ohjelman rungolle. Ohjelma ei kuitenkaan suoraan kääntynyt, vaan vielä piti hieman hämärästä virhe ilmoituksesta tulkita, että build toolsit ovat asentamatta. Asennus onnistui kuitenkin vaivatta klikkaamalla virheilmoituksen linkkiä. Tämän jälkeen Hello world sovelluksen rakentaminen ja asentaminen omalle Andoird laitteelleni (USB kaapelin avulla) onnistui ongelmitta. Sain siis kohtuullisen vaivatta omalle laitteelleni sovelluksen, jossa pohjana toimii alapalkin navigaatiopalkki, yläpalkissa komeilee sovelluksen nimi ja keskisisältönä vaihtelee hello world tarkoituksena eri tekstejä riippuen alapalkin valinnasta.

Projektin lisääminen gittiin onnistui vaivatta. Lisäsin repositoryyn tagin, josta näkee projektin tässä vaiheessa: https://github.com/Kokkeli/mobiiliohjelmointi/tree/harjoitus3

Kaiken kaikkiaan onnistuin suuremmitta vaivoitta pystyttämään ympäristön ja asentamaan Hello world sovelluksen puhelimelle asti.
___
### Harjoitus 4
Valmis harjoitus löytyy haarasta harkka4 https://github.com/Kokkeli/mobiiliohjelmointi/tree/harkka4
Tämä harjoitus tuotti jo hieman ongelmia ja opittua tuli roimasti. Suurimmaksi ongelmaksi tuli androidin layouttien luonti. Toisin sanoen UI:n rakentaminen osoittautui odotettua haastavammaksi. Tuntien hajoilun jälkeen kuitenkin aloin saamaan kiinni constraint layoutin luonnista ja rakentamisesta. Lopputulos on rakennettu constraint layoutin sisälle. UI:n luonnin jälkeen seuraava ongelma oli UI elementtien bindaaminen Javan puolelle. Tähän kuitenkin löytyi ratkaisut kohtalaisen helposti googlaamalla. Javaa en tosiaan ole ennen ohjelmoinut, joten myös joitakin pikkuasioita piti erikseen googlailla esim. syntaksiin liittyen. Itse bisneslogiikan kirjoittaminen ei kuitenkaan ollut iso työ vaan onnistui kohtuullisen helposti.

Opittua tuli ainakin constraint layoutin kanssa pelaaminen, UI elementtien bindaaminen ja käyttäminen javan puolella ja uuden android intentin luominen ja sille datan passaaminen. Nyt onnistuu jo siis tällaisen pienen sovelluksen luominen oikein mukavasti.
___
### Harjoitus 5
Valmis harjoitus löytyy haarasta harkka5.
https://github.com/Kokkeli/mobiiliohjelmointi/tree/harkka5
SQlite tietokannan yksinkertainen käyttö oli varsin helppoa. Apua ja esimerkkiä kannan käyttöön löysin seuraavasta esimerkkiprojektista: https://github.com/obaro/android-sqlite-sample
En tiedä miksi, mutta päätin tämän harjoituksen yhteydessä opiskella myös fragmenttien käyttöä. Tämä osoittautui paljon suuremmaksi työksi kuin SQLiten käyttö. Sovelluksessa on erillisellä fragmentilla tietokannan sisällön näyttö ja sisällön lisäys. Kumpikin fragmentti käyttää interfacea, jonka MainActivity täyttää. MainActivityn kontolle jää databasen kanssa keskustelu.

SQLiten näin yksinkertainen käyttö tuli opittua varsin helposti. Fragmenttien käytön opiskeluun meni reippaasti enemmän aikaa mutta nyt miellä osaavani fragment <--> activity käytön ja niiden välisen keskustelun toteutuksen.
___
### Harjoitus 6
Valmis harjoitus löytyy haarasta harkka5.
https://github.com/Kokkeli/mobiiliohjelmointi/tree/harkka6
Tämä harjoitus sujui helposti heti viidennen harjoituksen jälkeen. Poistamis ja järjestämis -ominausiiksien lisääminen oli helppoa, kun oikeat dokumentaatiot ja esimerkit olivat jo valmiiksi välilehdissä avonaisina.

Harjoitus syvensi hieman osaamistani sqlite+android ympäristössä. Yksi kokonaan uusi query tulikäyttöön (delete) ja kaikkien kirjojen haku queryyn tuli lisättyä järjestyksessä haku.

___
### Harjoitus 7 ja 8
Harjoitukset 7 ja 8 tein samaan aikaan samaan haaraan:
https://github.com/Kokkeli/mobiiliohjelmointi/tree/harkka7

Autentikoinnin ja peruskäytön toteutus firebaseen "samanaikaisesti" tuntui luontevalta, joten sekä harjoitus 7 että harjoitus 8 tulivat valmiiksi käsikädessä. Autentikoinnin luonnissa ei ollut suuria ongelmia. Firebase tarjosi suoraan toimivat esimerkit, joilla sai email+password autentikaation toimimaan. Itse sovellukseen piti vain lisätä login activity, josta onnistuvat login ja signup toiminnot. Firebasen säännöt on konfiguroitu niin, että tietokantaan pääsee kirjoittamaan ja lukemaan vain autentikoidut käyttäjät.

Peruskäytön toteutus firebasella oli pienen opiskelun jälkeen varsin helppoa. Firebasen omasta wikistä löytyi hyvät ohjeet tietojen lisäämiseen, hakemiseen ja poistamiseen. Suurimmaksi ongelmaksi osoittautui android puolella ilmennyt virhe, joka aiheutti ohjelman kaatumisen. Virhe ilmeni, kun yritin piirtää databaselta saatuja kirjoja ennen kuin edellisen haun kirjat olivat piirretty. Toisin sanoen kun käyttäjä painoi Books välilehteä nopeasti putkeen. Syy ongelmaan oli null kontekstin käyttö. Ongelmasta pääsin eroon varmistamalla kontekstin saatavuus ennen kirjojen piirtämistä. Suurin ongelma siis liittyi android navigaation rakennusvaiheiden järjestykseen. Ongelmista selviydyttyäni ymmärrykseni androidin rakennuspalikoihin syveni jälleen hieman.

___
### Harjoitus 9 ja 10

Harjoitukset 9 ja 10 löytyvät samasta haarasta: https://github.com/Kokkeli/mobiiliohjelmointi/tree/harkka9 Tajusin vasta jälkikäteen, että harjoitukseen 9 toteuttamaani tekstimuodossa sijainnin näyttöä ei enää ole nähtävissä suoraan haarasta harkka9 koska menin pushaamaan päälle harkka10:n kartta toteutuksen. Harkka9 toteutus on kuitenkin nähtävissä täältä: https://github.com/Kokkeli/mobiiliohjelmointi/tree/85435d37ca6f569ccbdcc2f7b842b4179b8ed5a2

Tehtävänannossa annetuista linkeistä löytyi varsin hyvät esimerkit kummankin harjoituksen toteuttamiseen. Harkka9: https://github.com/miksa007/AndroidGPS2018 Harkka10:
https://developers.google.com/maps/documentation/android-api/start

Harjoitus 9 tekemisen aloitin hyvin pitkälle annetun esimerkin mukaan. Lopulta päädyin kuitenkin muokkaamaan ratkaisusta hieman erilaisen. Nyt lokaatio dataa aletaan keräämään ja päivittämään heti permissionin saatua. Erillistä nappia lokaation päivitykseen ei ole vaan se tapahtuu automaattisesti. Tämä harjoitus oli ensikosketukseni permissionien käyttöön ja lokaatiodatan kyselyyn. Esimerkin avulla kummastakin on nyt pieni kuva, josta on hyvä lähteä rakentamaan laajaa harjoitustyötä.

Harjoitus 10 tekemiseen ei tarvinnut hirveästi muuta tehdä kuin seurata googlen ohjeita maps apin käytön aloittamiseen. Lokaatiodata joka piirretään kartalle oli jo valmiina harjoitus 9:stä. Ei siis tarvinnut muuta kuin antaa tämä lokaatio maps apille. Harjoitus 10 sujui ilman ongelmia.
