/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/


class Solution {
    public int minCut(String s) {
        int n = s.length();
        char[] sc = s.toCharArray();
        int[] dp = new int[n];
        boolean[][] isPalidrome = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            int min = i; 
            for (int j = 0; j <= i; j++) {
                if (sc[i] == sc[j] && (j >= i - 1 || isPalidrome[j + 1][i - 1])) {
                    min = j == 0 ? 0 : Math.min(dp[j - 1] + 1, min);
                    isPalidrome[j][i] = true;
                }
            }
            dp[i] = min;
        }
        return dp[n - 1];
    }
}
