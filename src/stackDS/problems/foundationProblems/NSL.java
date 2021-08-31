package stackDS.problems.foundationProblems;

import java.util.*;

/**
 * NSL -> Nearest Smaller to Left
 */
public class NSL {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        print("Enter elements with space:");
        String[] arr = sc.nextLine().split("\\s+");

        List<Integer> v = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for (int i=0; i<arr.length; i++){
            int arrI = Integer.parseInt(arr[i]);

            if (s.size() == 0) v.add(-1);

            else if(s.size()>0 && s.peek()<arrI) v.add(s.peek());

            else if (s.size()>0 && s.peek()>=arrI){
                while (s.size()>0 && s.peek()>=arrI) s.pop();

                if (s.size() == 0) v.add(-1);
                else v.add(s.peek());
            }

            s.push(arrI);
        }

        print("Output : ");
        System.out.println(v);
    }

    private static void printLn(String s){
        System.out.println(s);
    }
    private static void print(String s){
        System.out.print(s);
    }
}
