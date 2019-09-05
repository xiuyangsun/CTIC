package Q4_05_Validate_BST;

import CtCILibrary.TreeNode;

public class Question {
	public static boolean checkBST(TreeNode node) {
		if (node == null) {
			return true;
		}
		boolean leftLess = true;
		boolean rightgreater = true;
		
		if (node.left != null) {
			leftLess = node.left.data <= node.data;
		}
		if (node.right != null) {
			rightgreater = node.right.data > node.data;
		}
		
		if (leftLess && rightgreater == false) {
			return false;
		} else {
			return checkBST(node.left) && checkBST(node.right);
		}
		
	}

	public static void main(String[] args) {
		int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
		TreeNode node = TreeNode.createMinimalBST(array);
		//node.left.data = 5;
		//node.left.right.data = 3;
		System.out.println(checkBST(node));

		test();
	}

	public static void test() {
		TreeNode node;
		boolean condition;
		System.out.println("test cases for equals condition.");

		/* Expect true: for left child: node.data <= last_printed.
   2
  / \
 /   \
 2   3
      \
      4
		*/
		int[] array2 = {1, 2, 3, 4};
		node = TreeNode.createMinimalBST(array2);
		node.left.data = 2;
		node.print();
		condition = checkBST(node);
		System.out.println("should be true: " + condition);

		/* Expect false: for right child: node.data <= last_printed.
   2
  / \
 /   \
 1   2
      \
      4
		 */
		int[] array3 = {1, 2, 3, 4};
		node = TreeNode.createMinimalBST(array3);
		node.right.data = 2;
		node.print();
		condition = checkBST(node);
		System.out.println("should be false: " + condition);
	}
}