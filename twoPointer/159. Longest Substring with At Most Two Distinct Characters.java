/*
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.

*/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<> ();
        int l = 0;
        int r = 0;
        int res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() > 2) {
                while (map.size() > 2) {
                    char prev = s.charAt(l);
                    int ct = map.get(prev);
                    if (ct == 1) {
                        map.remove(prev);
                    } else {
                        map.put(prev, ct - 1);
                    }
                    l++;
                }
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
