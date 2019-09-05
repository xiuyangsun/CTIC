package Q4_03_List_of_Depths;

import CtCILibrary.*;
import Library.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class QuestionBFS {
	
	public static ArrayList<LinkedList<TreeNode>> createLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if (root != null) {
			current.add(root);
		}
		while (current.size() > 0) {
			lists.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for(TreeNode node: parents) {
				if (node.left != null) {
					current.add(node.left);
				}
				
				if (node.right != null) {
					current.add(node.right);
				}
			}
		}
		return lists;
	}
	
	
	

	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);
	}

}
