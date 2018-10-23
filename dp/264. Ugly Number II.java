/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.

*/

class Solution {
    public int nthUglyNumber(int n) {
        int n2 = 0;
        int n3 = 0;
        int n5 = 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int c2 = res[n2] * 2;
            int c3 = res[n3] * 3;
            int c5 = res[n5] * 5;
            int min = Math.min(c2, Math.min(c3, c5));
            res[i] = min;
            if (c2 == min) {
                n2++;
            }
            if (c3 == min) {
                n3++;
            }
            if (c5 == min) {
                n5++;
            }
        }
        return res[n - 1];
    }
}
