package zzz_codingChallenges.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    private static boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();
        int digit = n;
        while(digit != 1){
            digit = getSumOfSquareOfDigits(digit);
            if(!set.add(digit))
                return false;
        }
        return true;
    }

    private static int getSumOfSquareOfDigits(int digit) {

        int sum = 0;
        int temp = digit;
        while(temp != 0){
            int rem = temp % 10;
            sum += (rem*rem);
            temp = temp / 10;
        }

        return sum;
    }
}
