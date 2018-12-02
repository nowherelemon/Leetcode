/*

There are N dominoes in a line, and we place each domino vertically upright.

In the beginning, we simultaneously push some of the dominoes either to the left or to the right.



After each second, each domino that is falling to the left pushes the adjacent domino on the left.

Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.

Return a string representing the final state. 

Example 1:

Input: ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."
Example 2:

Input: "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.


*/





//keep track of last pos of L & R





class Solution {
    public String pushDominoes(String dominoes) {
        char[] sc = dominoes.toCharArray();
        int L = -1;
        int R = -1;
        for (int i = 0; i <= sc.length; i++) {
            if (i == sc.length || sc[i] == 'R') {
                if (R > L) {
                    while (R < i) {
                        sc[R++] = 'R';
                    }
                } else {
                    R = i;
                   continue; 
                }
            } else if (sc[i] == 'L') {
                if (L > R || (L == -1 && R == -1)) {
                    while (++L < i) {
                        sc[L] = 'L';
                    }
                } else {
                    int l = i - 1;
                    int r = R + 1;
                    while (r < l) {
                        sc[r++] = 'R';
                        sc[l--] = 'L';
                    }
                    L = i;
                }
            }
        }
        return new String(sc);
    }
}
