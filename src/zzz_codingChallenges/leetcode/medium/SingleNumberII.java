package zzz_codingChallenges.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberII {

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(99));
        System.out.println(solve(new int[]{0,1,0,1,0,1,99}));
    }

    private static int solve(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int e : nums){
            int count = map.getOrDefault(e,0);
            map.put(e,count+1);
        }
        int res = 0;
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                res = key;
                break;
            }
        }

        return res;
    }
}
