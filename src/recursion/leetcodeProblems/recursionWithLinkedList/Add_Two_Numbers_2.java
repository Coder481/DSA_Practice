package recursion.leetcodeProblems.recursionWithLinkedList;

import recursion.leetcodeProblems.ListNode;

public class Add_Two_Numbers_2 {

    static ListNode resHead;

    public static void main(String[] args) {

        ListNode l1 = new ListNode(9
                ,new ListNode(9
                ,new ListNode(9
                ,new ListNode(9
                ,new ListNode(9)))));
        ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9)));


//        ListNode l1 = new ListNode(0);
//        ListNode l2 = new ListNode(0);
        ListNode res = addTwoNumbers(l1,l2);

        while(res != null) {
            System.out.print(res.val + "-->");
            res = res.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        resHead = null;

        add(l1,l2,0);

        return resHead;
    }

    private static void add(ListNode l1, ListNode l2, int carry) {

        int sum = l1.val + l2.val + carry;

        if (l1.next == null && l2.next == null){
            insert(new ListNode(sum), true);
            return;
        }

        else if (l1.next == null ){
            l1.next = new ListNode(0);
        }

        else if (l2.next == null){
            l2.next = new ListNode(0);
        }

        insert(new ListNode(sum%10),false);

        add(l1.next,l2.next,sum/10);

    }

    private static void insert(ListNode listNode, boolean isLast) {

        if (isLast && listNode.val>9){
            int x = listNode.val;
            listNode.val = x % 10;
            x = x / 10;
            listNode.next = new ListNode(x);
        }

        if (resHead == null) {
            resHead = listNode;
            return;
        }

        ListNode temp = resHead;

        while (temp.next != null)
            temp = temp.next;

        temp.next = listNode;
    }

}
