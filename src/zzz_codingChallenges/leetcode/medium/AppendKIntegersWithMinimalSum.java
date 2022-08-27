package zzz_codingChallenges.leetcode.medium;

import java.util.Arrays;

public class AppendKIntegersWithMinimalSum {


    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,5,2};
        int k = 2;
        System.out.println(minimalKSum(nums,k));
    }

    private static long minimalKSum(int[] nums, int k) {

        int max = nums[0];
        for(int e : nums) if (e > max) max = e;

        boolean[] arr = new boolean[max];
        for(int e : nums) arr[e-1] = true;

        long sum = 0;
        for(int i=0; i<max; i++){
            if(k==0) break;
            if(!arr[i]){
                sum+=(i+1);
                --k;
            }
        }

        if(k!=0){
            while(k!=0){
                sum += (++max);
                --k;
            }
        }

        return sum;
    }
}
