package zzz_codingChallenges.leetcode.easy;

import java.util.*;

public class SetMismatch {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
    }

    private static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int size = nums.length;
        int shouldBe = (size*(size+1))/2;
        int current = 0;
        int afterNoDuplicates = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<=nums.length-1; i++){
            current += nums[i];
            if(!set.contains(nums[i])) afterNoDuplicates += nums[i];
            set.add(nums[i]);
        }

        res[0] = current - afterNoDuplicates;
        res[1] = shouldBe - afterNoDuplicates;
        return res;
    }
}
