package linkedList.doublyLinkedList.addNode;

import linkedList.doublyLinkedList.Node;

public class AddNodeAfterNode {

    public static Node addNode(Node head, Node desNode,int data){

        Node newNode = new Node();
        newNode.data = data;

        if (head == null) {
            newNode.next = null;
            newNode.prev = null;
            return newNode;
        }

        if (desNode == null) return head;

        if (desNode.next == null){
            newNode.next = null;
        }else {
            newNode.next = desNode.next;
            desNode.next.prev = newNode;
        }

        desNode.next = newNode;
        newNode.prev = desNode;

        return head;
    }

}
