package stackDS.problems;


import globalClasses.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * The main concept behind this problem is that
 * We have to find the index of the NGL elements
 */
public class StockSpanProblem {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        print("Enter elements with space:");
        String[] arr = sc.nextLine().split("\\s+");

        List<Integer> v = new ArrayList<>();
        Stack<Pair<Integer,Integer>> s = new Stack<>();

        for (int i=0; i< arr.length; i++){
            int arrI = Integer.parseInt(arr[i]);

            if (s.size() == 0) v.add(-1);

            else if (s.size()>0 && s.peek().getKey() > arrI) v.add(s.peek().getValue());

            else if (s.size()>0 && s.peek().getKey()<=arrI){
                while (s.size()>0 && s.peek().getKey()<=arrI) s.pop();

                if (s.size() == 0) v.add(-1);
                else v.add(s.peek().getValue());
            }

            s.push(new Pair<>(arrI,i));

        }

        for (int i=0; i<v.size(); i++) v.set(i, i - v.get(i));

        print("Output : ");
        System.out.println(v);
    }

    private static void print(String s){
        System.out.print(s);
    }
}
