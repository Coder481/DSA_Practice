package linkedList.cirularLinkedList.problems;

import linkedList.cirularLinkedList.CircularLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Using length of linked list:
 *      [5| ]->[4| ]->[3| ]->[2| ]->[1| ]->[5| ]
 *      length of list is = 5  (last one is first one in circular linked list)
 *      now move to 3rd node to half the list
 */
public class HalfTheCLL {

    public static List<CircularLinkedList.Node> getHalvedNodesList(CircularLinkedList.Node head){

        List<CircularLinkedList.Node> outputList = new ArrayList<>();

        // if linked list is empty, return empty outputList
        if (head == null){
            return null;
        }
        // if linked list has only one node then this will be the firstHalf and secondHalf both
        else if (head.next == head){
            outputList.add(head);
            outputList.add(head);
            return outputList;
        }
        else {
            // get length of the linked list
            float listLen = (float) FindLengthOfCLL.getLength(head);

            // half the linked list length to get two half parts of linkedList
            int firstPartLen = (int) Math.ceil(listLen/2);

            CircularLinkedList.Node secondPartHeadNode = null;

            // move to first half part of linkedList
            CircularLinkedList.Node temp = head;
            int count = 0;
            while (count != firstPartLen-1){
                count++;
                temp = temp.next;
            }

            // store head node of second half part into the temp1 variable
            CircularLinkedList.Node temp1 = temp.next;


            // link the end node with the head node of the circularLinkedList
            temp.next = head;
            // save first half part of linkedList into the outputList
            outputList.add(head);



            // move to the secondHalf part of the linkedList
            secondPartHeadNode = temp1;
            while (temp1.next != head){
                temp1 = temp1.next;
            }
            // link the end node with the head node of the circularLinkedList
            temp1.next = secondPartHeadNode;


            // save second half part of linkedList into the outputList
            outputList.add(secondPartHeadNode);

            return outputList;

        }

    }

}
