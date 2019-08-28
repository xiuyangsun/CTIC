package CH01.Q1_8;

import CtCILibrary.AssortedMethods;
// Use two arrays, one for rows and one for columns, loop through the matrix to record if there is a value 0 in them
// then loop through the matrix again and change values in all recorded rows and columns to 0
public class QuestionA {			
	
	public static void setZeros(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		boolean[] rows = new boolean[m];
		boolean [] columns = new boolean[n];
		
		for (int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					columns[j] = true;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rows[i] || columns[j]) {
					matrix[i][j] = 0;
				}
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
