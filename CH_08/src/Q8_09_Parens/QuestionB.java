package Q8_09_Parens;

import java.util.ArrayList;

public class QuestionB {
	
	public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] strs, int index) {
		if(leftRem < 0 || leftRem > rightRem) {
			return;
		} 
		
		if(leftRem == 0 && rightRem == 0) {
			list.add(String.copyValueOf(strs));
		} else {
			strs[index] = '(';
			addParen(list, leftRem - 1, rightRem, strs, index + 1);
			
			strs[index] = ')';
			addParen(list, leftRem, rightRem - 1, strs, index + 1);
		}			
	}
	
	public static ArrayList<String> generateParens(int count) {
		char[] strs = new char[count * 2];
		ArrayList<String> result = new ArrayList<String>();
		addParen(result, count, count, strs, 0);
		return result;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = generateParens(6);
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println(list.size());		
	}

}
