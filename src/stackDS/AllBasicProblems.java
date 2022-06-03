package stackDS;

import javafx.util.Pair;

import java.util.Stack;

public class AllBasicProblems {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapRainWater(arr));
    }


    private static int trapRainWater(int[] height){
        int size = height.length;
        if(size == 0) return 0;

        int[] maxL = new int[size];
        int[] maxR = new int[size];

        maxL[0] = height[0];
        maxR[size-1] = height[size-1];
        for(int i=1; i<size; i++){
            maxL[i] = Math.max(maxL[i-1], height[i]);
            maxR[size-1-i] = Math.max(maxR[size-i], height[size-1-i]);
        }

        int totalWater = 0;
        for(int i=0; i<size; i++){
            int h = Math.min(maxL[i], maxR[i]);
            totalWater += (h - height[i]);
        }
        return totalWater;
    }

    private static int[] stockSpan(int[] arr){
        int size = arr.length;
        if(size == 0) return arr;

        Stack<Pair<Integer, Integer>> s = new Stack<>();
        int[] res = new int[size];

        for(int i=0; i<size; i++){

            while(s.size() > 0 && s.peek().getKey()<=arr[i])
                s.pop();

            if(s.size() == 0) res[i] = -1;
            else res[i] = s.peek().getValue();
            s.push(new Pair<>(arr[i],i));

        }

        for(int i=0; i<size; i++) res[i] = i - res[i];
        return res;
    }



    private static int[] nsl(int[] arr){
        int size = arr.length;
        if(size == 0) return arr;
        Stack<Integer> s = new Stack<>();
        int[] res = new int[size];
        for(int i=0; i<=size-1; i++){

            while(s.size() > 0 && s.peek()>=arr[i])
                s.pop();

            if(s.size() == 0) res[i] = -1;
            else res[i] = s.peek();
            s.push(arr[i]);
        }
        return res;
    }

    private static int[] nsr(int[] arr){
        int size = arr.length;
        if(size == 0) return arr;
        Stack<Integer> s = new Stack<>();
        int[] res = new int[size];
        for(int i=size-1; i>=0; i--){

            while(s.size() > 0 && s.peek()>=arr[i])
                s.pop();

            if(s.size() == 0) res[i] = -1;
            else res[i] = s.peek();
            s.push(arr[i]);
        }
        return res;
    }

    private static int[] ngl(int[] arr){
        int size = arr.length;
        if(size == 0) return arr;
        Stack<Integer> s = new Stack<>();
        int[] res = new int[size];
        for(int i=0; i<=size-1; i++){

            while(s.size() > 0 && s.peek()<=arr[i])
                s.pop();

            if(s.size() == 0) res[i] = -1;
            else res[i] = s.peek();
            s.push(arr[i]);
        }
        return res;
    }

    private static int[] ngr(int[] arr){
        int size = arr.length;
        if(size == 0) return arr;
        Stack<Integer> s = new Stack<>();
        int[] res = new int[size];
        for(int i=size-1; i>=0; i--){

            while(s.size() > 0 && s.peek()<=arr[i])
                s.pop();

            if(s.size() == 0) res[i] = -1;
            else res[i] = s.peek();
            s.push(arr[i]);
        }
        return res;
    }

}
