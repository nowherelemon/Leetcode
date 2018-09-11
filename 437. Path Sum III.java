/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
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
    int ct = 0;
    public int pathSum(TreeNode root, int sum) {

        Map<Integer, Integer> map = new HashMap<> ();
        map.put(0, 1);
        helper(root, map, 0, sum);
        
        return ct;
    }
    
    private void helper(TreeNode root, Map<Integer, Integer> map, int cur, int target) {
        if (root == null) return;
        cur += root.val;
        if (map.containsKey(cur - target)) {
            ct += map.get(cur - target);
        }
        
        
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        
        helper(root.left, map, cur, target);
        helper(root.right, map, cur, target);
        
        map.put(cur, map.get(cur) - 1);
    }
}
