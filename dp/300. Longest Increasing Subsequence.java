/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
*/

/* This is a classic algorithm, we start from the very beginning of the array, everytime we meet a new number, we try to find the right place
to insert: replace this number of the number that just bigger than it. If it is the largest one, we can increase the length

class Solution {
    public int lengthOfLIS(int[] nums) {
        int size = 0;
        int[] res = new int[nums.length];
        for (int n : nums) {
            int m = Arrays.binarySearch(res, 0, size, n);
            if (m < 0) m = -(m + 1);
            if (m == size) {
                size++;
            }
            res[m] = n;
        }
        return size;
    }
}
