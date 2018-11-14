/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/


//backtracking, consider the case for 5 5 5 5 5








class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<> ();
        List<Integer> list = new ArrayList<> ();
        helper(res, list, nums, 0);
        return res;
    }
    
    private void helper (List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        if (start <= nums.length) {
            res.add(new ArrayList<> (list));
        }
        int i = start;
        while (i < nums.length) {
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
            i++;
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
    }
    
    
}
