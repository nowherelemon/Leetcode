/*
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
  s = "wordgoodstudentgoodword",
  words = ["word","student"]
Output: []
*/


class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<> ();
        if (s.length() < 1 || words.length < 1) return res;
        int len = words[0].length();
        Map<String, Integer> ct = new HashMap<> ();
        for (String w : words) {
            ct.put(w, ct.getOrDefault(w, 0) + 1);
        }
        int wordNum = words.length;
        
        for (int j = 0; j < len; j++) {
            Map<String, Integer> tmp = new HashMap<> ();
            int num = 0;
            for (int i = j; i < s.length() - words.length * len + 1; i += len) {
                boolean removed = false;
                while (num < wordNum) {
                    String cur = s.substring(i + num * len, i + (num + 1) * len);
                    if (ct.containsKey(cur)) {
                        tmp.put(cur, tmp.getOrDefault(cur, 0) + 1);
                        if (tmp.get(cur) > ct.get(cur)) {
                            removed = true;
                            int substract = 0;
                            while (tmp.get(cur) > ct.get(cur)) {
                                String removeWord = s.substring(i + substract * len, i + substract * len + len);
                                tmp.put(removeWord, tmp.get(removeWord) - 1);
                                substract++;
                            }
                            num = num - substract + 1;
                            i += (substract - 1) * len;
                            break;
                        }
                    } else {
                        tmp.clear();
                        i += num * len;
                        num = 0;
                        break;
                    }
                    num++;
                }
                if (num == wordNum) {
                    res.add(i);
                }
                if (num > 0 && !removed) {
                    String first = s.substring(i, i + len);
                    tmp.put(first, tmp.get(first) - 1);
                    num--;
                }
            } 
        }
        return res;
    }
}
