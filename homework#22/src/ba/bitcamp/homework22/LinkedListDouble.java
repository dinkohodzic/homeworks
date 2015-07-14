package ba.bitcamp.homework22;

public class LinkedListDouble {
	private Node start;

	// Empty constructor
	public LinkedListDouble() {
		super();
		start = null;
	}

	// Constructor containing a Linked list of Double elements
	public LinkedListDouble(LinkedListDouble doubleLinked) {

		for (int i = 0; i <= doubleLinked.getSize(); i++) {

			add(doubleLinked.get(i));
		}
	}

	/**
	 * This method adds an element to the end of the list
	 * 
	 * @param element
	 *            A Double value
	 * 
	 */
	public void add(Double element) {
		if (start == null) {

			start = new Node(element);

		} else {

			Node last = getLastNode();

			last.setNext(new Node(element));
		}
	}

	/**
	 * This method adds an element on a given index
	 * 
	 * @param element
	 *            The Double element
	 * @param index
	 *            The index
	 */
	public void add(Double element, int index) {

		try {
			Node tmp = start;

			for (int i = 0; i < index - 1; i++) {
				tmp = tmp.getNext();
			}

			Node newNode = new Node(element);
			newNode.setNext(tmp.getNext());
			tmp.setNext(newNode);

		} catch (IndexOutOfBoundsException e) {

			System.out.println("Entered index is wrong");
		}

	}

	/**
	 * This method removes an element on a given index
	 * 
	 * @param index
	 *            The index
	 * 
	 */
	public void remove(int index) {
		if (index > 0) {
			try {
				Node temp = start;
				for (int i = 0; i < index; i++) {
					temp = temp.getNext();
				}
				Node previous = getPrevious(temp);

				previous.setNext(temp.getNext());

			} catch (IndexOutOfBoundsException e) {

				System.out.println("Entered index is wrong");
			}
		}
	}

	/**
	 * This method gets the previous node
	 * 
	 * @param n
	 *            The Node
	 * 
	 * @return The previous Node
	 */
	public Node getPrevious(Node element) {

		if (element == start) {
			return null;
		}

		Node tmp = start;
		while (tmp.getNext() != element) {

			tmp = tmp.getNext();
		}
		return tmp;
	}

	/**
	 * This method returns the Double value of a given index
	 * 
	 * @param index
	 *            The index
	 * 
	 * @return The value
	 */
	public Double get(int index) {
		try {
			Node tmp = start;
			for (int i = 0; i < index; i++) {
				tmp = tmp.getNext();
			}
			return tmp.getValue();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Entered index is wrong");
		}
		return null;
	}

	/**
	 * This method returns the size of the list
	 * 
	 * @return The size
	 */
	public int getSize() {
		if (start == null) {
			return 0;
		}
		int counter = 0;
		Node temp = start;
		while (temp.getNext() != null) {
			counter++;
			temp = temp.getNext();
		}
		return counter;
	}

	/**
	 * This method returns the element in the middle of the list
	 * 
	 * @return The middle element
	 */
	public Double getMidle() {
		if (start == null) {
			return null;
		}
		Node temp = start;
		int size = getSize() / 2;
		for (int i = 0; i < size; i++) {
			temp = temp.getNext();
		}
		return temp.getValue();

	}

	/**
	 * This method removes the first element of the list
	 */
	public void removeFirst() {

		Node first = start;
		first = first.getNext();
		start = first;

	}

	/**
	 * This method removes the last element of the list
	 */
	public void removeLast() {

		Node last = getLastNode();
		Node previous = getPrevious(last);

		previous.setNext(null);

	}

	/**
	 * This method returns the last element of the list
	 * 
	 * @return The last Node
	 */
	public Node getLastNode() {
		if (start == null) {
			return null;
		}
		Node temp = start;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		return temp;

	}

	/**
	 * This method returns the first element of the list
	 * 
	 * @return The first element
	 */
	public Double getFirst() {
		if (start == null) {
			return null;
		}
		return start.getValue();

	}

	/**
	 * This method returns the last element of the list
	 * 
	 * @return The last element
	 */
	public Double getLast() {

		return getLastNode().getValue();
	}

	// To string method
	@Override
	public String toString() {
		if (start == null) {
			return "The list is empty";
		}

		return start.toString();
	}

	public class Node {

		private Double value;
		private Node next;

		// Default constructor
		public Node(Double value) {
			super();
			this.value = value;
		}

		public Double getValue() {
			return value;
		}

		public void setValue(Double value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		// toString method
		@Override
		public String toString() {
			if (next == null) {
				return value + "";
			}
			return value + ", " + next.toString();
		}

	}

}
