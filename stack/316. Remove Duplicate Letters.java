/*

Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: "bcabc"
Output: "abc"
Example 2:

Input: "cbacdcbc"
Output: "acdb"

*/

//Greedy find the begnning character

class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) return "";
        int[] sc = new int[26];
        for (char c : s.toCharArray()) {
            sc[c - 'a']++;
        }
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            } 
            if (sc[s.charAt(i) -'a'] == 1) {
                break;
            }
        }
        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll(s.charAt(pos) + "", ""));
    }
}
