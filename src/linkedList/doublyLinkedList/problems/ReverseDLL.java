package linkedList.doublyLinkedList.problems;

import linkedList.doublyLinkedList.Node;

public class ReverseDLL {

    public static Node reverse(Node head){

        if (head == null) return null;

        /*Node newHead = new Node();

        Node temp = head;

        while (temp.next != null){
            int data = temp.data;
            Node prev = temp.prev;
            Node next = temp.next;

            newHead.next = prev;
            newHead.prev = next;
            newHead.data = data;

            temp = temp.next;

        }*/

        Node temp = null;
        Node current = head;

        /* swap next and prev for all nodes of
         doubly linked list */
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        /* Before changing head, check for the cases like
         empty list and list with only one node */
        if (temp != null) {
            head = temp.prev;
        }

        return head;


    }

}
