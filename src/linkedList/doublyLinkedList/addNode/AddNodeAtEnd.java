package linkedList.doublyLinkedList.addNode;

import linkedList.doublyLinkedList.Node;

public class AddNodeAtEnd {

    public static Node addNode(Node head, int data){

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (head == null){
            newNode.prev = null;
            return newNode;
        }

        Node temp = head;

        while (temp.next != null){
            temp = temp.next;
        }

        newNode.prev = temp;
        temp.next = newNode;

        return head;

    }

}
