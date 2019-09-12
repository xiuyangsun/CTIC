package Q8_11_Coins;

public class Question {	
	
	public static int makeChange(int amount) {
		if (amount < 0) {
			return 0;
		} else if(amount == 0) {
			return 1;
		} else {
			return makeChange(amount - 1) + 
					 makeChange(amount - 5) + 
					 makeChange(amount - 10) + 
					 makeChange(amount - 25);
		}
	}
	
	public static void main(String[] args) {
		int ways = makeChange(10);
		System.out.println(ways);
	}

}