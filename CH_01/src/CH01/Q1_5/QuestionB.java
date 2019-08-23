package CH01.Q1_5;

public class QuestionB {	
// Combine the two situation together.
	public static boolean oneEditAway(String first, String second) {
		if (Math.abs(first.length() - second.length()) > 1 )
			return false;
		
		String s1 = first.length() <= second.length() ? first : second;
		String s2 = first.length() <= second.length() ? second : first;
		boolean hasDiff = false;
		int index1 = 0, index2 = 0;
		while (index1 < s1.length() && index2 < s2.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (hasDiff)
					return false;
				hasDiff = true;
				if (s1.length() != s2.length()) {
					index2++;
				} else { 
					index1++;
					index2++;
				}
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		String a = "paele";
		String b = "pale";
		boolean isOneEdit1 = oneEditAway(a, b);
		System.out.println(a + ", " + b + ": " + isOneEdit1);

		String c = "pale";
		String d = "pkle";
		boolean isOneEdit2 = oneEditAway(c, d);
		System.out.println(c + ", " + d + ": " + isOneEdit2);
	}

}
