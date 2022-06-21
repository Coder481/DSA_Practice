package stackDS.problems;

import java.util.Arrays;
import java.util.Stack;

public class Asteroid {

    public static void main(String[] args) {

        int[] arr = {-5,-3,5,2,10,-8};
        System.out.println(Arrays.toString(solve(arr)));

    }

    private static int[] solve(int[] arr){
        Stack<Integer> s = new Stack<>();
        for(int e : arr){

            boolean canPush = true;
            while(!s.isEmpty() && (s.peek()*e)<0){
                int absE = Math.abs(e);
                int absTop = Math.abs(s.peek());

                // If the upcoming asteroid is bigger than the top element of stack
                // then explode the top element
                if(absE > absTop)
                    s.pop();

                // If both asteroid have same sizes
                else if(absE == absTop){
                    s.pop();
                    canPush = false;
                    break;
                }

                // If the upcoming asteroid is smaller than the top of stack
                else {
                    canPush = false;
                    break;
                }
            }

            if(canPush) s.push(e);
        }

        int size = s.size();
        int[] res = new int[size];
        for(int i=size-1; i>=0; i--)
            res[i] = s.pop();

        return res;
    }

}
