/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Now your job is to find the total Hamming distance between all pairs of the given numbers.
*/


class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] ones = new int[31];
        int[] zeros = new int[31];
        for (int i = 0; i < ones.length; i++) {
            for (int n : nums) {
                int bit = (n >>> i) & 1;
                if (bit == 1) {
                    ones[i]++;
                } else {
                    zeros[i]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < ones.length; i++) {
            res += ones[i] * zeros[i];
        }
        return res;
    }
}
