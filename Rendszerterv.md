## A rendszer célja
Megrendelőnk eddig konzolos terminál segítségével vezette a Páksége leltárát. Ez manapság már korszerűtlen megoldásnak számít, nem csak a terminál kinézete miatt, hanem felhasználóbarátsága miatt is. Az adatok könnyen elírhatók és bonyodalmas a menüpontok közötti ugrálás.

---
## Projektterv
A projektet páros programozás segítségével fogjuk implementálni, így az alábbi pontokat Pápai Kristóf és Sárosi Gábor közösen készítik:
-	adatbázis tervezése és létrehozása
-	alkalmazáslogika implementációja
-	grafikus felület elkészítése
-	tesztelés

---

## Üzleti folyamatok modellje:

Követelmények:
Funkcionális követelmények:
-	a termékek leltára
-	a temékek előllításának menete
-	A programot csak az arra jogosultak tudják használni: rendelkezzen autentikációval
Nem funkcionális követelmények:
-	A felhasználói felület legyen letisztult
-	A menüpontok között gyors legyen a navigáció

---
## Funkcionális terv
A program indulásakor egy bejelentkező felület fog megjelenni. Az adatok megadásával elérhetővé válik a leltár. A leltárhoz a CRUD műveletekkel tudunk hozzáférni. A termékek és a "receptek" is így tarthatók nyilván. A program bezárásával a felhasználó kijelentkezik.

---
## Fizikai környezet
Az alkalmazás Java programozási nyelven készül. A grafikus interfészt Swing segítéségével készítjük el. Az adatbázis MySQL szervert fog használni. Java-ból az adatbázishoz való hozzáférést a JDBC segítségével oldjuk meg.

---
## Fejlesztői eszközök:
-	IntelliJ Idea
-	XAMPP
-	Visual Studio Code

---

## Adatbázisterv:
---

## Implementációs terv
1.: Az adatbázis elkészítése
2.: Front-end kommunikáció az adatbázissal
3.: A grafikus felület elkészítése a programhoz
---
## Tesztterv:
---
## Telepítési terv:
---
## Karbantartási terv:



