/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy;
        ListNode second = first;

        while(first != null) {
            int prefixSum = 0;
            second = first.next;
            while(second != null) {
                 prefixSum += second.val;

                 if(prefixSum == 0) first.next = second.next;

                 second = second.next;
            }
            first = first.next;
        }

        return dummy.next;
    }
}