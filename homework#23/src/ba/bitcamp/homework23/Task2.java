package ba.bitcamp.homework23;

import java.util.EmptyStackException;

public class Task2 {
	private Node start;

	//Default constructor
	public Task2() {
		start = null;
	}

	/**
	 *Adds an item at the top of this stack.
	 * 
	 * @param s
	 *            The String.
	 */
	public void push(String s) {

		if (start == null) {
			start = new Node(s);
		} else {
			Node first = new Node(s);
			first.setNextNode(start);
			start = first;
		}

	}

	/**
	 * Removes the object at the top of the stack.
	 * 
	 * @return The String at the top.
	 * @throws EmptyStackException
	 *             
	 */
	public String pop() throws EmptyStackException {
		
		String value = start.getValue();
		
		if (start == null) {
			throw new EmptyStackException();
		}
		
		start = start.getNextNode();

		return value;
	}

	/**
	 * Returns which element is at the top of the stack
	 * 
	 * @return The String at the top.
	 * @throws EmptyStackException
	 *           
	 */
	public String peek() throws EmptyStackException {

		if (start == null) {
			throw new EmptyStackException();
		}

		return start.getValue();
	}

	/**
	 * Tests if the stack is empty.
	 * 
	 * @return true if the stack contains no items, false
	 *         otherwise.
	 */
	public boolean isEmpty() {
		return start == null;
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
		int position = 1;
		Node tmp = start;
		while (tmp != null) {
			if (tmp.getValue().equals(s)) {
				return position;
			}
			position++;
			tmp = tmp.getNextNode();
		}
		return -1;
	}

	public String toString() {
		if (start == null) {
			return "The list is empty";
		}

		return start.toString();
	}

	
	public class Node {
		
		private String value;
		
		private Node nextNode;

		public Node(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public String toString() {
			if (nextNode == null) {
				return value;
			}
			return value + " " + nextNode.toString();
		}
	}

	public static void main(String[] args) {

	
		long start = System.currentTimeMillis();
		
		Task2 stack = new Task2();
		
		for (int i = 0; i < 100000; i++) {
			stack.push("Names");
		}
		while (!stack.isEmpty()) {
			stack.pop();
		}
		System.out.println((System.currentTimeMillis() - start));

	}

}
