package stackDS.implementation;

import java.util.ArrayList;
import java.util.List;

public class ByArray {

    public static void main(String[] args) {

        StackA<Integer> s = new StackA<>();

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


class StackA<T>{
    List<T> list;
    private int topIndex;

    public StackA() {
        this.list = new ArrayList<>();
        this.topIndex = -1;
    }

    public T pop(){
        if(topIndex == -1) return null;
        return list.remove(topIndex--);
    }

    public void push(T data){
        list.add(data);
        topIndex++;
    }

    public T peek(){
        if(topIndex == -1) return null;
        return list.get(topIndex);
    }

    public int size(){
        return list.size();
    }
}
