package Library;


public class TreeNode {
	public int data;      
	public TreeNode left;    
	public TreeNode right; 
	public TreeNode parent;
	private int size = 0;

	public TreeNode(int d) {
		data = d;
		size = 1;
	}
	
	private void setLeftChild(TreeNode left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}
	
	private void setRightChild(TreeNode right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}
	
	public int size() {
		return size;
	}
//	Take the middle value from the array to be the root of the tree, 
//	then to the second level, take the middle of first half to be left , middle of second half to be right
//	follow the pattern to the end.
	public static TreeNode createMinimalBST(int[] array) {
		return createMinimalBST(array, 0, array.length - 1);
	}
	
	public static TreeNode createMinimalBST(int[] array, int start, int end) {
		if (start < end) {
			return null;
		}
		
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(array[mid]);
		node.left = createMinimalBST(array, start, mid - 1);
		node.right = createMinimalBST(array, mid + 1, end);
		
		return node;
	}
// DFS loop to the last leaf of left branch then the right branch
	public boolean isBST () {
		if (left != null) {
			if (data < left.data || !left.isBST()) {
				return false;
			}
		}
		
		if (right != null) {
			if (data > right.data || !right.isBST()) {
				return false;
			}
		}
		
		return true;
	}
// DFS loop to the last leaf of left branch then the right branch
	public int height () {
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}
}
