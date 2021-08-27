package linkedList.singleLinkedList.addNodeInList;

import linkedList.singleLinkedList.LinkedList;

public class AddAtMiddle {

    public static LinkedList.Node add(LinkedList.Node head, LinkedList.Node des, int data){


        /*
         * [9| ]-> [5| ]-> [7|null]
         *
         * let des = [9| ] and data = 25
         * separatedNode = [5| ]-> [7|null]
         * des.next = [9| ]-> [25|null]
         * des.next.next = [9| ]-> [25| ]-> [5| ]-> [7|null]
         * return [9| ]
         */

        LinkedList.Node separatedNode = des.next;

        des.next = new LinkedList.Node(data);

        des.next.next = separatedNode;

        return head;
    }

}
