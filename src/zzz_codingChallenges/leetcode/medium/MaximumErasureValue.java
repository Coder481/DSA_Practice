package zzz_codingChallenges.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,4,5,6};
        System.out.println(maximumUniqueSubarray(nums));
    }

    private static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int i=0;
        while(i<nums.length){
            if(set.contains(nums[i])){
                --i;
                maxSum = Math.max(maxSum,sum);
                sum = 0;
            }
            else{
                set.add(nums[i]);
                sum += nums[i];
                ++i;
                if(i == nums.length-1){
                    return Math.max(maxSum, sum);
                }
            }
        }
        return maxSum;
    }
}
