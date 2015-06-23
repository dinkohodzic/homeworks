package ba.bitcamp.homework.weekend5;

public class Protagonist extends Character {
	private static final int MAX_CHARACTERS = 4;

	private Goal goal;
	private Character[] characters;
	private Character enemy;

	public Protagonist(String name, String gender, boolean isAble, Goal goal) {
		super(name, gender, isAble);
		this.goal = goal;
		this.enemy = null;
	}

	public void setOpponent(Character enemy) {
		this.enemy = enemy;
	}

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public Character[] getCharacters() {
		return characters;
	}

	public void setCharacters(Character[] characters)
			throws IllegalArgumentException {
		if (characters.length > Protagonist.MAX_CHARACTERS) {
			throw new IllegalArgumentException();

		}
		this.characters = characters;
	}

	public Character getEnemy() {
		return enemy;
	}

}
