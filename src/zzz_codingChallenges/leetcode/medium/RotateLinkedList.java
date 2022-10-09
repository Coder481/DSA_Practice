package zzz_codingChallenges.leetcode.medium;

import zzz_codingChallenges.leetcode.common.ListNode;

public class RotateLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        int k = 2;

        ListNode.printList(rotateRight(head, k));
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        int size = 0;
        ListNode temp = head;
        while(temp != null){
            ++size;
            temp = temp.next;
        }

        if(size == k) return head;
        else if(size < k) k = k%size;

        while(k!=0){
            --k;
            head = rotate(head);
        }

        return head;
    }

    private static ListNode rotate(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }

        temp.next = head;
        prev.next = null;
        return temp;
    }
}
