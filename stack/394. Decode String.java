/*

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

*/

class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() < 1) return "";
        Stack<String> strStack = new Stack<> ();
        Stack<Integer> ctStack = new Stack<> ();
        
        String res = "";
        
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int n = 0;
                while (Character.isDigit(s.charAt(i))) {
                    n = n * 10 + s.charAt(i) - '0';
                    i++;
                }
                ctStack.push(n);
                //System.out.println(n);
            } else if (s.charAt(i) == '[') {
                strStack.push(res);
                res = "";
                i++;
            } else if (s.charAt(i) == ']') {
                String cur = "";
                int ct = ctStack.pop();
                for (int j = 0; j < ct; j++) {
                    cur += res;
                }
                res = strStack.pop() + cur;
                i++;
            } else {
                res += s.charAt(i++);
            }
        }
        return res;
    }
}
