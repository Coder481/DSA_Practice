package zzz_codingChallenges.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {



    private static List<Integer> findDisappearedNumbers(int[] nums) {

        int size = nums.length;
        boolean[] tmp = new boolean[size + 1];
        for(int i=0; i<=size; i++)
            tmp[i] = false;

        for(int i : nums)
            if(!tmp[i]) tmp[i] = true;

        List<Integer> res = new ArrayList<>();
        for(int i=1; i<=size; i++)
            if(!tmp[i]) res.add(i);

        return res;
    }
}
