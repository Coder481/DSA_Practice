package zzz_codingChallenges.leetcode.contests.weeklyContest290;

import java.util.*;

public class IntersectionOfMultipleArrays {

    public static void main(String[] args) {

        int[][] nums = new int[][]{{7,34,45,10,12,27,13},{27,21,45,10,12,13}};

        List<Integer> res = intersection(nums);

        for(int e : res)
            System.out.print(e + " ");

    }

    private static List<Integer> intersection(int[][] nums) {

        int size = nums.length;

        Map<Integer, Integer> countMap = new HashMap<>();

        for(int[] arr : nums){
            for(int e : arr){
                countMap.put(e, countMap.getOrDefault(e, 0) + 1);
            }
        }

        List<Integer> res = new ArrayList<>();

        for(int key : countMap.keySet()){
            if(countMap.get(key) == size)
                res.add(key);
        }

        Collections.sort(res);

        return res;
    }
}
