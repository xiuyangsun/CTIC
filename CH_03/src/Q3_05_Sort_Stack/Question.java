package Q3_05_Sort_Stack;

import java.util.Stack;

import CtCILibrary.AssortedMethods;

public class Question {
	public static void pushToHelper (Stack<Integer> origin, Stack<Integer> helper) {
		while (!origin.isEmpty()) {
			int temp = origin.pop();
			if (helper.isEmpty()) {
				helper.push(temp);
			} else {
				while (!helper.isEmpty() && helper.peek() > temp ) {
					origin.push(helper.pop());
				}
				helper.push(temp);
				while (!origin.isEmpty() && origin.peek() >= helper.peek()) {
					helper.push(origin.pop());
				}
			}
		}
	}
	
	public static void pushBack (Stack<Integer> origin, Stack<Integer> helper) {
		while (!helper.isEmpty()) {
			origin.push(helper.pop());
		}
	}
		
	
	public static void sort(Stack<Integer> s) {
		Stack<Integer> helper = new Stack<Integer>();
		pushToHelper(s, helper);
		pushBack(s, helper);					
	}
		
	public static void main(String [] args) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			int r = AssortedMethods.randomIntInRange(0,  1000);
			s.push(r);
		}
		
		sort(s);
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
}
