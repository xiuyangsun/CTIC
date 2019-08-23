package CH01.Q1_4;

public class Tester {

	
	public static void main(String[] args) {
		String[] strings = {"Rats live on no evil star",
							"A man, a plan, a canal, panama",
							"Lleve",
							"Tacotac",
							"asda",
							"a, a, b. b. c. a.a",
							"a,  a, b. b. c. a.a"};
		for (String s : strings) {
			boolean a = QuestionA.isPermutationOfPalindrome(s);
			System.out.println(s);
			if (a) {
				System.out.println("Agree: " + a);
			} else {
				System.out.println("Disagree: " + a);
			}
			System.out.println();
		}

	}

}
