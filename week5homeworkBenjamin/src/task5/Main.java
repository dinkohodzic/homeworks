package task5;

public class Main {

	public static void main(String[] args) {
		// Creating date using only day as input
		Date d1 = new Date(10);
		d1.setDay(31);
		d1.setMonth(3);
		// Printing the date
		System.out.println(d1);

		// Creating date using day and month as input
		Date d2 = new Date(7, 12);


		// Printing date 25.06.01
		System.out.println(d2);

		// Creating date using all elements
		Date d3 = new Date(30, 12, 2014);

		// Printing date 
		System.out.println(d3);

		// Adding days
		d3.dayPassed();
		d3.dayPassed();
		d3.dayPassed();

		// Printing date 
		System.out.println(d3);
	}

}
