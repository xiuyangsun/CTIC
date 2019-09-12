package Q8_09_Parens;

import java.util.HashSet;
import java.util.Set;

public class QuestionA {
	public static String insertInside(String str, int leftIndex) {
		String left = str.substring(0, leftIndex + 1);
		String right = str.substring(leftIndex + 1, str.length());
		return left + "()" + right;
	}
	
	public static Set<String> generateParens(int remaining) {
		Set<String> result = new HashSet<String>();
		if (remaining == 0) {
			result.add("");
			return result;
		}
		
		Set<String> prev = generateParens(remaining - 1);
		
		for (String str: prev) {
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '(') {
					String s = insertInside(str, i);
					result.add(s);
				}
			}
		 result.add("()" + str);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Set<String> list = generateParens(4);
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println(list.size());
	}

}
