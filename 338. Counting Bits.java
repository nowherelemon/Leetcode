//Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.


class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        if (num == 0) return dp;
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
