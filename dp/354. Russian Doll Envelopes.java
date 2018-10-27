/*
You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Note:
Rotation is not allowed.

Example:

Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3 
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
*/

//sort and then longest increasing subsequence

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length < 1 || envelopes[0].length < 1) return 0;
        Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] nums = new int[envelopes.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = envelopes[i][1];
        }
        int size = 0;
        int[] arr = new int[nums.length];
        for (int n : nums) {
            int m = Arrays.binarySearch(arr, 0, size, n);
            if (m < 0) {
                m = - (m + 1);
            }
            if (m == size) {
                size++;
            }
            arr[m] = n;
        }
        return size;
    }
}
