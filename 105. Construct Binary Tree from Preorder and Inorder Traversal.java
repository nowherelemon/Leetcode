/*
Given preorder and inorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    private TreeNode helper(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preIndex >= preorder.length) return null;
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        
        int preVal = preorder[preIndex];
        int index = -1;
        
        for (int i = inStart; i <= inEnd; i++) {
            if (preVal == inorder[i]) {
                index = i;
                break;
            }
        }
        root.left = helper(preIndex + 1, inStart, index - 1, preorder, inorder);
        root.right = helper(preIndex + index - inStart + 1, index + 1, inEnd, preorder, inorder);
        return root;
    }
}
