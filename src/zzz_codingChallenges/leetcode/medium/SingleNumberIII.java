package zzz_codingChallenges.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumberIII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{1,2,1,3,2,5})));
    }



    private static int[] solve(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int e : nums){
            int count = map.getOrDefault(e,0);
            map.put(e,count+1);
        }
        int[] res = new int[2];
        int index = 0;
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                res[index] = key;
                index++;
                if(index == 2)
                    break;
            }
        }

        return res;
    }



    public int[] solveByBitManipulation(int[] nums) {
        if (nums == null || nums.length < 2 || nums.length % 2 != 0) {
            throw new IllegalArgumentException("Invalid Input");
        }

        int aXORb = 0;
        for (int n : nums) {
            aXORb ^= n;
        }

        int rightSetBit = aXORb & -aXORb;
        int a = 0;
        for (int n : nums) {
            if ((n & rightSetBit) != 0) {
                a ^= n;
            }
        }

        return new int[] {a, aXORb ^ a};
    }
}
