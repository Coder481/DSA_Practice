package linkedList.doublyLinkedList.addNode;

import linkedList.doublyLinkedList.Node;

public class AddNodeAtStart {

    public static Node addNode(Node head, int data){

        Node newNode = new Node();
        newNode.data = data;
        newNode.prev = null;


        newNode.next = head;

        if (head != null){
            head.prev = newNode;
        }

        return newNode;

    }
}
