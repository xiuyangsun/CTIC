package Q8_02_Robot_in_a_Grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import CtCILibrary.AssortedMethods;

public class QuestionB {
	public static ArrayList<Point> getPath(boolean[][] maze) {
		int row = maze.length;
		int col = maze[0].length;
		ArrayList<Point> path = new ArrayList<Point>();
		HashSet<Point> failedPoints = new HashSet<Point>();
		if (row == 0 || col == 0) {
			return null;
		}
		
		if (getPath(maze, row - 1, col - 1, path, failedPoints)) {
			return path;
		}
		
		return null;
	}
	
	public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
		if (row < 0 || col < 0 || !maze[row][col]) {
			return false;
		}
		Point p = new Point(row, col);
		if (failedPoints.contains(p)) {
			return false;
		}
		
		boolean isOriginal = row == 0 && col == 0;
		
		if (isOriginal || getPath(maze, row - 1, col, path, failedPoints)  || getPath(maze, row, col - 1, path, failedPoints)) {
			path.add(p);
			return true;
		}
		
		failedPoints.add(p);
		return false;
		
	}
	
	public static void main(String[] args) {
		int size = 20;
		boolean[][] maze = AssortedMethods.randomBooleanMatrix(size, size, 60);
		
		AssortedMethods.printMatrix(maze);
		
		ArrayList<Point> path = getPath(maze);
		if (path != null) {
			System.out.println(path.toString());
		} else {
			System.out.println("No path found.");
		}
	}

}
