package linkedList.cirularLinkedList.problems;

import linkedList.cirularLinkedList.CircularLinkedList;

public class FindLengthOfCLL {

    public static int getLength(CircularLinkedList.Node head){

        CircularLinkedList.Node temp = head;
        int count = 0;

        if (head != null) {
            do {
                temp = temp.next;
                count++;
            } while (temp != head);

        }
        return count;

    }

}
