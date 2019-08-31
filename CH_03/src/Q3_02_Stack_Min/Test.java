package Q3_02_Stack_Min;

public class Test {
	public static void main(String [] args) {
		StackWithMin2 stackWithMin2 = new StackWithMin2();
		
		stackWithMin2.push(2);
		System.out.println(stackWithMin2.min());
		stackWithMin2.push(1);
		System.out.println(stackWithMin2.min());
		stackWithMin2.push(5);
		System.out.println(stackWithMin2.min());
		stackWithMin2.push(3);
		System.out.println(stackWithMin2.min());
		stackWithMin2.push(1);
		System.out.println(stackWithMin2.min());
		stackWithMin2.pop();
		System.out.println(stackWithMin2.min());
	}
}
