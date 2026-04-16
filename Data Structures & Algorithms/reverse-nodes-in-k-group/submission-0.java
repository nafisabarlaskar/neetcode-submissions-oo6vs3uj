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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return head;
        }

        int count = 0;
        ListNode node = head;
        while (count < k && node != null){
            count++;
            node = node.next;
        }

        if (count == k){
            ListNode reverse = reverse(head, k);
            head.next = reverseKGroup(node, k);
            return reverse;
        }

        return head;
    }

    private ListNode reverse(ListNode head, int k){
        ListNode curr = head, prev = null;
        while (k-- > 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
