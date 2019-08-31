package Q3_02_Stack_Min;

import java.util.Stack;
// Use a NodeWirhMin object as the element put into Stack, every when push a value, find the min value to form the object
// and put the object into the stack.
public class StackWithMin extends Stack<NodeWithMin> {
    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }
    
    public int min() {
    	if (this.isEmpty()) {
    		return Integer.MAX_VALUE;
    	} else {
    		return peek().min;
    	}
    }
}
