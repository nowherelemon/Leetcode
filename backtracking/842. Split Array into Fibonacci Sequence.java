/*
iven a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].

Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:

0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
F.length >= 3;
and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.

Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.

Example 1:

Input: "123456579"
Output: [123,456,579]
Example 2:

Input: "11235813"
Output: [1,1,2,3,5,8,13]
Example 3:

Input: "112358130"
Output: []
Explanation: The task is impossible.
Example 4:

Input: "0123"
Output: []
Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not valid.
Example 5:

Input: "1101111"
Output: [110, 1, 111]
Explanation: The output [11, 0, 11, 11] would also be accepted.

*/



class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        String num = S;
        int n = num.length();
        List<Integer> list = new ArrayList<> ();
        for (int i = 1; i <= (n - 1) / 2; i++) {
            if (num.charAt(0) == '0' && i >= 2) {
                break;
            }
            long first = Long.parseLong(num.substring(0, i));
            if (first > Integer.MAX_VALUE) {
                break;
            }
            list.add((int)first);
            for (int j = i + 1; n - j >= j - i && n - j >= i; j++ ) {
                if ((j - i) > 1 && num.charAt(i) == '0') {
                    break;
                } 
                long second = Long.parseLong(num.substring(i, j));
                if (second > Integer.MAX_VALUE) {
                    break;
                }
                String next = num.substring(j);
                if (next.length() < 1) {
                    break;
                }
                list.add((int) second);
                if (isValid(first, second, next, list)) {
                    return list;
                }
                list.remove(1);
            }
            list.remove(0);
        }
        return list;
    }
    
    private boolean isValid(long s1, long s2, String num, List<Integer> list) {
        if (num.length() < 1) {
            return true;
        }
        long sum = s1 + s2;
        if (sum > Integer.MAX_VALUE) {
            return false;
        }
        if (!num.startsWith(String.valueOf(sum))) {
            return false;
        }
        list.add((int) sum);
        if (isValid(s2, sum, num.substring(String.valueOf(sum).length()),list)) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }

}
