package linkedList.doublyLinkedList.deleteNode;

import linkedList.doublyLinkedList.Node;

public class DeleteANode {

    public static Node delete(Node head, Node desNode){

        if (head == null) return null;

        if (desNode == null) return head;

        if (desNode.prev == null) return head.next;

        if (desNode.next == null) {
            desNode.prev.next = null;
        }else {
            desNode.next.prev = desNode.prev;
            desNode.prev.next = desNode.next;
        }


        return head;

    }

}
