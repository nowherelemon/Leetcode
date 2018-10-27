/*

Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
             
*/

//dp[start][end] = max(dp[start][i - 1] + value[i] + dp[i + 1][end])

class Solution {
    public int maxCoins(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length < 2) return nums[0];
        int n = nums.length;
        int[] a = new int [n + 2];
        int[][] dp = new int[n + 2][n + 2];
        a[0] = 1;
        a[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            a[i] = nums[i - 1];
        }
        boolean[][] visited = new boolean[n + 2][n + 2];
        return dfs(1, n, a, visited, dp);
    }
    private int dfs(int start, int end, int[] a, boolean[][] visited, int[][] dp) {
        if (visited[start][end]) {
            return dp[start][end];
        }
        int res = 0;
        for (int k = start; k <= end; k++) {
            int left = dfs(start, k - 1, a, visited, dp);
            int mid = a[start - 1] * a[k] * a[end + 1];
            int right = dfs(k + 1, end, a, visited, dp);
            res = Math.max(res, left + mid + right);
        }
        visited[start][end] = true;
        dp[start][end] = res;
        return res;
    }
}

