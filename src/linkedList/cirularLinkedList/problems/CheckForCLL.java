package linkedList.cirularLinkedList.problems;

import linkedList.cirularLinkedList.CircularLinkedList;

public class CheckForCLL {

    public static boolean isCLL(CircularLinkedList.Node head){

        if (head == null) return false;

        CircularLinkedList.Node temp = head;
        while (temp.next != head){
            if (temp.next==null) return false;
            temp = temp.next;
        }
        return true;
    }

}
