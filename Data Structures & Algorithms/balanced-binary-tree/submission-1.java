/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        // Base case
        if (root == null) {
            return 0;
        }

        // Calculate left subtree height
        int leftHeight = getHeight(root.left);

        if (leftHeight == -1) {
            return -1;
        }

        // Calculate right subtree height
        int rightHeight = getHeight(root.right);

        if (rightHeight == -1) {
            return -1;
        }

        // Check if current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return height to parent
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
