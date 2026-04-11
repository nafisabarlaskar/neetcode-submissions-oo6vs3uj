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
    public void reorderList(ListNode head) {
        ListNode prev = null, slow = head, fast = head;
        if (head == null || head.next == null){
            return;
        }

        while (slow != null && fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null){
            prev.next = null;
        }

        prev = null;
        ListNode curr = slow;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode head2 = prev, head1 = head, node = head;
        while (head1 != null){
            node = head1.next;
            head1.next = head2;
            head2 = head2.next;
            if (node != null) {
                head1.next.next = node;
            } else {
                head1.next.next = head2;
            }

            head1 = node;
        }
    }
}
