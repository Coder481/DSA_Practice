package zzz_codingChallenges.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;

        int[] res = solve(nums, target);
        System.out.println(res[0]+" "+res[1]);
        System.out.println();

        int[] resByAlgo = solveByAlgo(nums, target);
        System.out.println(resByAlgo[0]+" "+resByAlgo[1]);
    }

    // O(n)
    private static int[] solveByAlgo(int[] num, int target){
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0; i< num.length; i++){
            if(map.containsKey(target - num[i])){
                res[0] = map.get(target - num[i]);
                res[1] = i;
                return res;
            }
            map.put(num[i], i);
        }
        return res;
    }


    // O(n^2)
    private static int[] solve(int[] nums, int target) {
        for(int i = 0; i< nums.length-1; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
