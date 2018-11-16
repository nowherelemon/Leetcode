/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

*/



class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<> ();
        List<Integer> list = new ArrayList<> ();
        boolean[] visited = new boolean[candidates.length];
        helper(res, list, visited, candidates, target, 0, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, boolean[] visited, int[] nums, int target, int start, int sum)     {
        if (sum == target) {
            res.add(new ArrayList<> (list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            if (sum + nums[i] > target) {
                break;
            }
            list.add(nums[i]);
            visited[i] = true;
            helper(res, list, visited, nums, target, i + 1, sum + nums[i]);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
