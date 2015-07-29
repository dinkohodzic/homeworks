package ba.bitcamp.homework.weekend5;

public class Goal extends StoryElement {

	public static final int EASY = 0;
	public static final int DIFFICULT = 1;
	public static final int IMPOSSIBLE = 2;

	private int difficulty;
	private int event;
	private Character character;

	// Constructor
	public Goal(String name, int difficulty, int event, Character character) {
		super(name);
		this.difficulty = difficulty;
		this.event = event;
		this.character = character;
	}

	//Getters and setters
	
	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		if (difficulty >= Goal.EASY || difficulty <= Goal.IMPOSSIBLE) {

			this.difficulty = difficulty;
		}
	}

	public int getEvent() {
		return event;
	}

	public void setEvent(int event) {
		if (event >= Event.DEFEAT || event <= Event.MANIPULATION) {

			this.event = event;
		}
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}
}
