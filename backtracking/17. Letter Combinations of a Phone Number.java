/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

*/


class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() < 1) return new ArrayList<String> ();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> q = new LinkedList<> ();
        q.add("");
        for (char c : digits.toCharArray()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                String val = mapping[Integer.valueOf("" + c)];
                for (char c1 : val.toCharArray()) {
                    String next = cur + c1;
                    q.offer(next);
                }
            }
        }
        return new ArrayList<> (q);
    }
}
