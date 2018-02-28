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
