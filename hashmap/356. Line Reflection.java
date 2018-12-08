/*
Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

Example 1:

Input: [[1,1],[-1,1]]
Output: true
Example 2:

Input: [[1,1],[-1,-1]]
Output: false
Follow up:
Could you do better than O(n2) ?
*/


class Solution {
    public boolean isReflected(int[][] points) {
       Set<String> set = new HashSet<> ();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int[] p : points) {
            set.add(p[0] + "a" + p[1]);
            max = Math.max(max, p[0]);
            min = Math.min(min, p[0]);
        }
        int sum = max + min;
        for (int[] p : points) {
            int x = sum - p[0];
            String s = x + "a" + p[1];
            if (!set.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
