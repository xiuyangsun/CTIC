package Q2_05_Sum_Lists;

import CtCILibrary.LinkedListNode;

public class QuestionA {	
	private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		int carry = l1.data + l2.data;
		LinkedListNode head = new LinkedListNode();
		head.data = carry % 10;
		carry = carry /10;
		LinkedListNode current = head;
		while (l1 != null || l2 != null) {
			int sum = carry;
			if (l1 != null) {
				sum += l1.data;
				l1 = l1.next;
			}
			
			if (l2 != null) {
				sum += l2.data;
				l2 = l2.next;
			}
			
			int value = sum % 10;
			carry = sum / 10;
			current.next = new LinkedListNode();
			current.next.data = value;
			current = current.next;
		}
		if (carry != 0) {
			current.next = new LinkedListNode();
			current.next.data = carry;
		}
		return head;
	}
	
	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		if (node.next != null) {
			value = 10 * linkedListToInt(node.next);
		}
		return value + node.data;
	}	
	
	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(9, null, null);
		LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(9, null, lA2);
		
		LinkedListNode lB1 = new LinkedListNode(1, null, null);
		LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(0, null, lB2);	
		
		LinkedListNode list3 = addLists(lA1, lB1);
		
		System.out.println("  " + lA1.printForward());		
		System.out.println("+ " + lB1.printForward());			
		System.out.println("= " + list3.printForward());	
		
		int l1 = linkedListToInt(lA1);
		int l2 = linkedListToInt(lB1);
		int l3 = linkedListToInt(list3);
		
		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));		
	}
}
