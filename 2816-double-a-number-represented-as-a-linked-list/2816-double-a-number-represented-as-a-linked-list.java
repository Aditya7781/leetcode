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
    public ListNode doubleIt(ListNode head) {
        ListNode prev=null, curr=head, next=null;
        // reverse 
		while (curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
        ListNode res=null;
        int extra=0;
        while(prev!=null || extra>=1){
            int sum=extra;
            if(prev!=null)
                sum+=prev.val+prev.val;
            extra=sum/10;
            sum=sum%10;
            ListNode fresh=new ListNode(sum);
            // adding in reverse order for correct output
            fresh.next=res;
            res=fresh;
            if(prev!=null)
            prev=prev.next;
        }
        return res;
    }
}