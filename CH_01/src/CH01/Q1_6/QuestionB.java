package CH01.Q1_6;
// Use StringBuilder to do append operation.
public class QuestionB {	
	public static String compress(String str) {
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}
	
	public static void main(String[] args) {
		String str = "aa";
		System.out.println(str);
		System.out.println(compress(str));
	}
}
