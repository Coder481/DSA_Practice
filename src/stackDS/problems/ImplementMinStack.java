package stackDS.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class ImplementMinStack {

    static Stack<Integer> s = new Stack<>();
    static Stack<Integer> ss = new Stack<>();

    public static void main(String[] args) {

        final int POP = 1;

        Scanner sc = new Scanner(System.in);

        print("Enter integer with space:");
        String[] arr = sc.nextLine().split("\\s+");


        print("Enter integer (0->push, 1->pop) with space:");
        String[] popArr = sc.nextLine().split("\\s+");


        List<Integer> arrInt = Arrays.stream(arr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> popArrInt = Arrays.stream(popArr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i=0; i<arr.length; i++){

            push(arrInt.get(i));

            if (popArrInt.get(i) == POP){
                pop();
                int minValue = getMin();

                String ans = (minValue==-1) ? "Empty Stack" : "Smallest value at position "+i+" is:" + minValue;
                printLn(ans);
            }
        }

    }

    private static int getMin(){
        if (ss.size() == 0) return -1;

        return ss.peek();
    }

    private static void push(int a){
        s.push(a);

        if (ss.size() == 0 || ss.peek() >= a)
            ss.push(a);

    }

    private static void pop(){
        if (s.size() == 0) return;

        int ans = s.peek();
        s.pop();

        if (ss.peek() == ans)
            ss.pop();

    }

    private static void printLn(String s){
        System.out.println(s);
    }
    private static void print(String s){
        System.out.print(s);
    }
}
