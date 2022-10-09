package zzz_codingChallenges.leetcode.hard;

import zzz_codingChallenges.leetcode.common.ListNode;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) return null;

        ListNode head = lists[0];
        for(int i=1; i<lists.length; i++) head = merge(head, lists[i]);

        return head;
    }


    private static ListNode merge(ListNode ptr1, ListNode ptr2){

        if(ptr1 == null) return ptr2;
        if(ptr2 == null) return ptr1;

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
