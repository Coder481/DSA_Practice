package stackDS.basicOperations;

import java.util.Stack;

public class Basics {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // push operation : Add element at the top the stack
        stack.push(1);
        stack.push(16);
        stack.push(5);
        stack.push(12);
        stack.push(10);

        /*for (Integer i : stack){
            print(i+" ");
        }*/

        printStackData(stack);

        // pop operation : Remove top element of the stack and return it
        int popped = stack.pop();
        printLn("Popped Element:"+popped);

        printStackData(stack);

        // peek operation : Return to element without removing it
        int peekEle = stack.peek();
        printLn("Peek Element: "+peekEle);

        printStackData(stack);


        // search operation : Search an element in the stack
        //                      return position of the element if present else return -1
        int search = 20;
        int position = stack.search(search);
        String msg = position==-1 ? peekEle+" not found in stack." : search+" is found at position "+position;
        printLn(msg);

        printStackData(stack);

        // empty() : returns true if nothing is on the top of the stack. Else, returns false.
        printLn("Stack is empty: "+stack.empty());


        stack.add(-25);     // add element at top of the stack
        stack.add(2,-20); // add element at a specific position of stack

        printStackData(stack);

    }

    private static void printStackData(Stack<Integer> stack) {
        printLn("");
        printLn("The Stack is: "+ stack);
        printLn("Size of stack: "+ stack.size());           // number of elements in the stack
        printLn("Capacity of stack: "+ stack.capacity());   // current capacity of the stack
        printLn("");
    }


    private static void printLn(String s){
        System.out.println(s);
    }
    private static void print(String s){
        System.out.print(s);
    }
}
