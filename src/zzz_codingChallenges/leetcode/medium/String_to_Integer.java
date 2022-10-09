package zzz_codingChallenges.leetcode.medium;

import java.text.NumberFormat;
import java.text.ParsePosition;

public class String_to_Integer {

    public static void main(String[] args) {
        System.out.println(myAtoi(".1"));
    }
    private static int myAtoi(String s) {

        StringBuilder res = new StringBuilder();
        String sign = "";

        for(int i=0; i<=s.length()-1; i++){
            if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                if(i != s.length()-1 && isNumeric(s.charAt(i+1)+""))
                    sign = s.charAt(i)+"";
            }
            else if(isNumeric(s.charAt(i)+"")){
                res.append(s.charAt(i));
                if(i != s.length()-1 && !isNumeric(s.charAt(i+1)+"")) break;
            }
            else if (!(s.charAt(i)+"").equals(" ") && !isNumeric(s.charAt(i+1)+"")) {
                System.out.println(s.charAt(i+1)+"a");
                break;
            }
            else if((s.charAt(i)+"").equals(".")) break;
        }

        if(res.length() == 0) res.append("0");

        try{
            return Integer.parseInt(sign+res);
        }
        catch(ArithmeticException | NumberFormatException e){
            System.out.println(sign);
            int sub = 0;
            int mult = 1;
            if(sign.equals("-")) mult = -1;
            else sub = 1;
            return (int) ((Math.pow(2, 31) * mult) - sub) ;
        }

    }

    private static boolean isNumeric(String str) {
        ParsePosition pos = new ParsePosition(0);
        NumberFormat.getInstance().parse(str, pos);
        boolean isNum = str.length() == pos.getIndex();
        System.out.println("Is "+str+" numeric: "+isNum);
        return isNum;
    }
}
