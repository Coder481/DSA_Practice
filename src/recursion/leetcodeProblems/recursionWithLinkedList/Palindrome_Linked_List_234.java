package recursion.leetcodeProblems.recursionWithLinkedList;

import recursion.leetcodeProblems.ListNode;

import java.util.Stack;

public class Palindrome_Linked_List_234 {

    public static void main(String[] args) {

//        ListNode head = new ListNode(1,new ListNode
//                (2,new ListNode(3,new ListNode
//                        (4,new ListNode(5,new ListNode
//                                (6,new ListNode(7)))))));

        ListNode head = new ListNode(1, new ListNode(2));

        Stack<Integer> stack = new Stack<>();

        ListNode temp1 = head;

        while (temp1 != null){
            stack.push(temp1.val);
            temp1 = temp1.next;
        }

        temp1 = head;

        int flag = 0;
        while (temp1 != null ){

            if (temp1.val != stack.pop()){
                flag = 1;
                break;
            }

            temp1 = temp1.next;
        }

        System.out.print(flag == 0);
    }

}
