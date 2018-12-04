/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 
Explanation: The first 3 pairs are returned from the sequence: 
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]
Explanation: The first 2 pairs are returned from the sequence: 
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]

*/


class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length < 1 || nums2.length < 1) return new ArrayList<int[]> ();
        List<int[]> res = new ArrayList<> ();
        PriorityQueue<int[]> pq = new PriorityQueue<> ((a, b) -> a[0] + a[1] - b[0] - b[1]);
        
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[] {nums1[i], nums2[0], 0});
        }
        int i = 0;
        while (i++ < k && !pq.isEmpty()) {
            int[] cur = pq.poll();
            res.add(new int[] {cur[0], cur[1]});
            
            if (cur[2] == nums2.length - 1) {
                continue;
            }
            pq.offer(new int[] {cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }
}
