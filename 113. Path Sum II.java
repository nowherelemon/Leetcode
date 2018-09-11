/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<> ();
        
        if (root == null) return res;
        
        helper(res, root, new ArrayList<Integer> (), 0, sum);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, TreeNode cur, List<Integer> list, int val, int target) {
        if (cur.left == null && cur.right == null && cur.val + val == target) {
            List<Integer> p = new ArrayList<Integer> (list);
            p.add(cur.val);
            res.add(p);
            return;
        } 
        list.add(cur.val);
        if (cur.left != null) {
            helper(res, cur.left, list, val + cur.val, target);
        }
        if (cur.right != null) {
            helper(res, cur.right, list, val + cur.val, target);
        }
        list.remove(list.size() - 1);
        
    }
}
