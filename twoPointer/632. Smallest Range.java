/*
You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

Example 1:
Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
Note:
The given list may contain duplicates, so ascending order means >= here.
1 <= k <= 3500
-105 <= value of elements <= 105.
For Java users, please note that the input type has been changed to List<List<Integer>>. And after you reset the code template, you'll see this point.
*/






//need a way to keep track of min and max, any idea?
















//pq





class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[2];
        if (nums.size() < 1 || nums.get(0).size() < 1) {
            return res;
        }
        PriorityQueue<Element> pq = new PriorityQueue<> ((a, b) -> (a.val - b.val));
        int start = -1;
        int end = -1;
        int max = Integer.MIN_VALUE;
        int range = Integer.MAX_VALUE;
        
        for (int i = 0 ; i < nums.size(); i++) {
            int cur = nums.get(i).get(0);
            if (cur > max) {
                max = cur;
            }
            pq.offer(new Element(i, 0, cur));
        }
        
        while (pq.size() == nums.size()) {
            Element cur = pq.poll();
            if (max - cur.val < range) {
                range = max - cur.val;
                start = cur.val;
                end = max;
            }
            if (cur.c < nums.get(cur.r).size() - 1) {
                Element next = new Element(cur.r, cur.c + 1, nums.get(cur.r).get(cur.c + 1));
                if (next.val > max) {
                    max = next.val;
                }
                pq.offer(next);
            }
        }
        res[0] = start;
        res[1] = end;
        return res;
    }
    
    class Element {
        int r;
        int c;
        int val;
        
        public Element(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }
}


