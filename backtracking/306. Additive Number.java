/*
Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Example 1:

Input: "112358"
Output: true 
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true 
Explanation: The additive sequence is: 1, 99, 100, 199. 
             1 + 99 = 100, 99 + 100 = 199
Follow up:
How would you handle overflow for very large input integers?
*/



//isValid



class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= (n - 1) / 2; i++) {
            if (num.charAt(0) == '0' && i >= 2) {
                return false;
            }
            long first = Long.parseLong(num.substring(0, i));
            for (int j = i + 1; n - j >= j - i && n - j >= i; j++ ) {
                if ((j - i) > 1 && num.charAt(i) == '0') {
                    break;
                } 
                long second = Long.parseLong(num.substring(i, j));
                String next = num.substring(j);
                if (isValid(first, second, next)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isValid(long s1, long s2, String num) {
        if (num.length() < 1) {
            return true;
        }
        long sum = s1 + s2;
        if (!num.startsWith(String.valueOf(sum))) {
            return false;
        }
        return isValid(s2, sum, num.substring(String.valueOf(sum).length()));
    }
}
