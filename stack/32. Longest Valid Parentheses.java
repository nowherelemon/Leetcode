/**
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

**/

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<> ();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                if (!st.isEmpty() && s.charAt(st.peek()) == '(') {
                    st.pop();
                } else {
                    st.push(i);
                }
            }
        }
        int a = 0;
        int b = s.length();
        int max = 0;
        if (st.isEmpty()) return s.length();
        while (!st.isEmpty()) {
            a = st.pop();
            System.out.println(a);
            max = Math.max(b - a - 1, max);
            b = a;
        }
        return Math.max(max, a);
    }
}
