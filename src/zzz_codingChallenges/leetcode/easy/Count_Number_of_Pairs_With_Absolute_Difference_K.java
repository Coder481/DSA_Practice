package zzz_codingChallenges.leetcode.easy;

import java.util.*;

public class Count_Number_of_Pairs_With_Absolute_Difference_K {

    public static void main(String[] args) {
        int[] numbers = {3,2,1,5,4};
        int k = 2;
        System.out.println(solveByAlgo(numbers,k));
    }

    private static int solve(int[] nums, int target) {
        int count = 0;
        for(int i = 0; i< nums.length-1; i++){
            for(int j = i+1; j<nums.length; j++){
                if(Math.abs(nums[i] - nums[j]) == target){
                    count += 1;
                }
            }
        }
        return count;
    }

    // O(n)
    private static int solveByAlgo(int[] num, int k){
//        List<Integer> l = new ArrayList<>();
//        Set<Integer> numSet = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;

        for(int e : num){
            if(map.containsKey(e + k))
                count += map.get(e + k);
            if(map.containsKey(e - k))
                count += map.get(e - k);
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        /*for (int j : num) {
            l.add(j + k);
            l.add(j - k);
            numSet.add(j);
        }
        System.out.println(l);

        Map<Integer,Integer> map = new HashMap<>();
        for(int item : l){
            if(map.containsKey(item)){
                int val = map.get(item) + 1;
                map.put(item, val);
            }
            else{
                map.put(item,1);
            }
        }
        System.out.println(map);

        for(int e : numSet){
            if(map.containsKey(e)){
                count += map.get(e);
            }
        }*/

        return count;
    }

}
