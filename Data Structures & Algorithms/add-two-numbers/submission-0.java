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
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0), node = dummy, l1 = list1, l2 = list2;
        int carry = 0;
        if (l1 == null && l2 == null){
            return null;
        } else if (l1 == null){
            return l2;
        } else if (l2 == null){
            return l1;
        }

        while (l1 != null || l2 != null || carry != 0){
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            node.next = new ListNode(sum % 10);
            carry = sum / 10;
            node = node.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return dummy.next;
    }
}
