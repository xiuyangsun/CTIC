package Q3_03_Stack_of_Plates;

import java.util.ArrayList;
import java.util.EmptyStackException;
// Use ArrayList that with data level to be stack
public class StackOfPlates {
	ArrayList<Stack> stackOfPlates = new ArrayList<Stack>();
	public int stackSize;
	
	public StackOfPlates (int stackSize) {
		this.stackSize = stackSize;
	}
	//keep track of the number of number of stack elements and number of integers in the current stack
	int stackNum = 0;
	int numberInStack = 0;
	// Add a new stack element in to the arraylist
	public void addStack () {
		stackOfPlates.add(new Stack(stackSize));
		stackNum++;
		numberInStack = 0;
	}
	//Check if the current stack is full
	//if true add a new slack
	public void push (int value) {
		if (stackNum == 0 || numberInStack == stackSize) {
			addStack();
		}
		
		Stack currentStack = stackOfPlates.get(stackNum - 1);
		currentStack.push(value);
		numberInStack++;
	}
	// Check if the current stack is empty after pop value
	// if empty switch to the previous stack and change the stackNum and numberInStack
	public int pop() {
		if (stackNum == 0) {
			throw new EmptyStackException();
		}
		Stack currentStack = stackOfPlates.get(stackNum - 1);
		int result = currentStack.pop();
		numberInStack--;
		
		if (numberInStack == 0) {
			stackNum--;
			numberInStack = stackSize;
		}
		
		return result;
	}
}
