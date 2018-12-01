/*
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
*/


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] ct = new int[26];
        int l1 = s1.length();
        int l2 = s2.length();
        
        if (l2 < l1) return false;
        for (int i = 0; i < l1; i++) {
            ct[s1.charAt(i) - 'a']++;
            ct[s2.charAt(i) - 'a']--;
        }
        if (allZero(ct)) {
            return true;
        }
        
        for (int i = l1; i < l2; i++) {
            ct[s2.charAt(i) - 'a']--;
            ct[s2.charAt(i - l1) - 'a']++;
            if (allZero(ct)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean allZero(int[] ct) {
        for (int n : ct) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}
