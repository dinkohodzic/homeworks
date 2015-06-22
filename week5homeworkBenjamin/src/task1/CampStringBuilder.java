package task1;

/**
 * 
 * @author dinko hodzic
 *
 */
public class CampStringBuilder {

	private char[] characters;

	// Constructor
	public CampStringBuilder(char[] characters) {
		super();
		this.characters = characters;
	}

	public char[] getCharacters() {
		return characters;
	}

	public void setCharacters(char[] characters) {
		this.characters = characters;
	}

	/**
	 * <h1>Adds the object to the end of an character array</h1> This method
	 * converts the object to a String and adds the String to an array of
	 * characters
	 * 
	 * @param The
	 *            object
	 */
	public void append(Object o) {
		int oldArrayLength = characters.length;
		int newArrayLength = oldArrayLength;
		for (int i = 0; i < o.toString().length(); i++) {
			newArrayLength++;
		}
		char[] newCharacters = new char[newArrayLength];
		for (int i = 0; i < characters.length; i++) {
			newCharacters[i] = characters[i];
		}
		int counter = 0;
		for (int i = oldArrayLength; i < newCharacters.length; i++) {
			newCharacters[i] = o.toString().charAt(counter++);
		}
		characters = newCharacters;
	}

	/**
	 * <h1>Adds the object to in front of an character array</h1> This method
	 * converts the object to a String and adds the String in front of an array
	 * of characters
	 * 
	 * @param The
	 *            object
	 */
	public void prepend(Object o) {
		int oldArrayLength = characters.length;
		int newArrayLength = oldArrayLength;
		for (int i = 0; i < o.toString().length(); i++) {
			newArrayLength++;
		}
		char[] newCharacters = new char[newArrayLength];
		for (int i = 0; i < o.toString().length(); i++) {
			newCharacters[i] = o.toString().charAt(i);
		}
		int counter = 0;
		for (int i = o.toString().length(); i < newCharacters.length; i++) {
			newCharacters[i] = characters[counter++];
		}
		characters = newCharacters;
	}

	// toString method
	public String toString() {
		String s = "";
		for (int i = 0; i < characters.length; i++) {
			s += characters[i];
		}
		return s;

	}
}
