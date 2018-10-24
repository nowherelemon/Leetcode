/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<> (wordDict);
        Set<Integer> set = new HashSet<> ();
        return dfs(s, 0, dict, set);
    }
    private boolean dfs(String s, int start, Set<String> dict, Set<Integer> set) {
        if (start == s.length()) return true;
        if (set.contains(start)) return false;
        
        for (int i = start + 1; i <= s.length(); i++) {
            if (dict.contains(s.substring(start, i))) {
                if (dfs(s, i, dict, set)) {
                    return true;
                } else {
                    set.add(i);
                }
            }
        }
        set.add(start);
        return false;
    }
}
