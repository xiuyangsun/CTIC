package CH01.Q1_8;

import CtCILibrary.AssortedMethods;
// Use two boolean to mark if there are value 0 in the first row and first column
// then loop through the matrix and record the 0 values position in the first row and column
// loop through again and change the rows and columns to be zeros
// check the two boolean values to decide whether or not convert row 0 and column 0 to zeros.
public class QuestionB {
	
	public static void setZeros(int[][] matrix) {
		boolean rowHasZero = false, columnHasZero = false;
		int m = matrix.length;
		int n = matrix[0].length;
		
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				rowHasZero = true;
			}
		}
		
		for (int j = 0; j < m; j++) {
			if (matrix[j][0] == 0) {
				columnHasZero = true;
			}
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j]= 0;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		
		if (rowHasZero) {
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}
		}
		
		if (columnHasZero) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		int nrows = 10;
		int ncols = 15;
		int[][] matrix = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);		

		AssortedMethods.printMatrix(matrix);
		
		setZeros(matrix);
		
		System.out.println();
		
		AssortedMethods.printMatrix(matrix);
	}
}
