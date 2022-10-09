package zzz_codingChallenges.leetcode.medium;

public class SwappingNodesInLinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        int first = -1;
        int second = -1;
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            if(size == k)
                first = temp.val;
            temp = temp.next;
        }

        int forLast = size - k + 1;
        size = 0;
        temp = head;
        while(temp != null){
            size++;
            if(size == forLast){
                second = temp.val;
                break;
            }
            temp = temp.next;
        }

        size = 0;
        temp = head;
        while(temp != null){
            size++;
            if(size == k)
                temp.val = second;
            else if(size == forLast){
                temp.val = first;
            }
            temp = temp.next;
        }

        return head;
    }
}
