package ba.bitcamp.homework.week6.day2;

public class Server extends Computer {
	// The capacity of the server
	private int maxComputers;

	// Constructor
	public Server(String name, char[] mac, int maxComputers) {
		super(name, mac);
		this.maxComputers = maxComputers;
	}

	// getter
	public int getMaxComputers() {
		return maxComputers;
	}

	// equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Server))
			return false;
		Server other = (Server) obj;
		if (maxComputers != other.maxComputers)
			return false;
		return true;
	}

	// toString method
	@Override
	public String toString() {
		String s = "";
		s += super.toString();
		s += "\nMaximum capacity of coumputers: " + maxComputers;

		return s;
	}

}
