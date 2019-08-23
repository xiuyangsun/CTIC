package CH01.Q1_1;
import java.util.Arrays;

public class QuestionA {
	public static boolean isUniqueChars(String str) {
		// Solution 1: Use boolean Array and use the character as the index
//		if (str.length() > 128) {
//			return false;
//		}
//		boolean[] charSet = new boolean[128];
//		
//		for (int i = 0; i < str.length(); i++) {
//			char c = str.charAt(i);
//			if (charSet[c]) {
//				return false;
//			}
//			charSet[c] = true;
//		}
//		return true;
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
// Solution 2: put the string into an chararray and sort the array. Check if adjacent characters are the same.
		if (str.length() > 128) {
			return false;
		}
		if (str.length() < 2) {
			return true;
		}
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		
		for ( int i = 0; i <charArray.length-1; i++) {
			if (charArray[i] == charArray[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}
}
