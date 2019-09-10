package Q5_03_Flip_Bit_to_Win;

import java.util.ArrayList;

public class QuestionB {
//	break the n binary String in to separate sequences
//	put the length of each sequences into an array
//	Loop through the array to check 0s adjacent 1s to find the longest sequence
	
	public static int longestSequence(int n) {
		if (n == -1) 
			return 32;
		if (n == 0)
			return 1;
		ArrayList<Integer> sequences = getAlternatingSequences(n);
		return findLongestSequence(sequences);
	}	
	
	// Start with 0s, so the first element in the sequence is the number of 0s(could be 0)
	// Reason to do this is to fix the consequence of 0s 1s 0s 1s...
	public static ArrayList<Integer> getAlternatingSequences(int n) {
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		int current = 0;
		int count = 0;
		for(int i = 0; i < 32; i++) {
			if ( (n & 1) != current) {
				sequence.add(count);
				current = n & 1;
				count = 0;
			}
			count++;
			n >>>= 1;
		}
		sequence.add(count);
		
		return sequence;
		
	}
	public static int findLongestSequence(ArrayList<Integer> seq) {
		int maxSeq = 1;
		// The 0s 1s order is fixed when the sequence was formed
		for (int i = 0; i < seq.size(); i += 2) {
			int zerosSeq = seq.get(i);
			int onesSeqPrev = i - 1 >= 0 ? seq.get(i - 1) : 0;
			int onesSeqNext = i + 1 < seq.size() ? seq.get(i + 1) : 0;
			
			int thisSeq = 0;
			if (zerosSeq == 1) { // Can merge
				thisSeq = onesSeqNext + 1 + onesSeqPrev; 
			} else if (zerosSeq > 1) { // Just add a one to either side
				thisSeq = 1 + Math.max(onesSeqPrev, onesSeqNext);
			} else if (zerosSeq == 0) { // No zero, but take either side
				thisSeq = Math.max(onesSeqPrev, onesSeqNext);
			}
			maxSeq = Math.max(thisSeq, maxSeq);
		}
		
		return maxSeq;
	}	
	
	public static void main(String[] args) {
		int original_number = 1775;
		int new_number = longestSequence(original_number);
			
		System.out.println(Integer.toBinaryString(original_number));
		System.out.println(new_number);
	}

}
