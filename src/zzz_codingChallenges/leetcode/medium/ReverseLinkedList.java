package zzz_codingChallenges.leetcode.medium;

public class ReverseLinkedList {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode sec = new ListNode(3);
        ListNode thr = new ListNode(4);

        head.next = first;
        first.next = sec;
        sec.next = thr;

        printList(reverseList(head));
        System.out.println("Head:\n"+head.val);
    }

    private static void printList(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
    }

    private static ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }
}
