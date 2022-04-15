package zzz_codingChallenges.leetcode.medium;

public class FIndDuplicateNumber {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
    }

    private static int findDuplicate(int[] nums) {
        for(int e : nums){
            int index = Math.abs(e);
            if(nums[index] < 0) return index;
            nums[index] = -nums[index];
        }
        return 0;
    }
}
