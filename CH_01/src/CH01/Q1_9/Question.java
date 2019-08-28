package CH01.Q1_9;

import java.awt.SecondaryLoop;

public class Question {
	public static boolean isSubstring(String big, String small) {
		int n = small.length();
		for (int i = 0; i <= big.length() - n; i++) {
			if (big.substring(i,i + n).equals(small))
				return true;
		}
		return false;
	}
	
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		
		String firstString = "";
		String secondString = "";
		for (int i = 0; i <= s1.length(); i++) {
			firstString = s1.substring(0, i);
			secondString = s1.substring(i);
			boolean a = isSubstring(s2, firstString);
			boolean b = isSubstring(s2, secondString);
			if(a && b) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean is_rotation = isRotation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + is_rotation);
		}
	}

}
