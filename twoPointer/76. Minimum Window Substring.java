/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/


class Solution {
    public String minWindow(String s, String t) {
        int[] sc = new int[256];
        int[] tc = new int[256];
        int ct = Integer.MAX_VALUE;
        String res = "";
        
        for (int i = 0; i < t.length(); i++) {
            tc[t.charAt(i)]++;
        }
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !valid(tc, sc)) {
                sc[s.charAt(j)]++;
                j++;
            }
            if (valid(tc, sc)) {
                if (j - i < ct) {
                    ct = (j - i);
                    res = s.substring(i, j);
                }
            } else {
                break;
            }
            sc[s.charAt(i)]--;
        }
        return res;
    }
    
    private boolean valid(int[] tc, int[] sc) {
        for (int i = 0; i < 256; i++) {
            if (sc[i] < tc[i]) {
                return false;
            }
        }
        return true;
    }
}
