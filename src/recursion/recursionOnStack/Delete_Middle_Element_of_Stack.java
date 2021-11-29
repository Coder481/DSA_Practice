package recursion.recursionOnStack;

import java.util.Stack;

/**
 * In this problem, we can delete element at any position by passing position in "k"
 * Here we are taking middle element
 */

public class Delete_Middle_Element_of_Stack {

    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) {

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        int k = s.size()/2 + 1;

        if (s.size()==0){
            System.out.println("Empty Stack");
            return;
        }

        System.out.println("Before Delete: "+s);

        delete(s,k);

        System.out.println("After Delete: "+s);

    }

    private static void delete(Stack<Integer> s, int k) {

        if (k==1){
            s.pop();
            return;
        }

        int temp = s.pop();

        delete(s,--k);

        s.push(temp);

    }

}
