package ba.bitcamp.homework.weekend5;

public abstract class StoryElement {
	private String name;

	// Default constructor
	public StoryElement(String name) {
		super();
		this.name = name;
	}

	// Empty constructor with default value "STElement"
	public StoryElement() {
		this.name = "STElement";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
