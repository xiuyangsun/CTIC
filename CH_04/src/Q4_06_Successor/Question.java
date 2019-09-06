package Q4_06_Successor;

import CtCILibrary.TreeNode;
// For this question there are two situations
// 1. TreeNode n has a right branch, then n.next will be the most left leaf of its right branch
// 2. TreeNode n doesn't has a right branch, then there are another several situations in this one
//		1) n is a left leaf => n.parent.left == n, n.next == n.parent;
//      2) n is a right leaf => n.parent.parent.parent == n.next;
//		3) n is the most right leaf => n.next = null;
//
public class Question {

	public static TreeNode inorderSucc(TreeNode n) { 
		if (n == null) {
			return null;
		}
		
		if (n.right != null) {
			return findLeftMostChild(n.right);
		} else {
			TreeNode m = n;
			TreeNode o = m.parent;
			while(o != null && o.left != m) {
				m = o;
				o = o.parent;
			}
			return o;
		}
	}
	
	public static TreeNode findLeftMostChild (TreeNode root) {
		if (root == null) {
			return null;
		}
		
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = inorderSucc(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}

}
