package zzz_codingChallenges.leetcode.easy;

import zzz_codingChallenges.leetcode.common.ListNode;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != null){
            lenA++;
            tempA = tempA.next;
        }
        while(tempB != null){
            lenB++;
            tempB = tempB.next;
        }
        if(lenA > lenB){
            int dif = lenA - lenB;
            tempA = headA;
            while(dif-- != 0) tempA = tempA.next;
            // call solve fun
            return solve(tempA, headB);
        }
        else if(lenA < lenB){
            int dif = lenB - lenA;
            tempB = headB;
            while(dif-- != 0) tempB = tempB.next;
            // call
            return solve(headA, tempB);
        }
        else {
            // call
            return solve(headA, headB);
        }
    }

    private static ListNode solve(ListNode headA, ListNode headB){
        while(headA != null && headB != null){
            if (headA.equals(headB)) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
