package Q5_03_Flip_Bit_to_Win;

public class QuestionA {
	
	public static int longestSequence(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == Integer.MAX_VALUE) {
			return 32;
		}
		if (n == Integer.MIN_VALUE) {
			return 2;
		}
		
		int max = 0;
		int current = 0;
		boolean secondZero = false;
		
		while (n != 0) {
			if ((n & 1) == 1) {
				current +=1;
			} else {
				if (!secondZero) {
					current++;
					secondZero = true;
				} else {
					max = Math.max(current, max);
					current = 0;
					secondZero = false;
				}
			}
			//System.out.println(Integer.toBinaryString(n));
			n = n >> 1;
		}
		max = Math.max(current, max); 
		return max = max == 31 ? 32 : max;
	}
	public static void main(String[] args) {
		int original_number = Integer.MAX_VALUE;
		int new_number = longestSequence(original_number);
		System.out.println(Integer.toBinaryString(original_number));
		for (int i = Integer.MIN_VALUE; i < Integer.MIN_VALUE+100; i++) {
			System.out.println(longestSequence(i));
		}
		System.out.println(new_number);			
	}

}
