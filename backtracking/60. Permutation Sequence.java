/*

The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"

*/



class Solution {
    public String getPermutation(int n, int k) {
        int[] factors = new int[n + 1];
        int sum = 1;
        factors[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum = i * sum;
            factors[i] = sum;
        }
        List<Integer> nums = new ArrayList<> ();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        k--;
        String res = "";
        for (int i = 1; i <= n; i++) {
            int index = k / factors[n - i]; 
            res += nums.get(index);
            nums.remove(index);
            k -= index * factors[n - i];
        }
        return res;
    }
}
