package recursion.leetcodeProblems.recursionWithLinkedList;

import recursion.leetcodeProblems.ListNode;

/**
 * Solution Approach
 *
 * Breaking original linked list into 3 parts
 * then reverse the required list and
 * then again combine all the parts
 *
 * Example :        1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
 *
 *              left = 3
 *              right = 5
 *
 *                  1 -> 2,     3 -> 4 -> 5,     6 -> 7
 *
 *              Now reverse middle list
 *                  1 -> 2,     5 -> 4 -> 3,     6 -> 7
 *
 *              Now again combine all three lists into one
 *                  1 -> 2 -> 5 -> 4 -> 3 -> 6 -> 7
 */

public class Reverse_Linked_List_II_92 {

    public static void main(String[] args) {

//        ListNode head = new ListNode(1,new ListNode
//                (2,new ListNode(3,new ListNode
//                        (4,new ListNode(5,new ListNode
//                                (6,new ListNode(7)))))));

        ListNode head = new ListNode(1,new ListNode(2));

        int left = 1;
        int right = 1;

        if (head.next == null) {
            System.out.print(head.val);
            return;
        }

        // Breaking the list into three parts-----------------------------------------------------------------

        ListNode leftEndNode = head;

        ListNode temp = head;
        int count = 1;
        while (count < right ){
            if (count == left-1)
                leftEndNode = temp;
            temp = temp.next;
            count += 1;
        }

        ListNode rightStartNode = temp.next;
        temp.next = null;

        // ******************************************************************************************************


        // Reversing the required list with handled edge cases
        ListNode newHead = reverseList((left==1) ? head : leftEndNode.next);



        // Combining all the three parts of the list ------------------------------------------------------------
        leftEndNode.next = null;

        ListNode temp1 = newHead;
        while (temp1.next != null)
            temp1 = temp1.next;

        temp1.next = rightStartNode;
        if (left != 1)
            leftEndNode.next = newHead;
        else
            head = newHead;

        // *******************************************************************************************************


        print(head);
    }

    private static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
    }


    // Method that reverse a linked list using recursion
    public static ListNode reverseList(ListNode head) {

        if (head==null)
            return null;

        if (head.next == null)
            return head;

        ListNode temp = head;

        head = reverseList(head.next);

        insert(head,temp);

        return head;

    }

    private static void insert(ListNode head, ListNode temp) {

        temp.next = null;

        ListNode val = head;

        while (val.next != null)
            val = val.next;

        val.next = temp;

    }

}
