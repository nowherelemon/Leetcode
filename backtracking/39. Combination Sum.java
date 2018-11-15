/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<> ();
        List<Integer> list = new ArrayList<> ();
        helper(res, list, candidates, target, 0, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int sum, int pos) {
        if (sum == target) {
            res.add(new ArrayList<> (list));
            return;
        }
        if (pos == candidates.length) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                list.add(candidates[i]);
                helper(res, list, candidates, target, sum + candidates[i], i);
                list.remove(list.size() - 1);
            }
        }
    }
}
