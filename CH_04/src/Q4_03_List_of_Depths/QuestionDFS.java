package Q4_03_List_of_Depths;

import Library.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import CtCILibrary.AssortedMethods;

public class QuestionDFS {

	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		createLinkedList(result, root, 0);
		return result;
	}
	
	public static void createLinkedList(ArrayList<LinkedList<TreeNode>> lists, TreeNode node, int level) {
		if (node == null) {
			return;
		}
		
		LinkedList<TreeNode> list = null;
		
		if (lists.size() == level) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else {
			lists.get(level);
		}
		
		list.add(node);
		createLinkedList(lists, node.left, level + 1);
		createLinkedList(lists, node.right, level + 1);
	}
	

	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		CtCILibrary.TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);
	}

}
