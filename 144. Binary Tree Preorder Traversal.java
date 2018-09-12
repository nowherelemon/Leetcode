//Given a binary tree, return the preorder traversal of its nodes' values.


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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<> ();
        List<Integer> res = new ArrayList<> ();
        if (root == null) return res;
        TreeNode node = root;
        while (node != null) {
            res.add(node.val);
            if (node.right != null) {
              st.push(node.right);  
            }
            if (node.left != null) {
                node = node.left;
            } else if (!st.isEmpty()) {
                node = st.pop();
            } else {
                node = null;
            }   
        }
        return res;
    }
}
