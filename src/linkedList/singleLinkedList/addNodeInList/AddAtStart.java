package linkedList.singleLinkedList.addNodeInList;

import linkedList.singleLinkedList.LinkedList;

public class AddAtStart {

    public static LinkedList.Node add(LinkedList.Node head, int data){
        LinkedList.Node newNode = new LinkedList.Node(data);
        newNode.next = head;
        return newNode;
    }

}
