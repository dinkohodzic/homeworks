package ba.bitcamp.homework.weekend5;

public class Character extends StoryElement {

	private String gender;
	private boolean isAlive;
	private boolean isAble;

	// Constructor
	public Character(String name, String gender, boolean isAble) {
		super(name);
		this.gender = gender;
		this.isAlive = true;
		this.isAble = isAble;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setisAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean isAble() {
		return isAble;
	}

	public void setIsAble(boolean isAble) {
		this.isAble = isAble;
	}

	/**
	 * Sets isAlive to false
	 */
	public void killCharacter() {
		isAlive = false;
	}

	/**
	 * Sets isAble to true
	 */
	public void becomeAble() {
		isAble = true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (isAble != other.isAble)
			return false;
		if (isAlive != other.isAlive)
			return false;
		return true;
	}

}
