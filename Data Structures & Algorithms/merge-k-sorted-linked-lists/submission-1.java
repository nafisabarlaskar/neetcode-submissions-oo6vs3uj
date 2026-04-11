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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists){
            pq.offer(list);
        }

        ListNode dummy = new ListNode(0), curr = dummy;
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            if (node.next != null){
                pq.offer(node.next);
            }
            
            curr.next = new ListNode(node.val);
            curr = curr.next;
        }

        return dummy.next;
    }
}
