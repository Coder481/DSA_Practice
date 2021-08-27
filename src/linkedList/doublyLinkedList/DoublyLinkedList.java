package linkedList.doublyLinkedList;

import linkedList.doublyLinkedList.addNode.AddNodeAfterNode;
import linkedList.doublyLinkedList.addNode.AddNodeAtEnd;
import linkedList.doublyLinkedList.addNode.AddNodeAtStart;
import linkedList.doublyLinkedList.addNode.AddNodeBeforeNode;
import linkedList.doublyLinkedList.deleteNode.DeleteANode;
import linkedList.doublyLinkedList.problems.ReverseDLL;

public class DoublyLinkedList {

    public static void main(String[] args) {

        Node head = null;

        printLn("Add node at start");
        head = AddNodeAtStart.addNode(head,1);
        Node temp = head;
        head = AddNodeAtStart.addNode(head,0);

        printList(head);

        head = AddNodeAtEnd.addNode(head,2);

        printLn("");
        printLn("Add node at end");
        printList(head);

        printLn("");

        // temp = 1
        head = AddNodeAfterNode.addNode(head,temp,-1);
        printList(head);

        head = AddNodeBeforeNode.addNode(head,head,-2);
        printList(head);

        head = DeleteANode.delete(head,temp);
        printList(head);

        printLn("");
        printLn("Reversed DLL");
        head = ReverseDLL.reverse(head);
        printList(head);

    }

    private static void printList(Node head) {
        if (head == null) return;

        print("DLL -> ");
        Node temp = head;
        Node lastNode = null;

        print("Forward: ");
        while (temp != null){
            print(temp.data+" ");
            lastNode = temp;
            temp = temp.next;
        }

        print(" ,Backward: ");

        while (lastNode != null){
            print(lastNode.data+" ");
            lastNode = lastNode.prev;
        }

        printLn("");
    }


    private static void printLn(String s){
        System.out.println(s);
    }
    private static void print(String s){
        System.out.print(s);
    }
}
