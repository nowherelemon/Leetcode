/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.


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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
       if (root == null) return 0;
        
        helper(root, 0);
        
        return sum;
    }
    
    private void helper(TreeNode root, int n) {
        if (root.left == null && root.right == null) {
            sum += (root.val + n * 10);
            return;
        }
        if (root.left != null) {
            helper(root.left, n * 10 + root.val);
        }
        if (root.right != null) {
            helper(root.right, n * 10 + root.val);
        }
        
    }
}
