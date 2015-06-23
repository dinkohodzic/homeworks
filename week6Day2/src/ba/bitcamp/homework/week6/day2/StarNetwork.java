package ba.bitcamp.homework.week6.day2;

public class StarNetwork extends Network implements Functionable {
	// Initializing parameters
	private Server server;
	private int counter;

	public StarNetwork(String nameOfNetwork, Server server) {
		super(nameOfNetwork);
		this.server = server;
	}

	/**
	 * Checks if the network is functioning
	 * 
	 * @return True if it's working, otherwise false
	 */
	@Override
	public boolean isFunctioning() {
		counter = 0;
		for (int i = 0; i < getComputers().length; i++) {
			if (getComputers()[i] != null) {
				counter++;
			}
		}
		if (server.getMaxComputers() < counter) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * This method adds one computer
	 * 
	 * @param c
	 *            The computer
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
				cl.connect(server);
			}
		}

	}

	/**
	 * This method removes one computer
	 * 
	 * @param c
	 *            The computer
	 */
	@Override
	public void removeComputer(Computer c) throws IllegalArgumentException {
		if (c instanceof Client) {
			Client cl = (Client) c;
			for (int i = 0; i < getComputers().length; i++) {
				if (getComputers()[i].equals(cl)) {
					cl.disconnect();
					ArrayManipulation.shrinkArray(getComputers(), i);

				}
			}
		} else {
			throw new IllegalArgumentException();
		}
		throw new IllegalArgumentException("Computer not found!");

	}

}
