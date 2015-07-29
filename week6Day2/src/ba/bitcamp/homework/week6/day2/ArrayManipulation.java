package ba.bitcamp.homework.week6.day2;

public class ArrayManipulation {
	
	/**
	 * Extends the array by one element
	 * @param arr The array
	 * @return The new array
	 */
	public static Computer[] extendArray(Computer[] arr) {
		Computer[] newArr = new Computer[arr.length + 1];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		return newArr;
	}
	
	/**
	 * Shrinks the array by a given number
	 * @param arr The array
	 * @param element The element
	 * @return The new array
	 */
	public static Computer[] shrinkArray(Computer[] arr, int element) {
		Computer[] newArr = new Computer[arr.length - 1];
		System.arraycopy(arr, 0, newArr, 0, element);
		System.arraycopy(arr, element + 1, newArr, element, arr.length - element - 1);
		return newArr;

	}
}
