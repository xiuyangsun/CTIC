package Q4_11_Random_Node;

public class Question {

	public static void main(String[] args) {
		int[] counts = new int[10];
		for (int i = 0; i < 1000000; i++) {
			TreeNode root = new TreeNode(1);
			int[] array = {0, 6, 2, 3, 9, 4, 5, 8, 7};
			for (int x : array) {
				root.insertInOrder(x);
			}
			int d = root.getRandomNode().data;
			counts[d]++;
		}
		
		for (int i = 0; i < counts.length; i++) {
			System.out.println(i + ": " + counts[i]);
		}
	}

}
