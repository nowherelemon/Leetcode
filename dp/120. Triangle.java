/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() < 1) return 0;
        int[] dp = new int[triangle.size()];
        
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            int[] tmp = new int[dp.length];
            tmp[0] = list.get(0) + dp[0];
            tmp[list.size() - 1] = dp[list.size() - 2] + list.get(list.size() - 1);
            for (int j = 1; j < list.size() - 1; j++) {
                tmp[j] = list.get(j) +  Math.min(dp[j - 1], dp[j]);
            }
            dp = tmp;
        }
        int min = dp[0];
        for (int i = 1; i < dp.length; i++) {
            //System.out.println(dp[i]);
            min = Math.min(dp[i], min);
        }
        
        return min;
    }
}
