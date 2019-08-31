package Q3_02_Stack_Min;

import java.util.EmptyStackException;
import java.util.Stack;
// Use a second stack to keep track the minimum value in the stack
// When push, check if the new value is smaller than or equal to the min peek
// When pop, check if the removed value equals the min peek
public class StackWithMin2 {
	Stack<Integer> valueStack; Stack<Integer> min;
	
	public StackWithMin2() {
		valueStack = new Stack<Integer>();
		min = new Stack<Integer>();
		min.push(Integer.MAX_VALUE);
	}
	
	public void push (int value) {
		valueStack.push(value);
		if (min.peek() >= value) {
			min.push(value);
		}
	}
	
	public int pop () {
		int result = valueStack.pop();
		if (result == min.peek()) {
			min.pop();
		}
		return result;
	}
	
	public int peek () {
		return valueStack.peek();
	}
	
	public int min () {
		if (valueStack.peek() == null) {
			throw new EmptyStackException();
		}
		return min.peek();
	}
}


