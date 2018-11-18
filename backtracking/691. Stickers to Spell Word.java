/*
We are given N different types of stickers. Each sticker has a lowercase English word on it.

You would like to spell out the given target string by cutting individual letters from your collection of stickers and rearranging them.

You can use each sticker more than once if you want, and you have infinite quantities of each sticker.

What is the minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.

Example 1:

Input:

["with", "example", "science"], "thehat"
Output:

3
Explanation:

We can use 2 "with" stickers, and 1 "example" sticker.
After cutting and rearrange the letters of those stickers, we can form the target "thehat".
Also, this is the minimum number of stickers necessary to form the target string.
Example 2:

Input:

["notice", "possible"], "basicbasic"
Output:

-1
Explanation:

We can't form the target "basicbasic" from cutting letters from the given stickers.
Note:

stickers has length in the range [1, 50].
stickers consists of lowercase English words (without apostrophes).
target has length in the range [1, 15], and consists of lowercase English letters.
In all test cases, all words were chosen randomly from the 1000 most common US English words, and the target was chosen as a concatenation of two random words.
The time limit may be more challenging than usual. It is expected that a 50 sticker test case can be solved within 35ms on average.

*/





// backtracking + memorized





class Solution {
    public int minStickers(String[] stickers, String target) {
        if (target.length() < 1) return 0;
        if (stickers.length < 1) return -1;
        Map<String, Integer> map = new HashMap<> ();
        int[][] mp = new int[stickers.length][26];
        
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                mp[i][c - 'a']++;
            }
        }
        
        map.put("", 0);
        return helper(mp, map, target);
    }
    
    private int helper(int[][] mp, Map<String, Integer> map, String target) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        char[] sc = new char[26];
        for (char c : target.toCharArray()) {
            sc[c - 'a']++;
        }
        int ct = Integer.MAX_VALUE;
        for (int i = 0; i < mp.length; i++) {
            if (mp[i][target.charAt(0) - 'a'] == 0) {
                //System.out.println("Get continued: " + (target.charAt(0) - 'c'));
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (sc[j] > 0) {
                    for (int k = 0; k < Math.max(0, sc[j] - mp[i][j]); k++) {
                        sb.append((char) (j + 'a'));
                    }
                }
            }
            //System.out.println(sb.toString());
            int next = helper(mp, map, sb.toString());
            if (next != -1) {
                ct = Math.min(ct, next + 1);
            }
        }
        if (ct == Integer.MAX_VALUE) {
            ct = -1;
        }
        map.put(target, ct);
        return map.get(target);
    }
}
