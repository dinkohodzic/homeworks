package ba.bitcamp.homework.week6.day2;

public interface Connectable {
	/**
	 * Method prepared to connect a computer
	 * 
	 * @param c
	 *            The computer
	 */
	void connect(Computer c);

	/**
	 * Method prepared to connect a network
	 * 
	 * @param n
	 *            The network
	 */
	void connect(Network n);

	/**
	 * Method prepared to disconnect both the computer and the network
	 */
	void disconnect();

}
