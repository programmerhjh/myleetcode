package myleetcode;

import entity.TreeNode;

/**
 * 二叉树的最大深度
 * 递归（思维从递归尽头开始思考）
 * @author acer
 *
 */
public class MaximumDepthOfBinaryTree {
	
    public int maxDepth(TreeNode root) {
    	if(root == null)
    		return 0;
    	return 1 + Math.max(maxDepth(root.left), maxDepth(root.right)); 
    }
	
}
