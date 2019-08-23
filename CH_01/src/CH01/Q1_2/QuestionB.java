package CH01.Q1_2;

public class QuestionB {	
	public static boolean permutation(String s, String t) {
//	Put characters as index to modify the int array stands for shows up time of each of the 128 ASICII characters
//	Show up in first string ++, show up in the second string --
//	Loop through the array whose length is a constant and find any value is not is not 0;
		if (s.length() != t.length()) return false; // Permutations must be same length
		int[] array = new int[128];
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			array[c1]++;
			array[c2]--;
		}
		for (int a: array) {
			if (a != 0)
				return false;
		}
		return true;
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
