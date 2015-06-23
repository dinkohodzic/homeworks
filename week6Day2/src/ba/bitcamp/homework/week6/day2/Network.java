package ba.bitcamp.homework.week6.day2;

public abstract class Network {
	// Initializing attributes
	private String nameOfNetwork;
	private Computer[] computers;

	// Default constructor
	public Network(String nameOfNetwork) {
		super();
		this.nameOfNetwork = nameOfNetwork;
		this.computers = new Computer[0];
	}

	/**
	 * Method prepared to add a computer to the network
	 * 
	 * @param c
	 *            The computer
	 */
	public abstract void addComputer(Computer c);

	/**
	 * Method prepared to remove a computer from the network
	 * 
	 * @param c
	 *            The computer
	 */
	public abstract void removeComputer(Computer c);

	//getters
	public String getNameOfNetwork() {
		return nameOfNetwork;
	}

	public Computer[] getComputers() {
		return computers;
	}

}
