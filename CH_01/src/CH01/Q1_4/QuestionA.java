package CH01.Q1_4;

import java.io.Console;

public class QuestionA {	
	public static boolean isPermutationOfPalindrome(String phrase) {
//	Put all characters(lower case) and check if there are more characters showing odd times
//	Solution 1
//	The array store the time each character shows up
//		int[] array = new int[128];
//		
//		for (int i = 0; i < phrase.length(); i++) {
//			char c = Character.toLowerCase(phrase.charAt(i));
//			array[c]++;
//		}
//		int count = 0;
//		for (int a: array) {
//			if (a % 2 != 0) {
//				count++;
//			}
//			if (count >1) {
//				return false;
//			}
//		}
//		
//		return true;
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
// Solution 2
// Basically the same way as solution 1, but change the cout of odd characters within the firt loop through
		int[] array = new int[128];
		int count = 0;
		for (int i = 0; i < phrase.length(); i++) {
			char c = Character.toLowerCase(phrase.charAt(i));
			array[c]++;
			if (array[c] % 2 == 1) {
				count++;
			} else {
				count--;
			}
		}
		System.out.println(count);
		return count <= 1;
		
		
	}
	
	public static void main(String[] args) {
		String pali = "Rats live on no evil star";
		System.out.println(isPermutationOfPalindrome(pali));
	}


}
