package Q5_03_Flip_Bit_to_Win;

public class QuestionA {
// Change the Integer to a binary string and add 0 to the beginning of the String if n is positive.
//Loop through the string from left to right and from right to left to check the max length;
// get the max from two of them.
	public static int longestSequence(int n) {
		if (n == 0)
			return 1;
		String nString = Integer.toBinaryString(n);
		if (nString.length() < 32) {
			nString = "0" + nString;
		}
		int current = 0;
		int max = 0;
		boolean meetZero = false;

		for (int i = nString.length() -1; i >= 0 ; i--) {
			char c = nString.charAt(i);
			if (c == '1') {
				current++;
			} else {
				if (!meetZero) {
					current++;
					meetZero = true;
				} else {
					max = Math.max(current, max);
					current = 0;
					meetZero = false;
				}
			}
			//System.out.println("Current position: " + i + " current char: " + c + "current: " + current);
		}
		max = Math.max(current, max);
		
		current = 0;
		for (int i = 0; i < nString.length() ; i++) {
			char c = nString.charAt(i);
			if (c == '1') {
				current++;
			} else {
				if (!meetZero) {
					current++;
					meetZero = true;
				} else {
					max = Math.max(current, max);
					current = 0;
					meetZero = false;
				}
			}
			//System.out.println("Current position: " + i + " current char: " + c + "current: " + current);
		}
		
		
		max = Math.max(current, max);
		
		return max;
	}
	public static void main(String[] args) {
		int original_number = Integer.MIN_VALUE;
		int new_number = longestSequence(-10000);
		System.out.println(Integer.toBinaryString(-10000));

		System.out.println(new_number);		
	}

}
