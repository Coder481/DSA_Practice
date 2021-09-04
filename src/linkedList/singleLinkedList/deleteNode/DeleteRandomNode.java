package linkedList.singleLinkedList.deleteNode;

import linkedList.singleLinkedList.LinkedList;

/**
 * This is the problem (237) on LeetCode named "Delete Node in a Linked List"
 *
 * In this problem, we are not given head node of linked list instead
 * directly the node to be deleted.
 *
 * Ex:
 *           LinkedList          4 -> 5 -> 1 -> 9
 *           Node (to delete)     5
 *
 * Solution:
 *              Just change the value and the next node of the given node
 *              Ex.  change value of node 5 to its nextNode's value (i.e., 1)
 *                   and change next of node 5 to its nextNode's  nextNode (i.e., 9)
 *                   So. now (5->1) ---> (1->9)
 */
public class DeleteRandomNode {

    public static void main(String[] args) {
        LinkedList.Node head = new LinkedList.Node(4);
        LinkedList.Node node1 = new LinkedList.Node(5);
        LinkedList.Node node2 = new LinkedList.Node(1);
        LinkedList.Node node3 = new LinkedList.Node(9);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        deleteNode(node1);

        LinkedList.Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

    private static void deleteNode(LinkedList.Node node1) {

        if (node1.next == null)
            return;

        node1.data = node1.next.data;
        node1.next = node1.next.next;
    }


}
