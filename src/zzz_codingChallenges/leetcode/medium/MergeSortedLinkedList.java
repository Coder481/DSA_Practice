package zzz_codingChallenges.leetcode.medium;

public class MergeSortedLinkedList {

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        ListNode sec1 = new ListNode(3);
        ListNode thr1 = new ListNode(5);
        ListNode fourth1 = new ListNode(7);
        ListNode fifth1 = new ListNode(9);

        head1.next = sec1;
        sec1.next = thr1;
        thr1.next = fourth1;
        fourth1.next = fifth1;

        ListNode head2 = new ListNode(8);
        ListNode sec2 = new ListNode(10);
        ListNode thr2 = new ListNode(13);
        ListNode fourth2 = new ListNode(19);
        ListNode fifth2 = new ListNode(222);

        head2.next = sec2;
        sec2.next = thr2;
        thr2.next = fourth2;
        fourth2.next = fifth2;

        ListNode newHead = merge(head1, head2);
        printList(newHead);

    }


    private static void printList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
    }

    private static ListNode merge(ListNode ptr1, ListNode ptr2){

        ListNode head;
        if(ptr1.val < ptr2.val){
            head = ptr1;
            ptr1 = ptr1.next;
        }
        else{
            head = ptr2;
            ptr2 = ptr2.next;
        }

        ListNode temp = head;
        while(ptr1 != null && ptr2 != null){
            if(ptr1.val < ptr2.val){
                temp.next = ptr1;
                ptr1 = ptr1.next;
            }
            else{
                temp.next = ptr2;
                ptr2 = ptr2.next;
            }
            temp = temp.next;
        }

        if(ptr1 != null){
            temp.next = ptr1;
        }
        else
            temp.next = ptr2;

        return head;

    }
}
