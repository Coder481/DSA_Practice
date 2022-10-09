package z_labWork.sem6.competitiveCoding;

import java.util.Scanner;

public class Lab_8_MinCoin {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter target value:");
        int target = sc.nextInt();

        int totalCoins = 0;

        if(target >= 10){
            totalCoins += (target / 10);
            target = target % 10;
        }

        if(target >= 5){
            totalCoins += (target / 5);
            target = target % 5;
        }

        if(target >= 2){
            totalCoins += (target / 2);
            target = target % 2;
        }

        if(target >= 1){
            totalCoins += target;
        }

        System.out.println("Total coins required:" + totalCoins);
    }


}
