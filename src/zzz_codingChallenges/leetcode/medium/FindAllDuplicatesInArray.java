package zzz_codingChallenges.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {

    public List<Integer> findDuplicates(int[] nums) {

        int size = nums.length;
        boolean[] tmp = new boolean[size+1];
        for(int i=0; i<=size; i++)
            tmp[i] = false;


        List<Integer> res = new ArrayList<>();
        for(int e : nums){
            if(!tmp[e])
                tmp[e] = true;
            else
                res.add(e);
        }

        return res;
    }
}
