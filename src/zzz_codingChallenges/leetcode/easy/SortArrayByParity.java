package zzz_codingChallenges.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArrayByParity {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4,3,4,7,4};
        System.out.println(Arrays.toString(sortArrayByParity_UsingSwapping(arr)));
    }


    private static int[] sortArrayByParity_UsingSwapping(int[] nums) {
        int i=0;
        for(int j=0; j<nums.length; j++){
            if((nums[j]&1) == 0){
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }


    private static int[] sortArrayByParity(int[] nums) {
        int size = nums.length;
        int[] ret = new int[size];
        List<Integer> list = new ArrayList<>();
        for(int e : nums){
            int listSize = list.size();
            if((e&1)==1)
                list.add(listSize, e);
            else
                list.add(0,e);
        }


        for(int i=0; i<size; i++){
            ret[i] = list.get(i);
        }

        return ret;

    }

}
