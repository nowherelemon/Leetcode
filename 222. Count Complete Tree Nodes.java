/*
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        int h = getHeight(root);
        return h < 0 ? 0 : getHeight(root.right) == h - 1 ? (1 << h) + countNodes(root.right) : (1 << h - 1) + countNodes(root.left);
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + getHeight(root.left);
    }
}
