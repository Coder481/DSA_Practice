package linkedList.cirularLinkedList.addNode;

import linkedList.cirularLinkedList.CircularLinkedList;

public class AddNodeInSortedCLL {

    public static CircularLinkedList.Node insertNode(CircularLinkedList.Node head, int data){

        if (head == null) {
            CircularLinkedList.Node node = new CircularLinkedList.Node();
            node.data = data;
            node.next = node;
            return node;
        }

        if (head.data > data){

            CircularLinkedList.Node temp = head;
            while (temp.next != head){
                temp = temp.next;
            }

            CircularLinkedList.Node newNode = new CircularLinkedList.Node();
            newNode.data = data;
            newNode.next = head;

            temp.next = newNode;

            return newNode;
        }

        CircularLinkedList.Node temp = head;

        int flag = 0;
        while (temp.next != head){
            int smaller = temp.data;
            int larger = temp.next.data;
            if (data>=smaller && data<larger){
                CircularLinkedList.Node newNode = new CircularLinkedList.Node();
                newNode.data = data;
                newNode.next = temp.next;
                temp.next = newNode;
                flag = 1;
                break;
            }
            temp = temp.next;
        }

        if (flag == 0){
            CircularLinkedList.Node newNode = new CircularLinkedList.Node();
            newNode.data = data;
            newNode.next = head;
            temp.next = newNode;
        }

        return head;
    }

}
