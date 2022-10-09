package zzz_codingChallenges.leetcode.hard;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(longestValidParentheses(s));
    }

    private static int longestValidParentheses(String s){
        int maxCount = 0, count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')' && i!=0){
                if(s.charAt(i-1) == '(') count += 2;
                else {
                    if(count > maxCount) maxCount = count;
                    count = 0;
                }
            }
        }
        return maxCount;
    }

    private static int longestValidParentheses_Stack(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')'){
                if(!stack.isEmpty()){
                    count+=2;
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        return count;
    }
}
