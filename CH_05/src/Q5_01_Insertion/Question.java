package Q5_01_Insertion;

import CtCILibrary.AssortedMethods;

public class Question {

	public static int updateBits(int n, int m, int i, int j) {
		// Create all 1s from negation 0;
		int allOnes = ~0;
		System.out.println("allOnes: " +AssortedMethods.toFullBinaryString( allOnes));
		//shift left allOnes j+1 times make all ones from j+1 to the end
		// if the time shift equals  32 result will be 32 bits 0s;
		int left = j < 31 ? allOnes << (j + 1) : 0;
		System.out.println("left: " + AssortedMethods.toFullBinaryString(left));
		// shift 1 i times left make 1000000000, then minus 1 make first bit to i-1 bit to be 1111111;
		int right = ((1 << i) - 1);
		System.out.println("right: " + AssortedMethods.toFullBinaryString(right));
		// combine left and right to be 1111110000000111111111
		int mask = left | right;
		System.out.println("mask: " + AssortedMethods.toFullBinaryString(mask));
		// make int n from i to j to be 0s by and then together to make the mask
		int nWith0s = n & mask;
		System.out.println("nWith0s: " + AssortedMethods.toFullBinaryString(nWith0s));	
		// left shift m j times to make it match with the j to i empty position
		int mShifted = m << i;
		System.out.println("mShifted: " + AssortedMethods.toFullBinaryString(mShifted));
		// insert m into n by or them together
		return mShifted | nWith0s;
	}
	
	public static void main(String[] args) {
		int a = ~23423;
		System.out.println(AssortedMethods.toFullBinaryString(a));
		int b = 5;
		System.out.println(AssortedMethods.toFullBinaryString(b));		
		int c = updateBits(a, b, 29, 31);
		System.out.println(AssortedMethods.toFullBinaryString(c));
	}
}
