package heap.leetcodeProblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Find_Kth_Smallest_Pair_Distance_719 {

    public static void main(String[] args) {
//        int[] nums = {1,3,2,4,1,2,5};
//        int k = 4;

        int[] nums = {1,3,2};
        int k = 2;
        int n = nums.length;

        PriorityQueue<Integer> maxH = new PriorityQueue<>((a,b)->b-a);

        List<Integer> numList = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        System.out.println(numList);
        int i = 0;
        int j = 1;
        int count = 1;

        int difCount = 1;
        while (difCount<k){
            difCount++;
            if (j== nums.length-1 ){
                count++;
                i=0;
                j=count;
            }
            else {
                i++;
                j++;
            }
            maxH.add(Math.abs(numList.get(i)-numList.get(j)));
            if (difCount == k){
                k = k * 2;
                if (k > n*(n-1)/2 )
                    k = n*(n-1)/2;
            }
        }

        int res ;
        if (maxH.isEmpty())
            res = Math.abs(numList.get(i)-numList.get(j));
        else
            res = maxH.peek();

        /*if (j==nums.length) {
            j--;
            i--;
        }*/

        System.out.println(res+"->("+i+","+j+")");

//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j=i+1;j< nums.length; j++){
//                maxH.add(Math.abs(nums[i] - nums[j]));
//                if (maxH.size()>k)
//                    maxH.poll();
//            }
//        }

//        System.out.println(maxH.peek());

    }

}
