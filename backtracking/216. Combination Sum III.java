/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
*/


class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<> ();
        List<Integer> list = new ArrayList<> ();
        helper(res, list, k, n, 1, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int start, int sum) {
        if (list.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(list));
            }          
            return;
        }
        
        for (int i = start; i < 10; i++) {
            if (sum + i <= n) {
                list.add(i);
                helper(res, list, k, n, i + 1, sum + i);
                list.remove(list.size() - 1);
            }
        }
    }
}
