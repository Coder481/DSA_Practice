package linkedList.cirularLinkedList;

import linkedList.cirularLinkedList.addNode.AddNodeAtStart;
import linkedList.cirularLinkedList.addNode.AddNodeInSortedCLL;
import linkedList.cirularLinkedList.problems.CheckForCLL;
import linkedList.cirularLinkedList.problems.FindLengthOfCLL;
import linkedList.cirularLinkedList.problems.HalfTheCLL;
import linkedList.cirularLinkedList.problems.HalfTheCLLWithAlgo;
import linkedList.singleLinkedList.LinkedList;

import java.util.List;

public class CircularLinkedList {

    /** Linked list Node.  This inner class is made static so that
     main() can access it
     */
    public static class Node{
        public int data;
        public CircularLinkedList.Node next;
    }

    public static void main(String[] args) {
        Node head = null;

        head = AddNodeAtStart.addNode(head,5);
        head = AddNodeAtStart.addNode(head,4);
        head = AddNodeAtStart.addNode(head,3);
        head = AddNodeAtStart.addNode(head,6);
        head = AddNodeAtStart.addNode(head,1);

        printList(head);

        printLn("");

        print("Length of CLL: "+ FindLengthOfCLL.getLength(head));

        printLn("");

        List<Node> nodeList = HalfTheCLL.getHalvedNodesList(head);
        if (nodeList == null){
            print("Null List");
        }else {
            print("First Part: ");
            printList(nodeList.get(0));
            printLn("");
            print("Second Part: ");
            printList(nodeList.get(1));
        }

        printLn("");
        print("List: ");
        printList(head);

//        head = AddNodeAtStart.addNode(head,1);
//        head = AddNodeAtStart.addNode(head,2);
//        head = AddNodeAtStart.addNode(head,3);

        printLn("");
        printLn("");
        printLn("Half Using Algo");
        print("List: ");
        printList(head);
        printLn("");
        List<Node> nodeList1 = HalfTheCLLWithAlgo.halfTheCLL(head);
        if (nodeList1 == null){
            print("Null List");
        }else {
            print("First Part: ");
            printList(nodeList1.get(0));
            printLn("");
            print("Second Part: ");
            printList(nodeList1.get(1));
        }

        printLn("");
        print("List: ");
        printList(head);

        head = AddNodeInSortedCLL.insertNode(head,10);
        printLn("");
        printLn("");
        print("Items after adding in sorted CLL: ");
        printList(head);
        printLn("");

        print("Is list1 a CLL: "+ CheckForCLL.isCLL(head));
        printLn("");
        checkForSingeLinkedList();

    }

    private static void checkForSingeLinkedList() {
        CircularLinkedList.Node head = new CircularLinkedList.Node();
        head.data = 1;
        CircularLinkedList.Node secondNode = new CircularLinkedList.Node();
        secondNode.data = 2;
        CircularLinkedList.Node thirdNode = new CircularLinkedList.Node();
        thirdNode.data = 3;

        head.next = secondNode;
        secondNode.next = thirdNode;

        printLn("Is list2 a CLL: "+CheckForCLL.isCLL(head));
    }

    private static void printList(Node head) {
        Node temp = head;
        if (head == null) return;
        do{
            print(temp.data+" ");
            temp = temp.next;
        }while (temp != head);
    }

    private static void printLn(String s){
        System.out.println(s);
    }
    private static void print(String s){
        System.out.print(s);
    }

}
