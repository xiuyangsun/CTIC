package CH01.Q1_2;

import java.util.Arrays;

public class QuestionA {	
	public static boolean permutation(String str1, String str2) {
//	Convert two strings into charArray and sort, compare the sorted string to see if they are the same.
		if (str1.length() != str2.length()) {
			return false;
		}
		
		return sort(str1).equals(sort(str2));
	}
	public static String sort( String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
		
	}
	
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = permutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
		}
	}
}
