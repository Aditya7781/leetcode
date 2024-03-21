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
    public ListNode reverseList(ListNode head) {
        ListNode rev =  null;

        while(head!=null){
            if(rev== null){
                rev = new ListNode(head.val);
            }
            else{
                rev = new ListNode(head.val,rev);
            }
            head = head.next;
        }
         return rev;
    }
   
}