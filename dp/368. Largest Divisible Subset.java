/*
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
*/

//take care when constructing the results

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length < 1) return new ArrayList<Integer> ();
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 1;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        max = nums[index];
        List<Integer> res = new ArrayList<> ();
        int ct = dp[index];
        
        for (int i = index; i >= 0; i--) {
            if (max % nums[i] == 0 && dp[i] == ct) {
                max = nums[i];
                ct--;
                res.add(nums[i]);
            }
        }
        return res;
    }
}
