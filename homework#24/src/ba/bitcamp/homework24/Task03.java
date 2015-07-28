package ba.bitcamp.homework24;

import java.util.ArrayList;
import java.util.ListIterator;

public class Task03 {

	public static void main(String[] args) {

		// Creating list.
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		// Adding elements into the list.
		numbers.add(2);
		numbers.add(4);
		numbers.add(3);
		numbers.add(5);
		numbers.add(2);
		numbers.add(9);
		numbers.add(2);
		numbers.add(5);
		numbers.add(17);
		
		//Creating itterator for the list
		ListIterator<Integer> iter = numbers.listIterator();

		while (iter.hasNext()) {
			int temp = iter.next();
			if (iter.hasNext()) {
				iter.remove();
				temp += iter.next();
				iter.set(temp);
			}

		}
		//Printing the list
		System.out.println(numbers);
	

	}

}
