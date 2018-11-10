/*
Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
*/

//you can think it is we have 1 - n-1 already, based on this, for n, we need to append a number in the given array to satify the sum is n




class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums.length < 1) return 0;
        if (target < 0) return 0;
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (n > i) {
                    continue;
                } else if (n == i) {
                    dp[i]++;
                } else if (n < i) {
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];
    }
}
