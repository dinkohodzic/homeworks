<h1>Weekend Homework #5</h1>

<b>Zadatak 1</b>

Napisati dvije klase:
1. StoryElement klasa (abstract)    
a. Klasa koja opisuje jedan element u radnji jedne priče    
b. Sadrži atribut imena     
c. Sadrži dva konstruktora  
i. Konstruktor koji inicijalizira ime na datu vrijednost    
ii. Prazni konstruktor koji inicijalizira, preko prvog konstruktora, ime na „STElement“
2. Character klasa koja nasljeđuje StoryElement klasu
a. Klasa koja opisuje jednog lika u radnji jedne priče
b. Sadrži spol karaktera
c. Sadrži atribut koji opisuje da li je lik živ ili ne (default je true)
d. Sadrži atribut koji opisuje da li je lik sposoban ili ne
e. Sadrži metodu koja... ubija lika
f. Sadrži metodu koja pretvara nesposobnog lika u sposobnog
g. Konstruktor koji inicijalizira ime, spol karaktera i sposobnost karaktera

<b>Zadatak 2</b>

Napisati dvije klase:
1. Event klasa
a. Klasa koja opisuje događaj u radnji jedne priče
b. Klasa sadrži samo konstante i to:
i. Poraz
ii. Prijateljstvo
iii. Ljubav
iv. Osveta
v. Manipulacija
2. Goal klasa koja nasljeđuje StoryElement klasu
a. Klasa koja opisuje cilj jednog lika u radnji jedne priče
b. Sadrži atribut težine bazirano na tri vrijednosti (lagano, teško i nemoguće)
c. Sadrži atribut koji opisuje šta (Event) se treba desiti da se ispuni cilj
d. Sadrži atribut koji opisuje kome ili sa kim (Character) se treba desiti događaj pod c.
e. Sadrži konstruktor koji inicijalizira tri pomenuta atributa, kao i ime cilja

<b>Zadatak 3</b>

Napisati klasu:
1. Protagonist klasa koja nasljeđuje Character klasu
a. Opisuje glavnog pozitivca u priči
b. Sadrži atribut koji opisuje glavni cilj (Goal) lika
c. Sadrži jedan niz, kao atribut, likova (Character) koji pomažu glavnom liku (max. 3)
d. Sadrži jedan atribut koji označava glavnog neprijatelja (Character)
i. Dati atribut može biti null
e. Sadrži konstruktor koji inicijalizira ime, spol, sposobnost i cilj lika
f. Sadrži metodu koja postavi glavnog neprijatelja
g. Sadrži metodu koja doda jednog lika koji će pomoći glavnom liku
i. Pomenuta metoda se može samo četiri puta pozvati (peti throw-a exception)

<b>Zadatak 4</b>

Napisati metodu:
1. Metoda attainGoal() u klasi Protagonist
a. Metoda koja pokrene ciklus borbe glavnog lika i pokušaja da dokuči svoj cilj
b. Metoda ne može raditi ukoliko glavni lik nije živ
c. Metoda izračuna kolika je šansa da glavni lik dokuči svoj cilj
i. Ukoliko je glavni lik sposoban onda +40%
ii. Za svakog sposobnog pomoćnog lika +20%
iii. Ukoliko je glavni neprijatelj sposoban onda -30%
iv. Ukoliko je cilj težak onda -20%
v. Ukoliko je cilj nemoguć onda -100%
vi. Šansa uvijek mora biti između 0 i 100%
d. Bazirano na izračunatoj šansi metoda odluči da li je lik uspio ili ne
i. Uspjeh:
1. Ispisati na konzolu da je lik uspio i u čemu (Goal) je uspio
2. Napraviti jednog lika (nasumično izabranog) sposobnim (ako nije bio)
ii. Neuspjeh:
1. Ispisati na konzolu da lik nije uspio i u čemu (Goal) nije uspio
2. Nasumično izabrati jednoga lika koji je učestvovao i ubiti ga
3. Napraviti jednog lika (nasumično izabranog) sposobnim (ako nije bio)

<b>Zadatak 5</b>

Napraviti priču u main metodi pomoću navedenih klasa!