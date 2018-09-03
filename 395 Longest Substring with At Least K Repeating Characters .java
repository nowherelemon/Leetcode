//Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

//Divide and Conquer
//We check the entire string to find the character has less than k times, use it as pivot to split the array and recursively perform the same function

//TO DO: what's the time complexity


class Solution {
    public int longestSubstring(String s, int k) {
       return helper(s, 0, s.length() - 1, k);
    }
    
    private int helper(String s, int start, int end, int k) {
        if (end - start < k - 1) return 0;
        int[] ct = new int[26];
         for (int i = start; i <= end; i++) {
          ct[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < 26; j++) {
          int n = ct[j];
          if (n > 0 && n < k) {
            for (int i = start; i <= end; i++) {
              if (s.charAt(i) == (j + 'a')) {
                int left = helper(s, start, i - 1, k);
                int right = helper(s, i + 1, end, k);
                return Math.max(left, right);
              }        
            }
          }
        }
        return end - start + 1;
    }
}
