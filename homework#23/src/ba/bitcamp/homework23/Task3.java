package ba.bitcamp.homework23;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Task3 {
	
	Double[] arr;
	
	int size = 0;

	//Default constructor
	public Task3() {
		arr = new Double[0];
	}

	/**
	 * Adds an element to the end of the array
	 * 
	 * @param e The element(Double)
	 * @return true if successful, false otherwise
	 */
	public boolean add(Double e) {

		Double[] newArr = Arrays.copyOf(arr, arr.length + 1);
		newArr[newArr.length - 1] = e;
		arr = newArr;
		size++;
		return true;
	}

	/**
	 * Retrieves and removes the head of this queue, or returns null if this
	 * queue is empty.
	 * 
	 * @return array value on index 0
	 */
	public Double poll() {
		if (arr.length == 0) {
			throw new NoSuchElementException();
		} else {
			double value = arr[0];
			arr = Arrays.copyOfRange(arr, 1, arr.length);
			size--;
			return value;
		}
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null
	 * if this queue is empty.
	 * 
	 * @return
	 */
	public Double peek() {
		if (arr.length == 0) {
			return null;
		} else {
			return arr[0];
		}
	}

	public boolean isEmpty() {
		size = 0;
		return arr.length == 0;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue. This method
	 * differs from peek only in that it throws an exception if this queue is
	 * empty.
	 * 
	 * @return
	 */
	public Double element() throws NoSuchElementException {
		if (arr.length == 0) {
			throw new NoSuchElementException();
		} else {
			return arr[0];
		}
	}

	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions. When using a
	 * capacity-restricted queue, this method is generally preferable to add(E),
	 * which can fail to insert an element only by throwing an exception.
	 * 
	 * @param e
	 * @return
	 */
	public boolean offer(Double e) {

		if (size == arr.length) {
			ensureCapacity();
		}
		arr[size++] = e;
		return true;
	}

	private void ensureCapacity() {
		int newSize = arr.length * 2;
		arr = Arrays.copyOf(arr, newSize);
	}

	/**
	 * Retrieves and removes the head of this queue.
	 * 
	 * @return
	 */
	public Double remove() throws NoSuchElementException {

		if (arr.length == 0) {
			throw new NoSuchElementException();
		} else {
			double value = arr[0];
			arr = Arrays.copyOfRange(arr, 1, arr.length);
			return value;
		}
	}

	public String toString() {
		return Arrays.toString(arr);
	}

	public static void main(String[] args) {

		
		long start = System.currentTimeMillis();
		
		Task3 queue = new Task3();
		
		for (int i = 0; i < 1000; i++) {
			queue.add(77.77);
		}
		while (!queue.isEmpty()) {
			queue.poll();
		}

		System.out.println((System.currentTimeMillis() - start));
	}


}
