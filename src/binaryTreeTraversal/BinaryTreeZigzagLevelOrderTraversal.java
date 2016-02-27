package binaryTreeTraversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}
		List<Integer> temp = new ArrayList<Integer>();
		Set<Integer> hs = new HashSet<Integer>();
		assist(root, 1, hs, 'l', temp, res);
		return res;
	}
	
	private static void assist(TreeNode root, int level, Set<Integer> hs, char dir,
			List<Integer> temp, List<List<Integer>> res) {
		if (root == null) {
			return;
		}
		if (!hs.contains(level)) {
			hs.add(level);
			List<Integer> cur = new ArrayList<Integer>();
			res.add(cur);
			res.get(level - 1).add(root.val);
		} else {
			// deal with the direction by adding to different index
			if (dir == 'l') {
				res.get(level - 1).add(root.val);
			} else {
				res.get(level - 1).add(0, root.val);
			}
		}
		if (dir == 'l') {
			assist(root.left, level + 1, hs, 'r', temp, res);
			assist(root.right, level + 1, hs, 'r', temp, res);
		} else {
			assist(root.left, level + 1, hs, 'l', temp, res);
			assist(root.right, level + 1, hs, 'l', temp, res);
		}
		
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		List<List<Integer>> result = zigzagLevelOrder(root);
		// System.out.println(root.right.val);
		System.out.println(result);
	}

}
