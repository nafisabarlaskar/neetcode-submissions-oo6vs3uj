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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null){
            return head;
        }

        ListNode dummy = new ListNode(0), curr = head;
        while (curr != null && curr.next != null){
            ListNode next = curr.next;
            int a = curr.val, b = next.val;
            curr.next = new ListNode(gcd(a, b));
            curr.next.next = next;
            curr = next;
        }

        return head;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

