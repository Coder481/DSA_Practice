package zzz_codingChallenges.leetcode.medium;

import javafx.util.Pair;

import javax.script.ScriptEngineManager;

public class MinimizeResultByAddingParenthesesToExpression {

    public static void main(String[] args) {
        String exp = "247+38";
        System.out.println(minimizeResult("("+exp+")"));
    }

    private static String minimizeResult(String expression) {
        return solve(expression).getKey();
    }

    private static Pair<String, Integer> solve(String expression){

        if(singleInLeft(expression) && singleInRight(expression)){
            // solve exp here and store in max
            int value = evaluate(expression);
            return new Pair<>(expression, value);
        }

        int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE,c=Integer.MAX_VALUE;
        Pair<String, Integer> aP = null;
        Pair<String, Integer> bP = null;
        Pair<String, Integer> cP = null;
        if(!singleInLeft(expression)){
            String tempExp = expression;
            tempExp = moveOpenBrRight(tempExp);
            aP = solve(tempExp);
            a = evaluate(tempExp);
        }

        if(!singleInRight(expression)){
            String tempExp = expression;
            tempExp = moveCloseBrLeft(tempExp);
            bP = solve(tempExp);
            b = evaluate(tempExp);
        }

        if(!singleInLeft(expression) && !singleInRight(expression)){
            String tempExp = expression;
            tempExp = moveOpenBrRight(tempExp);
            tempExp = moveCloseBrLeft(tempExp);
            cP = solve(tempExp);
            c = evaluate(tempExp);
        }

        if(a < b && a < c && aP != null) return new Pair<>(aP.getKey(), a);
        else if(b<a && b<c && bP!=null) return new Pair<>(bP.getKey(),b);
        else if(cP != null) return new Pair<>(cP.getKey(), c);
        return new Pair<>("",0);
    }

    private static String moveOpenBrRight(String tempExp) {
        int leftBrIdx = tempExp.indexOf('(');
        char nextDigit = tempExp.charAt(leftBrIdx+1);
        return tempExp.substring(0,leftBrIdx) +  nextDigit + "(" + tempExp.substring(leftBrIdx+2);
    }

    private static String moveCloseBrLeft(String tempExp) {
        int rightBrIdx = tempExp.indexOf(')');
        char prevDigit = tempExp.charAt(rightBrIdx-1);
        return tempExp.substring(0,rightBrIdx-1) + ")" + prevDigit + tempExp.substring(rightBrIdx+1);
    }

    private static int evaluate(String exp){
        int size = exp.length();



        int leftBrIdx = exp.indexOf('(');
        int rightBrIdx = exp.indexOf(')');
        int plusIdx = exp.indexOf('+');

        String addExp = exp.substring(leftBrIdx+1,rightBrIdx);
        String[] arr = addExp.split("\\+");
        int value = Integer.parseInt(arr[0]) + Integer.parseInt(arr[0]);

        if(leftBrIdx != 0){
            value = value * Integer.parseInt(exp.substring(0,leftBrIdx));
        }
        if(rightBrIdx != size-1){
            value = value * Integer.parseInt(exp.substring(rightBrIdx+1));
        }

        System.out.println("evaluate() : exp-"+exp+", value-"+value);
        return value;
    }

    private static boolean singleInLeft(String exp){
        int leftBrIdx = exp.indexOf('(');
        int plusIdx = exp.indexOf('+');
//        System.out.println("singleInLeft: leftBrIdx-"+leftBrIdx+" plusIdx-"+plusIdx);
        return (plusIdx - leftBrIdx) == 2;
    }

    private static boolean singleInRight(String exp){
        int rightBrIdx = exp.indexOf(')');
        int plusIdx = exp.indexOf('+');
//        System.out.println("singleInLeft: rightBrIdx-"+rightBrIdx+" plusIdx-"+plusIdx);
        return (rightBrIdx - plusIdx) == 2;
    }
}
