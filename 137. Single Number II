//Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.


//refer to post: https://leetcode.com/problems/single-number-ii/discuss/43295/Detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers


class Solution {
    public int singleNumber(int[] nums) {
        int x1 = 0;
        int x2 = 0;
        int mask = 0;
        for (int n : nums) {
            x2 ^= x1 & n;
            x1 ^= n;
            mask = ~(x1 & x2);
            x1 &= mask;
            x2 &= mask;
        }
        return x1;
    }
}
