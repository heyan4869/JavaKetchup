package binaryTreeTraversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTreeLevelOrderTraversal {
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}
		Set<Integer> hs = new HashSet<Integer>();
		assist(root, 1, hs, res);
		return res;
	}

	private static void assist(TreeNode root, int level, Set<Integer> hs,
			List<List<Integer>> res) {
		if (root == null) {
			return;
		}
		if (!hs.contains(level)) {
			hs.add(level);
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(root.val);
			res.add(temp);
			assist(root.left, level + 1, hs, res);
			assist(root.right, level + 1, hs, res);
		} else {
			res.get(level - 1).add(root.val);
			assist(root.left, level + 1, hs, res);
			assist(root.right, level + 1, hs, res);
		}
		
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		List<List<Integer>> res = levelOrder(root);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> cur = res.get(i);
			for (int j = 0; j < cur.size(); j++) {
				System.out.print(" " + cur.get(j) + " ");
			}
			System.out.println();
		}

	}

}
