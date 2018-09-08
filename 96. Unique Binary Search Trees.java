//Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        if (n < 2) return 1;
        dp[0] = 1;
        dp[1] = 1;
        //dp[2] = 2;
        
        for (int i = 2; i <= n; i++) {
            for (int k = 0; k < i; k++) {
                dp[i] += dp[k] * dp[i - k - 1];
            }
        }
        return dp[n];
    }
}
