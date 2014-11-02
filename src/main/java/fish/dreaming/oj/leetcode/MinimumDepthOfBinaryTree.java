/**
 * 
 */
package fish.dreaming.oj.leetcode;

/**
 * @author tao
 *
 */
public class MinimumDepthOfBinaryTree {

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return DFS(root);
	}

	private static int DFS(TreeNode node) {
		if (node.left == null && node.right == null) {
			return 1;
		}
		if (node.left != null && node.right == null) {
			return DFS(node.left) + 1;
		}
		if (node.left == null && node.right != null) {
			return DFS(node.right) + 1;
		}

		return Math.min(DFS(node.left), DFS(node.right)) + 1;

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
