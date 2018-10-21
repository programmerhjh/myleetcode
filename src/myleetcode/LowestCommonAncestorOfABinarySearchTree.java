package myleetcode;

import entity.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 * @author acer
 *
 */
public class LowestCommonAncestorOfABinarySearchTree {

	TreeNode res = null;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		lca(root, p, q);
		return res;
	}

	public void lca(TreeNode root, TreeNode p, TreeNode q) {
		if ((root.val - p.val) * (root.val - q.val) <= 0) {
			res = root;
		} else if (root.val < p.val && root.val < q.val) {
			lca(root.right, p, q);
		} else {
			lca(root.left, p, q);
		}
	}
}
