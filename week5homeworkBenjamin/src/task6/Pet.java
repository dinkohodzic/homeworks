package task6;

public class Pet {
	// Attributes
	private String name;
	private int age;
	private String species;

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
	public Pet(String name, int age, String species) {
		super();
		this.name = name;
		this.age = age;
		this.species = species;
	}

	/**
	 * Prints the info as a string
	 */
	public String toString() {
		String s = "";
		s += "Name: " + name;
		s += "\nAge: " + age;
		s += "\nSpecies: " + species;
		return s;
	}

	/**
	 * Checks if the two types of pets are equal
	 * 
	 * @param p
	 *            The pet to compare
	 * 
	 * @return True if the pets are equal, otherwise returns false
	 */
	public boolean equals(Pet p) {
		return this.name.equals(p.name) && this.age == p.age
				&& this.species.equals(p.species);
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

}
