package zzz_codingChallenges.leetcode.easy;

public class BackspaceStringCompare {

    public static void main(String[] args) {

        String s = "ab#c";
        String t = "ad#d";

        System.out.println(backspaceCompare(s,t));
    }

    private static boolean backspaceCompare(String s, String t) {

        StringBuilder sRes = new StringBuilder();
        StringBuilder tRes = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == '#') {
                if(sRes.length() == 0) continue;
                sRes.deleteCharAt(sRes.length() - 1);
            }
            else sRes.append(c);
        }
        for(char c : t.toCharArray()){
            if(c == '#') {
                if(tRes.length() == 0) continue;
                tRes.deleteCharAt(tRes.length() - 1);
            }
            else tRes.append(c);
        }

        return sRes.toString().compareTo(tRes.toString()) == 0;
    }
}
