package stackDS.implementation;

import java.util.LinkedList;

public class ByLinkedList {

    public static void main(String[] args) {

        StackL<Integer> s = new StackL<>();

        s.push(1);
        s.push(2);
        System.out.println(s.pop());
        s.push(3);
        System.out.println(s.pop());
        s.push(4);
        s.push(5);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.push(12);
        System.out.println(s.peek()+", Size:"+s.size());
    }

}

class StackL<T>{
    LinkedList<T> list;
    int topIndex;

    public StackL() {
        this.list = new LinkedList<>();
        this.topIndex = -1;
    }

    public T pop(){
        if(list.size() == 0) return null;
        return list.pop();
    }

    public void push(T data){
        list.push(data);
    }

    public T peek(){
        return list.peek();
    }

    public int size(){
        return list.size();
    }
}
