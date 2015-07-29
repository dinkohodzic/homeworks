package task2;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// Initializing author
		Author martin = new Author("George R.R. Martin", "george1948@mail.com",
				"male");
		// Initializing books
		Book martinBook1 = new Book("A Game of Thrones", 39.90, 3, martin);
		Book martinBook2 = new Book("A Clash of Kings", 39.90, 2, martin);
		Book martinBook3 = new Book("A Storm of Swords", 39.90, 1, martin);
		Book martinBook4 = new Book("A Feast for Crows", 39.90, 3, martin);
		Book martinBook5 = new Book("A Dance with Dragons", 49.90, 1, martin);

		// Initializing author
		Author tolkien = new Author("J. R. R. Tolkien", "tolkien1888@mail.com",
				"male");
		// Initializing books
		Book tolkienBook1 = new Book("The fellowship of the ring", 29.90, 3,
				tolkien);
		Book tolkienBook2 = new Book("The two towers", 29.90, 2, tolkien);
		Book tolkienBook3 = new Book("The return of the king", 29.90, 1,
				tolkien);
		// Initializing array of books
		Book[] martinBooks = new Book[] { martinBook1, martinBook2,
				martinBook3, martinBook4, martinBook5 };
		Book[] tolkienBooks = new Book[] { tolkienBook1, tolkienBook2,
				tolkienBook3 };

		System.out.println(Arrays.toString(martinBooks));
	}

}
