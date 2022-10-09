package zzz_codingChallenges.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    public static void main(String[] args) {
        String[] words = {"a","ab","ac","bd","abc","abd","abdd"};
        int size = words.length;

        int[][] dp = new int[size][size];
        for(int[] e : dp)
            Arrays.fill(e,-1);

        int[] arr = new int[size];
        for(int i=0; i<size; i++)
            arr[i] = words[i].length();
        System.out.println(solve(0,-1,arr,size,dp));


//        System.out.println(longestStrChain(words));
    }


    private static int solve(int idx, int prev, int[] arr, int n, int[][] dp){
        if(idx == n) return 0;

        if(dp[idx][prev+1] != -1) return dp[idx][prev+1];

        // Not taking item
        int len = solve(idx+1, prev, arr, n, dp);

        // taking the item
        if(prev == -1 || arr[idx]>arr[prev])
            len = Math.max(len, 1+solve(idx+1, idx, arr, n, dp));

        return dp[idx][prev+1] = len;
    }


    static int[][] t;
    static public int longestStrChain(String[] words) {

        int size = words.length;
        if(size == 1) return 1;

        Arrays.sort(words, (s1, s2) -> s1.length() < s2.length() ? -1 : 0);

        // sort(words, size);
        System.out.println("Sorted Array:"+Arrays.toString(words));

        // Ready the map
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<size; i++){
            int flag = 0;
            for(int j=i+1; j<size; j++){
                if(isSuccessor(words[i],words[j])){
                    System.out.println("Successor:"+words[i]+"->"+words[j]);
                    flag = 1;
                    map.put(words[i],j);
                    break;
                }
            }
            if(flag == 0)
                map.put(words[i],-1);
        }

        System.out.println("Map:"+map);
        return getMaxChain(words, map);
    }

    static int getMaxChain(String[] words, Map<String,Integer> map){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<words.length; i++){
            int count = 1;
            int next = map.get(words[i]);
            while(next != -1){
                next = map.get(words[next]);
                ++count;
            }
            max = Math.max(max,count);
        }
        return max;
    }


    static boolean isSuccessor(String a, String b){
        int m = a.length();
        int n = b.length();
        if(m != n-1) return false;

        t = new int[m+1][n+1];
        for (int[] row : t)
            Arrays.fill(row,-1);

        int lcs = LCS(a,b,m,n);
        System.out.println("LCS:"+lcs);
        return n-lcs == 1;
    }

    static private int LCS(String x,  String y, int m,  int n){

        if(n==0||m==0)
            return 0;

        if(t[m][n] != -1)
            return t[m][n];

        if(x.charAt(m-1)==y.charAt(n-1))
            return t[m][n] = 1 + LCS(x,y,m-1,n-1);

        else
            return t[m][n] = Math.max(LCS(x,y,m,n-1),LCS(x,y,m-1,n));

    }


}
