/*
Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0 
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.
*/




//sort and binary search






class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        if (n < 1 || k > n * (n - 1)) return 0;
        Arrays.sort(nums);
        
        int l = 0;
        int r = nums[n - 1] - nums[0];

        for (int ct = 0; l < r; ct = 0) {
        	int m = (r - l) / 2 + l;
        	for (int i = 0, j = 0; i < n; i++) {
        		while (j < n && nums[j] <= nums[i] + m) {
        			j++;
        		}
        		ct += j - i - 1;
        	}
        	if (ct < k) {
        		l = m + 1;
        	} else {
        		r = m;
        	}
        }
        return l;
    }
}
