package zzz_codingChallenges.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class FindTheTownJudge {

    public int findJudge(int n, int[][] trust) {
        if(trust.length == 0) return -1;
        if(n == 1) return n;

        Map<Integer,Integer> map = new HashMap<>();
        for(int[] e : trust){
            int count = map.getOrDefault(e[1], 1);
            map.put(e[1],count+1);
        }

        System.out.println();

        for(int e : map.values()){
            if(e == (n-1)){
                for(int[] k : trust)
                    if(k[0] == e) return -1;
                return e;
            }
        }

        return -1;


        // int retSize = n-1;
        // int sec = trust[0][1];
        // for(int[] e : trust){
        //     if(e[1] != sec) return -1;
        // }
        // return sec;
    }
}
