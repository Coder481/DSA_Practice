package zzz_codingChallenges.leetcode.medium;

public class RemoveNthNodeFromEndList {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode sec = new ListNode(2);
        ListNode thr = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.next = sec;
        sec.next = thr;
        thr.next = fourth;
        fourth.next = fifth;

        int n = 2;
        printList(removeNthFromEnd(head,n));
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        int toDelete = 0;
        while(toDelete != (size - n)){
            toDelete++;
            if(temp == null) temp = head;
            else temp = temp.next;
        }


        if(temp == null) return head.next;
        if(temp.next == null) return temp;
        temp.next = temp.next.next;
        return head;
    }

    private static void printList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
    }
}
