package z_labWork.sem6.competitiveCoding;

public class Lab_1_Stack {

    public static void main(String[] args) {

        int size = 5;
        StackImplementation stack = new StackImplementation(size);

        stack.push("Java");
        stack.push("Kotlin");
        stack.push("Python");
        stack.push("Java");
        stack.push("C++");
        stack.push("C#");

        System.out.println("Now popping from stack");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

    }

}




class StackImplementation{

    Object[] arr;
    int top;
    int capacity;

    public StackImplementation(int size) {
        arr = new Object[size];
        top = -1;
        capacity = size;
    }


    public void push(Object element){
        if (top == capacity - 1){
            System.out.println("Stack Overflow");
            return;
        }
        top ++;
        arr[top] = element;
    }

    public Object pop(){
        if (top == -1){
            System.out.println("Stack Underflow");
            return null;
        }

        Object res = arr[top];
        arr[top] = null;
        top-- ;
        System.out.println("Popped: "+res.toString());
        return res;
    }

}






















