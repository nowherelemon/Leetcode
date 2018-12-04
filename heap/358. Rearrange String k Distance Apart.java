/*
Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:

Input: s = "aabbcc", k = 3
Output: "abcabc" 
Explanation: The same letters are at least distance 3 from each other.
Example 2:

Input: s = "aaabc", k = 3
Output: "" 
Explanation: It is not possible to rearrange the string.
Example 3:

Input: s = "aaadbbcc", k = 2
Output: "abacabcd"
Explanation: The same letters are at least distance 2 from each other.
*/




class Solution {
    public String rearrangeString(String s, int k) {
        int[] ct = new int[26];
        int[] pos = new int[26];
        for (char c : s.toCharArray()) {
            ct[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int p = find(ct, pos, i);
            if (p < 0) {
                return "";
            }
            sb.append((char) (p + 'a'));
            ct[p]--;
            pos[p] = i + k;
        }
        return sb.toString();
    }
    
    private int find(int[] ct, int[] pos, int index) {
        int max = Integer.MIN_VALUE;
        int p = -1;
        for (int i = 0; i < 26; i++) {
            if (ct[i] > 0 && ct[i] > max && pos[i] <= index) {
                max = ct[i];
                p = i;
            }
        }
        return p;
    }
}
