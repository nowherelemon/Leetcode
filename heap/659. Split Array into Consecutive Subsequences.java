/*
You are given an integer array sorted in ascending order (may contain duplicates), you need to split them into several subsequences, where each subsequences consist of at least 3 consecutive integers. Return whether you can make such a split.

Example 1:
Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5
Example 2:
Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5
Example 3:
Input: [1,2,3,4,4,5]
Output: False
*/



class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<> ();
        Map<Integer, Integer> append = new HashMap<> ();
        for (int n : nums)  {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        for (int n : nums) {
            if (freq.get(n) == 0) {
                continue;
            } else if (append.getOrDefault(n, 0) != 0) {
                append.put(n, append.get(n) - 1);
                append.put(n + 1, append.getOrDefault(n + 1, 0) + 1 );
            } else if (freq.getOrDefault(n + 1, 0) > 0 && freq.getOrDefault(n + 2, 0) > 0) {
                freq.put(n + 1, freq.get(n + 1) - 1);
                freq.put(n + 2, freq.get(n + 2) - 1);
                append.put(n + 3, append.getOrDefault(n + 3, 0) + 1);
            } else {
                return false;
            }
            freq.put(n, freq.get(n) - 1);
        }
        return true;
    }
}
