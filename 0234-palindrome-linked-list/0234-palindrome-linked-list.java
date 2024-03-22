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
    public boolean isPalindrome(ListNode head) {

        ListNode fast=head,slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //1 2 3 4
        //1 2 3 4 5

        ListNode end=reverse(slow,null);
        slow=head;
        while(end!=null){
            if(end.val!=slow.val) return false;
            end=end.next;
            slow=slow.next;
        }

       
        return true;
        
    }

    public ListNode reverse(ListNode node,ListNode prev){

            ListNode cur=node;
            ListNode next=null;
            while(cur!=null){
                next=cur.next;
                cur.next=prev;
                prev=cur;
                cur=next; 
            }
            return prev;
    }
}