/*

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

*/


class Solution {
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<> ();
        List<List<String>> res = new ArrayList<> ();
        if (s.length() < 1) return res;
        helper(res, list, s, 0);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> list, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<> (list));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (isP(start, i, s)) {
                list.add(s.substring(start, i + 1));
                helper(res, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isP(int l, int r, String s) {
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        return l >= r;
    }
}
