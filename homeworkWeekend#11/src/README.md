<h1>
WEEK 11

WEEKEND HOMEWORK
</h1>

<h3>
TASK #1 – CHECK IF FILE EXISTS
</h3>
Napraviti jedan server koji za klijenta provjeraje da li dati file na serverovom računaru postoji. Nije
potrebno uraditi GUI za ovaj zadatak.
PRIMJER
Ukoliko klijent pošalje serveru String „C:/Users/Neko/Desktop/text.txt“ i ukoliko server IMA
taj file u tom direktoriju onda server odgovara sa 1, a ukoliko taj file ne postoji onda odgovara sa 0.

<h3>
TASK #2 – THREE THREADS OF ONE CLASS
</h3>

Napraviti tri Thread-a. Prvi isprinta brojeve od 1 do 10, sa pauzom od 200 [ms] između svakog broja.
Drugi isprinta četiri puta „BitCamp“ sa pauzom od 1000 [ms], a treći isprinta pet Random brojeva u
rasponu od 1 do 5 sa pauzom od 700 [ms] između svakog.
Treći Thread kreće sa radom kada završi drugi, a drugi kreće sa radom kada završi prvi. Kada svi
završe zatvara se program.
Sva tri Thread-a su bazirani na samo jednoj klasi!

<h3>
TASK #3 – INTERRUPTING AT HREAD (GUI)
</h3>
Napraviti GUI aplikaciju koja ima jedan JLabel i jedan JButton. JLabel je na početku prazan, ali
nakon svake sekunde dobija jedno po jedno slovo abecede, pa tako nakon tri sekunde JLabel će imati
u sebi „abc“, a nakon pet će imati „abcde“. Klikom na dugme se zaustavi taj proces, ali ne i aplikacija.
Koristiti vlastite Thread-ove za ovaj zadatak! Nipošto ne koristiti glavni Thread za JLabel!

<h3>
TASK #4 – HTTP IMAGE SERVER
</h3>

Napraviti HTTP server kojem klijent daje (upload-uje) sliku u obliku niza byte-ova. Server kod sebe
spašava tu sliku i daje joj proizvoljno ime (može biti nasumično, može se generisati na osnovu ip adrese
i vremena kada je poslata slika). Nakon uspješnog prebacivanja slike na server, na stranici se
pojavljuje link na tu sliku tako da korisnik može otvoriti stranicu gdje se nalazi ta slika.
P RIMJER
Server prima sliku od klijenta i generiše joj ime 2034317.jpg. Na stranici servera (HTTP protokol)
pojavi se novi link koji vodi na stranicu, ukoliko je lokalni računar, localhost/2034317 i tu se pojavi
postavljena slika.

