package CH01.Q1_7;

import CtCILibrary.*;

public class Question {

	public static boolean rotate(int[][] matrix) {
		int n = matrix.length;
		if (n == 0) {
			return false;
		}
		//Loop through each row, until half of the rows
		//because the rest are already rotated in the column loops
		for (int i = 0; i <= (n / 2); i++) {
			//Loop thought every column in a row
			//except for the last one
			//because the last column is already replace by the first column
			for (int j = i; j < (n - i - 1); j++) {
				 int temp = matrix[i][j];
				 matrix[i][j] = matrix[n - j - 1][i];
				 matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				 matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				 matrix[j][n - i - 1]= temp;
				 System.out.println("i= " + i + " j= " + j + ' ' + matrix[i][j]);
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(5, 5, 0, 9);
		AssortedMethods.printMatrix(matrix);
		rotate(matrix);
		System.out.println();
		AssortedMethods.printMatrix(matrix);
	}

}
