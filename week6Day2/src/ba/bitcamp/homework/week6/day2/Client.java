package ba.bitcamp.homework.week6.day2;

public class Client extends Computer implements Connectable {

	// Initializing attributes
	private Computer userComputer;
	private Network userNetwork;

	// default constructor
	public Client(String name, char[] mac) {

		super(name, mac);
		this.userComputer = null;
		this.userNetwork = null;
	}

	/**
	 * This method makes a computer connectable
	 */
	@Override
	public void connect(Computer c) throws IllegalArgumentException {
		if (userNetwork != null || userComputer != null) {
			throw new IllegalArgumentException();
		}
		userComputer = c;
	}

	/**
	 * This method makes a network connectable
	 */
	@Override
	public void connect(Network n) throws IllegalArgumentException {
		if (userNetwork != null || userComputer != null) {
			throw new IllegalArgumentException();
		}
		userNetwork = n;
	}

	/**
	 * Disconnects both computer and network
	 */
	@Override
	public void disconnect() {
		userComputer = null;
		userNetwork = null;

	}

	// getters
	public Computer getUserComputer() {
		return userComputer;
	}

	public Network getUserNetwork() {
		return userNetwork;
	}

	/**
		 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Client))
			return false;
		Client other = (Client) obj;
		if (userComputer == null) {
			if (other.userComputer != null)
				return false;
		} else if (!userComputer.equals(other.userComputer))
			return false;
		if (userNetwork == null) {
			if (other.userNetwork != null)
				return false;
		} else if (!userNetwork.equals(other.userNetwork))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		s += super.toString();
		s += "\nUser Computer: " + userComputer;
		s += "\nUser Network: " + userNetwork;

		return s;
	}

}
