package zzz_codingChallenges.leetcode.medium;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        int[] n = new int[]{1,2,3,4};
        System.out.println(findUnsortedSubarray(n));


        // Type casting testing
        long l = 2L;
        double d = 2;
        int i = 2;

//        l = i;   // Allowed
//        i = l;     // Not allowed
//        i = d;    // Not allowed
//        d = i;    // Allowed
    }

    private static int findUnsortedSubarray(int[] nums) {
        int[] unsortedNums = nums.clone();
        Arrays.sort(nums);

        int start = -1;
        for(int i=0; i<nums.length; i++){
            int fromSorted = nums[i];
            int fromUnSorted = unsortedNums[i];
            if(fromSorted != fromUnSorted){
                start = i;
                break;
            }
        }

        int end = -1;
        for(int i=nums.length-1; i>=0; i--){
            int fromSorted = nums[i];
            int fromUnSorted = unsortedNums[i];
            if(fromSorted != fromUnSorted){
                end = i;
                break;
            }
        }

        if(start == -1 || end == -1 || (start > end)) return 0;

        return end - start + 1;
    }

}
