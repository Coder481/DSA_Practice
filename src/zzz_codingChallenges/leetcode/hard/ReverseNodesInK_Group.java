package zzz_codingChallenges.leetcode.hard;

import zzz_codingChallenges.leetcode.common.ListNode;

public class ReverseNodesInK_Group {

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

        printList(reverseKGroup(head, k));
    }

    private static void printList(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
    }

    private static ListNode reverseKGroup(ListNode head, int k){
        ListNode temp = head;
        int count = 1;
        while(count != k){
            if(temp == null) return head;
            ++count;
            temp = temp.next;
        }

        if(temp == null) return head;

        ListNode rest = reverseKGroup(temp.next, k);

        temp.next = null;

        ListNode res = reverse(head);
        head.next = rest;
        return res;
    }


    private static ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }
}
