package ba.bitcamp.homework.week6.day2;

public class BusNetwork extends Network implements Functionable {
	//Initializing attributes
	private int counter;
	//constructor
	public BusNetwork(String nameOfNetwork) {
		super(nameOfNetwork);

	}
	/**
	 * Tests if the network is functioning
	 */
	@Override
	public boolean isFunctioning() {
		counter = 0;
		for (int i = 0; i < getComputers().length; i++) {
			if (getComputers()[i] != null) {
				counter++;
			}
		}

		if (counter >= 2) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method adds a computer
	 */
	@Override
	public void addComputer(Computer c) throws IllegalArgumentException {
		if (c instanceof Server) {
			throw new IllegalArgumentException();
		} else {

			ArrayManipulation.extendArray(getComputers());
			getComputers()[getComputers().length - 1] = c;
			if (c instanceof Client) {
				Client cl = (Client) c;
				cl.connect(this);
			}
		}

	}
	
	/**
	 * This method removes a computer
	 */
	@Override
	public void removeComputer(Computer c) throws IllegalArgumentException {
		if (c instanceof Client) {
			Client cl = (Client) c;
			for (int i = 0; i < getComputers().length; i++) {
				if (getComputers()[i].equals(cl)) {
					cl.disconnect();
					ArrayManipulation.shrinkArray(getComputers(), i);
					return;
				}
			}
		} else {
			throw new IllegalArgumentException();
		}
		throw new IllegalArgumentException("Computer not found");
	}
	
	//toString method
	@Override
	public String toString() {
		String s = "";
		s += "BusNetwork is functioning: " + isFunctioning();
		s += "The network has: " + counter + "computers connected to it";

		return s;
	}

}
