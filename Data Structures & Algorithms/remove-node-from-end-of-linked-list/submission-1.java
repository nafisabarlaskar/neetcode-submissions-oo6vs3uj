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
        if (head == null){
            return head;
        }

        ListNode node = head;
        for (int i = 0; i < n; i++){
            node = node.next;
        }

        if (node == null){
            return head.next;
        }

        ListNode curr = head;
        while (node.next != null) {
            curr = curr.next;
            node = node.next;
        }

        curr.next = curr.next.next;
        return head;
    }
}
