package linkedList.singleLinkedList.deleteNode;

import linkedList.singleLinkedList.LinkedList;

public class DeleteSpecificKey {

    public static LinkedList.Node delete(LinkedList.Node head, int key){
        // Store head node
        LinkedList.Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            return head;
        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null)
            return head;

        // Unlink the node from linked list
        prev.next = temp.next;

        return head;
    }

    /**
     * Delete the complete linkedList:
     *      In Java and Python, automatic garbage collection happens,
     *      so deleting a linked list is easy.
     *      Just need to change head to null.
     *
     *      In C/C++:
     *              Iterate through the linked list and delete all the nodes one by one.
     *              The main point here is not to access the next of the current pointer
     *              if the current pointer is deleted.
     */
}
