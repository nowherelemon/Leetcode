/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
*/


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<> ();
        
        for (int i = 0; i < k - 1; i++) {
            enqueue(q, nums[i]);
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            enqueue(q, nums[i]);
            res[i - k + 1] = q.peekFirst();
            dequeue(q, nums[i - k + 1]);
        }
        return res;
    }
    
    private void enqueue(Deque<Integer> q, int n) {
        while (!q.isEmpty() && q.peekLast() < n) {
            q.pollLast();
        }
        q.offer(n);
    }
    
    private void dequeue(Deque<Integer> q, int n) {
        if (q.peekFirst() == n) {
            q.pollFirst();
        }
    }
}
