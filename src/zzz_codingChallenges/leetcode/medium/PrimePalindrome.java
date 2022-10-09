package zzz_codingChallenges.leetcode.medium;

public class PrimePalindrome {



    private static boolean isPalindrome(){
        return true;
    }


    public static int nextPrime(int input){
        int counter;
        input++;
        while(true){
            int l = (int) Math.sqrt(input);
            counter = 0;
            for(int i = 2; i <= l; i ++){
                if(input % i == 0)  counter++;
            }
            if(counter == 0) return input;
            else input++;
        }
    }
}
