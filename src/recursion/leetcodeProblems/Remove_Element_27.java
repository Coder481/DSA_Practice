package recursion.leetcodeProblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Remove_Element_27 {

    int[] nums;
    int underscore = 0;

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        int k = new Remove_Element_27().removeElement(nums,val);

        System.out.println(Arrays.toString(nums));
        System.out.println(k);

    }

    public int removeElement(int[] nums, int val) {
        this.nums = nums;

        replace(0,val);

        Arrays.sort(nums);

        for (Integer integer : nums){
            if (integer != -1)
                break;
            else
                underscore += 1;
        }

        // reversing array by swapping elements
        for (int i = 0; i <= (nums.length-1)/2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        return nums.length - underscore;
    }

    private void replace(int index, int val) {
        if (index == nums.length)
            return;
        if (nums[index] == val)
            nums[index] = -1;

        replace(index+1,val);
    }

}
