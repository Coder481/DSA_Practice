package heap.leetcodeProblems;

import java.util.*;
import java.util.stream.IntStream;

public class Max_Product_Of_Two_Elements_1464 {

    public static void main(String[] args) {

        int[] nums = {3,7};

        int[] ngr = getNgrList(nums);
        int[] ngl = getNglList(nums);

        List<Integer> maxProductArr = new ArrayList<>();

        for (int i=0; i< nums.length; i++){
            int mA = ngr[i] * nums[i];
            int mB = ngl[i] * nums[i];

            maxProductArr.add(Math.max(mA,mB));
        }

        int maxIndex = maxProductArr.indexOf(Collections.max(maxProductArr));

        int i = maxIndex;

        int x = ngr[maxIndex];
        int y = ngl[maxIndex];

        int j;
        if (x>y)
            j = IntStream.range(0, nums.length)
                    .filter(i1->x==nums[i1])
                    .findFirst()
                    .getAsInt();
        else
            j = IntStream.range(0, nums.length)
                    .filter(i1->y==nums[i1])
                    .findFirst()
                    .getAsInt();

        System.out.println((nums[i]-1)*(nums[j]-1));
    }

    private static int[] getNglList(int[] nums) {

        List<Integer> v = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for (Integer value : nums) {
            int arrI = value;

            if (s.size() == 0) v.add(-1);

            else if (s.size() > 0 && s.peek() >= arrI) v.add(s.peek());

            else if (s.size() > 0 && s.peek() < arrI) {
                while (s.size() > 0 && s.peek() < arrI)
                    s.pop();

                if (s.size() == 0) v.add(-1);
                else v.add(s.peek());
            }

            s.push(arrI);
        }

        return v.stream().mapToInt(i->i).toArray();
    }

    private static int[] getNgrList(int[] nums) {


        List<Integer> v = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for (int i=nums.length-1 ; i>=0; i--){
            int arrI = nums[i];

            if (s.size() == 0) v.add(-1);

            else if (s.size() > 0 && s.peek() >= arrI) v.add(s.peek());

            else if (s.size() > 0 && s.peek() < arrI){
                while (s.size()>0 && s.peek()< arrI)
                    s.pop();

                if (s.size() == 0) v.add(-1);
                else v.add(s.peek());
            }

            s.push(arrI);
        }

        Collections.reverse(v);

        return v.stream().mapToInt(i->i).toArray();
    }

}
