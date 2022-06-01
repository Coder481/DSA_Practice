package zzz_codingChallenges.leetcode.medium;

public class LinkedListCycleII {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode zero = new ListNode(0);
        ListNode four = new ListNode(-4);

        head.next = two;
        two.next = zero;
        zero.next = four;
        four.next = two;

        ListNode res = detectCycle(head);
        if(res == null) {
            System.out.println("null");
            return;
        }
        System.out.println(res);
    }

    private static ListNode detectCycle(ListNode head) {

        if(head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        if(slow.next == null)
            return null;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == null)
                return null;
            if(slow == fast)
                break;
        }
        slow = head;
        if(fast == null || fast.next == null) return null;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "val=" + val + ", next=" + next;
    }

}
