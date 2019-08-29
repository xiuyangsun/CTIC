package Q2_01_Remove_Dups;

import java.util.HashSet;
import java.util.Set;

import CtCILibrary.LinkedListNode;

public class QuestionA {
//	Use HashSet to check if a node already exist in the previous part of the list, if exist, skip it.
	public static void deleteDups(LinkedListNode n) {
		Set<Integer> set = new HashSet<>();
		LinkedListNode pre = null;;
		while(n != null) {
			if (set.contains(n.data)) {
				pre.next = n.next;
			} else {
				pre = n;
				set.add(n.data);
			}
			n = n.next;
		}
	}
	
	public static void main(String[] args) {	
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 2, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		deleteDups(head);
		System.out.println(head.printForward());
	}
}
