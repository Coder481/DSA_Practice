package zzz_codingChallenges.leetcode.contests.weeklyContest289;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsCompleteAllTasks {

    public static void main(String[] args) {
        int[] tasks = new int[]{2,3,3};
        System.out.println(solve(tasks));
    }

    private static int solve(int[] tasks){
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int e : tasks){
            countMap.put(e, countMap.getOrDefault(e,0)+1);
        }

        int res = 0;
        for(int count : countMap.values()){
            if(count == 1)
                return -1;
            if(count == 2 || count == 3)
                res ++;
            else{
                int div = count / 3;
                int rem = count % 3;
                if(rem == 0)
                    res += div;
                else if(rem == 1){
                    div --;
                    rem ++;
                    res += (div + rem);
                }
                else if(rem == 2){
                    res += (div + 1);
                }
            }
        }

        return res;
    }
}
