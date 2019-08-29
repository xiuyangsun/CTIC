package Q2_02_Return_Kth_To_Last;

import java.util.concurrent.CountDownLatch;

import CtCILibrary.*;

public class QuestionA {
// Loop through the linked list and count the length of the linked list and calculate the index of the node from beginning
//	Loop through the list again and return the node at the index
	public static LinkedListNode printKthToLast(LinkedListNode head, int k) {
		LinkedListNode runner = head;
		int count = 0;
		while(runner != null) {
			runner = runner.next;
			count++;
		}
		int index = count - k;
		if (index < 0 || index > count) {
			return null;
		}
		
		 int newCount = 0;
		 while (newCount < index) {
			 head = head.next;
			 newCount++;
		 }
		 return head;
	}
	
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 4, 5, 6};
		LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
		for (int i = 0; i <= array.length + 1; i++) {
			LinkedListNode node = printKthToLast(head, i);
			String nodeValue = node == null ? "null" : "" + node.data;
			System.out.println(i + ": " + nodeValue);
		}
	}

}
