package linkedList.singleLinkedList.addNodeInList;

import linkedList.singleLinkedList.LinkedList;

public class AddAtEnd {

    public static LinkedList.Node add(LinkedList.Node head, int data){

        // if linked list in empty then return head as new node
        if (head == null) return new LinkedList.Node(data);

        // traverse to the last node of the list
        LinkedList.Node lastNode = head;
        while (lastNode.next != null){
            lastNode = lastNode.next;
        }

        // set the new node as the next value of the last node
        lastNode.next = new LinkedList.Node(data);

        return head;
    }

}
