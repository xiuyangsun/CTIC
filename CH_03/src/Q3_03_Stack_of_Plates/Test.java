package Q3_03_Stack_of_Plates;

public class Test {
	public static void main (String[] args) {
		StackOfPlates stackOfPlates = new StackOfPlates(5);
		for (int i = 0; i < 34; i++) {
			stackOfPlates.push(i);
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		for (int i = 0; i < 20; i++) {
			System.out.println("Popped " + stackOfPlates.pop());
		}	
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		for (int i = 100; i < 110; i++) {
			stackOfPlates.push(i);
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		for (int i = 0; i < 20; i++) {
			System.out.println("Popped " + stackOfPlates.pop());
		}	
	}
}
