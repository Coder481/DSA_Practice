package recursion.leetcodeProblems.recursionWithLinkedList;

import recursion.leetcodeProblems.ListNode;

public class Merge_Two_Sorted_Lists_21 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode n2 = new ListNode(1,new ListNode(3,new ListNode(4)));

        print(n1);
        System.out.println();
        print(n2);
        System.out.println();

        ListNode resNode = sort(n1,n2);
        print(resNode);
    }

    private static void print(ListNode resNode) {
        while (resNode != null){
            System.out.print(resNode.val+"->");
            resNode = resNode.next;
        }
    }

    private static ListNode sort(ListNode l1, ListNode l2) {
        // Base condition
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val>l2.val){
            l2.next = sort(l1,l2.next);
            return l2;
        }
        else {
            l1.next = sort(l1.next,l2);
            return l1;
        }

    }

}
