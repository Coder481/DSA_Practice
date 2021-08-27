package linkedList.doublyLinkedList.addNode;

import linkedList.doublyLinkedList.Node;

public class AddNodeBeforeNode {

    public static Node addNode(Node head, Node desNode, int data){

        Node newNode = new Node();
        newNode.data = data;

        if (head == null) {
            newNode.next = null;
            newNode.prev = null;
            return newNode;
        }

        if (desNode == null) return head;

        if (desNode.prev == null){
            newNode.prev = null;
            head = newNode;
        }else {
            newNode.prev = desNode.prev;
            desNode.prev.next = newNode;
        }

        newNode.next = desNode;
        desNode.prev = newNode;

        return head;
    }

}
