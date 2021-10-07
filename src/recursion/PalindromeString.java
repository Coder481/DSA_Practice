package recursion;

import java.util.Scanner;

public class PalindromeString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        print("Enter a string to check for palindrome:");
        String s = sc.nextLine();
        print(s+" is palindrome: "+( isPalindrome(s,0,s.length()-1) ));
    }

    private static boolean isPalindrome(String s, int l, int r){
        if (l>=r) return true;
        if (s.charAt(l) != s.charAt(r)) return false;

        return isPalindrome(s,l+1,r-1);
    }

    private static void print(String s){
        System.out.print(s);
    }
}
