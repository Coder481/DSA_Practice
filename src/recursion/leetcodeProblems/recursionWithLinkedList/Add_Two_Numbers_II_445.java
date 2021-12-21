package recursion.leetcodeProblems.recursionWithLinkedList;

import recursion.leetcodeProblems.ListNode;

public class Add_Two_Numbers_II_445 {

    static ListNode res = null;

    public static void main(String[] args) {

        ListNode l1 = new ListNode(9
                ,new ListNode(2
                ,new ListNode(4
                ,new ListNode(3))));
        ListNode l2 =  new ListNode(9,new ListNode(5,new ListNode(6,new ListNode(4))));


        int l1Size = getLinkedListSize(l1);
        int l2Size = getLinkedListSize(l2);

        if (l1Size != l2Size){
            if (l1Size > l2Size){
                int dif = l1Size - l2Size;

                ListNode temp = new ListNode(0);
                ListNode first = temp;

                int i = 1;
                while (i<dif){
                    temp.next = new ListNode(0);
                    temp = temp.next;
                    i += 1;
                }
                temp.next = l2;
                l2 = first;
            }

            else {

                int dif = l2Size - l1Size;

                ListNode temp = new ListNode(0);
                ListNode first = temp;

                int i = 1;
                while (i<dif){
                    temp.next = new ListNode(0);
                    temp = temp.next;
                    i += 1;
                }
                temp.next = l1;
                l1 = first;
            }
        }


        int carry = add(l1,l2);

        if (carry != 0){
            ListNode temp = new ListNode(carry);
            temp.next = res;
            res = temp;
        }

        printLists(res,null);
    }

    private static int add(ListNode l1, ListNode l2) {

        if (l1.next == null && l2.next == null){
            int sum = l1.val + l2.val;

            int a = sum / 10;
            int b = sum % 10;

            res = new ListNode(b);
            return a;
        }

        int carry = add(l1.next,l2.next);

        int sum = l1.val + l2.val + carry;

        int a = sum / 10;
        int b = sum % 10;

        ListNode temp = new ListNode(b);
        temp.next = res;
        res = temp;

        return a;
    }


    private static int getLinkedListSize(ListNode head) {

        ListNode temp = head;
        int count = 0;
        while (temp != null){
            count += 1;
            temp = temp.next;
        }

        return count;
    }

    private static void printLists(ListNode l1, ListNode l2) {
        ListNode temp = l1;
        ListNode temp1 = l2;

        while (temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }

        System.out.println();

        while (temp1 != null){
            System.out.print(temp1.val+"->");
            temp1 = temp1.next;
        }
    }
}
