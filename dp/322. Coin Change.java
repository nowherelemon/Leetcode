/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
*/


class Solution {
    Map<Integer, Integer> map = new HashMap<> ();
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        int min = amount + 1;
        for (int coin : coins) {
            int cur = 0;
            if (coin <= amount) {
                int next = coinChange(coins, amount - coin);
                if (next >= 0) {
                    cur = next + 1;
                }
            }
            if (cur > 0) {
                min = Math.min(cur, min);
            }
        }
        min = (min == amount + 1) ? -1 : min; 
        map.put(amount, min);
        return min;
    }
}
