/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/



class Solution {
    public int trap(int[] height) {
        if (height.length < 1) return 0;
        int res = 0;
        int lh = height[0];
        int rh = height[height.length - 1];
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            if (lh < rh) {
                while (l < r && height[l] <= lh) {
                    res += lh - height[l];
                    l++;
                }
                lh = height[l];
            } else {
                while (l < r && height[r] <= rh) {
                    res += rh - height[r];
                    r--;
                }
                rh = height[r];
            }
        }
        return res;
    }
}
