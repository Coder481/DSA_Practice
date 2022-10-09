package zzz_codingChallenges.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_InputIsSortedArray {

    public static void main(String[] args) {

        int[] nums = {3,2,4};
        int target = 6;

        System.out.println(solveByAlgo(nums,target));
    }

    private static int[] solveByAlgo(int[] num, int target){
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0; i< num.length; i++){
            if(map.containsKey(target - num[i])){
                res[0] = map.get(target - num[i]) + 1;
                res[1] = i + 1;
                return res;
            }
            map.put(num[i], i);
        }
        return res;
    }
}
