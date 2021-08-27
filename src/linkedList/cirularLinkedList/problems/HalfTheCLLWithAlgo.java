package linkedList.cirularLinkedList.problems;

import linkedList.cirularLinkedList.CircularLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Halving the circularLinkedList using "Tortoise and Hare" algorithm
 */
public class HalfTheCLLWithAlgo {

    public static List<CircularLinkedList.Node> halfTheCLL(CircularLinkedList.Node head){

        CircularLinkedList.Node fastNode = head;
        CircularLinkedList.Node slowNode = head;

        List<CircularLinkedList.Node> outputList = new ArrayList<>();

        if (head == null){
            return null;
        }

        while (fastNode.next!=head && fastNode.next.next!=head){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        if (fastNode.next.next == head) fastNode = fastNode.next;

        CircularLinkedList.Node temp1 = slowNode.next;

        slowNode.next = head;
        fastNode.next = temp1;

        outputList.add(head);
        outputList.add(temp1);

        return outputList;

    }

}
