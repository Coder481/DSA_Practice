package recursion.leetcodeProblems.recursionWithLinkedList;

import recursion.leetcodeProblems.ListNode;

public class Remove_Linked_List_Elements_203 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1,new ListNode
                (2,new ListNode(6,new ListNode
                        (3,new ListNode(4,new ListNode
                                (5,new ListNode(6)))))));


        int val = 6;

        System.out.print("Before delete: ");
        printList(head);

        ListNode newHead = removeElements(head,val);

        System.out.println();
        System.out.print("After delete: ");
        printList(newHead);
    }

    private static void printList(ListNode node) {

        while (node != null){
            System.out.print(node.val+"->");
            node = node.next;
        }

    }

    private static ListNode removeElements(ListNode head, int val) {

        if(head == null) return null;

        head.next = removeElements(head.next,val);

        return (head.val == val) ? head.next : head;


        /*if (head != null && head.val==val)
            head = head.next;
        if (head == null || head.next == null)
            return head;

        ListNode temp = head;

        ListNode removedNode;

        if (head.val == val)
            removedNode = removeElements(head,val);
        else
            removedNode = removeElements(head.next,val);

        if (temp.val == val)
            head = removedNode;
        else
            temp.next = removedNode;

        return head;*/
    }

}
