package zzz_codingChallenges.leetcode.medium;

import com.sun.istack.internal.NotNull;

import java.util.Collections;

public class MultiplyStrings {

    public static void main(String[] args) {
        System.out.println(solve("9","9"));;
    }

    private static String solve(String num1, String num2){
        String res = "";

        if (num1.equals("0")||num2.equals("0"))
            return "0";

        for(int i=num2.length()-1 ;i >= 0; i--){
            char c1 = num2.charAt(i);
            int carry = 0;
            String sum = "";
            for(int j=num1.length()-1; j>=0; j--){
                char c2 = num1.charAt(j);
                int total = carry + ((c1 - '0') * (c2 - '0'));
                sum = (total % 10) + sum;
                carry = total / 10;
            }
            String endZeros = String.join("", Collections.nCopies(num2.length() - 1 - i, "0"));
            sum = sum + endZeros;

            if (carry != 0)
                sum = carry + sum;
            res = add(sum, res);
        }

        if (res.startsWith("0"))
            res = res.substring(1);
        return res;
    }

    private static String add(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if(lenA > lenB){
            int diff = lenA - lenB;
            String startZeros = String.join("", Collections.nCopies(diff, "0"));
            b = startZeros + b;
        }
        else{
            int diff = lenB - lenA;
            String startZeros = String.join("", Collections.nCopies(diff, "0"));
            a = startZeros + a;
        }


        int carry = 0;
        String res = "";
        for(int i=a.length() - 1; i>=0; i--){
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            int total = carry + (c1-'0') + (c2-'0');
            carry = total / 10;
            res = (total%10) + res;
        }
        if (carry != 0) res = carry + res;
        return res;
    }
}
