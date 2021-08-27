package linkedList.singleLinkedList.deleteNode;

import linkedList.singleLinkedList.LinkedList;

public class DeleteSpecificPosition {

    public static LinkedList.Node delete(LinkedList.Node head, int position){
        // If linked list is empty
        if (head == null)
            return null;

        // Store head node
        LinkedList.Node temp = head;

        // If head needs to be removed
        if (position == 0)
        {
            head = temp.next;   // Change head
            return head;
        }

        // Find previous node of the node to be deleted
        for (int i=0; temp!=null && i<position-1; i++)
            temp = temp.next;

        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return head;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        LinkedList.Node next = temp.next.next;

        temp.next = next;  // Unlink the deleted node from list

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
