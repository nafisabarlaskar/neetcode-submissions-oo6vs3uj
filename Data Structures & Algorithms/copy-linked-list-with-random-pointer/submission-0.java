/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }

        Node node = head;
        while (node != null){
            Node next = node.next;
            node.next = new Node(node.val);
            node.next.next = next;
            node = next;
        }

        node = head;
        Node head1 = node.next;
        while (node != null){
            if (node.random != null){
                node.next.random = node.random.next;
            }

            node = node.next.next;
        }

        node = head;
        while (node != null){
            Node next = node.next;
            node.next = next.next;
            if (next.next != null){
                next.next = next.next.next;
            }

            node = node.next;
        }

        return head1;
    }
}
