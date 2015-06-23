package ba.bitcamp.homework.weekend5;

public class Main {

	public static void main(String[] args) {
		Character enemy = new Character("Saruman", "male", true);
		Goal goal = new Goal("Defeat", Goal.DIFFICULT, Event.DEFEAT, enemy);
		Protagonist mainCharacter = new Protagonist("Frodo", "male", true, goal);
		Character character1 = new Character("Gandalf", "male", true);
		Character character2 = new Character("Legolas", "male", true);
		Character character3 = new Character("Sam", "male", true);
		

	}

}
