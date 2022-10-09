package zzz_codingChallenges.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class UglyNumber {

    public static void main(String[] args) {
        // -2147483648
        System.out.println(isUgly(-1));
    }

    private static boolean isUgly(int n) {

        if(n <= 0) return false;

        Set<Integer> set = new HashSet<>();
        primeFactors(n,set);

        System.out.println(set);
        for(int e : set) if (e != 1 && e != 2 && e != 3 && e != 5) return false;
        return true;
    }

    public static void primeFactors(int n, Set<Integer> set)
    {
        // Print the number of 2s that divide n
        while (n % 2 == 0) {
            set.add(2);
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                set.add(i);
                n /= i;
            }
        }

        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n > 2)
            set.add(n);
    }
}
