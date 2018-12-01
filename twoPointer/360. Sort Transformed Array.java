/*
Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function of the form f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)

Example 1:

Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
Output: [3,9,15,33]
Example 2:

Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
Output: [-23,-5,1,7]

*/


class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        if (nums.length < 1) return res;
        
        int index = a > 0 ? nums.length - 1 : 0;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int lv = calculate(nums[l], a, b, c);
            int lr = calculate(nums[r], a, b, c);
            if (a > 0) {    
                if (lv > lr) {
                    res[index--] = lv;
                    l++;
                } else {
                    res[index--] = lr;
                    r--;
                }
            } else {
                if (lv > lr) {
                    res[index++] = lr;
                    r--;
                } else {
                    res[index++] = lv;
                    l++;
                }
            }
        }
        return res;
    }
    
    private int calculate(int n, int a, int b, int c) {
        return a * n * n + b * n + c;
    }
}
