package zzz_codingChallenges.leetcode.medium;

public class LinkedListCycle {


    private static boolean detectCycle(ListNode head) {

        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        if(slow.next == null )
            return false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == null)
                return false;
            if(slow == fast)
                return true;
        }

        return false;
    }
}
