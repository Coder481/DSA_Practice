package zzz_codingChallenges.codechef.marchLunchtime2022;

import java.util.Scanner;

public class CREDCoins {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i=1; i<=t; i++){
            Scanner sc1 = new Scanner(System.in);
            String[] str = sc1.nextLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            System.out.println((x*y) / 100);
        }

    }

}
