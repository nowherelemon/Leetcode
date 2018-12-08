/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
*/


class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 1 || t < 0) return false;
        long b = (long) t + 1;
        System.out.println(b);
        Map<Long, Long> map = new HashMap<> ();
        
        
        for (int i = 0; i < nums.length; i++) {
            long key = nums[i] < 0 ? (nums[i] + 1) / b - 1 : nums[i] / b;
            if (map.containsKey(key)) {
                return true;
            } else if (map.containsKey(key - 1) && Math.abs(map.get(key - 1) - nums[i]) < b) {
                return true;
            } else if (map.containsKey(key + 1) && Math.abs(map.get(key + 1) - nums[i]) < b) {
                return true;
            } 
            map.put(key, (long)nums[i]);
            if (i >= k) {
                map.remove(nums[i - k] < 0 ? (nums[i - k] + 1) / b - 1 : nums[i - k] / b);
            }
        }
        return false;
    }
    
    
}
