package task6;

public class Cat extends Pet {
	/**
	 * Default constructor
	 * 
	 * @param name
	 *            The name
	 * @param age
	 *            The age
	 * @param species
	 *            The species
	 */
	public Cat(String name, int age, String species) {
		super(name, age, species);
	}

	/**
	 * Prints go away human.
	 */
	public String toString() {
		return "Go away human";
	}
}
