package linkedList.singleLinkedList;

import linkedList.singleLinkedList.addNodeInList.AddAtEnd;
import linkedList.singleLinkedList.addNodeInList.AddAtMiddle;
import linkedList.singleLinkedList.addNodeInList.AddAtStart;
import linkedList.singleLinkedList.deleteNode.DeleteSpecificKey;
import linkedList.singleLinkedList.deleteNode.DeleteSpecificPosition;
import linkedList.singleLinkedList.problems.FindLoop;
import linkedList.singleLinkedList.problems.MiddleNode;

/**
 * Like arrays, Linked List is a linear data structure.
 * Unlike arrays, linked list elements are not stored at a contiguous location;
 * the elements are linked using pointers.
 *
 * Advantages over arrays
 *      1) Dynamic size
 *      2) Ease of insertion/deletion
 *
 * Example: [9| ]-> [25| ]-> [5| ]-> [7|null]
 *         (head)   (node)  (node)    (node)
 *
 */
public class LinkedList {

    // head of list
    Node head;

    /** Linked list Node.  This inner class is made static so that
        main() can access it
     */
    public static class Node{
        public int data;
        public Node next;

        // Constructor
        public Node(int data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {

        // set head of the linked list
        Node head = new Node(1);

        // initialize second and third node of the linked list
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);

        /* Three nodes have been allocated dynamically.
            We have references to these three blocks as head,
            second and third

                head          secondNode         thirdNode
                 |                |                  |
                 |                |                  |
            +----+------+     +----+------+     +----+------+
            | 1  | null |     | 2  | null |     |  3 | null |
            +----+------+     +----+------+     +----+------+
         */
        // link secondNode with head of the linkedList
        head.next = secondNode;

        /*  Now next of the first Node refers to the second.  So they
            both are linked.

              head            secondNode        thirdNode
                |                |                  |
                |                |                  |
            +----+------+     +----+------+     +----+------+
            | 1  |  o-------->| 2  | null |     |  3 | null |
            +----+------+     +----+------+     +----+------+
            */

        // link thirdNode with the secondNode
        secondNode.next = thirdNode;

        /*  Now next of the second Node refers to third.  So all three
            nodes are linked.

               head             secondNode         thirdNode
                |                   |                  |
                |                   |                  |
            +----+------+     +----+------+     +----+------+
            | 1  |  o-------->| 2  |  o-------->|  3 | null |
            +----+------+     +----+------+     +----+------+ */


        // now print the complete linkedList with just head of the linkedList
        print("Initial list: ");
        printList(head);

        printLn("");

        // add node at start of the linked list
        head = AddAtStart.add(head, -1);
        print("Add at start: ");
        printList(head);

        printLn("");

        // add node at end of the linked list
        head = AddAtEnd.add(head, 5);
        print("Add at end: ");
        printList(head);

        printLn("");

        // add node after a specific  node
        head = AddAtMiddle.add(head,head,25);
        print("Add at middle: ");
        printList(head);

        printLn("");

        head = DeleteSpecificKey.delete(head,5);
        print("Delete a key(5): ");
        printList(head);

        printLn("");

        head = DeleteSpecificPosition.delete(head,4);
        print("Delete a position(4): ");
        printList(head);

        printLn("");

        Node middleNode = MiddleNode.getMiddleNode(head);
        print("Middle Node: "+middleNode.data);

        printLn("");
        print("Contains loop: "+FindLoop.containsLoop(head));
    }

    private static void printList(Node head) {
        Node n = head;
        while (n != null) {
            print(n.data + " ");
            n = n.next;
        }
    }

    private static void printLn(String s){
        System.out.println(s);
    }
    private static void print(String s){
        System.out.print(s);
    }
}
