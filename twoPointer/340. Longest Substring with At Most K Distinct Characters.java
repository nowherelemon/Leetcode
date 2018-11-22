/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
*/


class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() < 1 || k < 1) return 0;
        Map<Character, Integer> map = new HashMap<> ();
        int l = 0;
        int r = 0;
        int res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() > k) {
                while (map.size() > k) {
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
