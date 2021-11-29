package recursion.recursionOnStack;

import java.util.Stack;

public class Reverse_A_Stack {

    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) {

        s.push(1);
        s.push(0);
        s.push(5);
        s.push(2);


        if (s.size()==0){
            System.out.println("Empty Stack");
            return;
        }

        System.out.println("Before Reverse: "+s);

        rev(s);

        System.out.println("After Reverse: "+s);

    }

    private static void rev(Stack<Integer> s) {
        if (s.size()==1)
            return;

        int ele = s.pop();

        rev(s);

        insertAtEnd(s,ele);
    }

    private static void insertAtEnd(Stack<Integer> s, int ele) {
        if (s.size() == 0){
            s.push(ele);
            return;
        }

        int val = s.pop();

        insertAtEnd(s,ele);

        s.push(val);

    }

}
