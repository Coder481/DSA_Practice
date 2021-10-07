package recursion;

import java.util.Scanner;

public class PalindromeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        print("Enter any positive number of check for palindrome:");
        long num = sc.nextLong();
        long res = reverseTheNumber(num,0);
        print(num+" is palindrome: "+((num==res) ? "true" : "false"));
    }

    private static long reverseTheNumber(long n, long res){

        if (n == 0){
            return res;
        }

        long rem = n % 10;
        n = n/10;

        long exp = 0;
        if (n != 0) exp = countDigit(n);

        res = res + (rem* ( getPower(10, exp ) ) );

        return reverseTheNumber(n,res);
    }

    static long getPower(long base, long exp){
        return (long) Math.pow(base,exp);
    }

    static int countDigit(long n) {
        return (int)Math.floor(Math.log10(n) + 1);
    }

    private static void printLn(String s){
        System.out.println(s);
    }
    private static void print(String s){
        System.out.print(s);
    }

}
