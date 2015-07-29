package task6;

public class Dog extends Pet {
	// Attributes
	private String breed;

	/**
	 * Default constructor
	 * 
	 * @param name
	 *            The name
	 * @param age
	 *            The age
	 * @param species
	 *            The species
	 * @param strain
	 */
	public Dog(String name, int age, String species, String breed) {
		super(name, age, species);
		this.breed = breed;
	}

	/**
	 * Prints the sound a dog makes
	 */
	public String toString() {
		return "AV AV";
	}

	// getter and setter
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
}
