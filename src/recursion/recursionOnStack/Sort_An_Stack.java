package recursion.recursionOnStack;

import java.util.Stack;

public class Sort_An_Stack {

    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) {

        s.push(1);
        s.push(0);
        s.push(5);
        s.push(2);

        System.out.println("Before Sort: "+s);

        sort(s);

        System.out.println("After Sort: "+s);

    }

    private static void sort(Stack<Integer> s) {
        if (s.size()==1)
            return;

        int temp = s.pop();

        sort(s);

        insert(s,temp);

    }

    private static void insert(Stack<Integer> s, int temp) {
        if (s.size()==0 || s.peek()<=temp){
            s.push(temp);
            return;
        }

        int val = s.pop();

        insert(s,temp);

        s.push(val);
    }

}
