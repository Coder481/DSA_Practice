package recursion.leetcodeProblems.recursionWithLinkedList;

import recursion.leetcodeProblems.ListNode;

public class Reverse_Linked_List_206 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1,new ListNode
                (2,new ListNode(3,new ListNode
                        (4,new ListNode(5,new ListNode
                                (6,new ListNode(7)))))));

        ListNode temp = reverseList(head);

        while (temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }

    }

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
