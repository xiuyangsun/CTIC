package Q2_06_Palindrome;

import CtCILibrary.LinkedListNode;

public class QuestionA {
	public static LinkedListNode getReversedList (LinkedListNode head) {
		LinkedListNode reverse = null;
		
		while(head != null) {
			LinkedListNode n = new LinkedListNode(head.data);
			n.next = reverse;
			reverse = n;
			head = head.next;
		}
		return reverse;
	}
	
	public static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode reverse = getReversedList(head);

		while(reverse != null || head != null) {
			if(reverse ==null || head == null || reverse.data != head.data) {
				return false;
			}
			reverse = reverse.next;
			head = head.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int length = 9;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}
		
		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		// nodes[length - 2].data = 9; // Uncomment to ruin palindrome
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		System.out.println(isPalindrome(head));
	}

}
