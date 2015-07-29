package ba.bitcamp.homework24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Task04 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// Creating map.
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

		// Inputing key and number length.
		System.out.println("Insert key length: ");
		int key = in.nextInt();
		System.out.println("Insert value length: ");
		int number = in.nextInt();

		int counter = 0;

		ArrayList<Integer> list;
		int j;
		for (int i = 1; i < key + 1; i++) {
			counter++;
			list = new ArrayList<Integer>();
			for (j = 1; j < number + 1; j++) {
				list.add(j * counter);
			}
			map.put(i, list);
		}

		System.out.println(map);

		in.close();
	}

}
