// No.98

package binarySearchTree;

public class ValidateBST {
	public static boolean isValidBST(TreeNode root) {
		return assist(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public static boolean assist(TreeNode root, long minVal, long maxVal) {
		if (root == null) {
			return true;
		}
		if (root.val >= maxVal || root.val <= minVal) {
			return false;
		}
		return assist(root.left, minVal, root.val)
				&& assist(root.right, root.val, maxVal);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(7);
		System.out.println(isValidBST(root));
	}

}
