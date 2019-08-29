package Q2_04_Partition;

import java.time.chrono.MinguoChronology;

import CtCILibrary.LinkedListNode;
import sun.font.CreatedFontTracker;

public class Question {
// Create two sub Linked list , on with nodes' value less than x, and the other containing the rest nodes
// Connect the two list.
	public static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode less = null;
		LinkedListNode rest = null;
		
		while(node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				node.next = less;
				less = node;
			} else {
				node.next = rest;
				rest = node;
			}
			node = next;
		}
		if (less == null) {
			return rest;
		}
		LinkedListNode head = less;
		while(less.next != null) {
			less = less.next;
		}
		less.next = rest;
		
		return head;
	}
	
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {33,9,2,3,10,10389,838,874578,5};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		System.out.println(head.printForward());
		
		/* Partition */
		LinkedListNode h = partition(head, 3);
		
		/* Print Result */
		System.out.println(h.printForward());
	}

}
