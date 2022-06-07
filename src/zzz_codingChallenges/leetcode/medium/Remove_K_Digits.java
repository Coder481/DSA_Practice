package zzz_codingChallenges.leetcode.medium;

import java.util.Stack;

public class Remove_K_Digits {

    public static void main(String[] args) {
        String s = "10200";
        int k = 2;
        System.out.println(removeKdigits(s,k));
    }

    private static String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k) return "0";

        Stack<Character> s = new Stack<>();
        for(char c : num.toCharArray()){
            while(k>0 && !s.isEmpty() && s.peek() > c){
                s.pop();
                --k;
            }
            s.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty())
            sb.append(s.pop());
        sb.reverse();
        while(sb.charAt(0)=='0') {
            sb.deleteCharAt(0);
            if(sb.length() == 0) return "0";
        }
        return sb.toString();
    }
}
