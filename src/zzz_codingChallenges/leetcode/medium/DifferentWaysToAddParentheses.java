package zzz_codingChallenges.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

    public static void main(String[] args) {
        String s = "2*3-4*5";
        System.out.println(diffWaysToCompute(s));
    }

    private static List<Integer> diffWaysToCompute(String expression){
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' ||expression.charAt(i) == '*' ){
                String part1 = expression.substring(0,i);
                String part2 = expression.substring(i+1);
                List<Integer> first = diffWaysToCompute(part1);
                List<Integer> sec = diffWaysToCompute(part2);
                for(int t1 : first){
                    for(int t2 : sec){
                        int c=0;
                        switch(expression.charAt(i)){
                            case '+':
                                c = t1+t2;
                                break;
                            case '-':
                                c = t1-t2;
                                break;
                            case '*':
                                c = t1*t2;
                                break;
                        }
                        res.add(c);
                    }
                }
            }
        }
        if(res.isEmpty()) res.add(Integer.parseInt(expression));
        return res;
    }
}
