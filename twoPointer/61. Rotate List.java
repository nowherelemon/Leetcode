/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (k < 1) return head;
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode fast = prev;
        int i = 0;
        while (fast.next != null) {
            i++;
            fast = fast.next;
        }
        if (k % i == 0) return head;
        int m = i - k % i;
        while (m > 0) {
            prev = prev.next;
            m--;
        }
        ListNode newHead = prev.next;
        fast.next = head;
        prev.next = null;
        return newHead;
    }
}
