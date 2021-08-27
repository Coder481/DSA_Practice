package linkedList.singleLinkedList.problems;

import linkedList.singleLinkedList.LinkedList;

/**
 * Method 1:
 *      Traverse the whole linked list and count the no. of nodes.
 *      Now traverse the list again till count/2 and return the node at count/2.
 *
 * Method 2:
 *      Traverse linked list using two pointers. Move one pointer by one and the other pointers by two.
 *      When the fast pointer reaches the end slow pointer will reach the middle of the linked list.
 *
 * We are going to use Method 2 here,
 */
public class MiddleNode {

    public static LinkedList.Node getMiddleNode(LinkedList.Node head){
        if (head == null) return null;

        LinkedList.Node slowNode = head;
        LinkedList.Node fastNode = head;

        while ( fastNode != null ){
            if (fastNode.next == null) break;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return slowNode;
    }

}
