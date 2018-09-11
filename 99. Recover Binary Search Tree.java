/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

*/



//make use of inorder


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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        
        if (first == null && root.val <= prev.val) {
            first = prev;
        } 
        if (first != null && root.val <= prev.val) {
            second = root;
        }
        
        prev = root;
        
        traverse(root.right);
    }
}
