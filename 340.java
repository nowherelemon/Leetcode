//Longest Substring with At Most K Distinct Characters.

//Sliding windows

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        int[] count = new int[256];
        int j = 0;
        int ct = 0;
        
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) {
                ct++;
            }
            if (ct > k) {
                while (j < i && --count[s.charAt(j++)] > 0);
                ct--;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
