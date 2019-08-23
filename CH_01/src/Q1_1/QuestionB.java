package Q1_1;
import java.util.Arrays;

public class QuestionB {
	// Not using other data structure
	public static boolean isUniqueChars(String str) {
//		Loop through the string 
		if (str.length() > 128) {
			return false;
		}
		if (str.length() < 2) {
			return true;
		}
		
		for(int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle", "asdfghkalp"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}

}
