package Q4_08_First_Common_Ancestor;

import CtCILibrary.TreeNode;
// Remove the depth different between the two nodes and keep get the upper level
// if there is intersect return the first intersect
// if no intersect return null;
public class Question {
	public static int depth(TreeNode n) {
		int depth = 0;
		while(n != null) {
			n = n.parent;
			depth++;
		}
		return depth;
	}
	
	public static TreeNode getUpperNode (TreeNode n, int diff) {
		while(n != null && diff > 0) {
			n = n.parent;
			diff--;
		}
		return n;
	}
	public static TreeNode commonAncestor(TreeNode p, TreeNode q) {
		int diff = depth(p) - depth(q);
		TreeNode firsTreeNode = diff >= 0 ? q : p;
		TreeNode secondTreeNode = diff >= 0 ? p: q;
		secondTreeNode = getUpperNode(secondTreeNode, Math.abs(diff));
		
		while(firsTreeNode != null && secondTreeNode != null && firsTreeNode != secondTreeNode) {
			firsTreeNode = firsTreeNode.parent;
			secondTreeNode = secondTreeNode.parent;
		}
		return firsTreeNode == null || secondTreeNode == null ? null : firsTreeNode;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n1 = root.find(1);
		TreeNode n7 = root.find(7);
		TreeNode ancestor1 = commonAncestor(n1, n7);
		System.out.println("1, 7 lowest common ancestor is: " + ancestor1.data);
		TreeNode n6 = root.find(6);
		TreeNode n8 = root.find(8);
		TreeNode ancestor2 = commonAncestor(n6, n8);
		System.out.println("6, 8 lowest common ancestor is: " + ancestor2.data);
	}

}
