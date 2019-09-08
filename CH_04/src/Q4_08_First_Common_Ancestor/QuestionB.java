package Q4_08_First_Common_Ancestor;

import CtCILibrary.TreeNode;

// Go from root node down
// if root has p and q, check root.left and root.right
// take the branch that has p and q and keep looping down;
// time is n/2 + n/4 + n/8...  o(n)
public class QuestionB {
	
	public static boolean checkExist (TreeNode root, TreeNode a) {
		if (root == null) {
			return false;
		}
		if (root == a) {
			return true;
		}
		
		
		return checkExist(root.left, a) || checkExist(root.right, a);
	}
	
	public static boolean hasPandQ (TreeNode root, TreeNode p, TreeNode q) {
		return checkExist(root, p) && checkExist(root, q);
	}
	
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while(hasPandQ(root, p, q)) {
			if (hasPandQ(root.left, p, q)) {
				root = root.left;
			} else if (hasPandQ(root.right, p, q)) {
				root = root.right;
			} else {
				break;
			}
		}
		return root;
	}	
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(2);
		TreeNode n7 = root.find(8);
		TreeNode ancestor = commonAncestor(root, n3, n7);
		System.out.println(ancestor.data);
	}

}
