package linkedList.singleLinkedList.problems;

import linkedList.singleLinkedList.LinkedList;

/**
 * Floyd’s Cycle-Finding Algorithm:
 *      Traverse linked list using two pointers.
 *      Move one pointer(slowNode) by one and another pointer(fastNode) by two.
 *      If these pointers meet at the same node then there is a loop.
 *      If pointers do not meet then linked list doesn’t have a loop.
 */
public class FindLoop {

    public static boolean containsLoop(LinkedList.Node head){

        LinkedList.Node slowNode = head;
        LinkedList.Node fastNode = head;

        while (slowNode!=null && fastNode!=null && fastNode.next!=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if (slowNode == fastNode) return true;
        }

        return false;

    }

}
