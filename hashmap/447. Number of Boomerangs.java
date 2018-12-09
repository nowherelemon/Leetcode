/*
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
*/


class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<> ();
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            
            for (int key : map.keySet()) {                
                res += (map.get(key) - 1) * map.get(key);
            }
            
            map.clear();
            
        }
        
       
        return res;
    }
}
