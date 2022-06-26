package zzz_codingChallenges.leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "val=" + val + ", next=" + next;
    }

    public static void printList(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
    }
}
