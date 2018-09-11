/*

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }
    
    private TreeNode helper(int postIndex, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (postIndex < 0) return null;
        if (inStart > inEnd) return null;
        
        int val = postorder[postIndex];
        TreeNode root = new TreeNode(val);
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        root.right = helper(postIndex - 1, index + 1, inEnd, inorder, postorder);
        root.left = helper(postIndex - inEnd + index - 1, inStart, index - 1, inorder, postorder);
        
        return root;
    }
}
