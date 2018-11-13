/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/


class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<> ();
        List<Integer> list = new ArrayList<> ();
        helper(res, list, n, k, 1);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            res.add(new ArrayList<> (list));
            return;
        }
        // if (start > n) {
        //     return;
        // }
        for (int i = start; i <= n - k + list.size() + 1; i++) {
            list.add(i);
            helper(res, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
        
    }
}
