package ba.bitcamp.homework23;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Task1 {
	
	String[] arr;
	
	//Default constructor
	public Task1() {
		arr = new String[0];
	}

	/**
	 * Adds a String to the end of a stack
	 * 
	 * @param e The String
	 *            
	 */
	public void push(String e) {
		
		String[] newArr = Arrays.copyOf(arr, arr.length + 1);
		
		newArr[newArr.length - 1] = e;
		
		arr = newArr;

	}

	/**
	 * Removes the object at the top of the stack
	 * 
	 * @return The String that was removed.
	 * @throws EmptyStackException
	 *            
	 */
	public String pop() throws EmptyStackException {

		if (arr.length == 0) {
			throw new EmptyStackException();
		} else {
			String value = arr[arr.length - 1];
			arr = Arrays.copyOf(arr, arr.length - 1);
			return value;
		}
	}

	/**
	 * Shows which element is on top of the stack
	 * 
	 * @return The String at the top .
	 * @throws EmptyStackException
	 */
	public String peek() throws EmptyStackException {
		if (arr.length == 0) {
			throw new EmptyStackException();
		}
		return arr[arr.length - 1];
	}

	/**
	 * Tests if this stack is empty.
	 * 
	 * @return true if  the stack contains no items, false
	 *         otherwise.
	 */
	public boolean isEmpty() {
		return arr.length == 0;
	}

	/**
	 * Returns the position of the item compared to the first item of the stack
	 * 
	 * @param s The desired String.
	 *            
	 * @return The 1-based position from the top of the stack where the object
	 *         is located; the return value -1 indicates that the object is not
	 *         on the stack.
	 */
	public int search(String s) {
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i].equals(s)) {
				return arr.length - i;
			}
		}
		return -1;
	}

	public String toString() {
		return Arrays.toString(arr);
	}

	public static void main(String[] args) {

		
		long start = System.currentTimeMillis();
		Task1 stack = new Task1();
		for (int i = 0; i < 10000; i++) {
			stack.push("ABCD");
		}

		while (!stack.isEmpty()) {
			stack.pop();
		}

		System.out.println((System.currentTimeMillis() - start));

	}


}
