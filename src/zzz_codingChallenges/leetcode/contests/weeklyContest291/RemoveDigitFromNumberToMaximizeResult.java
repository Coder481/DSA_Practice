package zzz_codingChallenges.leetcode.contests.weeklyContest291;

public class RemoveDigitFromNumberToMaximizeResult {

    public static void main(String[] args) {
        String number = "123";
        char digit = '3';


        System.out.println(removeDigit(number, digit));
    }

    private static String removeDigit(String number, char digit) {

        int size = number.length();
        String max = Integer.MIN_VALUE+"";
        for(int i=0; i<size; i++){
            if(number.charAt(i) == digit){
                String temp1 = number.substring(0,i);
                String temp2 = number.substring(i+1);
                String res = temp1+temp2;
                if(res.compareTo(max) > 0) max = res;
            }
        }

        return max;

    }
}
