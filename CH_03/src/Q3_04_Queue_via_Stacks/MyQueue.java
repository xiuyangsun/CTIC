package Q3_04_Queue_via_Stacks;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MyQueue<T> {
	Stack<T> stackNewest, stackOldest;
	int count = 0;
	
	public MyQueue() {
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}
	
	public int size() {
		return count;
	}
	
	public void add(T value) {
		count++;
		stackNewest.push(value);
	}
	
	private void shiftStacks() {
		if (stackOldest.isEmpty()) { 
			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public T peek() {
		if (isEmpty()) {
			return null;
		}
		shiftStacks();
		return stackOldest.peek();
	} 
	
	public T remove() {
		if (isEmpty()) {
			return null;
		}
		count--;
		shiftStacks();
		return stackOldest.pop();
	}
	
	private boolean isEmpty() {
		return stackNewest.isEmpty() && stackOldest.isEmpty();
	}
	
	public T element () {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		shiftStacks();
		return stackOldest.peek();
	}
	
	public T poll () {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		count--;
		shiftStacks();
		return stackOldest.pop();
	}
}
