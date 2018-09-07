/*
Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?
*/


//Trie, set and find at the same time

class Solution {
    class Node {
        Node one;
        Node zero;
        
        public Node set (int n) {
            if (n == 1) {
                if (one == null) {
                    one = new Node();
                }
                return one;
            } else {
                if (zero == null) {
                    zero = new Node();
                }
                return zero;
            }
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        int max = 0;
        
        for (int n : nums) {
            int tmp = 0;
            Node set = root;
            Node find = root;
            int pos = 30;
            while (pos >= 0) {
                int bit = (n >>> pos) & 1;
                set = set.set(bit);
                
                if (bit == 0) {
                    if (find.one != null) {
                        tmp |= (1 << pos);
                        find = find.one;
                    } else {
                        find = find.zero;
                    }
                } else {
                    if (find.zero != null) {
                        tmp |= (1 << pos);
                        find = find.zero;
                    } else {
                        find = find.one;
                    }
                }
                pos--;
            }
            max = Math.max(max, tmp);
        }
        return max;
    }
}


