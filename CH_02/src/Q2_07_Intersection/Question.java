package Q2_07_Intersection;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Question {
	
	public static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
		LinkedListNode runner1 = list1;
		LinkedListNode runner2 = list2;
		
		int length1 = 0;
		int length2 = 0;
		
		while (runner1 != null) {
			runner1 = runner1.next;
			length1++;
		}
		
		while (runner2 != null) {
			runner2 = runner2.next;
			length2++;
		}
		
		LinkedListNode l1 = list1;
		LinkedListNode l2 = list2;
		
		if (length1 > length2) {
			while(length1 >length2) {
				l1 = l1.next;
				length1--;
			}
		} else if (length1 < length2) {
			while (length1 < length2) {
				l2 = l2.next;
				length2--;
			}
		}
		while(l1 != null && l2 != null) {
			if (l1.data == l2.data && l1.next == l2.next) {
				return l1;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		return new LinkedListNode();
	}
	
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
		LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);
		
		int[] vals2 = {12, 14, 15};
		LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);
		
		list2.next.next = list1.next.next.next.next;
		
		System.out.println(list1.printForward());
		System.out.println(list2.printForward());
		
		
		LinkedListNode intersection = findIntersection(list1, list2);
		
		System.out.println(intersection.printForward());
	}

}
