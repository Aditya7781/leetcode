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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null)
            return null;

        ListNode slow = head;
        ListNode fast=head;
        int i=0,j=0;
        while(fast.next!=null){
           if(i>=n){
               slow=slow.next;               
           }
           fast=fast.next;
           i++;
        }

        if(i+1 == n){
            head = head.next;
            return head;
        }
        slow.next=slow.next.next;
        return head;
    }
}