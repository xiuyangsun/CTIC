package CH01.Q1_5;

import java.util.zip.Inflater;

public class QuestionA {
// Loop through the strings, there could be only one character difference as been replaced.
	public static boolean oneEditReplace(String s1, String s2) {
		int diff = 0;
		for (int i = 0; i < s1.length(); i ++) {
			if (s1.charAt(i) != s2.charAt(i))
				diff++;
			if (diff > 1)
				return false;
		}
		return true;
	}
	
	/* Check if you can insert a character into s1 to make s2. */
	public static boolean oneEditInsert(String s1, String s2) {
		int index1 = 0, index2 = 0;
		boolean hasDiff = false;
		while(index1 < s1.length()) {
			char c1 = s1.charAt(index1);
			char c2 = s2.charAt(index2);
			if (c1 != c2) {
				index2++;
				if (hasDiff) return false;
				hasDiff = true;
			} else {
				index1++;
				index2++;
			}
		}
		
		return true;
	}	
//	1. Same length strings, one character difference(replace)
//	2. Remove is reverse insert, so the insert add remove could be treated the same, 1 character length difference.
	public static boolean oneEditAway(String first, String second) {
		if (first.length() == second.length()) {
			return oneEditReplace(first, second);
		} else if (first.length() + 1 == second.length()) {
			return oneEditInsert(first, second);
		} else if (first.length() - 1 == second.length()) {
			return oneEditInsert(second, first);
		} 
		return false;
	}
	
	public static void main(String[] args) {
		String a = "pse";
		String b = "pale";
		boolean isOneEdit = oneEditAway(a, b);
		System.out.println(a + ", " + b + ": " + isOneEdit);
	}

}
