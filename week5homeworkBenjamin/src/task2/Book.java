package task2;

public class Book {
	private String title;
	private double price;
	private int inStock;
	private Author author;

	// constructor
	public Book(String name, double price, int inStock, Author author)
			throws IllegalArgumentException {
		super();
		if (price < 0 || inStock < 0) {
			throw new IllegalArgumentException();
		}
		this.title = name;
		this.price = price;
		this.inStock = inStock;
		this.author = author;
	}

	public String getName() {
		return title;
	}

	public void setName(String name) {
		this.title = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws IllegalArgumentException {
		if (price < 0) {
			throw new IllegalArgumentException();
		}
		this.price = price;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) throws IllegalArgumentException {
		if (inStock < 0) {
			throw new IllegalArgumentException();
		}
		this.inStock = inStock;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		String s = "";
		s += "\nTitle: " + title;
		s += "\nPrice: " + price + "$";
		s += "\nIn stock: " + inStock;
		s += "\nAuthor: " + author;
		return s;
	}

}
