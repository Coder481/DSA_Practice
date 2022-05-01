package zzz_codingChallenges.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Count_Equal_and_Divisible_Pairs_in_Array {

    public static void main(String[] args) {
        int[] arr = {3,1,2,2,2,1,3};
        int k = 2;
        System.out.println(solve(arr, k));
    }

    private static int solve(int[] nums, int k){
        int count = 0;
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j] && i * j %k == 0) count++;
            }
        }
        return count;
    }

    private static int countPairs(int[] nums, int k) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<=nums.length-1; i++){
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }

        System.out.println(map);

        int count = 0;
        for(List<Integer> e : map.values()){
            if(e.size() <= 1) continue;
            for(int i=0; i<e.size()-1; i++){
                for(int j=i+1; j<=e.size()-1; j++){
                    if(e.get(i) * e.get(j) % k == 0) count++;
                }
            }
        }

        return count;
    }
}

