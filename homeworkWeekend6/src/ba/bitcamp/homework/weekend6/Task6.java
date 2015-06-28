package ba.bitcamp.homework.weekend6;

import java.util.Arrays;

public class Task6 {

	/**
	 * Fills matrix with integers in ascending order starting at 0
	 * 
	 * @param matrix
	 *            The matrix to fill
	 */
	public static void fillArray(int[][] matrix) {
		fillArray(matrix, 0, 0, 0);
	}

	private static void fillArray(int[][] matrix, int a, int b, int c) {
		if (a == matrix.length) {
			return;
		}
		if (b == matrix[a].length - 1) {
			matrix[a][b] = c;
			b = 0;
			a += 1;
			c += 1;
		} else {
			matrix[a][b] = c;
			b += 1;
			c += 1;
		}
		fillArray(matrix, a, b, c);

	}

	public static void main(String[] args) {
		int[][] matrix = new int[3][5];
		fillArray(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}
