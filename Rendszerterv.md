## A rendszer célja
Megrendelőnk eddig konzolos terminál segítségével vezette péksége leltárát. Ez manapság már korszerűtlen megoldásnak számít, nem csak a terminál kinézete miatt, hanem felhasználóbarátsága miatt is. Az adatok könnyen elírhatók és bonyodalmas a menüpontok közötti ugrálás.
Egy olyan rendszert készítünk, melyben szimulálható a kenyerek sütése, ezáltal bemutatható az automatikus leltározó.

---
## Projektterv
A projektet páros programozás segítségével fogjuk implementálni, így az alábbi pontokat Pápai Kristóf és Sárosi Gábor közösen készítik:
-	adatbázis tervezése és létrehozása
-	alkalmazáslogika implementációja
-	grafikus felület elkészítése
-	tesztelés

---

## Üzleti folyamatok modellje:
[![Üzleti folyamatok modellje](https://i.imgur.com/RoB6EdP.jpg)](https://i.imgur.com/RoB6EdP.jpg)

Követelmények:
Funkcionális követelmények:
-	a termékek leltára
-	a programot csak az arra jogosultak tudják használni: rendelkezzen autentikációval

Nem funkcionális követelmények:
-	A felhasználói felület legyen letisztult
-	A menüpontok között gyors legyen a navigáció

---
## Funkcionális terv
A program indulásakor egy bejelentkező felület fog megjelenni. Az adatok megadásával elérhetővé válik a menüablak. Innen lehet eljutni a pékség raktáráig. A leltárhoz a CRUD műveletekkel tudunk hozzáférni. A termékek és a bolt eszközei is így tarthatók nyilván. A program bezárásával a felhasználó kijelentkezik automatikusan.

---
## Fizikai környezet
Az alkalmazás Java programozási nyelven készül. A grafikus interfészt Swing segítéségével készítjük el. Az adatbázis MySQL szervert fog használni. Java-ból az adatbázishoz való hozzáférést a JDBC segítségével oldjuk meg.

---
## Fejlesztői eszközök:
-	IntelliJ Idea
-	Apache NetBeans IDE 13
-	XAMPP
-	Visual Studio Code

---
## Adatbázisterv:
[![Adatbázisterv](https://i.imgur.com/Fd7nBmJ.jpg)](https://i.imgur.com/Fd7nBmJ.jpg)
---

## Implementációs terv
1.: Az adatbázis elkészítése
2.: Front-end kommunikáció az adatbázissal
3.: A grafikus felület elkészítése a programhoz
---
## Tesztterv:
# A program legérzékenyebb területeit unit-tesztekkel fogjuk biztosítani.
Az alábbi elemekhez tervezünk unit-teszteket írni:
- Új fájl létrehozása sikeres-e?
- Lehet-e kétszer ugyanazt a kenyér példányt eltárolni?
- Működik-e a logolás?

Továbbá az alábbi elemekre kulcsfontosságú odafigyelni:
- Eltároljuk-e a user id-ját bejelentkezéskor?
- Lehet-e negatív számot leadni a kenyerek megrendelésekor?
---
## Telepítési terv:
A telepítéshez szükség van egy MySQL adatbázisra. A projekttel mellékelünk egy bakery.sql nevű fájlt. Ezt kell a felhasznlónak beimportálnia a MySQL admin felületén keresztül. Ezután a program .jar fájljának futtatásával elindítható a szoftver.
---
