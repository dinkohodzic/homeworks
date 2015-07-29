package task1;



public class Main {

	public static void main(String[] args) {
		
		char[] chars = new char[] { 'b', 'i', 't' };
		CampStringBuilder c = new CampStringBuilder(chars);

		//append method
		c.append("Camp");
		System.out.println(c.toString());
		//prepend method
		c.prepend("Hoework for ");
		System.out.println(c.toString());

	}

}
