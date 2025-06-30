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
    public ListNode swapPairs(ListNode head) {

       // Dummy node to simplify swapping at the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Pointer to track the node before the current pair
        ListNode prev = dummy;
     

       while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

             // Swapping
            prev.next = second;
            first.next = second.next;
            second.next = first;

         // Move to the next pair
            prev = first;
        }

        return dummy.next;
    }
}