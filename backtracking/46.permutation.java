/*

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<> ();
        int n = nums.length;
        boolean[] visited = new boolean[n];
        List<Integer> list = new ArrayList<> ();
        helper(nums, visited, res, list);
        return res;
    }
    
    private void helper(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            helper(nums, visited, res, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
