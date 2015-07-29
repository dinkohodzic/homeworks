package ba.bitcamp.homework.week6.day2;

import java.util.Arrays;

public abstract class Computer {

	// Initializing attributes
	private String name;
	private MACAddress mac;

	// Default constructor
	public Computer(String name, char[] mac) {
		super();
		this.name = name;
		this.mac = new MACAddress(mac);
	}

	public Computer() {
		this.name = "computer";
		this.mac = new MACAddress(new char[] { '0', '1', '2', '3', '4', '5',
				'6', '7', '8', '9', 'a', 'b' });
	}

	public String getName() {
		return name;
	}

	public MACAddress getMac() {
		return mac;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Computer))
			return false;
		Computer other = (Computer) obj;
		if (mac == null) {
			if (other.mac != null)
				return false;
		} else if (!mac.equals(other.mac))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		s += "Name: " + name;
		s += "\nMAC Adress: " + mac;

		return s;
	}

	/**
	 * Class for the MAC address
	 * 
	 * @author dinko.hodzic
	 *
	 */
	public class MACAddress {

		public char[] mac = new char[12];

		public MACAddress(char[] mac) {
			if (this.mac.length == mac.length) {
				this.mac = mac;
			}

		}

		@Override
		public String toString() {

			return Arrays.toString(mac);
		}

	}

}
