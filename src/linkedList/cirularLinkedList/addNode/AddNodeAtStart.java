package linkedList.cirularLinkedList.addNode;

import linkedList.cirularLinkedList.CircularLinkedList;

public class AddNodeAtStart {

    public static CircularLinkedList.Node addNode(CircularLinkedList.Node head, int data){

        CircularLinkedList.Node newNode = new CircularLinkedList.Node();
        newNode.data = data;
        newNode.next = head;

        CircularLinkedList.Node temp = head;

        // If head is null, means linked list is empty
        // then newNode will be the head node which is connected to itself
        if (head == null){
            newNode.next = newNode;
        }else {

            // traverse to the end of the list
            while (temp.next != head){
                temp = temp.next;
            }

            // change link of the last node
            temp.next = newNode;
        }

        head = newNode;

        return head;
    }

}
