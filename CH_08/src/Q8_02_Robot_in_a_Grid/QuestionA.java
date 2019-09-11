package Q8_02_Robot_in_a_Grid;

import java.util.ArrayList;

import CtCILibrary.AssortedMethods;

public class QuestionA {
	
	public static ArrayList<Point> getPath(boolean[][] maze) {
		int r = maze.length;
		int c = maze[0].length;
		if (r == 0 || c == 0) {
			return null;
		}
		ArrayList<Point> path = new ArrayList<Point>();
		if (getPath(maze, r -1, c - 1, path)) {
			return path;
		}
		return null;
	}	
	
	public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
		if (row < 0 || col < 0 || !maze[row][col]) {
			return false;
		}
		
		boolean isOriginal = (row == 0 && col == 0);
		
		if (isOriginal || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
			Point point = new Point(row, col);
			path.add(point);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int size = 5;
		boolean[][] maze = AssortedMethods.randomBooleanMatrix(size, size, 70);
		
		AssortedMethods.printMatrix(maze);
		
		ArrayList<Point> path = getPath(maze);
		if (path != null) {
			System.out.println(path.toString());
		} else {
			System.out.println("No path found.");
		}
	}

}
