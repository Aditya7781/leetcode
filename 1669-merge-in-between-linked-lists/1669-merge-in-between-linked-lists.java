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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = list1;
        while(a-->1){
            temp = temp.next;
        }
        ListNode temp2 = list1;
        while(b-->-1){
            temp2 = temp2.next;
        }
        ListNode temp3 = list2;
        while(temp3.next != null){
            temp3 = temp3.next;
        }
        temp.next = list2;
        temp3.next = temp2;
        return list1;
    }
}