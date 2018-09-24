/*


Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: "()"
Output: 1
Example 2:

Input: "(())"
Output: 2
Example 3:

Input: "()()"
Output: 2
Example 4:

Input: "(()(()))"
Output: 6
 

Note:

S is a balanced parentheses string, containing only ( and ).
2 <= S.length <= 50

*/


class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> st = new Stack<> ();
        
        for (char c : S.toCharArray()) {
            if (c == '(') {
                st.push(-1);
            } else {
                int cur = 0;
                while (st.peek() != -1) {
                    cur += st.pop();
                }
                st.pop();
                st.push(cur == 0 ? 1 : cur * 2);
            }
        }
        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }
}
