/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<> ();
        boolean[] visited = new boolean[nums.length];
        List<Integer> list = new ArrayList<> ();
        
        Arrays.sort(nums);
        helper(res, visited, nums, list);
        return res;
    }
    
    private void helper(List<List<Integer>> res, boolean[] visited, int[] nums, List<Integer> list) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<> (list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            helper(res, visited, nums, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
