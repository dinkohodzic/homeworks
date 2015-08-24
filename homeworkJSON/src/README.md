<h1>JSON Client-Sever komunikacija</h1>
<h3>Cilj:</h3>
<br>
Potrebno je napraviti Client-Server aplikacije (Client i Server), koje međusobno komuniciraju.

Komunikacija se odvije putem JSON stringa.

<br>


Client šalje upit na Server, a Server na taj upit odgovara sa random rečenicom iz fajla.

Potrebno je u file upisati određeni broj rečenica, koje će Server randomly čitati vraćati na Client.

Server prvo instancira BitResponse objekat, koji nakon toga pretvara u JSON i vraća na Client.

<br>


Odgovor Servera je u JSON formatu.

<br>


Client čita JSON i pretvara ga u BitResponse objekat.

<br>


Specifikacije:

BitRespones objekat se sastoji od:

- message (String)

- timestamp (Date)


<br>

JSON izgleda ovako:

{

"message": "Vaša poruka",

"timestamp": "2015-07-31 17:55:00"

}

<br>


Za ovaj zadatak, potrebno je korisiti Jackson biblioteku.




Biblioteku u .jar obliku, možete preuzeti na:

http://www.java2s.com/Code/JarDownload/jackson-all/jackson-all-1.9.0.jar.zip (otpakovati .zip)




Način importovanja te biblioteke u projekat je prikazan na ovom linku:

http://stackoverflow.com/questions/3280353/how-to-import-a-jar-in-eclipse




Primjeri upotrebe Jackson biblioteke:

http://www.technicalkeeda.com/java/convert-java-object-to-json-and-vice-versa-using-jackson

http://java67.blogspot.com/2015/02/how-to-parse-json-tofrom-java-object.html
