package binaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		assist(root, res);
		return res;
	}

	private static void assist(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		assist(root.left, res);
		res.add(root.val);
		assist(root.right, res);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		List<Integer> res = inorderTraversal(root);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(" " + res.get(i) + " ");
		}
	}

}
