package zzz_codingChallenges.leetcode.easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flown"};
        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        String res = "";
        int sLen = strs.length;
        int min = Integer.MAX_VALUE;
        for(String e : strs) {
            int len = e.length();
            if (len < min) min = len;
        }

        for(int i=0; i<=min-1; i++){
            int cmnCount = 0;
            char f = strs[0].charAt(i);
            for(int j=1; j<=sLen-1; j++){
                if(strs[j].charAt(i) == f){
                    cmnCount++;
                }
                else break;
            }
            if(cmnCount == sLen-1)
                res += f;
            else break;
        }
        return res;
    }
}
